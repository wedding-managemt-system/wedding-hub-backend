package org.example.product.controller;


import org.example.product.common.productResponse;
import org.example.product.model.productModel;
import org.example.product.server.productServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/product")

public class productController {

    @Autowired
    private productServer productServer;


    @PostMapping("/create")
    public productResponse createProduct(@RequestBody productModel product){
//        System.out.println(product);

        return this.productServer.createProductDetails(product);
    }


    @GetMapping("getProduct/{product_id}")
    public productResponse getProduct(@PathVariable String product_id){
         return this.productServer.getEachProductDetails(product_id);
    }


}
