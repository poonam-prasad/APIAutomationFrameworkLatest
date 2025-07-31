package com.testingproject.modules;

import com.google.gson.Gson;
import com.testingproject.pojos.*;

public class PayloadManager {
    Gson gson;
    public String createBookingPayloadAsString(){
        Booking booking=new Booking();
        booking.setFirstName("Poonam");
        booking.setLastName("Prasad");
        booking.setTotalprice(123);
        booking.setDepositpaid(true);

        BookingDates bookingDates=new BookingDates();
        bookingDates.setCheckin("2026-03-21");
        bookingDates.setCheckout("2026-05-21");
        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds("Breakfast");

        //Payload in Java Object
        System.out.println(booking);

         gson=new Gson();
        String jsonStringBoooking=gson.toJson(booking);
        return jsonStringBoooking;
    }

    //Deserialization
    public BookingResponse bookingResponseJava(String responseJSONString){
        gson=new Gson();
        BookingResponse bookingResponse=gson.fromJson(responseJSONString,BookingResponse.class);
        return bookingResponse;
    }

    public String createTokenPayloadAsJSON(){
        Auth auth=new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");

        gson=new Gson();
        String tokenPayloadAsJson=gson.toJson(auth);
        return tokenPayloadAsJson;
    }

    public TokenResponse tokenResponseAsJavaObject(String tokenResponseAsJSON){
        TokenResponse tokenResponseAsJavaObj=gson.fromJson(tokenResponseAsJSON,TokenResponse.class);
        return tokenResponseAsJavaObj;
    }

    public Booking getResponseFromJSON(String responseJSON){
        gson=new Gson();
        Booking booking=gson.fromJson(responseJSON,Booking.class);
        return booking;
    }
}
