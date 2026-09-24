package com.aos_sgwl.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aos_sgwl.backend.dto.ItemDTO;
import com.aos_sgwl.backend.mapper.ItemMapper;
import com.aos_sgwl.repository.ItemRepository;


@Service 
public class ItemService {
    private final ItemMapper itemMapper;
    
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper){
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public List<ItemDTO> getAllItem(){
        return itemRepository.findAll().stream().map(ItemMapper::toDTO).toList();    
    }

    public List<ItemDTO> getItemById(Long id){
        return itemRepository.findById(id).map(ItemMapper::toDTO);
    }

         
}
