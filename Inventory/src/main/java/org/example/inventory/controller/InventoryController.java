package org.example.inventory.controller;


import org.example.inventory.common.InventoryResponse;
import org.example.inventory.model.InventoryModel;
import org.example.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/create")
    public InventoryResponse createInventory(@RequestBody InventoryModel inventoryModel) {
        return this.inventoryService.createNewInventory(inventoryModel);
    }

    @GetMapping("/getInventory/{itemId}")
    public InventoryResponse getInventory(@PathVariable Integer itemId) {
         return this.inventoryService.getInventoryId(itemId);
    }

}
