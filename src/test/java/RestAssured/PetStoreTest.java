package RestAssured;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
public class PetStoreTest {

    Response response;
    String [] bodyID3=null;
    String [] bodyID1=null;

    @Test(priority = 1)
    public void findByStatusAvailable() throws JsonProcessingException {

        response = given()
                .header("Content-Type","application/json")
                .when()
                .get("https://petstore.swagger.io/v2/pet/findByStatus?status=available")
                .then()
                //status kod direkt burada kontrol edildi.
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();

        String body=response.getBody().asString();
        System.out.println(body);
        String [] bodySplit=body.split(",");
        bodyID3= bodySplit[22].split(":");
        bodyID1=bodySplit[0].split(":");
        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals("HTTP/1.1 200 OK",response.getStatusLine());


    }

    @Test(priority = 2)
    public void findByStatusPending()  throws JsonProcessingException{
        response = given()
                .header("Content-Type","application/json")
                .when()
                .get("https://petstore.swagger.io/v2/pet/findByStatus?status=pending")
                .then()
                //status kod direkt burada kontrol edildi.
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();


        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals("HTTP/1.1 200 OK",response.getStatusLine());

    }

    @Test(priority = 3)
    public void findByStatusSold()  throws JsonProcessingException{
        response = given()
                .header("Content-Type","application/json")
                .when()
                .get("https://petstore.swagger.io/v2/pet/findByStatus?status=sold")
                .then()
                //status kod direkt burada kontrol edildi.
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();



        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals("HTTP/1.1 200 OK",response.getStatusLine());

    }

    @Test(priority = 4)
    public void setPetID() throws JsonProcessingException {
        System.out.println(bodyID3[1]);
        response = given()
                .header("Content-Type","application/json")
                .when()
                .get("https://petstore.swagger.io/v2/pet/"+bodyID3[1])
                .then()
                //status kod direkt burada kontrol edildi.
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();

        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals("HTTP/1.1 200 OK",response.getStatusLine());
    }

    @Test(priority = 5)
    public void updatePet() throws JsonProcessingException{
        response = given()
                .header("Content-Type","application/x-www-form-urlencoded")
                .body("{\r\n    \"name\": \"fish\",\r\n    \"status\": \"sold\"\r\n}")
                .when()
                .post("https://petstore.swagger.io/v2/pet/"+bodyID1[1])
                .then()
                //status kod direkt burada kontrol edildi.
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();

        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals("HTTP/1.1 200 OK",response.getStatusLine());
    }

    @Test(priority = 6 )
    public void deletePet(){
        response = given()
                .header("Content-Type","application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/pet/"+bodyID1[1])
                .then()
                //status kod direkt burada kontrol edildi.
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();
    }



}
