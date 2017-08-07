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
		exec.submit(tt);
		System.in.read();//保持主线程存活， console端观察结果
	}

}
