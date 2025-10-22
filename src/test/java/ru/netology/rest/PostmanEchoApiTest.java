package ru.netology.rest;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoApiTest {
    @Test
    void shouldPost(){
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("{\"name\":\"Вася\", \"age\":42, \"height\": 182}") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("{\"name\":\"Вася\", \"age\":42, \"height\": 182}"));
    }


}
