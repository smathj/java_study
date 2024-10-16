package com.java.study.standard.cp14_stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class CollectEx_5 {

    public static void main(String[] args) {

        String[] strArr = {"aaa", "bbb", "ccc"};
        Stream<String> strStream = Stream.of(strArr);

        String result = strStream.collect(new ConcateCollector());

        System.out.println(Arrays.toString(strArr));
        System.out.println("result = " + result);

    }

    static class ConcateCollector implements Collector<String, StringBuilder, String> {
        @Override
        public Supplier<StringBuilder> supplier() {
            return () -> new StringBuilder();
        }

        @Override
        public BiConsumer<StringBuilder, String> accumulator() {
            return (sb, s) -> sb.append(s);
        }


        @Override
        public Function<StringBuilder, String> finisher() {
            return sb -> sb.toString();
        }

        @Override
        public BinaryOperator<StringBuilder> combiner() {
            return (sb, sb2) -> sb.append(sb2);
        }


        @Override
        public Set<Characteristics> characteristics() {
            return Collections.emptySet();
        }
    }

}
