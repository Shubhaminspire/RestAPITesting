package org.practise;


import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import pojo.Api;
import pojo.GetCourse;
import pojo.WebAutomation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PojoDeserialization {

    public static void main(String[] args) {
        String[] courseTitles= { "Selenium Webdriver Java","Cypress","Protractor"};

        String accessTokenResponse=	given().urlEncodingEnabled(false)
                .queryParams("code","4%2F0AdQt8qhdWKVSp2loh7KujZ-ejLafkMDyk5SDLJ9OBSDMotE7uOwsObBmZqv7IBcMKeWa0A")
                .queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
                .queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
                .queryParams("grant_type","authorization_code")
                .when().log().all()
                .post("https://www.googleapis.com/oauth2/v4/token").asString();
        JsonPath js=new JsonPath(accessTokenResponse);
        String accessToken=js.getString("access_token");

       GetCourse cour = given().queryParam("access_token",accessToken).expect().defaultParser(Parser.JSON)
                .when().get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);



        System.out.println(cour.getInstructor()+" "+cour.getUrl()+" "+cour.getServices()+" "+cour.getExpertise()+" "+cour.getLinkedIn());

        System.out.println(cour.getCourses().getApi().get(1).getCourseTitle());


        List<Api> apiCourses=cour.getCourses().getApi();
        for(int i=0;i<apiCourses.size();i++)
        {
            if(apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
            {
                System.out.println(apiCourses.get(i).getPrice());
            }
        }

        //Get the course names of WebAutomation
        ArrayList<String> a= new ArrayList<String>();


        List<WebAutomation> w=cour.getCourses().getWebAutomation();

        for(int j=0;j<w.size();j++)
        {
            a.add(w.get(j).getCourseTitle());
        }

        List<String> expectedList=	Arrays.asList(courseTitles);

        Assert.assertTrue(a.equals(expectedList));






        //System.out.println(response);
    }


}
