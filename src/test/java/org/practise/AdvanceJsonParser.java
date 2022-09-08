package org.practise;

import bodyinfo.CoursesResponse;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

public class AdvanceJsonParser {

    public static void main(String[] args) {
        JsonPath path  = new JsonPath(CoursesResponse.CoursesList("Selinium Python","Cypress","RPA"));

       // Print No of courses returned by API
       int coursesLength =  path.get("courses.size()");
        System.out.println("The no of courses offered are: "+coursesLength);


        // Print Purchase Amount
       int purchaseAmount =  path.get("dashboard.purchaseAmount");
        System.out.println("The Purchase Amount is: "+purchaseAmount);

        //3. Print Title of the first course
        System.out.println(path.getString("courses[0].title"));
        String courseName;
        String[] course = new String[coursesLength];
        int[] coursePrice = new int[coursesLength];
        //4. Print All course titles and their respective Prices
        for(int i=0; i<coursesLength; i++){
            course[i] = path.get("courses["+i+"].title");
             coursePrice[i] = path.get("courses["+i+"].price");
            System.out.println("The Course name is: "+course[i]+" and it's Price is: "+coursePrice[i]);

        }
        //5. Print no of copies sold by RPA Course
        for(int j=0; j<coursesLength; j++){
          //  courseName = path.get("courses["+j+"].title");
            int copiesSold = path.get("courses["+j+"].copies");
            if(course[j].equalsIgnoreCase("RPA")){
                System.out.println("The no of Copies sold by: "+course[j]+" are: "+copiesSold);
                break;
            }

        }


        //6. Verify if Sum of all Course prices matches with Purchase Amount
        int sum=0;
        for (int k =0;k<coursesLength;k++){
            int course_Price = path.get("courses["+k+"].price");
            int copies = path.get("courses["+k+"].copies");
            sum+=course_Price*copies;
        }

        System.out.println(sum);

        Assert.assertEquals(sum,purchaseAmount);


    }



}
