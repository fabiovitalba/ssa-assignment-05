package it.unibz.bulletify.creator.app;

import it.unibz.bulletify.creator.core.CreateItem;
import it.unibz.bulletify.creator.core.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/items")
public class CreateItemController {
    private final CreateItem createItem;

    @Autowired
    public CreateItemController(CreateItem createItem) {
        this.createItem = createItem;
    }

    @PostMapping
    public ItemCreatedDTO create(@RequestBody CreateItemFormDTO body) {
        Item newItem = this.createItem.createNewItem(body.getName(), body.getCategory());

        return new ItemCreatedDTO(newItem.getId(), newItem.getName(), newItem.getCategory());
    }
}
