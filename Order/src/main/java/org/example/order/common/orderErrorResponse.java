package org.example.order.common;


import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;

@Getter
public class orderErrorResponse implements orderResponse {
   @JsonUnwrapped
    private String errorMessage;

   public orderErrorResponse(String errorMessage) {
       this.errorMessage = errorMessage;
   }

}
