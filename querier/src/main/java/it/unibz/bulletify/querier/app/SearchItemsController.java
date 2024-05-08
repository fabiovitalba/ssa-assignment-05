package it.unibz.bulletify.querier.app;

import it.unibz.bulletify.querier.core.Item;
import it.unibz.bulletify.querier.core.SearchItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/items")
public class SearchItemsController {
    private SearchItems searchItems;

    @Autowired
    public SearchItemsController(SearchItems searchItems) {
        this.searchItems = searchItems;
    }

    @CrossOrigin
    @GetMapping
    public ItemsDTO findAllByCategory(@RequestParam(name = "category") String category) {
        List<Item> items = this.searchItems.findAllByCategory(category);

        return ItemsDTO.from(items);
    }
}
