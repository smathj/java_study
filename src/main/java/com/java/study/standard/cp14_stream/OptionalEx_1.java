package com.java.study.standard.cp14_stream;

import java.util.Optional;

public class OptionalEx_1 {

    public static void main(String[] args) {

        String str = "abc";
        Optional<String> optVal1 = Optional.of(str);
        Optional<String> optVal2 = Optional.of("abc");
        Optional<String> optVal3 = Optional.of(new String("abc"));

        // 만일 참조변수가 null일 가능성이 있으면 Optional.ofNullable()
        Optional<Object> optVal4 = Optional.ofNullable(null);

        Optional<String> optVal5 = null;
        System.out.println("optVal5 = " + optVal5);

        Optional<String> optVal6 = Optional.empty();
        String s = optVal6.orElse(null);    // null 일때 매개변수를 반환
        System.out.println("optVal6 = " + s);

        String v1 = optVal6.orElseGet(String::new); // orElseGet는 null 일떄 반환할 값을 적어준다, 즉  null이면  "" 을 리턴
        System.out.println("v1 = " + v1);


//        String v2 = optVal6.orElseThrow(NullPointerException::new); // null 이면 지정된 예외 발생
//        System.out.println("v2 = " + v2);








    }
}
