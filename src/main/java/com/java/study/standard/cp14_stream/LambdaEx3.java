package com.java.study.standard.cp14_stream;

public class LambdaEx3 {


    @FunctionalInterface
    interface MyFunction {
        void myMethod();
    }

    public static class Outer {
        int val = 10;   // Outher.this.val

        class Inner {
            int val = 20;   // this.val

            void method(int i) {    // void method(final int i)
                int val = 30;   // final int val = 30;
//                i = 10; // 에러, 상수의 값을 변경할 수 없음

                // 람다식 내에서 참조하는 지역변수는 상수로 간주한다(final이 붙지않아도)
                //  MyFunction f = (i) -> {                                                   // 외부 지역변수와 같은 이름의 매개변수는 허용되지 않는다
                MyFunction f = () -> {
                    System.out.println("            i : " + i);                             // 상수
                    System.out.println("            val : " + val);                         // 상수
                    System.out.println("            this.val : " + this.val);
                    System.out.println("            Outer.this.val : " + Outer.this.val);
                };

                f.myMethod();

            }   // Inner End
        }   // Outer
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.method(100);


    }


}
