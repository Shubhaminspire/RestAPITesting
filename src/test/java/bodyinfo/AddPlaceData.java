package bodyinfo;

import pojo.AddPlace;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;

public class AddPlaceData {
    private static List<String> types = new ArrayList<>(List.of("shoe park", "shoe"));

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
