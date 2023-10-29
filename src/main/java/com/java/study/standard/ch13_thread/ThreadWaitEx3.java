package com.java.study.standard.ch13_thread;

import java.util.ArrayList;

public class ThreadWaitEx3 {

    public static void main(String[] args) throws Exception {

        Table table = new Table();  // 여러 쓰레드가 공유하는 객체

        new Thread(new Cook(table), "COOK1").start();
        new Thread(new Customer(table, "donut"), "CUST1").start();
        new Thread(new Customer(table, "burger"), "CUST2").start();

        Thread.sleep(2000);  // 0.1초 (100밀리 세컨드) 후에 강제 종료시킨다
        System.exit(0);     // 프로그램 전체를 종료(모든 쓰레드가 종료됨)
    }

    static class Customer implements Runnable {

        private Table table;
        private String food;

        public Customer(Table table, String food) {
            this.table = table;
            this.food = food;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }

                String name = Thread.currentThread().getName();
                table.remove(food);
                System.out.println(name + " ate a " + food);

            }
        }

    }

    static class Cook implements Runnable {

        private Table table;

        public Cook(Table table) {
            this.table = table;
        }

        @Override
        public void run() {
            while (true) {
                // 임의의 요리를 하나 선택해서 table에 추가한다
                int idx = (int) (Math.random() * table.dishNum());
                table.add(table.dishNames[idx]);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
            }
        }

    }

    static class Table {
        String[] dishNames = {"donut", "donut", "burger"};  // 도넛이 더 자주나옴
        final int MAX_FOOD = 6; // 테이블 최대 음식갯수

        private ArrayList<String> dishes = new ArrayList<>();

        public synchronized void add(String dish) {

            while (dishes.size() >= MAX_FOOD) {
                String name = Thread.currentThread().getName();
                System.out.println(name + " is waiting");
                try {
                    wait(); // COOK 쓰레드를 기다리게 한다
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }

            dishes.add(dish);
            notify();   // 기다리고 있는 CUST를 깨우기 위함
            System.out.println("Dishes: " + dishes.toString());
        }




        public void remove(String dishName) {

            synchronized (this) {
                String name = Thread.currentThread().getName();

                // !
                while (dishes.size() == 0) {
                    System.out.println(name + " is waiting");
                    try {
                        wait(); // CUST 쓰레드를 기다리게 한다
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }
                }

                while (true) {
                    for (int i = 0; i < dishes.size(); i++) {
                        if (dishName.equals(dishes.get(i))) {
                            dishes.remove(i);
                            notify();   // 잠자고 있는 COOK을 꺠우기 위함
                        }
                    }

                    try {
                        System.out.println(name + " is waiting");
                        wait(); // 원하는 음식이 없는 CUST 쓰레드를 기다리게 한다
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }

        public int dishNum() {
            return dishNames.length;
        }
    }

}
