package org.example.product.server;


import jakarta.transaction.Transactional;
import org.example.product.common.productErrorResponse;
import org.example.product.common.productResponse;
import org.example.product.common.productSuccessResponse;
import org.example.product.model.productModel;
import org.example.product.repo.productRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class productServer {

    @Autowired
    private productRepo productRepo;


    @Autowired
    private ModelMapper modelMapper;

//    create product details
    public productResponse createProductDetails(productModel productModel){
        try {
            System.out.println(productModel);

            productRepo.save(modelMapper.map(productModel , productModel.class));

            return new productSuccessResponse(productModel , "Product created successfull");

        }catch (Exception e){
            return new productErrorResponse("Product creation failed");
        }
    }


//    get product considering Id
    public productResponse getEachProductDetails(String productId){
        System.out.println(productId);

       try {
            productModel product = productRepo.findByItemId(productId);
//           System.out.println(product);

           if(product == null){
               return new productErrorResponse("Product not found");
           }

           return new productSuccessResponse(product , "Product found");

       }catch (Exception e){
           return new productErrorResponse("Product get failed");
       }
    }

}
