package edu.icet.controller;

import edu.icet.model.Item;
import edu.icet.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/items")
@Slf4j
public class ItemController {

    private final ItemService service;
    @PostMapping("/add-item")
    public void addItem(@RequestBody Item item){
        service.addItem(item);
    }

    @PutMapping("/update-item")
    public void updateItem(@RequestBody Item item){
        service.updateItem(item);
    }

    @DeleteMapping("/delete-item/{id}")
    public void deleteItem(@PathVariable Integer id){
        service.deleteItem(id);
    }

   /* @GetMapping("/search-by-name/{itemName}")
    public List<Item> searchItemByName(@Valid @PathVariable String itemName){
        return service.getByName(itemName);
    }*/
    @GetMapping("/getAll")
    public List<Item> viewItems(){
        return service.viewItems();
    }

}
