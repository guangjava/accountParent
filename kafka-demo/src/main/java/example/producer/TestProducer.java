package example.producer;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;


@SuppressWarnings("deprecation")
public class TestProducer {
	public static void main(String[] args){
		long event = Long.parseLong(args[0]);
		Random random = new Random();
		
		Properties props = new Properties();
		props.put("metadata.broker.list", "broker1:9092,broker2:9092");
		props.put("serializer.class", "kafka.serializer.StringEncoder");
		props.put("partitioner.class", "example.producer.SimplePartitioner");
		props.put("request.required.acks", "1");
		
		ProducerConfig config = new ProducerConfig(props);
		
		Producer<String, String> producer = new Producer<>(config);
		
		for(long nEvents = 0; nEvents < event; nEvents++){
			long runtime = new Date().getTime();
			String ip = "192.168.2." + random.nextInt(255);
			String msg = runtime + ",www.example.com," + ip;
			KeyedMessage<String, String> data = new KeyedMessage<String, String>("page_visits", ip, msg);
			producer.send(data);
		}
		
		producer.close();
	}
}
