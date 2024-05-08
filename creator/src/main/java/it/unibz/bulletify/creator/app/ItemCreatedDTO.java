package it.unibz.bulletify.creator.app;

public class ItemCreatedDTO {
    public static class Inner {
        private Long id;
        private String name;
        private String category;

        public Inner(Long id, String name, String category) {
            this.id = id;
            this.name = name;
            this.category = category;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getCategory() {
            return category;
        }
    }

    private Inner item;

    public ItemCreatedDTO(Long id, String name, String category) {
        this.item = new Inner(id, name, category);
    }

    public Inner getItem() {
        return item;
    }

    public void setItem(Inner item) {
        this.item = item;
    }
}
