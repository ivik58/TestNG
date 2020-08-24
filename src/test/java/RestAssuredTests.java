import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;


public class RestAssuredTests {

    private static String API_KEY = "5f0075b64fba644dabbea818c980ef18";
    private static String URL = "http://api.openweathermap.org/data/2.5/weather";
    private static String CITY = "Penza";

    @Test
    public void getTemperature() {

        Response response =
                given()
                        .param("q", CITY)
                        .param("appid", API_KEY)
                        .when()
                        .get(URL)
                        .then()
                        .statusCode(200)
                        .log()
                        .body()
                        .extract()
                        .response();

        Map<String, String> main = response.jsonPath().getMap("main");
        String kelvin_temp = String.valueOf(main.get("temp"));
        Double celsius_temp = Double.valueOf(kelvin_temp) - 273.15;
        System.out.println("Temperature in Celsius = " + celsius_temp);
        Assert.assertEquals(response.getBody().asString().contains("Penza"), true);
    }

}
