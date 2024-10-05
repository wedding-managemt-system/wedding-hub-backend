package org.example.inventory.repo;

import org.example.inventory.model.InventoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InventoryRepo extends JpaRepository<InventoryModel , String> {
    @Query(value = "SELECT * FROM inventory_model WHERE item_id = ?1", nativeQuery = true)
    InventoryModel findByItemId(Integer itemId);

}
