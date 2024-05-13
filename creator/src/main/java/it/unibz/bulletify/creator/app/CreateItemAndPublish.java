package it.unibz.bulletify.creator.app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.unibz.bulletify.creator.core.CreateItem;
import it.unibz.bulletify.creator.core.Item;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateItemAndPublish {
    // Inside this class we'll:
    // 1. receive the data from the request
    // 2. publish a message to rabbitmq
    // 3. store in the database

    /**
     * RabbitTemplate is the most basic way of sending messages to
     * rabbitMQ. It handles the communication.
     */
    private final RabbitTemplate rabbitTemplate;
    /**
     * The CreateItem instance already handles the writing to the database.
     */
    private final CreateItem createItem;
    /**
     * This is the serializer.
     * Serialize is basically the way of representing the structure of an object.
     * It is used to transfer objects.
     * It's often a structure of file, like XML.
     *
     * ObjectMapper is what Java gives us to represent an Object as a string.
     * We'll use it to create a JSON.
     */
    private final ObjectMapper objectMapper;

    @Autowired
    public CreateItemAndPublish(RabbitTemplate rabbitTemplate, CreateItem createItem, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.createItem = createItem;
        this.objectMapper = objectMapper;
    }

    public Item createAndPublish(String name, String category) throws JsonProcessingException {
        // In here we're creating a message for rabbitMQ

        // First we create an item by calling the method from createItem.
        // This also creates an item in the database.
        Item item = this.createItem.createNewItem(name,category);
        String json = this.createJson(item);
        this.rabbitTemplate.convertAndSend(
            "bulletify-exchange",   // exchange
            "items.#",                       // routing key
            json                             // content
        );

        return item;
    }

    private String createJson(Item item) throws JsonProcessingException {
        // Takes the passed item and creates a JSON from it.
        return this.objectMapper.writeValueAsString(item);
    }
}
