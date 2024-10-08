package org.example.product.repo;

import org.example.product.model.productModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface productRepo extends JpaRepository<productModel, Integer> {
    @Query(value = "SELECT * FROM product_model WHERE product_id = ?1", nativeQuery = true)
    productModel findByItemId(String product_id);
}
