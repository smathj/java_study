package com.java.study.standard.cp14_stream;

public class LambdaEx1 {


    @FunctionalInterface
    interface MyFunction {
        void run();
    }

    public static void execute(MyFunction f) {
        f.run();
    }

    public static MyFunction getMyFunction() {
        MyFunction f = () -> System.out.println("f3.run()");
        return f;
    }

    public static void main(String[] args) {
        MyFunction f1 = () -> System.out.println("f1.run()");

        MyFunction f2 = new MyFunction() {
            public void run() { // public을 반드시 붙여야함
                System.out.println("f2.run()");
            }
        };

        MyFunction f3 = getMyFunction();

        f1.run();
        f2.run();
        f3.run();

        execute(f1);
        execute(() -> System.out.printf("rnu()"));
    }


}
