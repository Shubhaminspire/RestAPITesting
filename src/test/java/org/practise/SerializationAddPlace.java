package org.practise;

import bodyinfo.AddPlaceData;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.AddPlace;

import static io.restassured.RestAssured.given;

public class SerializationAddPlace {
    public static void main(String[] args) {

        RequestSpecification request = given().log().all().spec(AddPlaceData.reqSpec)
                .body(AddPlaceData.addPlace());

        Response response = request.when().post("/maps/api/place/add/json").then().spec(AddPlaceData.resSpec)
                .extract().response();
        String extractResponse = response.asString();

        System.out.println(extractResponse);

    }

}
