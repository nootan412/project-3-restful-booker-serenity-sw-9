package com.restful.booker.restfulbookersteps;

import com.restful.booker.constants.EndPoints;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class PingSteps {


    @Step("Getting the healthCheck details")
    public ValidatableResponse gettingTheHealthCheckDetails(){

       return SerenityRest.given().log().all()
                .when()
                .get(EndPoints.GET_PING)
                .then();

    }

}
