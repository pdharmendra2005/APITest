package stepDefinitions;

import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;

public class Hooks {

  @Before
  public void beforeScenario(){

  }
  public void setup() {
    try {
      RestAssured.useRelaxedHTTPSValidation();

    } catch (Exception ex) {

      ex.printStackTrace();
    }


  }

  @After
  public void afterScenario() {

  }
}
