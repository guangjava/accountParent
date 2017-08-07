/**
 * 
 */
package com.thread.interuptTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @comment
* 再启动一个线程池去提交 future 任务，该线程会在等待5秒后尝试获取future结果
* 并捕获future的超时异常。 最后设置future的 cancel 标志位，如果运行future的线程检查到标志位
* 改变就可以停止掉自己。
 * @author zhouchenguang
 * @date 2017年8月7日下午4:14:56
 * @version 1.0.0
 */
public class TestThread extends Thread{
	private ThreadPoolExecutor exec = new ThreadPoolExecutor(0, 10, 
			5, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(), 
			new ThreadPoolExecutor.CallerRunsPolicy());
	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		DivideFuture df = new DivideFuture();
		final Future<String> future = exec.submit(df);
		try {
			 //5秒后再超时，
            //给子线程5秒的时间打印 变量isC1,isC2,isC3的值
			System.out.println("1"+future.get(5, TimeUnit.SECONDS));
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			System.out.println("超时拉");
		}finally {
			df.cancel();
			future.cancel(true);
		}
	}

}
