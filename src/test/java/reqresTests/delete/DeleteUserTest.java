package reqresTests.delete;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import spec.Specifications;

import static io.restassured.RestAssured.given;

public class DeleteUserTest {

    @Test
    public void testSecondUserDeleted() {
        Specifications.buildSpec(Specifications.REQUEST_SPEC, Specifications.responseSpec(HttpStatus.SC_NO_CONTENT));
        given()
                .when()
                .delete("/users/2")
                .then().log().all();
    }
}
