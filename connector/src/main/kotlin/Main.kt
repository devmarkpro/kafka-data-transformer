import io.github.serpro69.kfaker.faker
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import kotlin.concurrent.fixedRateTimer
import kotlin.random.Random

object Product : IntIdTable() {
    val name = varchar("name", 500)
    val price = double("price").default(0.0)
    val color = varchar("color", 50).nullable()
    val category = varchar("category", 50)
    var quantity = integer("quantity").default(0)
    val description = varchar("description", 1000).nullable()
    val internalId = varchar("internalId", 50)
    val image = varchar("image", 500).nullable()
}

fun main() {
    val db = Database.connect(
        "jdbc:postgresql://127.0.0.1:5400/product_db",
        driver = "org.postgresql.Driver",
        user = "postgres",
        password = "secret",
    )
    val faker = faker{}
    fun toss(): Boolean = Random.nextDouble() < 0.5
    fixedRateTimer("timer", false, 0L, 1000) {
        transaction(db) {
            addLogger(StdOutSqlLogger)
            SchemaUtils.create(Product)
            val productName = faker.commerce.productName()
            val productId = Product.insert {
                it[name] = productName
                it[price] = Random.nextDouble()
                it[color] = faker.color.name()
                it[category] = faker.commerce.department()
                it[quantity] = Random.nextInt(0, 100)
                it[description] = if (toss()) faker.lorem.punctuation() else null
                it[image] = faker.internet.domain()
                it[internalId] = faker.code.asin()
            } get Product.id
            println("product $productId : $productName inserted")
        }
    }
}

