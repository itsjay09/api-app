package com.farmer.controller;

import com.farmer.model.Item;
import com.farmer.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final Logger logger = LoggerFactory.getLogger(ItemController.class);

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable("id") long id) {
        Item item = itemService.getItem(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Item>> getAllItem() {
        logger.info("start method getAllUser()");
        List<Item> users = itemService.getAllItem();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Item> saveItem(@PathVariable Item item) {
        Item savedItem = itemService.saveItem(item);
        return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
    }
}
