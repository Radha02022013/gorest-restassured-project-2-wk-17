package com.gorest.crudtest;

import com.gorest.model.UserPojo;
import com.gorest.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserCRUDTest extends TestBase {
    @Test
    public void verifyUserCreatedSuccessfully(){
        UserPojo userPojo = new UserPojo();
        userPojo.setName("Malav Devani");
        userPojo.setEmail("devtest@gmail.com");
        userPojo.setGender("Male");
        userPojo.setStatus("Active");
        Response response =
                given()
                        .header("Content-Type","application/json")
                        .header("Authorization","Bearer 600f4364266ef9256401822c412cbfa2a4fe3c13c5c708bf2206cbb120f2a4c9")
                        .body(userPojo)
                        .when()
                        .post("/users");
        response.then().statusCode(201);
        response.prettyPrint();
    }

    @Test
    public void userUpdateSuccessfully(){
        UserPojo userPojo = new UserPojo();
        userPojo.setName("Malav Devani");
        userPojo.setEmail("dev123test@gmail.com");
        userPojo.setGender("Male");
        userPojo.setStatus("Active");
        Response response =
                given()
                        .header("Content-Type","application/json")
                        .header("Authorization","Bearer 600f4364266ef9256401822c412cbfa2a4fe3c13c5c708bf2206cbb120f2a4c9")
                        .body(userPojo)
                        .when()
                        .patch("/users/7015080");
        response.then().statusCode(200);
        response.prettyPrint();
    }


    @Test
    public void deleteUser() {
        Response response = given()

                .header("Content-Type","application/json")
                .header("Authorization", "Bearer 600f4364266ef9256401822c412cbfa2a4fe3c13c5c708bf2206cbb120f2a4c9")

                .when()
                .delete("/users/7015080");
        response.then().statusCode(204);
        response.prettyPrint();
    }
}
