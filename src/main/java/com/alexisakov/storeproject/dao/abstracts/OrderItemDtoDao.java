package com.alexisakov.storeproject.dao.abstracts;

import com.alexisakov.storeproject.models.dto.OrderPageDto;

import java.util.List;

public interface OrderItemDtoDao {
    List<OrderPageDto> getOrderItemsByOrderIds(List<Long> orderIds);
}
