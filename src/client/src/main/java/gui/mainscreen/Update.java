package gui.mainscreen;

import gui.GUI_App;
import entity.Friend;
import entity.User;
import service.FriendServiceImpl;
import service.UserServiceImpl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

/**
 * The type My profile.
 */
public class Update {
/** Initialise frame. */
    private static JFrame frame;
    /** Initialise text entry 1. */
    private static JTextField txtentry1;
    /** Initialise text entry 2. */
    private static JTextField txtentry2;
    /** Initialise the label. */
    private static String label;

    /**
     * Update.
     * @param userIn the user in
     * @param clientIn the client in
     * @param stringIn the string in
     * @param clientFriend the clientFriend
     * @param frameIn the frame in
     */
    private Update(
            final User userIn,
            final UserServiceImpl clientIn,
            final String stringIn,
            final FriendServiceImpl clientFriend,
            final JFrame frameIn) {
        initialize(userIn, clientIn, stringIn, clientFriend, frameIn);
    }

    /**
     * Application.
     * @param userIn the user in
     * @param clientIn the client in
     * @param stringIn the string in
     * @param clientFriend the client friend
     * @param frameIn the frame in
     */
    public static void application(
            final User userIn,
            final UserServiceImpl clientIn,
            final String stringIn,
            final FriendServiceImpl clientFriend,
            final JFrame frameIn) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Update window = new Update(userIn, clientIn,
                            stringIn, clientFriend, frameIn);
                    Update.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Initialize.
     * @param userIn the user in
     * @param clientIn the client in
     * @param stringIn the string in
     * @param clientFriend the client friend
     * @param frameIn the frame in
     */
    public static void initialize(
            final User userIn,
            final UserServiceImpl clientIn,
            final String stringIn,
            final FriendServiceImpl clientFriend,
            final JFrame frameIn) {
        final int twosixsix = 266;
        final int fivezerozero = 500;
        final int twofivefive = 255;
        final int onetwoseven = 127;
        final int threezerozero = 300;
        final int onezero = 10;
        final int twozero = 20;
        final int threezero = 30;
        final int onesevenfive = 175;
        final int onefive = 15;
        final int oneonezero = 110;
        final int threezerosix = 306;
        final int twosixtwo = 262;
        final int fourtwo = 42;
        final int sixseven = 67;
        final int onethreetwo = 132;
        final int onethree = 13;



        frame = new JFrame();
        frame.getContentPane().setBackground(SystemColor.
                inactiveCaptionBorder);
        frame.setBounds(threezerozero, fivezerozero, threezerosix, twosixtwo);
        frame.getContentPane().setLayout(null);
        frame.setFocusable(true);

        if (stringIn == userIn.getUser_name()) {
            label = "user name";
        } else if (stringIn == userIn.getPassword()) {
            label = "password";
        }

        // Labels
        JLabel lblWelcome = new JLabel("Change your " + label);
        lblWelcome.setFont(new Font("Arial Black", Font.PLAIN, onefive));
        lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
        lblWelcome.setBounds(onezero, onezero, twosixsix, twozero);
        frame.getContentPane().add(lblWelcome);

        JLabel changeUserName = new JLabel("New " + label);
        changeUserName.setHorizontalAlignment(SwingConstants.CENTER);
        changeUserName.setBounds(onezero, fourtwo, twosixsix, twozero);
        frame.getContentPane().add(changeUserName);

        JLabel changePassword
                = new JLabel("Please repeat your new " + label);
        changePassword.setHorizontalAlignment(SwingConstants.CENTER);
        changePassword.setBounds(onezero, oneonezero, twosixsix, twozero);
        frame.getContentPane().add(changePassword);

        txtentry1 = new JTextField();
        txtentry1.setBounds(onezero, sixseven, twosixsix, threezero);
        frame.getContentPane().add(txtentry1);

        txtentry2 = new JTextField();
        txtentry2.setBounds(onezero, onethreetwo, twosixsix, threezero);
        frame.getContentPane().add(txtentry2);

        JButton updateYourAccount = new JButton("Update your account");
        updateYourAccount.setForeground(Color.WHITE);
        updateYourAccount.setFont(new Font("Arial Black",
                Font.PLAIN, onethree));
        updateYourAccount.setBackground(new Color(0, twofivefive,
                onetwoseven));
        updateYourAccount.setHorizontalAlignment(SwingConstants.CENTER);
        updateYourAccount.setBounds(onezero, onesevenfive,
                twosixsix, threezero);
        frame.getContentPane().add(updateYourAccount);
        updateYourAccount.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent arg0) {
                String entry1 = txtentry1.getText();
                String entry2 = txtentry2.getText();

                if (label == "user name") {

                    System.out.println(entry1 + entry2);

                    try {
                            if (entry1.equals(entry2)) {

                                User userTest
                                        = clientIn.getUser2(entry1);

                                if (userTest == null) {
                                //Makes the Login_s frame empty,
                                    // starts the GUI_App frame
                                    // and returns true
                                    // (for testing purpose)

                                txtentry1.setText(null);
                                txtentry2.setText(null);
                                frame.setVisible(false);

                                String oldUserName
                                        = userIn.getUser_name();


                                    // update the user
                                    userIn.setUser_name(entry1);
                                    clientIn.updateUser(userIn);
                                    System.out.println(userIn.getId());


                                    // update friends
                                    System.out.println(oldUserName);
                                    FriendServiceImpl test
                                            = new FriendServiceImpl();
                                    List<Friend> friends
                                            = test.getFriends(oldUserName);

                                    for (int i = 0; i < friends.size(); i++) {
                                        Friend temp = friends.get(i);
                                        test.deleteUser(temp.getId());
                                        temp.setUser_name_entry(entry1);
                                        test.createFriend(temp);
                                    }

                                    // load new screen
                                    frameIn.setVisible(false);
                                    GUI_App.application(entry1,
                                            userIn, clientIn);

                                } else {
                                    //Username password is not in the file
                                    JOptionPane.showMessageDialog(null,
                                            "Username already taken",
                                            "Update Account Error",
                                            JOptionPane.ERROR_MESSAGE);
                                    txtentry1.setText(null);
                                    txtentry2.setText(null);

                            }
                        } else {
                                //Username password is not in the file
                                JOptionPane.showMessageDialog(null,
                                        "Both username entries"
                                              +  " have to be equal",
                                        "Update Account Error",
                                        JOptionPane.ERROR_MESSAGE);
                                txtentry1.setText(null);
                                txtentry2.setText(null);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null,
                                "There was an error when trying"
                                       + " to read the logindetails "
                                        + "database file",
                                "Read file error",
                                JOptionPane.ERROR_MESSAGE);
                        e.printStackTrace();
                    }
                } else if (label == "password") {
                    try {
                        if (entry1.equals(entry2)) {

                            if (userIn.getPassword().equals(entry1)) {
                                //Password is equal to the old one
                                JOptionPane.showMessageDialog(null,
                                        "Your new password can"
                                              +  " not be equal to the old one",
                                        "Update Account Error",
                                        JOptionPane.ERROR_MESSAGE);
                                txtentry1.setText(null);
                                txtentry2.setText(null);
                            } else {
                                // tests if the new password is
                                // not equal to the old one
                                userIn.setPassword(entry1);
                                txtentry1.setText(null);
                                txtentry2.setText(null);
                                frame.setVisible(false);
                                clientIn.updateUser(userIn);
                                System.out.println(userIn.getId());

                            }
                        } else {
                            //Username password is not in the file
                            JOptionPane.showMessageDialog(null,
                                    "Both password entries have to be equal",
                                    "Update Account Error",
                                    JOptionPane.ERROR_MESSAGE);
                            txtentry1.setText(null);
                            txtentry2.setText(null);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null,
                                "There was an error when trying to"
                                      +  " read the logindetails database file",
                                "Read file error",
                                JOptionPane.ERROR_MESSAGE);
                        e.printStackTrace();
                    }
                } else {
                    System.out.println(label);
                }
            }
        });
    }
}
