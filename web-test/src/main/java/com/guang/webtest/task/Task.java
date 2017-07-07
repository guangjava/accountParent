package com.guang.webtest.task;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;

@Async
public class Task implements TaskInterface,Cloneable{
	public void asyncMethodwithVoidReturnType() {
		System.out.println("execute method in asychoronous "+Thread.currentThread().getName());
	}
	
	public Future<String> asyncMethodwithReturnType() {
		System.out.println("excute method in asychoronous "+Thread.currentThread().getName());
		try {
			Thread.sleep(10000);
			return new AsyncResult<String>("hello world");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

}
