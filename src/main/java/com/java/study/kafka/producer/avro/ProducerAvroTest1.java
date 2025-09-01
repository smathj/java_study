package com.java.study.kafka.producer.avro;

import com.java.study.kafka.avro.Customer;
import com.java.study.kafka.avro.CustomerGenerator;
import org.apache.kafka.clients.producer.*;

import java.util.Properties;

public class ProducerAvroTest1 {
    public static void main(String[] args) {

        Properties kafkaProps = new Properties();

        // 브로커 서버 - 단 1대만
        kafkaProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.35.25:9092");

        // 시리얼 라이저 - 키
        kafkaProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "io.confluent.kafka.serializers.KafkaAvroSerializer");

        // 시리얼 라이저 - 벨류
        kafkaProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "io.confluent.kafka.serializers.KafkaAvroSerializer");

        String schemaUrl = "http://192.168.35.25:8081";

        kafkaProps.put("schema.registry.url", schemaUrl);

        KafkaProducer<String, Customer> producer = new KafkaProducer<>(kafkaProps);

        String topic = "test";

        while(true) {
            Customer customer = CustomerGenerator.getNext();
            System.out.println("customer = " + customer);

            ProducerRecord<String, Customer> record = new ProducerRecord<String, Customer>(topic, customer.getCustomerName().toString(), customer);

            producer.send(record);

        }
    }


}
