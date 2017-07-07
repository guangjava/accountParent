package example.consumer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

public class ConsumerGroupExample {
	private final ConsumerConnector consumer;
	private final String topic;
	private ExecutorService excutor;
	
	public ConsumerGroupExample(String a_zookeeper, String a_groupId, String a_topic) {
		consumer = Consumer.createJavaConsumerConnector(
				createConsumerConfig(a_zookeeper,a_groupId));
		this.topic = a_topic;
	}
	
	public void shutdown() {
		if (consumer != null) {
			consumer.shutdown();
		}
		if (excutor != null) {
			excutor.shutdown();
		}
		try {
			if (!excutor.awaitTermination(5000, TimeUnit.MILLISECONDS)) {
				System.out.println("Timed out waiting for consumer threads to shut down, exiting uncleanly");
			}
		} catch (InterruptedException e) {
			System.out.println("Interrupted during shutdown, exiting uncleanly");
		}
	}
	
	public void run(int a_numThreads) {
		Map<String, Integer> topicCountMap = new HashMap<>();
		topicCountMap.put(topic, new Integer(a_numThreads));
		Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
		List<KafkaStream<byte[], byte[]>> streams = consumerMap.get(topic);
		
		//now launch all the threads
		
		excutor = Executors.newFixedThreadPool(a_numThreads);
		
		//now create an object to consume the messages
		
		int threadNumber = 0;
		for (final KafkaStream<byte[], byte[]> stream : streams) {
			excutor.submit(new ConsumerTest(stream,threadNumber));
			threadNumber++;
		}
	}
	
	private static ConsumerConfig createConsumerConfig(String a_zookeeper, String a_groupId) {
		Properties props = new Properties();
		props.put("zookeeper.connect", a_zookeeper);
		props.put("group.id", a_groupId);
		props.put("zookeeper.session.timeout.ms", "400");
		props.put("zookeeper.sync.time.ms", "200");
		props.put("auto.commit.interval.ms", "1000");
		
		return new ConsumerConfig(props);
	}
	
	public static void main(String[] args) {
		String zookeeper = args[0];
		String groupId = args[1];
		String topic = args[2];
		int threads = Integer.parseInt(args[3]);
		
		ConsumerGroupExample example = new ConsumerGroupExample(zookeeper, groupId, topic);
		example.run(threads);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			
		}
		example.shutdown();
	}
}
