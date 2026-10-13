package com.aos_sgwl.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.aos_sgwl.backend.dto.ItemDTO;
import com.aos_sgwl.backend.mapper.ItemMapper;
import com.aos_sgwl.backend.repository.ItemRepository;


@Service 
public class ItemService {
    // Declara os componentes usados pelo Service
    private final ItemMapper itemMapper;
    private final ItemRepository itemRepository;
    
    // Inicializa o Repository e o Mapper
    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper){
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    // Busca todos os itens e transforma em DTO
    public List<ItemDTO> getAllItem(){
        return itemRepository.findAll().stream().map(itemMapper::toDTO).toList();    
    }
    
    // Busca um item pelo ID
    public Optional<ItemDTO> getItemById(Long id){
        return itemRepository.findById(id).map(itemMapper::toDTO);
    }

    // Cria e salva um novo item
    public ItemDTO createItem(ItemDTO itemDTO){
        return itemMapper.toDTO(itemRepository.save(itemMapper.toEntity(itemDTO)));

    }

    // Procura o item e atualiza seus dados      
    public Optional<ItemDTO> updateItem(Long id, ItemDTO itemDTO){
        return itemRepository.findById(id)
        .map(item -> {
            item.setName(itemDTO.getName());
            item.setPrioridade(itemDTO.getPrioridade());
            item.setPreco(itemDTO.getPreco());
            item.setComprado(itemDTO.getComprado());
            return itemMapper.toDTO(itemRepository.save(item));
        });
    }

    // Verifica se existe e exclui o item
    public boolean deleteItem(Long id){
        if (!itemRepository.existsById(id)) return false;
        itemRepository.deleteById(id);
        return true;
    }

}
