package org.example.modules;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import org.example.payloads.pojos.Booking;
import org.example.payloads.pojos.Bookingdates;

import java.util.Collections;

public class PayloadManager {


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


    public void updatePayload(){



    }


}
