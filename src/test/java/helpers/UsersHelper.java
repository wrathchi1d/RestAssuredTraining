package helpers;

import io.qameta.allure.Step;
import pojo.CreateUserRequestEntity;
import pojo.CreateUserResponseEntity;
import pojo.UserDataResponseEntity;

import java.util.List;

import static endpoints.ReqresEndpoints.USERS;
import static io.restassured.RestAssured.given;
import static spec.Specifications.REQUEST_SPEC;

public class UsersHelper {

    @Step("Get all users data")
    public List<UserDataResponseEntity> getUsers() {
        return given()
                .spec(REQUEST_SPEC)
                .when()
                .get(USERS)
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserDataResponseEntity.class);
    }

    @Step("Create '{user}' user")
    public CreateUserResponseEntity createUsers(CreateUserRequestEntity user) {
        return given()
                .spec(REQUEST_SPEC)
                .body(user)
                .when().post(USERS)
                .then().log().all()
                .extract().as(CreateUserResponseEntity.class);
    }
}
