package org.example.product.common;


import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;
import org.example.product.model.productModel;

@Getter
public class productSuccessResponse implements productResponse{

    @JsonUnwrapped
    private productModel productModel;
    private String SuccessMessage;

    public productSuccessResponse(productModel productModel, String SuccessMessage) {
        this.productModel = productModel;
        this.SuccessMessage = SuccessMessage;
    }

}
