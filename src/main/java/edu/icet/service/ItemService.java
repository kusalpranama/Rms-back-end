package edu.icet.service;

import edu.icet.model.Item;

import java.util.List;

public interface ItemService {

    void addItem(Item item);

    void updateItem(Item item);

    void deleteItem(Integer id);

    List<Item> viewItems();

    //List<Item> getByName(String itemName);
}
