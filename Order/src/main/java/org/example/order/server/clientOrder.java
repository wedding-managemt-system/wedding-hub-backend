package org.example.order.server;

import jakarta.transaction.Transactional;
import org.example.inventory.dto.InventoryDTO;
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
              InventoryDTO inventoryResponse  = InventoryWebClient.get()
                      .uri(uriBuilder -> uriBuilder.path("/inventory/getInventory/{itemId}").build(itemId))
                      .retrieve()
                      .bodyToMono(InventoryDTO.class)
                      .block();  // Block to get the response synchronously

              System.out.println(inventoryResponse);

          } else {
              System.out.println("Invalid itemId: " + itemId);
          }



//         clientOrderRepo.save(modelMapper.map(clientOrder , clientOrderModel.class));

         return new orderSuccessResponse(clientOrder , "Order Successfully Added");


      }catch(Exception e){
//          System.out.println(e.getMessage());
          return new orderErrorResponse("Have an error while creating Order");
      }
  }

}
