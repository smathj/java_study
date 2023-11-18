package com.java.study.practical.ch6_parallel.part7_분할반복;

import java.util.List;
import java.util.Spliterator;

public class SpliteratorExample2 {

    // Spliterator에 포함된 데이터의 개수를 예측한다
    public static void printSize(String name, Spliterator<HelloPerson> spliterator) {
        System.out.printf("Estimated size (%s) : %s\n", name, spliterator.estimateSize());
    }

    // Spliterator의 데이터를 출력한다
    public static void printSpliterator(Spliterator<HelloPerson> spliterator) {
        spliterator.forEachRemaining((person) -> {
            System.out.printf("안녕~~ %s\n", person);
        });
    }
    public static void main(String[] args) {
        List<HelloPerson> personList = HelloPerson.getSampleDate();

        Spliterator<HelloPerson> spliterator1 = personList.spliterator();
        long exactSizeIfKnown = spliterator1.getExactSizeIfKnown();
        System.out.println("exactSizeIfKnown = " + exactSizeIfKnown);

        printSize("spliterator1", spliterator1);

        // spliterator1을 분할한다
        Spliterator<HelloPerson> spliterator2 = spliterator1.trySplit();

        System.out.println("첫 번쨰 split 후");
        printSize("spliterator1", spliterator1);
        printSize("spliterator2", spliterator2);

        // spliterator1을 다시 분할한다
        Spliterator<HelloPerson> spliterator3 = spliterator1.trySplit();


        System.out.println("두 번쨰 split 후");
        printSize("spliterator1", spliterator1);
        printSize("spliterator2", spliterator2);
        printSize("spliterator3", spliterator3);

        System.out.println(" ");
        System.out.println("spliterator1 출력");
        printSpliterator(spliterator1);
        System.out.println("spliterator2 출력");
        printSpliterator(spliterator2);
        System.out.println("spliterator3 출력");
        printSpliterator(spliterator3);
    }
}
