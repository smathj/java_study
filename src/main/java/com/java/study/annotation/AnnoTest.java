package com.java.study.annotation;

import java.lang.annotation.*;
import java.lang.reflect.Method;

/**
 * ! [ RetentionPolicy 어노테이션 유지 정책 ]
 * * SOURCE : 소스 파일에서만 유지하고 컴파일 때 삭제함
 * * CLASS : 컴파일된 바이트코드(.class)에서 유지된다, 그러나 실행 때 JVM이 사용할 수 없다
 * * RUNTIME : 컴파일된 바이트코드(.class)에서 유지된다, 실행 때 JVM이 사용할 수 있다 <--------------- [Point]
 */


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Check {
    // 추상 클래스 처럼 만든다
    String name();  // 필수 ( 모든 어노테이션에 있어야함 )
    int val();
}


public class AnnoTest {

    @Check(name = "first", val = 123)
    public static void test() {
        AnnoTest obj = new AnnoTest();
        try {
            Class<?> c = obj.getClass();
            Method m = c.getMethod("test"); // AnnoTest.test

            Check check = m.getAnnotation(Check.class);
            System.out.println(check.name() + " : " + check.val());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test();
    }
}
