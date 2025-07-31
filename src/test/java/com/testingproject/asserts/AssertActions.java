package com.testingproject.asserts;

import io.restassured.response.Response;

import static org.testng.Assert.assertEquals;
import static org.assertj.core.api.Assertions.*;

public class AssertActions
{
    public void verifyResponseBody(String actual, String expected,String description){
        assertEquals(actual,expected,description);
    }

    public void verifyResponseBody(int actual,int expected,String description){
        assertEquals(actual,expected,description);
    }

    public void verifyStatusCode(Response response,Integer expected){
        assertEquals(response.getStatusCode(),expected);
    }

    public void verifyStringKey(String keyExpect,String keyActual)
    {
        assertThat(keyActual).isNotNull();
        assertThat(keyActual).isNotBlank();
        assertThat(keyActual).isEqualTo(keyExpect);
    }
    public void verifyStringKey(int keyActual,int keyExpect)
    {
        assertThat(keyActual).isNotNull();
        assertThat(keyActual).isEqualTo(keyExpect);
    }

    public void verifyStringKeyNotNull(String keyActual){
        assertThat(keyActual).isNotNull();
    }

    public void verifyStringKeyNotNull(int keyActual){
        assertThat(keyActual).isNotNull();
    }

}
