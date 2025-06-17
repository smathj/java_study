package com.java.study.kafka.producer.async;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;
import java.util.concurrent.Future;

public class ProducerAsyncTest1 {
    public static void main(String[] args) {

        Properties kafkaProps = new Properties();

        // 브로커 서버 - 단 1대만
        kafkaProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.35.25:9092");

        // 시리얼 라이저 - 키
        kafkaProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        // 시리얼 라이저 - 벨류
        kafkaProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(kafkaProps);

        try {
            System.out.println("메시지 전송 시작...");

            String topic = "test";
            String key = "ksj";
            String message = "테스트 메세지";

            ProducerRecord<String, String> record = new ProducerRecord<>(topic, key, message);

            // 비동기 전송 후 결과 기다리기 >> 콜백 메서드 실행
            Future<RecordMetadata> future = producer.send(record, new DemoProducerCallback());

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

    // 카프카의 Callback
    private static class DemoProducerCallback implements Callback {

        @Override
        public void onCompletion(RecordMetadata recordMetadata, Exception e) {
            if (e != null) {
                e.printStackTrace();
                System.out.println("콜백 에러났슴다");
                return;
            }

            System.out.println("콜백 호출 했슴다");

        }
    }
}
