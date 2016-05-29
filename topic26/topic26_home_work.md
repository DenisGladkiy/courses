## Домашнее задание №26

### Создаем маленький REST-сервис с помощью Spring MVC
 * Читаем, что такое REST ([тут](https://habrahabr.ru/post/38730/), [тут](http://www.restapitutorial.ru/lessons/whatisrest.html) и [тут](https://ru.wikipedia.org/wiki/REST))
 * Изучаем Spring MVC ([reference](http://docs.spring.io/autorepo/docs/spring/4.0.x/spring-framework-reference/html/mvc.html), [на русском](http://www.spring-source.ru/articles.php))
 * Создаем небольшое REST приложение на основе Spring MVC. Имплементируем следующее REST API:
 ```

    REQUEST - /account
    METHOD -  GET
    BODY -

    Ожидаемый результат - список всех аккаунтов в формате JSON.
 ```
 ```

    REQUEST - /account/{id}
    METHOD - GET
    BODY -

    Ожидаемый результат - аккаунт по заданному id в формате JSON.
 ```
 ```

    REQUEST - /account
    METHOD - POST
    BODY - account в формате JSON

    Ожидаемый результат - создает новый аккаунт с параметрами, переданными в BODY.
 ```
 ```

    REQUEST - /account/{id}
    METHOD - PUT
    BODY - account в формате JSON

    Ожидаемый результат - обновляет аккаунт по id параметрами, переданными в BODY.
 ```
 ```

    REQUEST - /account/search?{name}&{startDate}&{endDate}
    METHOD - GET
    BODY -

    Ожидаемый результат - список всех аккаунтов, соответсвующих заданным параметрам в формате JSON. Аргументы поиска:
    {name} - поиск имени аккаунта по подстроке
    {startDate} - дата начала действия аккаунта должна быть >= этого значения
    {endDate} - дата начала действия аккаунта должна быть < этого значения
    Все аргументы опциональные.Если не один не задан - выдача всех аккаунтов.
 ```
 * Пример сущности account:

 ```
   {
     "id": 1,
     "name": "Ievgen",
     "nickName": "rxn1d",
     "startDate": "2016-01-01",
     "endDate": "2016-05-25",
     "games": [
       {
         "name": "Dota 2"
       },
       {
         "name": "CS: GO"
       }
     ]
   }
 ```
 * Сущности можно* хранить в памяти и не писать в базу, файлы и т.д (делайте как вам удобно).