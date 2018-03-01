package com.guang.core;

/**
 * @comment Java8中用sun.misc.Contended避免伪共享(false sharing)
 * @author zhouchenguang
 * @date 2017年11月18日下午11:47:37
 * @version 1.0.0
 */
public class FalseSharing implements Runnable{
	public final static int NUM_THREADS = 4;
	public static final long ITERATIONS = 500L * 1000L * 1000L;
	private final int arrayIndex;
	
	private static VolatileLong3[] longs = new VolatileLong3[NUM_THREADS];
	static{
		for(int i=0; i<NUM_THREADS; i++){
			longs[i] = new VolatileLong3();
		}
	}
	public FalseSharing(int arrayIndex) {
		this.arrayIndex = arrayIndex;
	}
	
	public static void main(String[] args) throws InterruptedException {
		long start = System.nanoTime();
		runTest();
		System.out.println("duration = "+(System.nanoTime()-start));
	}

	private static void runTest() throws InterruptedException {
		Thread[] threads = new Thread[NUM_THREADS];
		for(int i=0; i<NUM_THREADS; i++){
			threads[i] = new Thread(new FalseSharing(i));
		}
		
		for (Thread thread : threads) {
			thread.start();
		}
		
		for (Thread thread : threads) {
			thread.join();
		}
	}

	@Override
	public void run() {
		long i = ITERATIONS + 1;
		while( 0 != --i){
			longs[arrayIndex].value = i;
		}
		
	}
	
	public static final class VolatileLong{
		public volatile long value = 0l;
	}
	
	// long padding避免false sharing  
    // 按理说jdk7以后long padding应该被优化掉了，但是从测试结果看padding仍然起作用  
    public final static class VolatileLong2 {  
        volatile long p0, p1, p2, p3, p4, p5, p6;  
        public volatile long value = 0L;  
        volatile long q0, q1, q2, q3, q4, q5, q6;  
    }  
	
	 // jdk8新特性，Contended注解避免false sharing  
    // Restricted on user classpath  
    // Unlock: -XX:-RestrictContended  
	@sun.misc.Contended
	public static final class VolatileLong3{
		public volatile long value = 0l;
	}

}
