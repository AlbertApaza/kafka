import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;

import java.util.Properties;

public class DebeziumEventConsumer {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "debezium-consumer-app");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, "org.apache.kafka.common.serialization.Serdes$StringSerde");
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, "io.confluent.kafka.serializers.KafkaJsonSchemaSerializer");

        StreamsBuilder builder = new StreamsBuilder();
        KStream<String, String> source = builder.stream("dbserver1.inventory.customers");

        source.foreach((key, value) -> {
            System.out.println("Key: " + key + ", Value: " + value);
        });

        KafkaStreams streams = new KafkaStreams(builder.build(), props);
        streams.start();
    }
}