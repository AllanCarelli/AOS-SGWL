package com.aos_sgwl.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aos_sgwl.backend.dto.ItemDTO;
import com.aos_sgwl.backend.mapper.ItemMapper;
import com.aos_sgwl.repository.ItemRepository;


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
        return itemRepository.findAll().stream().map(ItemMapper::toDTO).toList();    
    }
    
    // Busca um item pelo ID
    public List<ItemDTO> getItemById(Long id){
        return itemRepository.findById(id).map(ItemMapper::toDTO);
    }

    // Cria e salva um novo item
    public ItemDTO createItem(ItemDTO itemDTO){
       return ItemMapper.toDTO(itemRepository.save(ItemMapper.toEntity(itemDTO)));

    }

    // Procura o item e atualiza seus dados      
    public Optional<ItemDTO> updateItem(Long id, ItemDTO itemDTO){
        return itemRepository.findById(id)
        .map(item -> {
            item.setName(itemDTO.getName());
            item.setPrioridade(itemDTO.getPrioridade());
            item.setPreco(itemDTO.getPreco());
            item.setComprado(itemDTO.getComprado())
            return ItemMapper.toDTO(itemRepository.save(product));
        })
    }

    // Verifica se existe e exclui o item
    public boolean deleteItem(Long id){
        if (!itemRepository.existsById(id)) return false;
        ItemRepository.deleteById(id);
        return true
    }

}
