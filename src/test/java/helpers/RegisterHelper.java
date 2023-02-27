package helpers;

import io.restassured.response.ValidatableResponse;
import pojo.RegisterUserRequestEntity;
import pojo.SuccessfulRegisterResponseEntity;
import pojo.UnsuccessfulRegisterResponseEntity;
import spec.Specifications;

import java.util.function.UnaryOperator;

import static endpoints.ReqresEndpoints.REGISTER;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.apache.http.HttpStatus.SC_OK;
import static spec.Specifications.REQUEST_SPEC;

public class RegisterHelper<T extends RegisterHelper> {

    private ValidatableResponse registerUser(RegisterUserRequestEntity user) {
        return given()
                .spec(REQUEST_SPEC)
                .body(user)
                .when().post(REGISTER)
                .then().log().all();
    }

    public  SuccessfulRegisterResponseEntity getSuccessfulRegisterEntity(RegisterUserRequestEntity user) {
        return registerUser(user)
                .spec(Specifications.responseSpec(SC_OK))
                .extract().as(SuccessfulRegisterResponseEntity.class);
    }

    public UnsuccessfulRegisterResponseEntity getUnsuccessfulRegisterEntity(RegisterUserRequestEntity user) {
        return registerUser(user)
                .spec(Specifications.responseSpec(SC_BAD_REQUEST))
                .extract().as(UnsuccessfulRegisterResponseEntity.class);
    }

    public T withValidationFunction(UnaryOperator<ValidatableResponse> validationFunction) {
        this.responseValidationFunction = validationFunction;
        return (T) this;
    }

    private UnaryOperator<ValidatableResponse> responseValidationFunction =
            response -> response.log().ifValidationFails().statusCode(200);
}
