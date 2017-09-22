package com.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ChannelServer {
	public void open() {
		try {
			ServerSocketChannel ssc = ServerSocketChannel.open();
			ssc.bind(new InetSocketAddress("127.0.0.1", 5000));
			SocketChannel sc = ssc.accept();
			ByteBuffer readBuffer = ByteBuffer.allocate(128);
			sc.read(readBuffer);
			readBuffer.flip();
			while (readBuffer.hasRemaining()) {
				System.out.print((char)readBuffer.get());
			}
			sc.close();
			ssc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ChannelServer cs = new ChannelServer();
		cs.open();
	}
}
