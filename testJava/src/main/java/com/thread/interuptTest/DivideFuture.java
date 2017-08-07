package com.thread.interuptTest;

import java.util.concurrent.Callable;

/**
 * @comment
* 使用了三种不同类型的标志位，用来更好的说明 jdk对基本类型的封包操作
* 使用threadlocal的原因是 如果call 方法再调用了其他bean 的其他方法 仍然可以通过threadlocal 获取到cancel的标志位 这里为了简单没有增加调用其他方法的代码
* 但是不影响说明原理
 * @author zhouchenguang
 * @date 2017年8月7日下午5:15:07
 * @version 1.0.0
 */
public class DivideFuture implements Callable<String>{
	private boolean b1;
	private Boolean b2;
	private RichBoolean b3;
	private ThreadLocal<Object> thlb1 = new ThreadLocal<>();
	private ThreadLocal<Boolean> thlb2 = new ThreadLocal<>();
	private ThreadLocal<RichBoolean> thlb3 = new ThreadLocal<>();
	/**
	 * 修改isC1,isC2,isC3的标志位
	 * @author zhouchenguang
	 * @date 2017年8月7日下午5:17:19
	 * @since 1.0.0
	 */
	public void cancel() {
		b1 = true;
		b2 = true;
		b3.setValue(true);
	}
	@Override
	public String call() throws Exception {
		//在线程调用时，再将isC初始化，
        //是的threadLocal取到的线程是执行该方法的线程
		b1 = false;
		b2 = false;
		b3 = new RichBoolean(false);
		thlb1.set(b1);
		thlb2.set(b2);
		thlb3.set(b3);
		for(int i=0; i<10; i++){
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			}
			System.out.println(i);
            System.out.println( "变量 isC1 的值:" + b1 );
            System.out.println( "变量 isC1 通过ThreadLocal获取的值:" + thlb1.get() );
 
            System.out.println( "变量 isC2 的值:" + b2 );
            System.out.println( "变量 isC2 通过ThreadLocal获取的值:" + thlb2.get() );
 
            System.out.println( "变量 isC3 的值:" + b3 );
            System.out.println( "变量 isC3 通过ThreadLocal获取的值:" + thlb3.get() );
		}
		return "this is callable";
	}

}
