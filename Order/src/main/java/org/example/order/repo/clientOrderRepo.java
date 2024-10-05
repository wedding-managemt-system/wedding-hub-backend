package org.example.order.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.order.model.clientOrderModel;

public interface clientOrderRepo extends JpaRepository<clientOrderModel, Integer> {

}
