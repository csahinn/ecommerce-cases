import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.json.JSONObject;

public class ApiTesting {
    private String baseUrl = "https://reqres.in/api";
    private String bearerToken = "QpwL5tke4Pnpja7X4"; //static bearer token of reqres.in

    @Test
    public void getUserList() { //GET REQUEST HAPPY PATH: We expect to return 200.
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + bearerToken)
                .get(baseUrl + "/users/2");

        Assert.assertEquals(response.getStatusCode(), 200);

        System.out.println(response.getBody().asString());
    }

    @Test
    public void getUserList2() { //We expect to return 404.
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + bearerToken)
                .get(baseUrl + "/users/23");

        Assert.assertEquals(response.getStatusCode(), 404);
        System.out.println(response.getBody().asString());
    }

    @Test
    public void loginAccount() { //POST REQUEST HAPPY PATH: We expect to return 200.
        String requestBody = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"cityslicka\"\n" +
                "}";

        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + bearerToken)
                .body(requestBody)
                .post(baseUrl + "/login");

        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println(response.getBody().asString());

    }

    @Test
    public void loginAccountMissingPassword() { //We expect to return 400: Missing Password.
        String requestBody = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "}";

        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + bearerToken)
                .body(requestBody)
                .post(baseUrl + "/login");

        Assert.assertEquals(response.getStatusCode(), 400); //Check response code

        System.out.println(response.getBody().asString()); //Print the body
    }
    /*
    @Test
    public void loginAccountInvalidPassword() { //We expect to return 400: Invalid Password.
        String requestBody = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"asdasd\"\n" +
                "}";

        Response response = RestAssured
               .given()
               .header("Content-Type","application/json")
                .header("Authorization","Bearer "+bearerToken)
               .body(requestBody)
               .post(baseUrl+"/login");

        Assert.assertEquals(response.getStatusCode(),400); //Check response code
        System.out.println(response.getBody().asString()); //Print the body
    }

    @Test
    public void loginAccountMissingBearerToken () { //We expect to return 401: Unauthorizated.
        String requestBody = "{\n" +
               "    \"email\": \"eve.holt@reqres.in\",\n" +
               "    \"password\": \"cityslicka\"\n" +
               "}";

        Response response = RestAssured
               .given()
               .header("Content-Type","application/json")
               .header("Authorization","Bearer ")
               .body(requestBody)
               .post(baseUrl+"/login");

        Assert.assertEquals(response.getStatusCode(),401); //Check response code
        System.out.println(response.getBody().asString()); //Print the body
    }

    @Test
    public void loginAccountInvalidBearerToken () { //We expect to return 401: Unauthorizated.
        String requestBody = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"cityslicka\"\n" +
                "}";

        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer invalidToken") //reqres.in Bearer Token alındı.
                .body(requestBody)
                .post(baseUrl + "/login");

        Assert.assertEquals(response.getStatusCode(), 401); //Check response code
        System.out.println(response.getBody().asString()); //Print the body
    } */
}