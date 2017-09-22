package com.concurent.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(128);
		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);
		new Thread(producer).start();
		new Thread(consumer).start();
		Thread.sleep(3000);
	}
	
	private static class Producer implements Runnable{
		private BlockingQueue<String> queue;
		
		/**
		 * @param queue
		 */
		public Producer(BlockingQueue<String> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			try {
				queue.put("1");
				Thread.sleep(2000);
				queue.put("2");
				Thread.sleep(2000);
				queue.put("3");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private static class Consumer implements Runnable{
		private BlockingQueue<String> queue;
		
		/**
		 * @param queue
		 */
		public Consumer(BlockingQueue<String> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			try {
				System.out.println(queue.take());
				System.out.println(queue.take());
				System.out.println(queue.take());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
