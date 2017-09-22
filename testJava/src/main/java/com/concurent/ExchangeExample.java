package com.concurent;

import java.util.concurrent.Exchanger;

public class ExchangeExample {
	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<>();
		ExchangerRunable<String> runable1 = new ExchangerRunable<String>(exchanger, "A");
		ExchangerRunable<String> runable2 = new ExchangerRunable<String>(exchanger, "B");
		new Thread(runable1).start();
		new Thread(runable2).start();
	}
	private static class  ExchangerRunable<E> implements Runnable{
		private Exchanger<E> exchanger; 
		private E object;
		/**
		 * @param exchanger
		 * @param object
		 */
		public ExchangerRunable(Exchanger<E> exchanger, E object) {
			this.exchanger = exchanger;
			this.object = object;
		}
		@Override
		public void run() {
			try {
				E previous = object;
				object = exchanger.exchange(object);
				System.out.println(Thread.currentThread().getName()+
						" exchange "+previous+" for "+object);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
