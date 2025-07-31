package com.testingproject.tests.CRUD;

import com.testingproject.base.BaseTest;
import com.testingproject.endpoints.APIConstants;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class HealthCheck extends BaseTest {

    @Test(groups = {"reg"}, priority = 2)
    @Description("TC03_HealthCheck")

    public void testHealthCheck() {
        requestSpecification.basePath(APIConstants.PING_URL);
        response= RestAssured.given(requestSpecification).when().get();

      vr=response.then().log().all();
      vr.statusCode(201);


    }
}