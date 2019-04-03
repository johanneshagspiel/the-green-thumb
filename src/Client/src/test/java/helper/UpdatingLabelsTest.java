package helper;

import static org.junit.Assert.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.junit.Test;

import GUI.GUI_App;
import Login.Login_r;
import entity.User;
import service.UserServiceImpl;

public class UpdatingLabelsTest {

	@Test
	public void testCar() {
		
		// Getting the user
		UserServiceImpl clientIn = new UserServiceImpl();
		User userIn = clientIn.getUser2("Test");
		userIn.setCar(0);
		userIn.setTotal(0);
		userIn.setTotal_saved(0);
		
		// Adding some user information
		final double entry = 1000;
		JLabel lblTotalCO2 = new JLabel("");
		JLabel lblCO2Saved = new JLabel("");
		JLabel lblLeaderboardContent = new JLabel("");
		JLabel lblLevel = new JLabel("");
		JLabel lblMotivation = new JLabel("");
		final int resultTotal = 27100;
		final int resultTotal_saved = 0;
		GUI_App.setLabel("Car Score");
		
		// Updating the label
		UpdatingLabels.updateEverythingTextField(userIn,
				clientIn, entry,
				lblTotalCO2, lblCO2Saved,
				lblLeaderboardContent,
				lblMotivation, lblLevel, "Car");
		
		// Checking the method
		assertEquals(userIn.getTotal(), resultTotal);
		assertEquals(userIn.getTotal_saved(), resultTotal_saved);
		
	}

}
