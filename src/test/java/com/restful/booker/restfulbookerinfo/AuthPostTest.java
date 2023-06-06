package com.restful.booker.restfulbookerinfo;

import com.restful.booker.restfulbookersteps.AuthSteps;
import com.restful.booker.testbase.AuthTestBase;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

import static io.restassured.RestAssured.given;

@RunWith(SerenityRunner.class)
public class AuthPostTest extends AuthTestBase {

    static String token;
    static String userName = "admin";
    static String password = "password123";
    @Steps
    AuthSteps authSteps;

    @Title("This will create the Auth Token")
    @Test
    public void test001() {
        ValidatableResponse response = authSteps.createTheAuthToken(userName,password);
        response.statusCode(200);
        token = response.extract().path("token");
        System.out.println("token is : "+ token);
    }

   /* public String getToken() {
        return token;
    }*/


}
