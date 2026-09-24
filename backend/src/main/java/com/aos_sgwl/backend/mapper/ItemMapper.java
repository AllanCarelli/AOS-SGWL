package com.aos_sgwl.backend.mapper;

import com.aos_sgwl.backend.dto.ItemDTO;
import com.aos_sgwl.backend.model.Item;

public class ItemMapper {

    private static ItemDTO toDTO(Item item) {
        return new ItemDTO(
            item.getId(),
            item.getName(),
            item.getPreco(),
            item.getPrioridade()
        );
    }

    private static Item ToEntity(ItemDTO itemDTO) {
        return new Item(
            itemDTO.getName(),
            itemDTO.getPreco(),
            itemDTO.getPrioridade()
        );
    }
    

}