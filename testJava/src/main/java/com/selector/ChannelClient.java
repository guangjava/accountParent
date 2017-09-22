package com.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ChannelClient {
	public static void main(String[] args) {
		try {
			SocketChannel sc = SocketChannel.open();
			sc.connect(new InetSocketAddress("127.0.0.1", 5000));
			ByteBuffer writeBuffer = ByteBuffer.allocate(128);
			ByteBuffer readBuffer = ByteBuffer.allocate(16);
			ByteBuffer writeBuffer2 = ByteBuffer.allocate(16);
			writeBuffer.put("hello world".getBytes());
			writeBuffer2.put("lalaland".getBytes());
			writeBuffer.flip();
			writeBuffer2.flip();
			ByteBuffer[] bufferArray = {writeBuffer,writeBuffer2};
			sc.write(bufferArray);
			sc.read(readBuffer);
			System.out.println(new String(readBuffer.array()));
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
