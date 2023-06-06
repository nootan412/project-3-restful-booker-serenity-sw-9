package com.restful.booker.restfulbookersteps;

import com.restful.booker.constants.EndPoints;
import com.restful.booker.model.AuthPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static io.restassured.RestAssured.given;

public class AuthSteps {




    @Step("Creating the AuthToken")
    public ValidatableResponse createTheAuthToken(String userName,String password) {
        AuthPojo authPojo =new AuthPojo();
        authPojo.setUsername(userName);
        authPojo.setPassword(password);
        return SerenityRest.given()
//                .auth().preemptive()
//                .basic(userName, password)
                .header("Content-Type", "application/json")
                //.contentType(ContentType.JSON)
                .when()
                .body(authPojo)
                .post(EndPoints.GET_Auth)
                .then();

    }
}
