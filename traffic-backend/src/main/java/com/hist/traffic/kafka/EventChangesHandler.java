//package com.hist.traffic.kafka;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import com.launchdarkly.eventsource.EventHandler;
//import com.launchdarkly.eventsource.MessageEvent;
//
//public class EventChangesHandler implements EventHandler {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(EventChangesHandler.class);
//
//    private KafkaTemplate<String, String> kafkaTemplate;
//    private String topic;
//
//    public EventChangesHandler(KafkaTemplate<String, String> kafkaTemplate, String topic) {
//        this.kafkaTemplate = kafkaTemplate;
//        this.topic = topic;
//    }
//
//    @Override
//    public void onOpen() throws Exception {
//        // Method to handle open connection
//    }
//
//    @Override
//    public void onClosed() throws Exception {
//        // Method to handle closed connection
//    }
//
//    @Override
//    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
//        LOGGER.info(String.format("Event data -> %s", messageEvent.getData()));
//        kafkaTemplate.send(topic, messageEvent.getData());
//    }
//
//    @Override
//    public void onComment(String s) throws Exception {
//        // Method to handle comments
//    }
//
//    @Override
//    public void onError(Throwable t) {
//        LOGGER.error("Error in event stream", t);
//    }
//}
