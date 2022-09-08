package org.practise;

import bodyinfo.AddPlaceData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import pojo.AddPlace;
import static io.restassured.RestAssured.given;

public class SerilizationAddPlace extends AddPlace {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        String response = given().log().all().queryParam("key","qaclick123").contentType(ContentType.JSON)
                .body(AddPlaceData.addPlace()).when().post("/maps/api/place/add/json").then().assertThat().statusCode(200).extract()
                .response().asString();
        System.out.println(response);

    }

}
