package reqresTests.listResource;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import pojo.ResourceDataResponseEntity;
import spec.Specifications;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class ResourceTest {

    @Test
    public void testResourcesSortedByYearInAscendingOrder() {
        Specifications.buildSpec(Specifications.REQUEST_SPEC, Specifications.responseSpec(HttpStatus.SC_OK));

        List<ResourceDataResponseEntity> resources = given()
                .when()
                .get("/unknown")
                .then().log().all()
                .extract().body().jsonPath().getList("data", ResourceDataResponseEntity.class);

        List<Integer> years = resources.stream()
                .map(ResourceDataResponseEntity::getYear)
                .collect(Collectors.toList());

        List<Integer> sortedYears = years.stream()
                .sorted()
                .collect(Collectors.toList());

        assertEquals(years, sortedYears);
    }
}
