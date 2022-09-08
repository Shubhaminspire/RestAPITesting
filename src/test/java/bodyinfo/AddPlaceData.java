package bodyinfo;

import com.github.dockerjava.core.dockerfile.DockerfileStatement;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;

public class AddPlaceData {
    public static String Url = "https://rahulshettyacademy.com";
    private static List<String> types = new ArrayList<>(List.of("shoe park", "shoe"));

    // Request Spec Builder that can be used anywhere where we are sending common chaining across Test
    public static RequestSpecification reqSpec = new RequestSpecBuilder().setBaseUri(Url)
            .addQueryParam("key", "qaclick123")
            .setContentType(ContentType.JSON).build();

    // Request Spec Builder that can be used anywhere where we are sending common chaining across Test
    public static ResponseSpecification resSpec = new ResponseSpecBuilder().expectStatusCode(200)
            .expectContentType(ContentType.JSON).build();

    public static AddPlace addPlace() {

        AddPlace place = new AddPlace();
        Location loc = new Location();
        loc.setLat(48.78569);
        loc.setLng(34.898842);

        place.setAccuracy(100);
        place.setName("Shubham Kumar Sharma");
        place.setPhone_number("(+91) 9968455365");
        place.setAddress("149A, Govindpura, Jaipur 302012");
        place.setWebsite("http://google.com");
        place.setLanguage("Indian");
        place.setTypes(types);
        place.setLocation(loc);
        return place;
    }
}
