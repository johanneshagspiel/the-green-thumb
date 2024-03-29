package GUI_mainscreen;

import entity.User;

import org.junit.Test;

import gui.mainscreen.AddFriend;
import service.UserServiceImpl;

import javax.swing.*;

/**
 * The type Add friend test.
 */
public class AddFriendTest {

    /**
     * Test application.
     */
    @Test
    public void testApplication() {
        // Setup
        final User userIn = null;
        final UserServiceImpl clientIn = null;
        final JFrame frameIn = null;
        final JLabel imgAchievement = null;

        // Run the test
        AddFriend.application(userIn, clientIn, frameIn, imgAchievement);

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
        final JFrame frameIn = null;
        final JLabel imgAchievement = null;

        // Run the test
        AddFriend.initialize(userIn, clientIn, frameIn, imgAchievement);

        // Verify the results
    }
}
