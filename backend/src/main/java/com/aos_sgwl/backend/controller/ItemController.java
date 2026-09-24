package com.aos_sgwl.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController

@RequestMapping("/api")

@Tag(name = "Item", description = "CRUD operations for item")

public class ItemController {
    private final ItemService ItemService;

    public ItemController(ItemService ItemService){
        this.itemService = itemService;
    }

    @GetMapping
    
    
}
