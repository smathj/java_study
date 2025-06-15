package com.java.study.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Properties;
import java.util.concurrent.Future;

public class ProducerTest1 {
    public static void main(String[] args) {

        Properties kafkaProps = new Properties();

        kafkaProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.35.25:9092");
        kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(kafkaProps);

        try {
            System.out.println("메시지 전송 시작...");

            ProducerRecord<String, String> record = new ProducerRecord<>("test2", "ksj", "테스트 메세지");

            // 비동기 전송 후 결과 기다리기
            Future<RecordMetadata> future = producer.send(record);
            RecordMetadata metadata = future.get(); // 전송 완료까지 대기

            System.out.println("메시지 전송 성공!");
            System.out.println("토픽: " + metadata.topic());
            System.out.println("파티션: " + metadata.partition());
            System.out.println("오프셋: " + metadata.offset());

        } catch (Exception e) {
            System.err.println("메시지 전송 실패: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // 프로듀서 종료
            producer.flush(); // 남은 메시지 전송 완료
            producer.close(); // 리소스 정리
            System.out.println("프로듀서 종료");
        }
    }
}
