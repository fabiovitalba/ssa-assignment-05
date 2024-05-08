package it.unibz.bulletify.creator.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateItem {
    private ItemRepository itemRepository;

    @Autowired
    public CreateItem(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item createNewItem(String name, String category) {
        return this.itemRepository.save(
                new Item(name, category)
        );
    }
}
