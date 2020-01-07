package com.pluralsight.microservices.console;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FastPassRestControllerr {

	@Autowired
	TollSource tollSource;

	@PostMapping("/toll")
	public String publishMessage(@RequestBody String payload) {

		System.out.println(payload);
		Random r = new Random();
		tollSource.fastpassToll()
				.send(MessageBuilder.withPayload(payload).setHeader("speed", r.nextInt() * 10).build());
		return "success";

	}

}
