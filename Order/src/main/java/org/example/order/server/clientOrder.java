package org.example.order.server;

import jakarta.transaction.Transactional;
import org.example.inventory.dto.InventoryDTO;
import org.example.product.dto.productDTO;
import org.example.order.common.orderErrorResponse;
import org.example.order.common.orderSuccessResponse;
import org.example.order.model.clientOrderModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.order.repo.clientOrderRepo;
import org.example.order.common.orderResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.example.order.dto.clientOrderDTO;

@Service
@Transactional

public class clientOrder {
   private final WebClient InventoryWebClient;
   private final WebClient productWebClient;


  @Autowired
    private clientOrderRepo clientOrderRepo;

  @Autowired
    private ModelMapper modelMapper;


public clientOrder (WebClient InventoryWebClient, WebClient productWebClient , ModelMapper modelMapper , clientOrderRepo orderRepo) {
        this.InventoryWebClient = InventoryWebClient;
        this.productWebClient = productWebClient;
        this.modelMapper = modelMapper;
        this.clientOrderRepo = orderRepo;

    }

    public orderResponse addClientOrder(clientOrderModel clientOrder){
      try {
        System.out.println(clientOrder);

          String itemId = clientOrder.getItemId();
          System.out.println(itemId);

          if (itemId != null && !itemId.isEmpty()) {

//              communicate with inventory table
              InventoryDTO inventoryResponse  = InventoryWebClient.get()
                      .uri(uriBuilder -> uriBuilder.path("/getInventory/{itemId}").build(itemId))
                      .retrieve()
                      .bodyToMono(InventoryDTO.class)
                      .block();  // Block to get the response synchronously

              System.out.println(inventoryResponse);

              String quantity = inventoryResponse.getQuantity();
              Integer itemQuantity = Integer.parseInt(quantity);

//              communicate with product Table
//              productDTO productResponse = productWebClient.get()
//                      .uri(uriBuilder -> uriBuilder.path(""))


              System.out.println(quantity);


              if(itemQuantity > 0){
                  clientOrderRepo.save(modelMapper.map(clientOrder , clientOrderModel.class));
                  return new orderSuccessResponse(clientOrder , "Order Successfully Added");

              }else{
                  return new orderErrorResponse("Item Haven't enough stock");
              }

          } else {
              System.out.println("Invalid itemId: " + itemId);
          }

          return null;

      }catch(Exception e){
          return new orderErrorResponse(e.getMessage());
      }
  }

}
