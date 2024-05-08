package it.unibz.bulletify.creator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CreatorApplication {

	public static final String topicExchange = "bulletify-exchange";
	public static final String routingKey = "items.#";

	public static void main(String[] args) {
		SpringApplication
				.run(CreatorApplication.class, args);
	}

}
