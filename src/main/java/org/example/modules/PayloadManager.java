package org.example.modules;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.example.payloads.pojos.*;

import java.util.Collections;

public class PayloadManager {
    Gson gson;


    public String createPayloadGSON() {
        Faker faker = new Faker();
        Booking booking = new Booking();
        String expectFirstName = faker.name().firstName();


        booking.setFirstname(expectFirstName);
        booking.setLastname("Sherikar");
        booking.setTotalprice(999);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2018-01-01");
        ;
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds(Collections.singletonList("Breakfast"));

        System.out.println(booking);
        // object -> JSOn String (GSON)

        Gson gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        System.out.println(jsonStringBooking);
        return jsonStringBooking;

    }


    public String updatePayload() {

        Booking booking = new Booking();
        booking.setFirstname("Amit");
        booking.setLastname("Sherikar");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds(Collections.singletonList("Breakfast"));

        System.out.println(booking);
        // Object -> JSON String (GSON)
        gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        System.out.println(jsonStringBooking);
        return jsonStringBooking;

    }

    public String setAuthPayload() {
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");
        gson = new Gson();
        String jsonStringBooking = gson.toJson(auth);
        System.out.println(jsonStringBooking);
        return jsonStringBooking;
    }

    public String getTokenFromJSON(String tokenResponse){
        gson = new Gson();
        TokenResponse tokenResponse1 = gson.fromJson(tokenResponse,TokenResponse.class);
        return  tokenResponse1.getToken();
    }


    public BookingRespons bookingResponseJava(String responseString){
        gson = new Gson();
        BookingRespons bookingRespons = gson.fromJson(responseString,BookingRespons.class);
        return bookingRespons;

    }

    public Booking bookingResponsePUTReqJava(String responseString){
        gson = new Gson();
        Booking booking = gson.fromJson(responseString,Booking.class);
        return booking;

    }


}
