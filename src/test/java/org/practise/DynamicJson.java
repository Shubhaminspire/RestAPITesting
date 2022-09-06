package org.practise;

import bodyinfo.BodyContent;
import bodyinfo.Reuse;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class DynamicJson {
    @Test
    public void addBook(){
        baseURI = "http://216.10.245.166";
//       String AddBook_Response =  given().header("Content-Type","application/json")
//                .body(BodyContent.getBookBody())
//                .when().post("/Library/Addbook.php").then().assertThat().statusCode(200)
//                .extract().response().asString();
//
//        JsonPath path = Reuse.rawtoJson(AddBook_Response);
//        String id = path.get("ID");
//        System.out.println(id);

        // Getting the Body Attribute Value as a Parameter
        String AddBook_Response =  given().header("Content-Type","application/json")
                .body(BodyContent.getBookBody("abdjl8d","567"))
                .when().post("/Library/Addbook.php").then().assertThat().statusCode(200)
                .extract().response().asString();

        JsonPath path = Reuse.rawtoJson(AddBook_Response);
        String id = path.getString("ID");
        System.out.println(id);

    }
}
