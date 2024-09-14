package universitymanagementsystem;
import javax.swing.*;
import java.awt.*;
public class Splash extends JFrame implements Runnable{

	Thread t;
	public Splash() {
		setTitle("College Management System");
			
		ImageIcon i1 = new ImageIcon(getClass().getResource("/universitymanagementsystem/icons/logo.png"));
		Image i2 = i1.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		getContentPane().add(image);
		
		t=new Thread(this);
		t.start();
		
		setLocation(400,70);
		setSize(700,700);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Splash();
	}

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
			setVisible(false);
			new Login();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
