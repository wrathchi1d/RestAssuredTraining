package reqresTests.listUsers;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import pojo.UserDataResponseEntity;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

public class SimpleUsersWithoutSpecTest {

    private static final String BASE_URL = "https://reqres.in/api";

    @Test
    public void testAvatarContainsUserId() {
        List<UserDataResponseEntity> users = given()
                .contentType(ContentType.JSON)
                .when()
                .get(BASE_URL + "/users")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserDataResponseEntity.class);

        // Assert that user avatar contains user id string
//        users.forEach(user -> assertTrue(user.getAvatar().contains(user.getId().toString())));
        assertTrue(users.stream()
                .allMatch(user -> user.getAvatar().contains(user.getId().toString()))
        );

        // Assert that all user emails end with @reqres.in
        assertTrue(users.stream()
                .allMatch(user -> user.getEmail().endsWith("@reqres.in"))
        );
    }
}
