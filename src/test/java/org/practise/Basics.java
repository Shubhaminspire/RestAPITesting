package org.practise;

// Given - all input details
// When - Submit the API - Resource and Http Method
// Then - Validating Response

import bodyinfo.BodyContent;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Basics {
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
       String response =  given().queryParam("key","qaclick123").header("Content-Type","application/json").
                body(BodyContent.postMap).when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200).body("scope",equalTo("APP"))
                .header("Server","Apache/2.4.41 (Ubuntu)").extract().response().asString();

        System.out.println(response);

        JsonPath path = new JsonPath(response);

        String place_id = path.getString("place_id");
        String status = path.getString("status");
        System.out.println("\"place_id\": " +place_id);

        Assert.assertEquals(status,"OK","Not Matching with actual status value of Response");
    }

}
