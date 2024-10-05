package org.example.order.server;


import jakarta.transaction.Transactional;
import org.example.order.common.orderErrorResponse;
import org.example.order.common.orderSuccessResponse;
import org.example.order.model.clientOrderModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.order.repo.clientOrderRepo;
import org.example.order.common.orderResponse;

@Service
@Transactional

public class clientOrder {
  @Autowired
    private clientOrderRepo clientOrderRepo;

  @Autowired
    private ModelMapper modelMapper;


  public orderResponse addClientOrder(clientOrderModel clientOrder){
      try {
        System.out.println(clientOrder);

         clientOrderRepo.save(modelMapper.map(clientOrder , clientOrderModel.class));

         return new orderSuccessResponse(clientOrder , "Order Successfully Added");


      }catch(Exception e){
//          System.out.println(e.getMessage());
          return new orderErrorResponse("Have an error while creating Order");
      }
  }

}
