package it.unibz.bulletify.creator.app;

import com.fasterxml.jackson.core.JsonProcessingException;
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
    private final CreateItemAndPublish createItem;

    @Autowired
    public CreateItemController(CreateItemAndPublish createItem) {
        this.createItem = createItem;
    }

    // Whenever POST /v1/items is called, this method is invoked.
    @PostMapping
    public ItemCreatedDTO create(@RequestBody CreateItemFormDTO body) throws JsonProcessingException {
        Item newItem = this.createItem.createAndPublish(body.getName(), body.getCategory());

        return new ItemCreatedDTO(newItem.getId(), newItem.getName(), newItem.getCategory());
    }
}
