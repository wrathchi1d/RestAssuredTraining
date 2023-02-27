package spec;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {

    public static final String BASE_URL = "https://reqres.in/api";

    public static final RequestSpecification REQUEST_SPEC =
         new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .setContentType(ContentType.JSON)
                .build();


    public static ResponseSpecification responseSpec(int code) {
        return new ResponseSpecBuilder()
                .expectStatusCode(code)
                .build();
    }

    public static void buildSpec(RequestSpecification request, ResponseSpecification response) {
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }
}
