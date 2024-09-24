package com.olzhas.justforfun.controller;

import com.olzhas.justforfun.dto.ItemDto;
import com.olzhas.justforfun.entity.Item;
import com.olzhas.justforfun.mapper.ItemMapper;
import com.olzhas.justforfun.service.ItemService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "item_controller")
@RestController
@RequestMapping("api/item")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @PostMapping("/add")
    public ResponseEntity<String> addItem(@RequestBody ItemDto item) {
        itemService.save(item);
        return ResponseEntity.ok("Item added");
    }

    @GetMapping("/all")
    public ResponseEntity<List<ItemDto>> getAllItems() {
        List<ItemDto> items = itemService.findAll();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/item/{id}")
    public ResponseEntity<ItemDto> getItemById(@PathVariable Long id) {
        ItemDto item = itemService.getItem(id);
        return ResponseEntity.ok(item);
    }

    @PutMapping("/itemUP/{id}")
    public ResponseEntity<String> updateItem(@RequestBody ItemDto item, @PathVariable Long id) {
        itemService.update(item,id);
        return ResponseEntity.ok("Item updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id) {
        itemService.delete(id);
        return ResponseEntity.ok("Item deleted");
    }
}
