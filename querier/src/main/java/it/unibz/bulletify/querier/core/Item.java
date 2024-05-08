package it.unibz.bulletify.querier.core;

import jakarta.persistence.*;

@Entity
@Table
public class Item {
    @Id
    private Long id;

    private String name;

    private String category;

    public Item() {
    }

    public Item(Long id, String name, String category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public Item(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
