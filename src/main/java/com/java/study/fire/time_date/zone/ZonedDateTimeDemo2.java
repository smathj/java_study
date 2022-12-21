package com.java.study.fire.time_date.zone;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeDemo2 {
    public static void main(String[] args) {

        // 한국 출발 2017-12-09 14:30
        ZonedDateTime departure = ZonedDateTime.of(
                LocalDateTime.of(2017, 12, 9, 14, 30),
                ZoneId.of("Asia/Seoul")
        );

        System.out.println("departure = " + departure);

        // 파리 도착 2017-12-09 17:25
        ZonedDateTime arrival = ZonedDateTime.of(
                LocalDateTime.of(2017, 12, 9, 17, 25),
                ZoneId.of("Europe/Paris")
        );
        System.out.println("arrival = " + arrival);

        // 비행 시간
        System.out.println(Duration.between(departure, arrival));

        // 서로다른 지역의 시간차이를 알아서 구해준다 ㄷㄷ !!


    }
}
