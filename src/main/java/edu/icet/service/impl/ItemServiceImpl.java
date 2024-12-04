package edu.icet.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.icet.entity.ItemEntity;
import edu.icet.model.Customer;
import edu.icet.model.Item;
import edu.icet.repository.ItemRepository;
import edu.icet.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class ItemServiceImpl implements ItemService {

    private final ItemRepository repository;
    private final ModelMapper mapper;

    @Override
    public void addItem(Item item) {
    repository.save(mapper.map(item,ItemEntity.class));
    }

    @Override
    public void updateItem(Item item) {
        repository.save(mapper.map(item,ItemEntity.class));
    }

    @Override
    public void deleteItem(Integer id) {
    repository.deleteById(id);
    }

    @Override
    public List<Item> viewItems() {
        List<Item> itemList = new ArrayList<>();

        repository.findAll().forEach(ItemEntity ->{
            itemList.add(mapper.map(ItemEntity,Item.class));
        });

        return itemList;
    }





}
