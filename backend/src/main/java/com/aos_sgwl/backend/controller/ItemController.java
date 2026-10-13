package com.aos_sgwl.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aos_sgwl.backend.dto.ItemDTO;
import com.aos_sgwl.backend.service.ItemService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController

@RequestMapping("/api")

@Tag(name = "Item", description = "CRUD operations for item")

public class ItemController {

    private final ItemService ItemService;

    public ItemController(ItemService itemService){
        this.ItemService = itemService;
    }

    @GetMapping
    public List<ItemDTO> getAll() {
        return ItemService.getAllItem();
    }
    
    
    
}
