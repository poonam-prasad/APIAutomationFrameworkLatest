package com.testingproject.tests.CRUD;

import com.testingproject.base.BaseTest;
import com.testingproject.endpoints.APIConstants;
import com.testingproject.pojos.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestCreateBooking extends BaseTest {

    @Test(groups="reg",priority=1)
    @Description("TC01_Verify Booking can be created")
    @Owner("Poonam")

    public void testCreateBooking_Positive(){
        //Setup and making request
        System.out.println("Positive test");
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response= RestAssured.given(requestSpecification).when().body(payloadManager.createBookingPayloadAsString()).post();

        //Extraction
        BookingResponse bookingResponse= payloadManager.bookingResponseJava(response.asString());

        //Assertions
        assertActions.verifyStringKeyNotNull(bookingResponse.getBookingId());
        assertActions.verifyStringKey(bookingResponse.getBooking().getFirstName(),"Poonam");

        System.out.println(response.asString());
    }

    @Test(groups="reg",priority=1)
    @Description("TC02_Verify Booking cannot be created with empty payload")
    @Owner("Poonam")
    public void testCreateBooking_Negative(){
        System.out.println("Negative Test");
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response= RestAssured.given(requestSpecification).when().body("").post();

        vr=response.then().log().all().statusCode(500);


    }
}
