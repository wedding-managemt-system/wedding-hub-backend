package org.example.order.common;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;
import org.example.order.dto.clientOrderDTO;
import org.example.order.model.clientOrderModel;

@Getter
public class orderSuccessResponse implements orderResponse {
     @JsonUnwrapped
    private clientOrderModel clientOrderModel;
     private String successMessage;

     public orderSuccessResponse(clientOrderModel clientOrderModel , String successMessage) {
         this.clientOrderModel = clientOrderModel;
         this.successMessage = successMessage;
     }
}
