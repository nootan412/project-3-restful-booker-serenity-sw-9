package com.restful.booker.model;

import java.util.HashMap;

public class BookingPojo {
    private String firstname;
    private String lastname;
    private int totalPrice;
    private boolean depositPaid;
    private HashMap<String, String> bookingDates;
    private String additionalNeeds;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isDepositPaid() {
        return depositPaid;
    }

    public void setDepositPaid(boolean depositPaid) {
        this.depositPaid = depositPaid;
    }

    public HashMap<String, String> getBookingDates() {
        return bookingDates;
    }

    public void setBookingDates(HashMap<String, String> bookingDates) {
        this.bookingDates = bookingDates;
    }

    public String getAdditionalNeeds() {
        return additionalNeeds;
    }

    public void setAdditionalNeeds(String additionalNeeds) {
        this.additionalNeeds = additionalNeeds;
    }
    public static BookingPojo getBooking(String firstname,String lastname,int totalPrice,boolean depositPaid,String additionalNeeds,HashMap<String ,String > bookingDates ){
        BookingPojo bookingPojo = new BookingPojo();
        bookingPojo.setFirstname(firstname);
        bookingPojo.setLastname(lastname);
        bookingPojo.setTotalPrice(totalPrice);
        bookingPojo.setDepositPaid(depositPaid);
        bookingPojo.setAdditionalNeeds(additionalNeeds);
        bookingPojo.setBookingDates(bookingDates);
        return bookingPojo;
    }

}
