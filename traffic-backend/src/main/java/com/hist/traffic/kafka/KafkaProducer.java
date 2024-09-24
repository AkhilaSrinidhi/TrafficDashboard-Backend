//package com.hist.traffic.kafka;
//
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//import com.launchdarkly.eventsource.EventHandler;
//import com.launchdarkly.eventsource.EventSource;
//
//import java.net.URI;
//import java.util.concurrent.TimeUnit;
//
//@Service
//public class KafkaProducer {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
//
//    private KafkaTemplate<String, String> kafkaTemplate;
//
//    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//    public void sendMessage() throws InterruptedException {
//        String topic = "wikimedia_recentchange";
//
//        // To read real-time stream data from Wikimedia, we use EventSource
//        EventHandler eventHandler = new EventChangesHandler(kafkaTemplate, topic);
//       String url = "https://stream.wikimedia.org/v2/stream/recentchange ";
//      //  String url = "https://tie.digitraffic.fi/api/tms/v1/stations/23001/sensor-constants";
//        EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));
//        EventSource eventSource = builder.build();
//        eventSource.start();
//
//        // Keep the event source running for 10 minutes
//        TimeUnit.MINUTES.sleep(10);
//    }
//}
//
//
