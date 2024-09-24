package com.hist.traffic.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class TrafficProducer {

    private KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "vehicle_data";
    private Random random = new Random();

    public TrafficProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    
    private String[] intersectionIds = {
            "Intersection-1", "Intersection-2", "Intersection-3", 
            "Intersection-4", "Intersection-5", "Intersection-6",
            "Intersection-7", "Intersection-8", "Intersection-9", 
            "Intersection-10"
        };

    // Simulate and send traffic data
    public void streamTrafficData() throws InterruptedException {
        while (true) {
        	String intersectionId = intersectionIds[random.nextInt(intersectionIds.length)];
            int vehicleCount = random.nextInt(50);
//            long timestamp = System.currentTimeMillis();
            long initialTime = System.currentTimeMillis(); 
            long timestamp = initialTime + TimeUnit.HOURS.toMillis(random.nextInt(5));

            String data = String.format("{\"intersectionId\": \"%s\", \"vehicleCount\": %d, \"timestamp\": %d}", 
            		intersectionId, vehicleCount, timestamp);

            kafkaTemplate.send(TOPIC, data);
            System.out.println("Sent traffic data: " + data);

            // Simulate traffic data every 2 seconds
            TimeUnit.SECONDS.sleep(2);
        }
    }
}
