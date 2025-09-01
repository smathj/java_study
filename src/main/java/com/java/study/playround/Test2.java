package com.java.study.playround;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.poi.ss.formula.functions.T;

import java.time.LocalTime;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;


public class Test2 {

    public static void main(String[] args) {


        List<Keynote> keynoteList = dbload();


        log("[1] 정렬되지 않는 리스트", () -> {
            for (Keynote keynote : keynoteList) {
                System.out.println("keynote = " + keynote);
            }
        });


        log("[2] 유닛 순서로 정렬한 리스트", () -> {

            List<Keynote> sortedList = keynoteList.stream()
                    .sorted(((o1, o2) -> o1.getUnit().getSortOrder() - o2.getUnit().getSortOrder()))
                    .collect(Collectors.toList());

            for (Keynote keynote : sortedList) {
                System.out.println("keynote = " + keynote);
            }
        });



        log("[3] 유닛별 맵 생성 Key 유닛, Value 리스트", () -> {

            Map<Unit, List<Keynote>> unitMap = keynoteList.stream()
                    .collect(Collectors.groupingBy(
                            Keynote::getUnit,
                            TreeMap::new,
                            Collectors.toList()

                    ));

            for (Map.Entry<Unit, List<Keynote>> entry : unitMap.entrySet()) {
                Unit key = entry.getKey();
                List<Keynote> value = entry.getValue();
                System.out.println("key = " + key);
                System.out.println("value = " + value);
                System.out.println();
            }


        });

        log("[4] 유닛별 맵 생성 Key 유닛, Value 리스트 ✨ 정렬추가", () -> {

            Map<Unit, List<Keynote>> unitMap = keynoteList.stream()
                    .collect(Collectors.groupingBy(
                            Keynote::getUnit,
                            TreeMap::new,
                            Collectors.collectingAndThen(
                                    Collectors.toList(),
                                    list -> list.stream()
                                            .sorted((o1, o2) -> (o1.getSchedule().getStartTime().compareTo(o2.getSchedule().getStartTime())))
                                            .collect(Collectors.toList())
                            )

                    ));

            for (Map.Entry<Unit, List<Keynote>> entry : unitMap.entrySet()) {
                Unit key = entry.getKey();
                List<Keynote> value = entry.getValue();
                System.out.println("key = " + key);
                System.out.println("value = " + value);
                System.out.println();
            }


        });

        log("[5] 유닛별 맵 생성 Key 유닛, Value 리스트 정렬추가 ✨ 간단 버전", () -> {

            Map<Unit, List<Keynote>> unitMap = keynoteList.stream()
                    .collect(Collectors.groupingBy(
                            Keynote::getUnit,
                            TreeMap::new,
                            Collectors.collectingAndThen(
                                    Collectors.toList(),
                                    list -> list.stream()
                                            .sorted(Comparator.comparing(keynote -> keynote.getSchedule().getStartTime()))
                                            .collect(Collectors.toList())
                            )

                    ));

            for (Map.Entry<Unit, List<Keynote>> entry : unitMap.entrySet()) {
                Unit key = entry.getKey();
                List<Keynote> value = entry.getValue();
                System.out.println("key = " + key);
                System.out.println("value = " + value);
                System.out.println();
            }


        });


        log("[6] mapping 테스트, 제목만 List 로 추출", () -> {

            List<String> titleList = keynoteList.stream()
                    .collect(Collectors.mapping(keynote -> keynote.getTitle(), Collectors.toList()));

            for (String title : titleList) {
                System.out.println("title = " + title);
            }


        });



        log("[6] mapping 테스트, 제목만 Set 으로 추출", () -> {

            Set<String> titleSet = keynoteList.stream()
                    .collect(Collectors.mapping(keynote -> keynote.getTitle(), Collectors.toSet()));

            for (String title : titleSet) {
                System.out.println("title = " + title);
            }


        });




        log("[7] mapping 테스트, 하나의 문장으로 이어붙이기", () -> {

            String textLine = keynoteList.stream()
                    .collect(Collectors.mapping(keynote -> keynote.getTitle(), Collectors.joining(", ")));

            System.out.println("textLine = " + textLine);


        });






    }







    // 람다를 받아서 실행하는 간단한 로그 메서드
    public static void log(String description, Runnable task) {
        System.out.println("----------------------------------");
        System.out.println();
        System.out.println(">> " + description + " [Start]");

        task.run();

        System.out.println("<< " + description + " [End]");
        System.out.println();
        System.out.println("----------------------------------");
    }


    public static List<Keynote> dbload() {

        Unit unit0 = new Unit(301, "301호", 1);
        Unit unit1 = new Unit(201, "201호", 2);
        Unit unit2 = new Unit(202, "202호", 3);

//        Unit unit3 = new Unit(203, "203호", 4);

//        Schedule schedule1 = new Schedule(LocalTime.of(10, 0), LocalTime.of(11, 0));
//        Schedule schedule2 = new Schedule(LocalTime.of(12, 0), LocalTime.of(13, 0));
//        Schedule schedule3 = new Schedule(LocalTime.of(13, 0), LocalTime.of(14, 0));
//        Schedule schedule4 = new Schedule(LocalTime.of(18, 0), LocalTime.of(20, 0));


        Keynote keynote1_1 = new Keynote("키노트1-1", unit0, new Schedule(LocalTime.of(10, 0), LocalTime.of(11, 0), "N"));
        Keynote keynote1_2 = new Keynote("키노트1-2", unit0, new Schedule(LocalTime.of(11, 0), LocalTime.of(12, 0), "N"));
        Keynote keynote1_3 = new Keynote("키노트1-3", unit0, new Schedule(LocalTime.of(12, 0), LocalTime.of(15, 0), "Y"));

        Keynote keynote2_1 = new Keynote("키노트2-1", unit2, new Schedule(LocalTime.of(10, 0), LocalTime.of(12, 0), "N"));
        Keynote keynote2_2 = new Keynote("키노트2-2", unit2, new Schedule(LocalTime.of(13, 0), LocalTime.of(15, 0), "N"));

        Keynote keynote3_1 = new Keynote("키노트3-1", unit1, new Schedule(LocalTime.of(10, 0), LocalTime.of(11, 0), "N"));
        Keynote keynote3_2 = new Keynote("키노트3-2", unit1, new Schedule(LocalTime.of(11, 0), LocalTime.of(12, 0), "N"));
        Keynote keynote3_3 = new Keynote("키노트3-3", unit1, new Schedule(LocalTime.of(12, 0), LocalTime.of(13, 0), "N"));
        Keynote keynote3_4 = new Keynote("키노트3-4", unit1, new Schedule(LocalTime.of(13, 0), LocalTime.of(15, 0), "Y"));


        List<Keynote> keynoteList = List.of(keynote1_1, keynote3_2, keynote2_2, keynote1_3, keynote3_1, keynote2_1, keynote3_4, keynote1_2, keynote3_3);

        return keynoteList;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Keynote {

        private String title;
        private Unit unit;
        private Schedule schedule;



    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Unit implements Comparable<Unit> {

        private int roomNumber;
        private String roomName;
        private int sortOrder;

        @Override
        public int compareTo(Unit unit) {
//            return this.sortOrder - unit.getSortOrder();
            return Integer.compare(this.sortOrder, unit.getSortOrder());
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Schedule {

        private LocalTime startTime;
        private LocalTime endTime;
        private String breakYn;

    }


}
