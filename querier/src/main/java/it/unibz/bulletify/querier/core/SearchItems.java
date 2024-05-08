package it.unibz.bulletify.querier.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchItems {
    private ItemRepository itemRepository;

    @Autowired
    public SearchItems(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> findAllByCategory(String category) {
        return this.itemRepository.findAllByCategory(category);
    }
}
