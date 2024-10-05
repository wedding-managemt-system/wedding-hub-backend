package org.example.order.controller;


import org.example.order.common.orderResponse;
import org.example.order.model.clientOrderModel;
import org.example.order.server.clientOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/client")

public class clientOrderController {

    @Autowired
    private clientOrder clientOrderService;

    @PostMapping("/add-order")
    public orderResponse addOrder(@RequestBody clientOrderModel clientOrder) {
//        System.out.println(clientOrder);
       return clientOrderService.addClientOrder(clientOrder);
//        return null;
    }

}
