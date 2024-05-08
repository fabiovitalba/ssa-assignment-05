package it.unibz.bulletify.creator.core;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = { "name", "category" })
})
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "category")
    private String category;

    public Item() {
    }

    public Item(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public Item(Long id, String name, String category) {
        this.id = id;
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
