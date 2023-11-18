package com.java.study.first.thread_pool;

public class Test05 {

	public static void main(String[] args) {
		Account account = new Account();
		DrawThread t1 = new DrawThread(account);
		DrawThread t2 = new DrawThread(account);

		t1.start();
		t2.start();
	}
}

class Account {
	private long balance = 1000;

	public void draw(long amount) {
		balance -= amount;
	}

	public long getBalance() {
		return balance;
	}
}

class DrawThread extends Thread {
	Account account;

	DrawThread(Account account) {
		this.account = account;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			account.draw(10);
			System.out.println(this.getName() + " 출금 후 잔액 " + account.getBalance());
		}
	}
}