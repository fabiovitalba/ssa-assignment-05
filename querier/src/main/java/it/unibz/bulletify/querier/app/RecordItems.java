package it.unibz.bulletify.querier.app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.unibz.bulletify.querier.core.Item;
import it.unibz.bulletify.querier.core.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordItems {
    private final ItemRepository itemRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public RecordItems(ItemRepository itemRepository, ObjectMapper objectMapper) {
        this.itemRepository = itemRepository;
        this.objectMapper = objectMapper;
    }

    @SuppressWarnings("unused")
    public void recordItem(String jsonItem) throws JsonProcessingException {
        Item item = this.objectMapper.readValue(jsonItem,Item.class);
        this.itemRepository.save(item);
    }
}
