package com.alexisakov.storeproject.dao.implementation;

import com.alexisakov.storeproject.dao.abstracts.OrderPageDtoDao;
import com.alexisakov.storeproject.models.dto.OrderItemDto;
import com.alexisakov.storeproject.models.dto.OrderPageDto;
import com.alexisakov.storeproject.models.dto.ShelfOrderItemsDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderPageDtoDaoImpl implements OrderPageDtoDao {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @SuppressWarnings("unchecked")
    public List<OrderPageDto> getOrderPageByOrderIds(List<Long> orderIds) {
        List<Object[]> resultList = entityManager.createNativeQuery("""
        SELECT
            s.shelf_name,
            p.name AS item_name,
            p.id AS item_id,
            o.id AS order_id,
            oi.quantity AS order_quantity,
            (
                SELECT string_agg(DISTINCT s2.shelf_name, ', ')
                FROM shelf s2
                LEFT JOIN shelf_product sp2 ON s2.id = sp2.shelf_id
                LEFT JOIN product p2 ON sp2.product_id = p2.id
                LEFT JOIN shelf_shelf_category ssc2 ON s2.id = ssc2.shelf_id
                LEFT JOIN shelf_category sc2 ON ssc2.category_id = sc2.id
                WHERE p2.id = p.id
                AND pc.category_name != sc2.category_name
                AND s2.shelf_name != s.shelf_name
            ) AS additional_shelves
        FROM
            shelf s
            LEFT JOIN shelf_product sp ON s.id = sp.shelf_id
            LEFT JOIN product p ON sp.product_id = p.id
            LEFT JOIN order_item oi ON p.id = oi.product_id
            LEFT JOIN orders o ON oi.order_id = o.id
            LEFT JOIN shelf_shelf_category ssc ON s.id = ssc.shelf_id
            LEFT JOIN shelf_category sc ON ssc.category_id = sc.id
            LEFT JOIN product_category pc ON p.product_category_id = pc.id
        WHERE
            o.id IN (:orderIds)
            AND pc.category_name = sc.category_name
        GROUP BY
            s.shelf_name,
            sc.category_name,
            p.name,
            p.id,
            o.id,
            oi.quantity,
            pc.category_name
        ORDER BY
            s.shelf_name;
    """)
                .setParameter("orderIds", orderIds)
                .getResultList();

        Map<String, OrderPageDto> orderPageMap = new HashMap<>();

        for (Object[] row : resultList) {
            String shelfName = (String) row[0];
            String orderPageName = "Страница сборки заказов №: " + (orderIds);

            if (!orderPageMap.containsKey(orderPageName)) {
                OrderPageDto orderPageDto = new OrderPageDto();
                orderPageDto.setOrderPageName(orderPageName);
                orderPageMap.put(orderPageName, orderPageDto);
            }

            OrderPageDto orderPageDto = orderPageMap.get(orderPageName);
            List<ShelfOrderItemsDto> shelfOrderItemsList = orderPageDto.getOrderItems();

            if (shelfOrderItemsList == null) {
                shelfOrderItemsList = new ArrayList<>();
                orderPageDto.setOrderItems(shelfOrderItemsList);
            }

            ShelfOrderItemsDto shelfOrderItemsDto = null;

            for (ShelfOrderItemsDto shelfOrderItems : shelfOrderItemsList) {
                if (shelfOrderItems.getShelfName().equals(shelfName)) {
                    shelfOrderItemsDto = shelfOrderItems;
                    break;
                }
            }

            if (shelfOrderItemsDto == null) {
                shelfOrderItemsDto = new ShelfOrderItemsDto();
                shelfOrderItemsDto.setShelfName(shelfName);
                shelfOrderItemsList.add(shelfOrderItemsDto);
            }

            OrderItemDto orderItemDto = new OrderItemDto();
            orderItemDto.setItemName((String) row[1]);
            orderItemDto.setItemId((Long) row[2]);
            orderItemDto.setOrderId((Long) row[3]);
            orderItemDto.setOrderQuantity((short) row[4]);
            orderItemDto.setAdditionalShelves((String) row[5]);

            List<OrderItemDto> orderItems = shelfOrderItemsDto.getOrderItems();

            if (orderItems == null) {
                orderItems = new ArrayList<>();
                shelfOrderItemsDto.setOrderItems(orderItems);
            }

            orderItems.add(orderItemDto);
        }

        return new ArrayList<>(orderPageMap.values());
    }
}
