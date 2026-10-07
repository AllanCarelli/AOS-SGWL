package com.aos_sgwl.backend.mapper;

import org.springframework.stereotype.Component;

import com.aos_sgwl.backend.dto.ItemDTO;
import com.aos_sgwl.backend.model.Item;

// Indica que o Mapper deve ser auto-configurado pelo spring.
@Component
public class ItemMapper {
//Converte a entidade e seus atributos(Item) em DTO para enviar resposta a API
    public ItemDTO toDTO(Item item) {
        return new ItemDTO(
            item.getId(),
            item.getName(),
            item.getPreco(),
            item.getPrioridade()
        );
    }
//Converte o DTO que recebe em Entidade para que seja salvo as informações no banco
//Id gerado no banco automaticamente ao ser salvo, por esse motivo não é passado 
    public Item toEntity(ItemDTO itemDTO) {
        return new Item(
            itemDTO.getName(),
            itemDTO.getPreco(),
            itemDTO.getPrioridade()
        );
    }
    
}
