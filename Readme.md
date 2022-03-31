# Rest сервер с взаимодействием с БД
## Описание
Программа представляет возможность получения JSON объектов из БД. На контроллере сконфигурирован один мапинг для получения данных.
В составе программы используются:
1. RestController обрабатывающий входящие и исходящие запросы.
2. MySql сервер (возможно поднять контейнер Docker).
3. Liquibase миграция, использующаяся для первоначального создания и наполнения данными.
4. OpenApi Swagger UI для описания спецификации API и выполнения запросов 
  
## Предварительные настройки
1. Настроить подключение к БД. При разработке поднимал docker контейнер с MySQL Server 8.0.28-1debian10.
```
docker run -v /mysql_data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=mysql -p 3306:3306  mysql
```
2. Настраиваем параметры подключения к БД в файле application.properties  
```
spring.datasource.url=jdbc:mysql://192.168.99.100/jdbctemplate?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=mysql
```
3. Если при запуске программы хотите использовать sql скрипты (schema.sql, data.sql) расположенные в корне папки resource, тогда необходимо  раскомментируйте строку в application.properties  
```
#spring.sql.init.mode=always
```
4. При необходимости скорректируйте мастер файл Liquibase db.changelog-master.yaml. В программе предоставлены 3 варианта (файла) создания таблиц - .yaml, .sql, xml. В соответствии с текущей настройкой мастер файла будет выполнен .xml.  

## Запуск программы
1. Поднимается TomCat на порту 8080
2. Происходит подключение к БД и создании указанной схемы - jdbctemplate
3. Стартует Liquibase и создает таблицу "customer" и записывает действие в историю (таблицы DATABASECHANGELOG, DATABASECHANGELOGLOCK)
4. Наполнение данных resource\data.sql
```
INSERT INTO jdbctemplate.customer VALUES (1,'Vasya', 'Pupkin', 100, 89999999999);
INSERT INTO jdbctemplate.customer VALUES (2, 'Ivan', 'Ivanov', 10, 0);
INSERT INTO jdbctemplate.orders VALUES (1, '2022-01-01', 1, 'iPhone', 70000);
INSERT INTO jdbctemplate.orders VALUES (2, '2022-01-02', 2, 'Xiaomi', 50000);
INSERT INTO jdbctemplate.orders VALUES (3, '2022-01-03', 2, 'Nokia', 15000);
```

## Схема БД
![](uml.png)

## Выполнение
1. Переходим по ссылке   
http://127.0.0.1:8080/products/fetch-product?name=vasya
2. Получаем ответ от сервера с названием товара в зависимости от переданного параметра.  

## Спецификация API 
[Swagger UI](http://localhost:8080/swagger-ui/index.html)  
[Swagger UI image](Swagger.PNG)  
## Дополнительная информация
Для получения данных из таблицы используется технология выполнения запроса из файл с sql запросом (скриптом query.sql)
