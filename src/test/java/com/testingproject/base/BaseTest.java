package com.testingproject.base;

import com.testingproject.asserts.AssertActions;
import com.testingproject.endpoints.APIConstants;
import com.testingproject.modules.PayloadManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.ConnectException;

public class BaseTest {

   public RequestSpecification requestSpecification;
   public Response response;
   public ValidatableResponse vr;
   public AssertActions assertActions;
   public JsonPath jsonPath;
   public PayloadManager payloadManager;


    @BeforeTest
    public void setUp()
    {
        System.out.println("Starting test");
         payloadManager=new PayloadManager();
        assertActions=new AssertActions();
        requestSpecification= RestAssured.given();
        requestSpecification.baseUri(APIConstants.BASE_URL);
        //requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        requestSpecification.contentType(ContentType.JSON).log().all();
    }

    public String getToken(){
        requestSpecification=RestAssured.given();
        requestSpecification.baseUri(APIConstants.BASE_URL);
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);

        String payload=payloadManager.createTokenPayloadAsJSON();

        response=requestSpecification.contentType(ContentType.JSON).body(payload).when().put();

        String token=payloadManager.tokenResponseAsJavaObject(response.asString()).getToken();

        return token;
    }

    @AfterTest
    public void tearDown(){
        System.out.println("Finished test");
    }
}
