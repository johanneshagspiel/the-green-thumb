package Login;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class MessageClicker implements Runnable {
	
	public static void main(String[] args) {
	Runnable runnable = new MessageClicker();
	Thread thread = new Thread(runnable);
	thread.start();
	}
	
	//A thread that will automaticly click on messages, making testing easier
	public void run() {
        System.out.println("Blib Blop");
        try {
        	Robot robot = new Robot();
			TimeUnit.MILLISECONDS.sleep(300); //Make this amount higher if some messages still pop up
			robot.keyPress(KeyEvent.VK_ENTER);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
