package com.thread.interuptTest;

public class IncreaseThread extends Thread{
	public long i = 0;

	/* (non-Javadoc)
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		while (true) {
			i++;
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		IncreaseThread thread = new IncreaseThread();
		thread.start();
		Thread.sleep(1000);
		System.out.println(thread.i);
		thread.stop();;
		return;
	}
	
}
