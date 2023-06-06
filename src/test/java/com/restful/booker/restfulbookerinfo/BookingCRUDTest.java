package com.restful.booker.restfulbookerinfo;

import com.restful.booker.model.BookingPojo;
import com.restful.booker.restfulbookersteps.BookingSteps;
import com.restful.booker.testbase.BookingTestBase;
import com.restful.booker.utils.TestUtils;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasValue;
@RunWith(SerenityRunner.class)
public class BookingCRUDTest extends BookingTestBase {

    static String firstname = "Johny";
    static String lastname = "English";
    static int totalPrice = 150;
    static boolean depositPaid = true;
    static String additionalNeeds = "Breakfast";
    static String username = "admin";
    static String password = "password123";
    static int bookingId;
    @Steps
    BookingSteps bookingSteps;

    @Title("This will create the booking")
    @Test
    public void test001() {
        HashMap<String, String> bookingDates = new HashMap<>();
        bookingDates.put("checkin", "2018-07-01");
        bookingDates.put("checkout", "2019-07-25");

        ValidatableResponse response = bookingSteps.createTheBooking(firstname, lastname, totalPrice, depositPaid, additionalNeeds, bookingDates);
        response.log().all().statusCode(200);
        bookingId = response.extract().path("bookingid");

        HashMap<String, Object> bookingMap = response.extract().path("");
        Assert.assertThat(bookingMap, hasValue(bookingId));

    }


    @Title("This will get booking details")
    @Test
    public void test002() {
        ValidatableResponse response = bookingSteps.getTheBookingDetails(bookingId);
        response.log().all().statusCode(200);
        HashMap<String, Object> bookingMap = response.extract().path("");
        Assert.assertThat(bookingMap, hasValue(bookingId));
    }

    @Title("This will update booking details")
    @Test
    public void UpdateTheBooking() {
        firstname = "Michel" + TestUtils.getRandomValue();
        lastname = "Smith" + TestUtils.getRandomValue();
        additionalNeeds = "Dinner";
        HashMap<String, String> bookingDates = new HashMap<>();
        bookingDates.put("checkin", "2023-08-01");
        bookingDates.put("checkout", "2023-08-25");

        ValidatableResponse response = bookingSteps.updateTheBookingDetails(bookingId, firstname, lastname, totalPrice, depositPaid, additionalNeeds, bookingDates);
        response.statusCode(200);

        HashMap<String, Object> bookingMap = response.extract().path("");
        Assert.assertThat(bookingMap, hasValue(bookingId));

    }

    @Title("This will delete booking details")
    @Test
    public void deleteTheBooking() {

       bookingSteps.deleteTheBookingDetails(bookingId)
       .statusCode(201);

    }


}
