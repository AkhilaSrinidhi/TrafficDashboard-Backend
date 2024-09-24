package com.hist.traffic.kafka;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
public class TrafficStreamController {

    private final TrafficDataConsumer trafficDataConsumer;

    public TrafficStreamController(TrafficDataConsumer trafficDataConsumer) {
        this.trafficDataConsumer = trafficDataConsumer;
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/traffic-stream")
    public SseEmitter streamTrafficData() {
        return trafficDataConsumer.addEmitter();
    }
}
