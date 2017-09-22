package com.concurent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class BarrierExample {

	public static void main(String[] args) {
		Runnable barrier1Action = new Runnable() {
			public void run() {
				System.out.println("Barrier1Action Done");
			}
		};
		Runnable barrier2Action = new Runnable() {
			public void run() {
				System.out.println("Barrier2Action Done");
			}
		};
		CyclicBarrier barrier1 = new CyclicBarrier(2, barrier1Action);
		CyclicBarrier barrier2 = new CyclicBarrier(2, barrier2Action);
		CyclicBarrierRunnable runnable1 = new CyclicBarrierRunnable(barrier1, barrier2);
		CyclicBarrierRunnable runnable2 = new CyclicBarrierRunnable(barrier1, barrier2);
		new Thread(runnable1).start();
		new Thread(runnable2).start();
	}
	
	private static class CyclicBarrierRunnable implements Runnable{
		private CyclicBarrier barrier1;
		private CyclicBarrier barrier2;
		@Override
		public void run() {
			try {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName()+
						" waiting at barrier1");
				barrier1.await();
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName()+
						" waiting at barrier2");
				barrier2.await();
				System.out.println(Thread.currentThread().getName()+
						" done");
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
			
		}
		/**
		 * @param barrier1
		 * @param barrier2
		 */
		public CyclicBarrierRunnable(CyclicBarrier barrier1, CyclicBarrier barrier2) {
			this.barrier1 = barrier1;
			this.barrier2 = barrier2;
		}
		
	}

}
