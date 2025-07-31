package com.testingproject.Sample;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestIntegrationSample {
    //Create booking
    //Verify get booking
    //Update booking
    //Delete booking

    @Test(groups={"qa"},priority=1)
    @Description("TC#INT1- Step1 - Verify that booking is created")
    @Owner("Poonam")
    public void testCreateBooking(){
        Assert.assertTrue(true);
    }

    @Test(groups={"qa"},priority=2)
    @Description("TC#INT2- Step 2 - Verify that able to retrieve booking with booking id ")
    @Owner("Poonam")
    public void testGetBooking(){
        Assert.assertTrue(true);
    }

    @Test(groups={"qa"},priority=3)
    @Description("TC#INT3- Step 3 - Verify that able to Update booking that was created before")
    @Owner("Poonam")
    public void testUpdateBooking(){
        Assert.assertTrue(true);
    }

    @Test(groups={"qa"},priority=4)
    @Description("TC#INT4- Step 4 - Verify that able to Delete booking that was created before")
    @Owner("Poonam")
    public void testDeleteBooking(){
        Assert.assertTrue(true);
    }
}
