package reqresTests.create;

import org.testng.annotations.Test;
import pojo.CreateUserRequestEntity;
import pojo.CreateUserResponseEntity;
import helpers.UsersHelper;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateUserTest {

    private static final String USER_NAME = "morpheus";
    private static final String USER_JOB = "leader";

    @Test
    public void testUserCreated() {
        CreateUserResponseEntity createUserResponseEntity =
                new UsersHelper()
                        .createUsers(CreateUserRequestEntity.builder()
                        .name(USER_NAME)
                        .job(USER_JOB).build());

        assertThat(createUserResponseEntity.getName()).isEqualTo(USER_NAME);
        assertThat(createUserResponseEntity.getJob()).isEqualTo(USER_JOB);
    }
}
