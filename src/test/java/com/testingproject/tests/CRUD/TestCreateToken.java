package com.testingproject.tests.CRUD;

import com.testingproject.base.BaseTest;
import com.testingproject.endpoints.APIConstants;
import com.testingproject.modules.PayloadManager;
import com.testingproject.pojos.TokenResponse;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestCreateToken extends BaseTest {

    @Test(groups = {"reg"}, priority = 2)
    @Description("TC02_Create Token")

    public void testCreateToken() {
        requestSpecification.basePath(APIConstants.AUTH_URL);
        response = RestAssured.given(requestSpecification).when().body(payloadManager.createTokenPayloadAsJSON()).post();

        //Extraction from json string to java object
        TokenResponse tokenResponse= payloadManager.tokenResponseAsJavaObject(response.asString());

        //assertion
        assertActions.verifyStringKeyNotNull(tokenResponse.getToken());
        System.out.println(tokenResponse.getToken());

    }
}