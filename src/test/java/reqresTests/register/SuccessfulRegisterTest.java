package reqresTests.register;

import org.testng.annotations.Test;
import pojo.RegisterUserRequestEntity;
import pojo.SuccessfulRegisterResponseEntity;
import helpers.RegisterHelper;

import static org.assertj.core.api.Assertions.assertThat;

public class SuccessfulRegisterTest {

    private static final String REGISTER_EMAIL = "eve.holt@reqres.in";
    private static final String REGISTER_PASSWORD = "pistol";
    private static final int EXPECTED_ID = 4;
    private static final String EXPECTED_TOKEN = "QpwL5tke4Pnpja7X4";

    @Test
    public void testSuccessfulRegister() {
        SuccessfulRegisterResponseEntity successfulRegister =
                new RegisterHelper<>()
                        .getSuccessfulRegisterEntity(RegisterUserRequestEntity.builder()
                                .email(REGISTER_EMAIL)
                                .password(REGISTER_PASSWORD).build());

        assertThat(successfulRegister.getId())
                .as("Id is incorrect")
                .isEqualTo(EXPECTED_ID);

        assertThat(successfulRegister.getToken())
                .as("Token is incorrect")
                .isEqualTo(EXPECTED_TOKEN);
    }
}
