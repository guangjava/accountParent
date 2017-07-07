package guang.producer;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class TestProducer {
	public static void main(String[] args){
		long event = Long.parseLong(args[0]);
		Random random = new Random();
		
		Properties props = new Properties();
		props.put("metadata.broker.list", "broker1:9092,broker2:9092");
		props.put("serializer.class", "kafka.serializer.StringEncoder");
		props.put("request.required.acks", "1");
		
		KafkaProducer<String, String> producer = new KafkaProducer<>(props);
		
		for(long nEvents = 0; nEvents < event; nEvents++){
			long runtime = new Date().getTime();
			String ip = "192.168.2." + random.nextInt(255);
			String msg = runtime + ",www.example.com," + ip;
			ProducerRecord<String, String> data = new ProducerRecord<String, String>("page_visits", ip, msg);
			producer.send(data);
		}
		
		producer.close();
	}
}
