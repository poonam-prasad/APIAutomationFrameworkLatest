package com.testingproject.pojos;

public class BookingResponse {
    Booking booking;
    int bookingId;

    public Booking getBooking(){
        return booking;
    }
    public void setBooking(){
        this.booking=booking;
    }

    public int getBookingId(){
        return bookingId;
    }
    public void setBookingId(int bookingId){
        this.bookingId=bookingId;
    }
}