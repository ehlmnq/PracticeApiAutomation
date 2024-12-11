package resources;

import io.restassured.RestAssured;

import io.restassured.response.Response;



import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiTest {

public static void main(String [] args)
{
	
    	RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        // Send a GET request to the /users endpoint
        Response response = 
                given()
                    .when()
                    .get("/users")
                    .then()
                    .statusCode(200) // Validate the response status code
                    .body("size()", greaterThan(0)) // Validate that the response contains at least one user
                    .body("[0].id", equalTo(1)) // Validate the id of the first user
                    .body("[0].name", notNullValue()) // Validate the name of the first user is not null
                    .extract()
                    .response();
        
        // Print the response body
        System.out.println(response.getBody().asString());
	
}
   
    
    
}