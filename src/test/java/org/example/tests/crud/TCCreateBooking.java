package org.example.tests.crud;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.example.base.BaseTest;
import org.example.endpoints.APIConstants;
import org.testng.annotations.Test;

public class TCCreateBooking extends BaseTest {


    @Owner("Maruf")
    @Description("Verify that the create booking with the valid payload, Status Code 200")
    @Test
    public void testPositivePOSTReq(){


        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given().spec(requestSpecification)
                .when().body(payloadManager.createPayloadGSON()).post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
    }

}
