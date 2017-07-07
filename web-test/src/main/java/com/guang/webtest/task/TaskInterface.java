package com.guang.webtest.task;

import java.util.concurrent.Future;

public interface TaskInterface {
	public void asyncMethodwithVoidReturnType();

	public Future<String> asyncMethodwithReturnType();
}
