/**
 * 
 */
package com.thread.interuptTest;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @comment
* 通过线程池 开启一个线程去处理
* 模拟请求来时，开启一个线程处理请求的场景
 * @author zhouchenguang
 * @date 2017年8月7日下午4:10:05
 * @version 1.0.0
 */
public class Main {

	/**
	 * @param args
	 * @author zhouchenguang
	 * @throws IOException 
	 * @date 2017年8月7日下午4:10:05
	 * @since 1.0.0
	 */
	public static void main(String[] args) throws IOException {
		ThreadPoolExecutor exec = new ThreadPoolExecutor(0, 10, 
				5, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(),
				new ThreadPoolExecutor.CallerRunsPolicy());
		TestThread tt = new TestThread();
		Thread.yield();
		exec.submit(tt);
		System.in.read();//保持主线程存活， console端观察结果
		/*超时拉
		4
		变量 isC1 的值:true
		变量 isC1 通过ThreadLocal获取的值:false
		变量 isC2 的值:true
		变量 isC2 通过ThreadLocal获取的值:false
		变量 isC3 的值:com.thread.interuptTest.RichBoolean@1339a0dc
		变量 isC3 通过ThreadLocal获取的值:com.thread.interuptTest.RichBoolean@1339a0dc*/
		/*我们cancel时是将isC2的变量重新赋值了，也就是说isC2指向了一个新的对象 而thISC2 里面还是老的值，所以他们打印出来的结果不同。

		同理，isC1 = true 这句话因为jdk 封包操作的原因类似isC2也是重新new了一个对象，isC1指向了新对象，而thISC1中还是老对象。*/
	}

}
