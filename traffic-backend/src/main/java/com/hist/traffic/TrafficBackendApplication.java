package com.hist.traffic;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
////import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.beans.factory.annotation.Autowired;
//
//
//import com.hist.traffic.kafka.KafkaProducer;
//
//@SpringBootApplication
////@EntityScan(basePackages = "com.hist.traffic.entity")
//public class TrafficBackendApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(TrafficBackendApplication.class, args);
//	}
//	
//	@Autowired
//	private KafkaProducer kafkaProducer;
//	
//	@Override
//	public void run(String... args) throws Exception{
//		kafkaProducer.sendMessage();
//	}
//
//}
//



import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import com.hist.traffic.kafka.KafkaProducer;
import com.hist.traffic.kafka.TrafficProducer;
@SpringBootApplication
public class TrafficBackendApplication implements CommandLineRunner {

   

    public static void main(String[] args) {
        SpringApplication.run(TrafficBackendApplication.class, args);
    }
    
//    @Autowired
//    private KafkaProducer kafkaProducer;
//    @Override
//    public void run(String... args) throws Exception {
//        kafkaProducer.sendMessage();
//    }
    
    @Autowired
    private TrafficProducer trafficProducer;
    @Override
    public void run(String... args) throws Exception {
        trafficProducer.streamTrafficData();
    }
}
