package br.com.postech.techchallengeclientregistration.bdd.stepDefs;

import static io.restassured.RestAssured.given;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.response.Response;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@CucumberContextConfiguration
public class CucumberSteps {
  private Response response;
  private String request;

  @LocalServerPort
  private Integer port;

  private static final String HOST = "http://localhost:";
  private static final String BASE_URL_PREFIX = "/techchallenge/clients";

  @Given("client wants to register")
  public void clientWantsToRegister() {
    request = "{\n" +
        "\"cpf\":\"36227297836\",\n" +
        "\"name\":\"Alex Ferreira\",\n" +
        "\"email\":\"alex@teste.com\",\n" +
        "\"date_of_birth\":\"05-06-1994\"\n" +
        "}";

  }

  @When("client calls registration endpoint")
  public void clientCallsRegistrationEndpoint() {
    response = given()
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(request)
        .when()
        .post(HOST + port + BASE_URL_PREFIX);
  }

  @Then("client receives success confirmation")
  public void clientReceivesSuccessConfirmation() {
    response.then()
        .statusCode(HttpStatus.CREATED.value());
  }
}
