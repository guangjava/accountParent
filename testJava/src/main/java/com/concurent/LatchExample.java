package com.concurent;

import java.util.concurrent.CountDownLatch;

public class LatchExample {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		Waiter waiter = new Waiter(latch);
		Decrementer decrementer = new Decrementer(latch);
		new Thread(waiter).start();
		new Thread(decrementer).start();
	}
	
	private static class Waiter implements Runnable{
		private CountDownLatch latch;

		/**
		 * @param latch
		 */
		public Waiter(CountDownLatch latch) {
			this.latch = latch;
		}

		@Override
		public void run() {
			try {
				latch.await();
				System.out.println("wait is ok");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private static class  Decrementer implements Runnable{
		private CountDownLatch latch;
		@Override
		public void run() {
			try {
				Thread.sleep(1000);
				latch.countDown();
				System.out.println(1);
				Thread.sleep(1000);
				latch.countDown();
				System.out.println(2);
				Thread.sleep(1000);
				latch.countDown();
				System.out.println(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		/**
		 * @param latch
		 */
		public Decrementer(CountDownLatch latch) {
			this.latch = latch;
		}
		
	}

}
