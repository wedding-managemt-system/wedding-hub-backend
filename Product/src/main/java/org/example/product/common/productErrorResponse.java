package org.example.product.common;


import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;

@Getter
public class productErrorResponse implements productResponse {

    @JsonUnwrapped
    private String errorMessage;

    public productErrorResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
