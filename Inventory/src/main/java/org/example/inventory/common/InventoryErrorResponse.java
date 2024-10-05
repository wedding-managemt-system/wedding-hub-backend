package org.example.inventory.common;


import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;
import org.example.inventory.model.InventoryModel;

@Getter
public class InventoryErrorResponse implements InventoryResponse{
    @JsonUnwrapped
    private String ErrorMessage;

    public InventoryErrorResponse (String errorMessage) {
        this.ErrorMessage = errorMessage;
    }

}
