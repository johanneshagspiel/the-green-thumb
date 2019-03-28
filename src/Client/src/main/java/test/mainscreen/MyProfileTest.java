package test.mainscreen;

import entity.User;
import GUI_mainscreen.MyProfile;
import org.junit.Test;
import service.UserServiceImpl;

/**
 * The type My profile test.
 */
public class MyProfileTest {

    /**
     * Test application.
     */
    @Test
    public void testApplication() {
        // Setup
        final User userIn = null;
        final UserServiceImpl clientIn = null;
        final String username = "Ardy";

        // Run the test
        MyProfile.application(userIn, clientIn, username);

        // Verify the results
    }

    /**
     * Test initialize.
     */
    @Test
    public void testInitialize() {
        // Setup
        final User userIn = null;
        final UserServiceImpl clientIn = null;
        final String username = "Ardy";

        // Run the test
        MyProfile.initialize(userIn, clientIn, username);

        // Verify the results
    }
}
