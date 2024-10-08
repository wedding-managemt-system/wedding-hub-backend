package org.example.product.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class productModel {
    @Id
    String product_id;
    String product_name;
    String product_description;
    boolean forSale;
}
