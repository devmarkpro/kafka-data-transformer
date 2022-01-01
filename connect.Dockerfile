FROM confluentinc/cp-kafka-connect-base:6.2.1

ENV CONNECT_PLUGIN_PATH=/usr/share/java,/usr/share/confluent-hub-components
RUN confluent-hub install --no-prompt debezium/debezium-connector-mysql:1.3.1
RUN confluent-hub install --no-prompt debezium/debezium-connector-postgresql:1.7.1
RUN confluent-hub install --no-prompt confluentinc/kafka-connect-jdbc:10.0.0
