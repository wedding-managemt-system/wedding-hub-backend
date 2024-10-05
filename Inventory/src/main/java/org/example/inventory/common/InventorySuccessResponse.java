package org.example.inventory.common;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;
import org.example.inventory.model.InventoryModel;

@Getter
public class InventorySuccessResponse implements InventoryResponse{
    @JsonUnwrapped
    private InventoryModel inventoryModel;
    private String successMessage;

    public InventorySuccessResponse(InventoryModel inventoryModel, String successMessage) {
        this.inventoryModel = inventoryModel;
        this.successMessage = successMessage;
    }
}
