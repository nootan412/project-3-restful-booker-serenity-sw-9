package com.restful.booker.restfulbookersteps;

import com.restful.booker.constants.EndPoints;
import com.restful.booker.model.BookingPojo;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class BookingSteps {

    static String userName = "admin";
    static String password = "password123";

    @Step("Creating the booking with firstname : {0}, lastname : {1},totalPrice : {2}, depositPaid :{3}, additionalNeeds :{4}, bookingDates : {5}")
    public ValidatableResponse createTheBooking(String firstname, String lastname, int totalPrice, boolean depositPaid, String additionalNeeds, HashMap<String, String> bookingDates) {


        BookingPojo bookingPojo = BookingPojo.getBooking(firstname, lastname, totalPrice, depositPaid, additionalNeeds, bookingDates);

        return SerenityRest.given()
                //.header("Connection", "keep-alive")
                .header("Content-Type", "application/json")
                .body(bookingPojo)
                .when()
                .post(EndPoints.CREATE_BOOKINGS)
                .then();
    }

    @Step("Getting the booking details with bookingId : {0}")
    public ValidatableResponse getTheBookingDetails(int bookingId) {
        return SerenityRest.given()
                //.header("Connection", "keep-alive")
                .pathParam("bookingID", bookingId)
                .when()
                .get(EndPoints.GET_SINGLE_BOOKING_BY_ID)
                .then();
    }

    @Step("Updating the booking with bookingId : {0}, firstname : {1}, lastname : {2},totalPrice : {3}, depositPaid :{4}, additionalNeeds :{5}, bookingDates : {6}")
    public ValidatableResponse updateTheBookingDetails(int bookingId, String firstname, String lastname, int totalPrice, boolean depositPaid, String additionalNeeds, HashMap<String, String> bookingDates) {

        BookingPojo bookingPojo = BookingPojo.getBooking(firstname, lastname, totalPrice, depositPaid, additionalNeeds, bookingDates);

        return SerenityRest.given()
                .auth().preemptive()
                .basic("admin", "password123")
                .header("Content-Type", "application/json")
                .header("Connection", "keep-alive")
                .header("Accept", "application/json")
                .header("Cookie", "token =abc123")
                .pathParam("bookingID", bookingId)
                .body(bookingPojo)
                .when()
                .put(EndPoints.UPDATE_BOOKING_BY_ID)
                .then();
    }

    @Step("Deleting the booking details with bookingId : {0}")
    public ValidatableResponse deleteTheBookingDetails(int bookingId) {

        return SerenityRest.given().log().all()
                .auth().preemptive()
                .basic("admin", "password123")
                .header("Content-Type", "application/json")
                .header("Connection", "keep-alive")
                .header("Accept", "application/json")
                .header("Cookie", "token = abc123")
                .pathParam("bookingID", bookingId)
                .when()
                .delete(EndPoints.DELETE_BOOKING_BY_ID)
                .then();


    }
}
