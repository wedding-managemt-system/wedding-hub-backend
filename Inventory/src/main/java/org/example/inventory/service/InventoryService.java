package org.example.inventory.service;

import jakarta.transaction.Transactional;
import org.example.inventory.common.InventoryErrorResponse;
import org.example.inventory.common.InventoryResponse;
import org.example.inventory.common.InventorySuccessResponse;
import org.example.inventory.model.InventoryModel;
import org.example.inventory.repo.InventoryRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.reactive.function.client.WebClient;

@Service
@Transactional

public class InventoryService {
//    private final WebClient webClient;

    @Autowired
    private InventoryRepo inventoryRepo;

    @Autowired
    private ModelMapper modelMapper;

//    public InventoryService(WebClient webClient , InventoryRepo inventoryRepo , ModelMapper modelMapper) {
//        this.modelMapper = modelMapper;
//        this.webClient = webClient;
//        this.inventoryRepo = inventoryRepo;
//    }

    public InventoryResponse createNewInventory(InventoryModel inventoryModel) {
        System.out.println(inventoryModel);
        try {
            inventoryRepo.save(modelMapper.map(inventoryModel , InventoryModel.class));

            return new InventorySuccessResponse(inventoryModel , "Inventory Added Successful");

        }catch(Exception e) {
            return new InventoryErrorResponse("Inventory Creation Failed");
        }
    }


//    get inventory using id
    public InventoryResponse getInventoryId(Integer itemId) {
//        System.out.println(id);
       try {
           InventoryModel item = inventoryRepo.findByItemId(itemId);
           System.out.println(item);
           return new InventorySuccessResponse(item , "Item Retrieved Successful");

       }catch(Exception e) {
           return new InventoryErrorResponse("Inventory Get Failed");
       }
    }
}
