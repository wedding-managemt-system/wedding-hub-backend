package org.example.inventory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class InventoryModel {
    @Id
    private String InventoryId;
    private String ItemId;
    private String productId;
    private String quantity;
}
