package RestAssured;
import com.fasterxml.jackson.core.JsonProcessingException;
import groovy.util.logging.Slf4j;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Slf4j
public class PetStoreTest {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(PetStoreTest.class);

    Response response;
    String [] bodyID3=null;
    String [] bodyID1=null;

    //Available durumunda olan tüm pathleri getirir.
    @Test(priority = 1, description = "Available durumunda olan tüm pathleri getirilir")
    public void findByStatusAvailable() throws JsonProcessingException {

        log.info("Available durumunda olan tüm pathleri getirir.");

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
        String [] bodySplit=body.split(",");
        bodyID3= bodySplit[16].split(":");
        bodyID1=bodySplit[0].split(":");
        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals("HTTP/1.1 200 OK",response.getStatusLine());


    }

    //Pending durumunda olan tüm pathleri getirir.
    @Test(priority = 2,description = "Pending durumunda olan tüm pathleri getirilir")
    public void findByStatusPending()  throws JsonProcessingException{
        log.info("Pending durumunda olan tüm pathleri getirir.");
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

    //Sold durumunda olan tüm pathleri getirir.
    @Test(priority = 3, description = "Sold durumunda olan tüm pathleri getirilir")
    public void findByStatusSold()  throws JsonProcessingException{
        log.info("Sold durumunda olan tüm pathleri getirir.");
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

    //Available durumunda olan tüm pathlerin üçüncüsünü getirir.
    @Test(priority = 4,description = "Available durumunda olan tüm pathlerin üçüncüsünü getirilir")
    public void setPetID() throws JsonProcessingException {
        log.info("Available durumunda olan tüm pathlerin üçüncüsünü getirir.");
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

    //Verilen veriler ile eşit olan petin durumunu günceller.
    @Test(priority = 5, description = "Girilen verilere sahip olan petin durumu güncellenir")
    public void updatePet() throws JsonProcessingException{
        log.info("Girilen veriler ile eşit olan petin durumunu günceller.");
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

    //Verilen ID değerindeki peti siler.
    @Test(priority = 6 , description = "Verilen ID değerindeki pet silinir")
    public void deletePet(){
        log.info("Verilen ID değerindeki peti siler.");
        response = given()
                .header("Content-Type","application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/pet/"+bodyID1[1])
                .then()
                //status kod direkt burada kontrol edildi.
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();
        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals("HTTP/1.1 200 OK",response.getStatusLine());
    }



}
