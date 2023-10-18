package com.alexisakov.storeproject.service;

import com.alexisakov.storeproject.dao.implementation.OrderPageDtoDaoImpl;
import com.alexisakov.storeproject.models.dto.OrderPageDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderPageDtoService {

    private final OrderPageDtoDaoImpl orderPageDtoDao;

    public OrderPageDtoService(OrderPageDtoDaoImpl orderPageDtoDao) {
        this.orderPageDtoDao = orderPageDtoDao;
    }

    public List<OrderPageDto> getOrderPageByOrderIds(List<Long> orderIds) {
        return orderPageDtoDao.getOrderPageByOrderIds(orderIds);
    }
}
