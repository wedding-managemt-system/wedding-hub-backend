package org.example.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class clientOrderDTO {
    private String orderId;
    private String ItemId;
    private String OrderData;
    private String amount;
}
