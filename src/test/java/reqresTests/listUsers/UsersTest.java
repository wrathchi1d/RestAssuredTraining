package reqresTests.listUsers;

import org.testng.annotations.Test;
import pojo.UserDataResponseEntity;
import helpers.UsersHelper;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class UsersTest {

    @Test
    public void testAvatarContainsUserId() {
        List<UserDataResponseEntity> users =
        new UsersHelper().getUsers();

        // Assert that user avatar contains user id string
        assertTrue(users.stream()
                .allMatch(user -> user.getAvatar().contains(user.getId().toString()))
        );

        // Assert that all user emails end with @reqres.in
        assertTrue(users.stream()
                .allMatch(user -> user.getEmail().endsWith("@reqres.in"))
        );
    }
}
