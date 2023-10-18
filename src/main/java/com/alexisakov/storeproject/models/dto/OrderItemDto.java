package com.alexisakov.storeproject.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {
    private String itemName;
    private Long itemId;
    private Long orderId;
    private short orderQuantity;
    private String additionalShelves;
}
