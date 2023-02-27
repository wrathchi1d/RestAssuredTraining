package reqresTests.register;

import org.testng.annotations.Test;
import pojo.RegisterUserRequestEntity;
import helpers.RegisterHelper;

import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.assertj.core.api.Assertions.assertThat;

public class UnsuccessfulRegisterTest {

    private static final String REGISTER_EMAIL = "sydney@fife";
    private static final String EXPECTED_ERROR = "Missing password";

    @Test(enabled = false)
    public void testUnsuccessfulRegister() {
        String unsuccessfulRegisterMessage =
               new RegisterHelper<>()
                       .withValidationFunction(response -> response.log().ifValidationFails().statusCode(SC_BAD_REQUEST))
                       .getUnsuccessfulRegisterEntity(RegisterUserRequestEntity.builder()
                                .email(REGISTER_EMAIL).build()).getError();

        assertThat(unsuccessfulRegisterMessage)
                .as("Error message is incorrect")
                .isEqualTo(EXPECTED_ERROR);
    }
}
