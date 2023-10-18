package com.alexisakov.storeproject.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShelfOrderItemsDto {
    private String shelfName;
    private List<OrderItemDto> orderItems;
}
