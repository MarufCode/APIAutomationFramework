package org.example.tests.crud;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.example.base.BaseTest;
import org.example.endpoints.APIConstants;
import org.openxmlformats.schemas.drawingml.x2006.chart.CTRotY;
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

    @Test
    @Owner("Maruf")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC#2 - Verify that the Booking not created when Payload is missing")
    public void testCreateBookingNegative() {
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured.given().spec(requestSpecification)
                .when().body("{}").post();
        validatableResponse = response.then().log().all();
        // TestNG Assertions
        assertActions.verifyStatusCodeInvalidReq(response);
    }


}
