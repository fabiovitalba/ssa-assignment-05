package it.unibz.bulletify.querier.app;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
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

        // MessageListenerAdapter uses meta-programming in order to find the correct method
        // to call using the provided string.
        return new MessageListenerAdapter(recordItems,"recordItem");
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connFactory, MessageListenerAdapter adapter) {
        // This container is a package that we're going to inject into Spring, so that Spring
        // knows what to do, when messages come in.
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();

        // For the connection connFactory that we have:
        container.setConnectionFactory(connFactory);
        // it goes to the queue "items":
        container.setQueueNames("items");
        // attaches the listener for new messages:
        container.setMessageListener(adapter);

        return container;
    }
}
