package Util;


import context.ScenarioContext;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utility.Constants;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtility {

  private static final Logger log = LoggerFactory.getLogger(TestUtility.class);

  public static void invokePostAPI(RequestSpecification request, Map<String, Object> pathParam) throws InterruptedException {
    String postRequestUrl = Constants.TOKEN_URL;

    int count=1;
    while(count>0 &&count<=3) {
      try {
        ScenarioContext.response= request.when().post(postRequestUrl).prettyPeek();
        break;
      }catch ( Exception e){
        log.error(" Connection error"+e.getMessage());
        Thread.sleep(3000);
        count++;
      }
    }
    log.info("Response"+ScenarioContext.response.body().prettyPrint());
  }

  public static void invokePostAPI(RequestSpecification request, String endpoint,Map<String, Object> pathParam) throws InterruptedException {

    int count=1;
    while(count>0 &&count<=3) {
      try {
        ScenarioContext.response= request.when().log().all().post(endpoint).prettyPeek();
        // ScenarioContext.response= request.when().post(endpoint).prettyPeek();
        break;
      }catch ( Exception e){
        log.error(" Connection error"+e.getMessage());
        Thread.sleep(3000);
        count++;
      }
    }
    log.info("Response"+ScenarioContext.response.body().prettyPrint());
  }
  public static void invokePutAPI(RequestSpecification request, String endpoint,Map<String, Object> pathParam) throws InterruptedException {

    int count =1;
    while(count>0 &&count<=3) {
      try {
        ScenarioContext.response= request.when().log().all().put(endpoint).prettyPeek();
        break;
      }catch ( Exception e){
        log.error(" Connection error"+e.getMessage());
        Thread.sleep(3000);
        count++;
      }
    }
    log.info("Response"+ScenarioContext.response.body().prettyPrint());
  }

  public static void invokeDeleteAPI(RequestSpecification request, String endpoint,Map<String, Object> pathParam) throws InterruptedException {

    int count=1;
    while(count>0 &&count<=3) {
      try {
        ScenarioContext.response= request.when().log().all().delete(endpoint).prettyPeek();
        // ScenarioContext.response= request.when().delete(endpoint).prettyPeek();
        break;
      }catch ( Exception e){
        log.error(" Connection error"+e.getMessage());
        Thread.sleep(3000);
        count++;
      }
    }
    log.info("Response"+ScenarioContext.response.body().prettyPrint());
  }

  public static void invokeGetAPI(RequestSpecification request, String endPoint,String queryString) throws InterruptedException {
    Thread.sleep(1000);
    int count=1;
    while(count>0 &&count<=3) {
      try {
        ScenarioContext.response= request.when().log().all().get(endPoint).prettyPeek();
        //  ScenarioContext.response= request.when().get(endPoint).prettyPeek();
        break;
      }catch ( Exception e){
        log.error(" Connection error"+e.getMessage());
        Thread.sleep(5000);
        count++;
      }
    }
    log.info("Response"+ScenarioContext.response.body().prettyPrint());
  }



  public static HashMap<String,Object> convertJSONFileIntoMap(String fileName) throws IOException {

    log.info("File Read"+fileName);

    return new ObjectMapper().readValue(readjsonFileToString(fileName), HashMap.class);

  }

  public static String readjsonFileToString(String filePath) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(filePath)));
    String result;
    StringBuilder stringBuilder = new StringBuilder();
    while ((result = bufferedReader.readLine()) != null) {
      stringBuilder.append(result);
    }
    return stringBuilder.toString();


  }




}
