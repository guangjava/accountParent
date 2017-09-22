package com.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class SelectorDemo {
	
	public void useSelector() throws IOException {
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.configureBlocking(false);
		serverSocketChannel.socket().bind(new InetSocketAddress(5000));
		Selector selector = Selector.open();
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		ByteBuffer readBuffer = ByteBuffer.allocate(128);
		ByteBuffer writeBuffer = ByteBuffer.allocate(16);
		writeBuffer.put("received.".getBytes());
		while (true) {
			int n = selector.select();
			if (n > 0) {
				Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
				while (iterator.hasNext()) {
					SelectionKey selectionKey = (SelectionKey) iterator.next();
					System.out.println(selectionKey.isValid());
					iterator.remove();
					if (selectionKey.isAcceptable()) {
						SocketChannel sc = serverSocketChannel.accept();
						sc.configureBlocking(false);
						sc.register(selector, SelectionKey.OP_READ);
					}else if (selectionKey.isReadable()) {
						SocketChannel channel = (SocketChannel) selectionKey.channel();
						readBuffer.clear();
						channel.read(readBuffer);
						readBuffer.flip();
						System.out.println(new String(readBuffer.array()));
						selectionKey.interestOps(SelectionKey.OP_WRITE);
					}else if (selectionKey.isWritable()) {
						writeBuffer.rewind();
						SocketChannel channel = (SocketChannel) selectionKey.channel();
						channel.write(writeBuffer);
						selectionKey.interestOps(SelectionKey.OP_READ);
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		SelectorDemo demo = new SelectorDemo();
		try {
			demo.useSelector();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
