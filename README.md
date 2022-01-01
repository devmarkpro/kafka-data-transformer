# kafka-data-transformer


Create Kafka Topic
```shell
docker-compose exec broker \
 kafka-topics --create \
 --topic data-transformer \
 --partitions 1 \
 --replication-factor 1 \
 --if-not-exists \
 --zookeeper zookeeper:2181
 
 # Created topic data-transformer.
```

```shell
docker-compose exec broker \
 kafka-topics --create \
 --topic data-transformer-offset \
 --partitions 1 \
 --replication-factor 1 \
 --if-not-exists \
 --zookeeper zookeeper:2181
 
 # Created topic data-transformer-offset.
```

```shell
docker-compose exec broker \
 kafka-topics --create \
 --topic data-transformer-config \
 --partitions 1 \
 --replication-factor 1 \
 --if-not-exists \
 --zookeeper zookeeper:2181
 
 # Created topic data-transformer-config.
```

```shell
docker-compose exec broker \
 kafka-topics --create \
 --topic data-transformer-status \
 --partitions 1 \
 --replication-factor 1 \
 --if-not-exists \
 --zookeeper zookeeper:2181
 
 # Created topic data-transformer-status.
```

Check Kafka Topics:

```shell
docker-compose exec broker \
kafka-topics --describe \
--zookeeper zookeeper:2181
```
Output

```text
Topic: data-transformer	TopicId: vXFewYLoSNueGxnTtoD7ag	PartitionCount: 1	ReplicationFactor: 1	Configs:
	Topic: data-transformer	Partition: 0	Leader: 1	Replicas: 1	Isr: 1
Topic: data-transformer-config	TopicId: CD3GQRchTruUUiQ3pIxpwg	PartitionCount: 1	ReplicationFactor: 1	Configs:
	Topic: data-transformer-config	Partition: 0	Leader: 1	Replicas: 1	Isr: 1
Topic: data-transformer-offset	TopicId: w1p4gFPBRaaxANaHaMkKlA	PartitionCount: 1	ReplicationFactor: 1	Configs:
	Topic: data-transformer-offset	Partition: 0	Leader: 1	Replicas: 1	Isr: 1
Topic: data-transformer-status	TopicId: xTvsKVZOSuaLR3IgV0ayTA	PartitionCount: 1	ReplicationFactor: 1	Configs:
	Topic: data-transformer-status	Partition: 0	Leader: 1	Replicas: 1	Isr: 1
```

Consume product topic:

```shell
docker-compose exec broker kafka-console-consumer --bootstrap-server broker:9092 --topic fulfillment.public.product
```
    
