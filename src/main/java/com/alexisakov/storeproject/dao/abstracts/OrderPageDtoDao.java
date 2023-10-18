package com.alexisakov.storeproject.dao.abstracts;

import com.alexisakov.storeproject.models.dto.OrderPageDto;

import java.util.List;

public interface OrderPageDtoDao {
    List<OrderPageDto> getOrderPageByOrderIds(List<Long> orderIds);
}
