package org.example.order.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class clientOrderModel {
  @Id
  private String orderId;
  private String ItemId;
  private String OrderData;
  private String amount;
}
