package com.example.JPAStudy.service;

import com.example.JPAStudy.entity.ConfigOption;
import com.example.JPAStudy.entity.Item;
import com.example.JPAStudy.repo.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;


    public Item postItem(String name){
      return itemRepository.save(Item.builder().name(name).build());
    }

    public ConfigOption postConfigOption(String name){
        return null;
    }

}
