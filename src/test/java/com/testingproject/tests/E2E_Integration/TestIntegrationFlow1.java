package com.testingproject.tests.E2E_Integration;

import com.testingproject.base.BaseTest;
import com.testingproject.endpoints.APIConstants;
import com.testingproject.modules.PayloadManager;
import com.testingproject.pojos.Booking;
import com.testingproject.pojos.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;


public class TestIntegrationFlow1 extends BaseTest {
    @Test(groups={"qa"},priority=1)
    @Description("TC#INT1- Step1 - Verify that booking is created")
    @Owner("Poonam")

    public void testCreateBooking(ITestContext iTestContext){
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response= RestAssured.given(requestSpecification).when().body(payloadManager.createBookingPayloadAsString()).post();

        //Extraction
        BookingResponse bookingResponse= payloadManager.bookingResponseJava(response.asString());

        //Assertions
        assertActions.verifyStringKeyNotNull(bookingResponse.getBookingId());
        assertActions.verifyStringKey(bookingResponse.getBooking().getFirstName(),"Poonam");

        System.out.println(response.asString());

        iTestContext.setAttribute("bookingid",bookingResponse.getBookingId());
    }

    @Test(groups={"qa"},priority=2)
    @Description("TC#INT2- Step 2 - Verify that able to retrieve booking with booking id ")
    @Owner("Poonam")
    public void testGetBooking(ITestContext iTestContext){
         Integer bookingid=(Integer) iTestContext.getAttribute("bookingid");
       requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL+"/"+bookingid);

       response=RestAssured.given(requestSpecification).when().get();

       vr=response.then().log().all().statusCode(200);

       Booking booking= payloadManager.getResponseFromJSON(response.toString());

       assertActions.verifyStringKey(booking.getFirstName(),"Poonam");
assertThat(booking.getFirstName()).isNotNull().isEqualTo("Poonam");
    }

    @Test(groups={"qa"},priority=3)
    @Description("TC#INT3- Step 3 - Verify that able to Update booking that was created before")
    @Owner("Poonam")
    public void testUpdateBooking(ITestContext iTestContext){

         Integer bookingid=(Integer) iTestContext.getAttribute("bookingid");
         String token=getToken();

         requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL+"/"+bookingid);
        // response=RestAssured.given(requestSpecification).when().body(PayloadManager.)
    }

    @Test(groups={"qa"},priority=4)
    @Description("TC#INT4- Step 4 - Verify that able to Delete booking that was created before")
    @Owner("Poonam")
    public void testDeleteBooking(){
        Assert.assertTrue(true);
    }
}
