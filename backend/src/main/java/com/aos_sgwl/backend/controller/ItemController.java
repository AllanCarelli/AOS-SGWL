package com.aos_sgwl.backend.controller;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aos_sgwl.backend.dto.ItemDTO;
import com.aos_sgwl.backend.service.ItemService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController

@RequestMapping("/api")

@Tag(name = "Item", description = "CRUD operations for itens")

public class ItemController {

    private final ItemService ItemService;

    public ItemController(ItemService itemService){
        this.ItemService = itemService;
    }

    @GetMapping
    public List<ItemDTO> getAll() {
        return ItemService.getAllItem();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDTO> getById(@PathVariable Long id){
        return ItemService.getItemById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}")
    public ResponseEntity<ItemDTO> create(@Valid @RequestBody ItemDTO itemDTO) {
        return ResponseEntity.status(201).body(ItemService.createItem(itemDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemDTO> update(@PathVariable long id, @Valid @RequestBody ItemDTO itemDTO) {
        return ItemService.updateItem(id, itemDTO).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        return ItemService.deleteItem(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
