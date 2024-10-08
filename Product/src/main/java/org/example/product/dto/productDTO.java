package org.example.product.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class productDTO {
    String product_id;
    String product_name;
    String product_description;
    boolean forSale;
}
