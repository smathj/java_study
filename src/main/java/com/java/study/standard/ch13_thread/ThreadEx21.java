package com.java.study.standard.ch13_thread;

public class ThreadEx21 {
    public static void main(String[] args) {

        Runnable r = new RunnableEx21();
        new Thread(r).start();  // ThreadGroup에 의해 참조되므로 gc대상이 아니다
        new Thread(r).start();  // ThreadGroup에 의해 참조되므로 gc대상이 아니다

    }
}

class Account {
    private int balance = 1000;

    public int getBalance() {
        return balance;
    }

    // ! v1.
    /*
    public synchronized void withdraw(int money) {
        if (balance >= money) {
            try {
                Thread.sleep(1000);
            } catch(Exception e) {
                e.printStackTrace();
            }
            balance -= money;
        }
    }
    */

    // ! v2.
    public void withdraw(int money) {
        /**
         * 블록안으로 들어오면 lock을 얻고 나가면 lock을 반납한다
         * this는 락을 걸고자하는 객체를 참조
         */
        synchronized (this) {   // this = Account,
//            System.out.println("this = " + this);
//            System.out.println("this.getClass().getName() = " + this.getClass().getName());
            if (balance >= money) {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                balance -= money;
            }
        }

    }
}

class RunnableEx21 implements Runnable {
    Account acc = new Account();

    @Override
    public void run() {
        while (acc.getBalance() > 0) {
            // 100, 200, 300 중의 한 값을 임의로 선택하여 출금(withdraw)
            int money = (int) (Math.random() * 3 + 1) * 100;
            acc.withdraw(money);
            System.out.println("balance: " + acc.getBalance());
        }
    }
}