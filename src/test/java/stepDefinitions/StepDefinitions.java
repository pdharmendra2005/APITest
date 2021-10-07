package stepDefinitions;
import static context.ScenarioContext.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import context.ScenarioContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.plugin.event.Node;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static Util.TestUtility.convertJSONFileIntoMap;
import static Util.TestUtility.invokePostAPI;
import static utility.Constants.TOKEN_URL;

public class StepDefinitions {
public static RequestSpecification request;
private static final String JSON_REQUEST_DIRECTORY="src/main/java/testData/";
  public StepDefinitions(){


  }

  @Given("^i have test data$")
  public void i_have_test_data()  {

  }

  @When("^i make a call to testworld api$")
  public void i_make_a_call_to_testworld_api() throws IOException, InterruptedException {
    request = RestAssured.with();
    Map<String, Object> headers = new HashMap<>();


    headers.put("Content-Type", "application/json");
    headers.put("Accept","application/json");
    System.out.println("path"+JSON_REQUEST_DIRECTORY + "Test1.json");
    Map<String, Object> requestBody = convertJSONFileIntoMap(JSON_REQUEST_DIRECTORY + "Test1.json");


    if(!headers.isEmpty()) {
      request.headers(headers);
    }
    request.body(requestBody);


    String endPoint = TOKEN_URL+"/api/technicalskills ";
    invokePostAPI(request, endPoint,null);

  }

  @Then("^i should see status code 200$")
  public void i_should_see_status_code_200()  {
    System.out.println("response======"+ response);
    System.out.println("status code===="+response.getStatusCode());
assertThat(response.getStatusCode(),equalTo(200));

  }



  @And("^i validate response key \"([^\"]*)\" value \"([^\"]*)\"$")
  public void i_validate_response_key_something_value_something(String keyheader, String keyvalue){
    String st1= response.getBody().jsonPath().getString(keyheader);
    System.out.println("st1===="+st1);
    assertThat(st1, equalTo(keyvalue));

  }


  @And("i validate response key <{string}> value <{string}>")
  public void iValidateResponseKeyValue(String keyheader, String keyvalue) {
    String st1= response.getBody().jsonPath().getString(keyheader);
    System.out.println("st1===="+st1);
    assertThat(st1, equalTo(keyvalue));
  }
}

