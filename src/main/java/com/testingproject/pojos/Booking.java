package com.testingproject.pojos;

public class Booking {

    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;

    public String getFirstName(){
        return firstname;
    }
    public void setFirstName(String firstname){
        this.firstname=firstname;
    }

    public String getLastName(){
        return lastname;
    }
    public void setLastName(String lastname){
        this.lastname=lastname;
    }

    public Integer getTotalprice(){
        return totalprice;
    }
    public void setTotalprice(Integer totalprice)
    {
        this.totalprice=totalprice;
    }
    public Boolean getDepositpaid(){
        return depositpaid;
    }
    public void setDepositpaid(Boolean depositpaid){
        this.depositpaid=depositpaid;
    }

    public BookingDates getBookingdates(){
        return bookingdates;
    }
    public void setBookingdates(BookingDates bookingdates){
        this.bookingdates=bookingdates;
    }

    public String getAdditionalNeeds(){
        return additionalneeds;
    }
    public void setAdditionalneeds(String additionalneeds){
        this.additionalneeds=additionalneeds;
    }
}

