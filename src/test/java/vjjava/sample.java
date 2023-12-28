package vjjava;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class sample {
	
@Test
private void tc0() {
	RestAssured.baseURI="https://reqres.in/";
	RequestSpecification resquestspecification= RestAssured.given();
	resquestspecification.queryParam("Page","2");
	Response response=resquestspecification.request(Method.GET,"/api/users?page=2");
	int statuscode=response.getStatusCode();
	System.out.println(statuscode);
	String asprettystring =response.getBody().asPrettyString();
	System.out.println(asprettystring);
	
}
@Test
private void tc1() {
	RestAssured.baseURI="https://reqres.in/";
	RequestSpecification requestspecification=RestAssured.given();
	requestspecification.pathParam("id", "2");
	Response response=requestspecification.request(Method.GET,"/api/users/2{id}");
	int statuscode =response.statusCode();
	System.out.println(statuscode);
	String asprettystring=response.getBody().asPrettyString();
	System.out.println(asprettystring);
	
}
@Test
private void tc3() {
	RestAssured.baseURI="https://reqres.in/";
	RequestSpecification requestspecification=RestAssured.given();
	JSONObject jsonobject=new JSONObject();
	jsonobject.put("name","Ram Sarath");
	jsonobject.put("job","leader");
	requestspecification.body(jsonobject.toJSONString());
	Response response=requestspecification.request(Method.POST,"/api/users");
	int statuscode=response.getStatusCode();
	System.out.println(statuscode);
	String asprettystring=response.getBody().asPrettyString();
	System.out.println(asprettystring);
	
}
	@Test
	private void tc4() {
		RestAssured.baseURI="https://reqres.in/";
		RequestSpecification requestspecification=RestAssured.given();
		JSONObject jsonobject=new JSONObject();
		jsonobject.put("name","babu");
		jsonobject.put("job", "QA");
		requestspecification.body(jsonobject.toJSONString());
		requestspecification.pathParam("id","2");
		Response response=requestspecification.request(Method.PUT,"/api/users/2/{id}");
		int statuscode=response.getStatusCode();
		System.out.println(statuscode);
		String asprettystring=response.getBody().asPrettyString();
		System.out.println(asprettystring);
	}
}




