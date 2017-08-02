package com.jvm;

public class FalseShareTest implements Runnable{
	public static int NUM_THREADS = 2;
	public final static long ITERATIONS = 500L * 1000L * 1000L;
	private final int arrayIndex;
	public static long SUM_TIME = 0l;
	private static VolatileLong[] longs;
	
	public FalseShareTest(final int arrayIndex) {
		this.arrayIndex = arrayIndex;
	}

	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(5000);
		if (args.length > 0) {
			NUM_THREADS = Integer.valueOf(args[0]);
		}
		for(int i=0; i<10; i++){
			System.out.println(i);
			longs = new VolatileLong[NUM_THREADS];
			for(int j=0; j<NUM_THREADS; j++){
				longs[j] = new VolatileLong();
			}
			final long start = System.nanoTime();
			runTest();
			final long end = System.nanoTime();
			SUM_TIME += (end - start);
		}
		System.out.println("平均耗时："+SUM_TIME/10);
	}
	
	private static void runTest() throws InterruptedException {
		Thread[] threads = new Thread[NUM_THREADS];
		for(int i=0; i<NUM_THREADS; i++){
			threads[i] = new Thread(new FalseShareTest(i));
		}
		for(Thread t : threads){
			t.start();
		}
		for (Thread t : threads) {
			t.join();
		}
	}

	@Override
	public void run() {
		long i = ITERATIONS + 1;
		while (0 < --i) {
			longs[arrayIndex].value = i;
		}
	}

	public final static class VolatileLong{
		public volatile long value = 0l;
//		public long p1,p2,p3,p4,p5,p6;
//		四线程下结果
//		不屏蔽 平均耗时：15451786052
//		屏蔽     平均耗时：31085986600
//		时间相差两倍，因为存在伪共享
//		双线程下结果
//		不屏蔽 平均耗时：10115539292
//		屏蔽     平均耗时：14972244885
	}
}
