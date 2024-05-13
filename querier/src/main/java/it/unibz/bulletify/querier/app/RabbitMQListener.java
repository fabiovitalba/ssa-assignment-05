package it.unibz.bulletify.querier.app;

import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * We need to configure a listener in the querier application. This
 * listener must receive the messages from rabbitMQ that can handle
 * whatever comes in.
 */
@Component
public class RabbitMQListener {

    @Bean
    MessageListenerAdapter adapter(RecordItems recordItems) {
        // An adapter is a concept that we use when we have two interfaces, that
        // do not quite match each other. We need to match the RabbitMQ interface (API)
        // to the code that we want to run, when there's a new message (=RecordItems).

    }
}
