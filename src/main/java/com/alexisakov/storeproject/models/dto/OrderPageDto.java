package com.alexisakov.storeproject.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderPageDto {
    private String orderPageName;
    private List<ShelfOrderItemsDto> orderItems;
}
