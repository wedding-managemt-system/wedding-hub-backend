package org.example.inventory.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class InventoryDTO {
    private String InventoryId;
    private String ItemId;
    private String productId;
    private String quantity;
}
