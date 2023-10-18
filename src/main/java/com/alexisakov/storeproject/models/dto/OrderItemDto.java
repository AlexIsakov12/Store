package com.alexisakov.storeproject.models.dto;

import com.alexisakov.storeproject.models.entity.Shelf;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
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
