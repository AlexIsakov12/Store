package com.alexisakov.storeproject.service;

import com.alexisakov.storeproject.models.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TestDataInitService implements CommandLineRunner {
    private final ProductService productService;
    private final CategoryService categoryService;
    private final CustomerService customerService;
    private final OrderService orderService;
    private final OrderItemService orderItemService;
    private final WarehouseService warehouseService;
    private final ShelfService shelfService;
    private final ShelfProductService shelfProductService;
    private final ShelfCategoryService shelfCategoryService;

    public TestDataInitService(ProductService productService, CategoryService categoryService, CustomerService customerService, OrderService orderService, OrderItemService orderItemService, WarehouseService warehouseService, ShelfService shelfService, ShelfProductService shelfProductService, ShelfCategoryService shelfCategoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.customerService = customerService;
        this.orderService = orderService;
        this.orderItemService = orderItemService;
        this.warehouseService = warehouseService;
        this.shelfService = shelfService;
        this.shelfProductService = shelfProductService;
        this.shelfCategoryService = shelfCategoryService;
    }

    @Override
    public void run(String... args) {
        // инициализируем товары
        Product notebook = Product.builder().id(1L).name("Ноутбук").build();
        Product monitor = Product.builder().id(2L).name("Монитор").build();
        Product smartphone = Product.builder().id(3L).name("Смартфон").build();
        Product personalComputer = Product.builder().id(4L).name("Системный блок").build();
        Product watch = Product.builder().id(5L).name("Часы").build();
        Product microphone = Product.builder().id(6L).name("Микрофон").build();
        productService.saveAll(List.of(notebook, monitor, smartphone, personalComputer, watch, microphone));

        // инициализируем категории товаров
        ProductCategory notebookProductCategory = ProductCategory.builder().id(100L).categoryName("Ноутбуки").productList(List.of(notebook)).build();
        ProductCategory monitorProductCategory = ProductCategory.builder().id(200L).categoryName("Мониторы").productList(List.of(monitor)).build();
        ProductCategory smartphoneProductCategory = ProductCategory.builder().id(300L).categoryName("Смартфоны").productList(List.of(smartphone)).build();
        ProductCategory pcProductCategory = ProductCategory.builder().id(400L).categoryName("Системные блоки").productList(List.of(personalComputer)).build();
        ProductCategory watchProductCategory = ProductCategory.builder().id(500L).categoryName("Часы").productList(List.of(watch)).build();
        ProductCategory microphoneProductCategory = ProductCategory.builder().id(600L).categoryName("Микрофоны").productList(List.of(microphone)).build();
        ProductCategory freezerProductCategory = ProductCategory.builder().id(700L).categoryName("Холодильники").build();
        ProductCategory microwaveProductCategory = ProductCategory.builder().id(800L).categoryName("Микроволновые печи").build();
        categoryService.saveAll(List.of(notebookProductCategory, monitorProductCategory, smartphoneProductCategory, pcProductCategory, watchProductCategory, microphoneProductCategory, freezerProductCategory, microwaveProductCategory));

        // инициализируем покупателя
        Customer customer = Customer.builder().age((byte) 20).email("email").fullName("name").imageLink("link").phoneNumber("number").build();
        customerService.save(customer);

        // создаем заказ №10
        Order orderNumberTen = Order.builder().orderTime(LocalDateTime.now()).customer(customer).id(10L).build();
        orderService.save(orderNumberTen);

        // добавляем к заказу №10 OrderItems
        OrderItem notebookOrderNumberTen = OrderItem.builder().order(orderNumberTen).product(notebook).quantity((short) 2).build();
        OrderItem smartphoneOrderNumberTen = OrderItem.builder().order(orderNumberTen).product(smartphone).quantity((short) 1).build();
        OrderItem microphoneOrderNumberTen = OrderItem.builder().order(orderNumberTen).product(microphone).quantity((short) 1).build();
        orderItemService.saveAll(List.of(notebookOrderNumberTen, smartphoneOrderNumberTen, microphoneOrderNumberTen));

        // создаем заказ №11
        Order orderNumberEleven = Order.builder().orderTime(LocalDateTime.now()).customer(customer).id(11L).build();
        orderService.save(orderNumberEleven);

        // добавляем к заказу №11 OrderItems
        OrderItem monitorOrderNumberEleven = OrderItem.builder().order(orderNumberEleven).product(monitor).quantity((short) 3).build();
        orderItemService.save(monitorOrderNumberEleven);

        // создаем заказ №14
        Order orderNumberFourteen = Order.builder().orderTime(LocalDateTime.now()).customer(customer).id(14L).build();
        orderService.save(orderNumberFourteen);

        // добавляем к заказу №14 OrderItems
        OrderItem notebookOrderNumberFourteen = OrderItem.builder().order(orderNumberFourteen).product(notebook).quantity((short) 3).build();
        OrderItem watchOrderNumberFourteen = OrderItem.builder().order(orderNumberFourteen).product(personalComputer).quantity((short) 4).build();
        orderItemService.saveAll(List.of(notebookOrderNumberFourteen, watchOrderNumberFourteen));

        // создаем заказ №15
        Order orderNumberFifteen = Order.builder().orderTime(LocalDateTime.now()).customer(customer).id(15L).build();
        orderService.save(orderNumberFifteen);

        // добавляем к заказу №15 OrderItems
        OrderItem watchOrderNumberFifteen = OrderItem.builder().order(orderNumberFifteen).product(watch).quantity((short) 1).build();
        orderItemService.save(watchOrderNumberFifteen);

        // инициализируем склад
        Warehouse mainWarehouse = Warehouse.builder().name("Главный склад").build();
        warehouseService.save(mainWarehouse);

        // инициализируем категории стеллажей
        ShelfCategory monitorShelfCategory = ShelfCategory.builder().categoryName("Мониторы").build();
        ShelfCategory notebookShelfCategory = ShelfCategory.builder().categoryName("Ноутбуки").build();
        ShelfCategory smartphoneShelfCategory = ShelfCategory.builder().categoryName("Смартфоны").build();
        ShelfCategory pcShelfCategory = ShelfCategory.builder().categoryName("Системные блоки").build();
        ShelfCategory microphoneShelfCategory = ShelfCategory.builder().categoryName("Микрофоны").build();
        ShelfCategory watchShelfCategory = ShelfCategory.builder().categoryName("Часы").build();
        ShelfCategory microwaveShelfCategory = ShelfCategory.builder().categoryName("Микроволновые печи").build();
        ShelfCategory freezerShelfCategory = ShelfCategory.builder().categoryName("Холодильники").build();
        shelfCategoryService.saveAll(List.of(monitorShelfCategory, notebookShelfCategory, smartphoneShelfCategory, pcShelfCategory, microphoneShelfCategory, watchShelfCategory, freezerShelfCategory, microwaveShelfCategory));

        // инициализируем полки
        Shelf shelfA = Shelf.builder().shelfName("Стеллаж А").warehouse(mainWarehouse).shelfCategories(List.of(monitorShelfCategory, notebookShelfCategory)).build();
        Shelf shelfB = Shelf.builder().shelfName("Стеллаж Б").warehouse(mainWarehouse).shelfCategories(List.of(smartphoneShelfCategory)).build();
        Shelf shelfJ = Shelf.builder().shelfName("Стеллаж Ж").warehouse(mainWarehouse).shelfCategories(List.of(pcShelfCategory, microphoneShelfCategory, watchShelfCategory)).build();
        Shelf shelfV = Shelf.builder().shelfName("Стеллаж В").warehouse(mainWarehouse).shelfCategories(List.of(microwaveShelfCategory)).build();
        Shelf shelfZ = Shelf.builder().shelfName("Стеллаж З").warehouse(mainWarehouse).shelfCategories(List.of(freezerShelfCategory)).build();
        shelfService.saveAll(List.of(shelfA, shelfB, shelfJ, shelfV, shelfZ));


        ShelfProduct shelfProductOne = ShelfProduct.builder().shelf(shelfA).product(notebook).quantity((short) 50).build();
        ShelfProduct shelfProductTwo = ShelfProduct.builder().shelf(shelfB).product(smartphone).quantity((short) 100).build();
        ShelfProduct shelfProductThree = ShelfProduct.builder().shelf(shelfJ).product(personalComputer).quantity((short) 10).build();
        ShelfProduct shelfProductFour = ShelfProduct.builder().shelf(shelfJ).product(watch).quantity((short) 20).build();
        ShelfProduct shelfProductFive = ShelfProduct.builder().shelf(shelfJ).product(microphone).quantity((short) 5).build();
        ShelfProduct shelfProductSix = ShelfProduct.builder().shelf(shelfV).product(smartphone).quantity((short) 5).build();
        ShelfProduct shelfProductSeven = ShelfProduct.builder().shelf(shelfZ).product(smartphone).quantity((short) 2).build();
        ShelfProduct shelfProductEight = ShelfProduct.builder().shelf(shelfA).product(watch).quantity((short) 3).build();
        ShelfProduct shelfProductNine = ShelfProduct.builder().shelf(shelfA).product(monitor).quantity((short) 5).build();
        shelfProductService.saveAll(List.of(shelfProductOne, shelfProductTwo, shelfProductThree, shelfProductFour, shelfProductFive, shelfProductSix, shelfProductSeven, shelfProductEight, shelfProductNine));
    }
}
