package org.practise;

// Given - all input details
// When - Submit the API - Resource and Http Method
// Then - Validating Response

import bodyinfo.BodyContent;
import bodyinfo.Reuse;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Basics {
    public static String place_id;

    public static String address = "PNo 149 Main Road Govindpura, Jaipur";
    public static String status;

    //static BodyContent content;
    public static void main(String[] args) {
        //content= new BodyContent();
        // Verify that Add Place API is working fine
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        //RestAssured.basePath ="/maps/api/place/add/";
//        given().log().all().queryParam("key","qaclick123").header("Content-Type","application/json").
//                body(BodyContent.postMap).when().post("/maps/api/place/add/json")
//                .then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
//                .header("Server","Apache/2.4.41 (Ubuntu)");

        // Add Place > Update Place with New Address > Get Place to validate if New Address is Present in Response
        String response = given().queryParam("key", "qaclick123").header("Content-Type", "application/json").
                body(BodyContent.postMapBody).when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200).body("scope", equalTo("APP"))
                .header("Server", "Apache/2.4.41 (Ubuntu)").extract().response().asString();

        System.out.println(response);

        JsonPath res1 = Reuse.rawtoJson(response);

        place_id = res1.getString("place_id");
        status = res1.getString("status");
        System.out.println("\"place_id\": " + place_id);

        Assert.assertEquals(status, "OK", "Not Matching with actual status value of Response");


        //Update Address
        given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body(BodyContent.updateMap()).when().put("/maps/api/place/update/json")
                .then().log().all().assertThat().statusCode(200)
                .body("msg", equalTo("Address successfully updated"));


// get the update Address Value and Compare with Expected using Assert

        String getResponse = given().log().all().queryParam("key", "qaclick123")
                .queryParam("place_id", place_id)
                .header("Content-Type", "application/json").when().get("/maps/api/place/get/json")
                .then().assertThat().statusCode(200).extract().response().asString();

        JsonPath path2 = Reuse.rawtoJson(getResponse);

        Assert.assertEquals(path2.getString("address"), address);
        System.out.println(path2.getString("address"));
        System.out.println("Successfully Validated");

    }

}
