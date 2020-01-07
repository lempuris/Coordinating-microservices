package com.pluralsight.microservices.console;

import java.util.Random;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.support.MessageBuilder;

@EnableBinding(TollSource.class)
//@EnableBinding(Source.class)
public class TollPublisher {
	
	Random r = new Random();

	// @InboundChannelAdapter(channel = Source.OUTPUT)
	@Bean
	//@InboundChannelAdapter(channel = "fastpassTollChannel", poller = @Poller(fixedDelay = "2000"))
	public MessageSource<Toll> sendTollCharge() {
		// return "{station:\"20\", customerId:\"100\",
		// timestamp:\"2017-07-12T03:15:00\"}";
		return () -> MessageBuilder.withPayload(new Toll("20", "100", "2017-07-12T03:15:00")).setHeader("speed", r.nextInt(8)*10).build();
	}

	class Toll {
		public String stationId;
		public String customerId;
		public String timeStamp;

		public Toll() {
			// TODO Auto-generated constructor stub
		}

		public Toll(String stationId, String customerId, String timeStamp) {
			super();
			this.stationId = stationId;
			this.customerId = customerId;
			this.timeStamp = timeStamp;
		}

	}

}
