package org.example.order.controller;


import org.aspectj.weaver.ast.Or;
import org.example.base.dto.OrderEventDTO;
import org.example.order.common.orderResponse;
import org.example.order.kafka.OrderProducer;
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

    @Autowired
    private OrderProducer orderProducer;

    @PostMapping("/add-order")
    public orderResponse addOrder(@RequestBody clientOrderModel clientOrder) {
//        System.out.println(clientOrder);
        OrderEventDTO orderEventDTO = new OrderEventDTO();

    orderEventDTO.setMessage("New Order Requested");
    orderEventDTO.setStatus("pending");
    orderProducer.sendMessage(orderEventDTO);

       return clientOrderService.addClientOrder(clientOrder);
//        return null;
    }

}
