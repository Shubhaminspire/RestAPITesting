package bodyinfo;

import org.practise.Basics;

public class BodyContent {

       public static String postMapBody = "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": 48.78569,\n" +
                "    \"lng\": 34.898842\n" +
                "  },\n" +
                "  \"accuracy\": 100,\n" +
                "  \"name\": \"Shubham Kumar Sharma\",\n" +
                "\"phone_number\": \"(+91) 9968455365\",\n" +
                "  \"address\": \"149, Govindpura,Jaipur 302012\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}\n";

    public static String updateMap(){
        return "{\n" +
                "\"place_id\":\""+ Basics.place_id +"\",\n" +
                "\"address\":\""+Basics.address+"\",\n" +
                "\"key\":\"qaclick123\"\n" +
                "}\n";
    }
}
