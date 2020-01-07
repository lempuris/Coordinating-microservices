package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.SendTo;

@SpringBootApplication
@EnableBinding(Sink.class)
//@EnableBinding(Processor.class)
public class PluralsightStreamTollintakeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PluralsightStreamTollintakeApplication.class, args);
	}

	@StreamListener(target = Sink.INPUT, condition = "headers['speed'] > 40")
	// @ServiceActivator(inputChannel = Sink.INPUT)
	// @StreamListener(Processor.INPUT)
	// @SendTo(Processor.OUTPUT)
	public void log(String message) {
		System.out.println("fast " + message);

	}

	@StreamListener(target = Sink.INPUT, condition = "headers['speed'] <= 40")
	public void slowLog(String message) {
		System.out.println("Slow " + message);
	}

}
