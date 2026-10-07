package com.aos_sgwl.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aos_sgwl.backend.dto.ItemDTO;
import com.aos_sgwl.backend.mapper.ItemMapper;
import com.aos_sgwl.backend.repository.ItemRepository;

@Service
public class ItemService {
    private final ItemMapper itemMapper;
    
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper){
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public List<ItemDTO> getAllItem(){
        return itemRepository.findAll().stream().map(itemMapper::toDTO).toList();    
    }

    public Optional<ItemDTO> getItemById(Long id){
        return itemRepository.findById(id).map(itemMapper::toDTO);
    }
    public ItemDTO createItem(ItemDTO itemDTO){
       return itemMapper.toDTO(itemRepository.save(itemMapper.toEntity(itemDTO)));

    }
         
    public Optional<ItemDTO> updateItem(Long id, ItemDTO itemDTO){
        return itemRepository.findById(id)
        .map(item -> {
            item.setName(itemDTO.getName());
            item.setPrioridade(itemDTO.getPrioridade());
            item.setPreco(itemDTO.getPreco());
            return itemMapper.toDTO(itemRepository.save(item));
        });
    }
    public boolean deleteItem(Long id){
        if (!itemRepository.existsById(id)) return false;
        itemRepository.deleteById(id);
        return true;
    }

}
