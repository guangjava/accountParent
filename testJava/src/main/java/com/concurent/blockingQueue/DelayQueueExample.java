package com.concurent.blockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueExample {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<DelayElement> queue = new DelayQueue<>();
		queue.put(new DelayElement("1"));
		Thread.sleep(500);
		DelayElement element;
		String value;
		view(queue);
		queue.put(new DelayElement("2"));
		Thread.sleep(2000);
		view(queue);
		view(queue);
	}

	/**
	 * @param queue
	 * @author zhouchenguang
	 * @date 2017年9月4日下午3:46:30
	 * @since 1.0.0
	 */
	private static void view(BlockingQueue<DelayElement> queue) {
		DelayElement element = queue.poll();
		String value = element==null ? "" : element.getValue();
		System.out.println(value);
	}
	
	private static class DelayElement implements Delayed{
		private long millis;
		private String value;
		
		/**
		 * @param value
		 */
		public DelayElement(String value) {
			this.value = value;
			millis = System.currentTimeMillis();
		}

		@Override
		public int compareTo(Delayed o) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public long getDelay(TimeUnit unit) {//返回值为正数时，这个元素不释放，负数才释放
			long delay = millis+1500-System.currentTimeMillis();
			System.out.println(value+","+delay);
			return delay;
		}

		/**
		 * 返回 #{bare_field_comment}
		 * @return the value
		 */
		public String getValue() {
			return value;
		}
		
	}

}
