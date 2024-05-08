package it.unibz.bulletify.querier.app;

import it.unibz.bulletify.querier.core.Item;

import java.util.List;

public class ItemsDTO {
    public static ItemsDTO from(List<Item> items) {
        return new ItemsDTO(items);
    }

    private List<Item> items;

    public ItemsDTO() {
    }

    public ItemsDTO(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
