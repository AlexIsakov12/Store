# Документация к тестовому заданию по реализации страницы заказов интернет-магазина 
## Стек технологий
### Java 17, Spring Boot (Data JPA), Hibernate, Maven, REST API

## Работа с API
### Endpoints
На данный момент реализован один эндпоинт: 
**GET: api/orders/getOrderPage - возвращает страницу по номерам заказов**

### Передача и получение параметров (далее будет показана работа с API с помощью Postman)
1. Откройте Postman и в боковой панели выберите вкладку **Collections -> RESTful API Basics -> Get Data**
2. В поле **Enter URL** вставьте путь до эндпоинта (на примере уже реализованного: http://localhost:8080/api/orders/getOrderPage)
3. Во вкладке Params нам необходимо передать параметры в виде пары **"ключ-значение"**. Ключем должен быть параметр **"orders"**, а значение - это то, какие значения вы хотите передать ("на примере это номера заказов: "10, 11, 14, 15")
4. После того, как вы введёте key-value пару, Postman автоматически создаст готовый URL для отправки GET-запроса.
5. Нажмите **"Send"** и в случае, если вы всё сделали верно, API вернет нам тело ответа с кодом статуса "200". Тело ответа вы можете просмотреть внизу во вкладке **Body** в любом доступном формате (JSON, XML и т.п.)

### Пример выходных параметров:
```json
[
    {
        "orderPageName": "Страница сборки заказов №: [10, 11, 14, 15]",
        "orderItems": [
            {
                "shelfName": "Стеллаж А",
                "orderItems": [
                    {
                        "itemName": "Монитор",
                        "itemId": 2,
                        "orderId": 11,
                        "orderQuantity": 3,
                        "additionalShelves": null
                    },
                    {
                        "itemName": "Ноутбук",
                        "itemId": 1,
                        "orderId": 10,
                        "orderQuantity": 2,
                        "additionalShelves": null
                    },
                    {
                        "itemName": "Ноутбук",
                        "itemId": 1,
                        "orderId": 14,
                        "orderQuantity": 3,
                        "additionalShelves": null
                    }
                ]
            },
            {
                "shelfName": "Стеллаж Б",
                "orderItems": [
                    {
                        "itemName": "Смартфон",
                        "itemId": 3,
                        "orderId": 10,
                        "orderQuantity": 1,
                        "additionalShelves": "Стеллаж В, Стеллаж З"
                    }
                ]
            },
            {
                "shelfName": "Стеллаж Ж",
                "orderItems": [
                    {
                        "itemName": "Микрофон",
                        "itemId": 6,
                        "orderId": 10,
                        "orderQuantity": 1,
                        "additionalShelves": null
                    },
                    {
                        "itemName": "Системный блок",
                        "itemId": 4,
                        "orderId": 14,
                        "orderQuantity": 4,
                        "additionalShelves": null
                    },
                    {
                        "itemName": "Часы",
                        "itemId": 5,
                        "orderId": 15,
                        "orderQuantity": 1,
                        "additionalShelves": "Стеллаж А"
                    }
                ]
            }
        ]
    }
]
```
**Данный JSON будет очень удобно распарсить команде фронтендеров для создания страницы.**
