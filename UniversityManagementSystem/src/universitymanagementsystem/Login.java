package universitymanagementsystem;
import javax.swing.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
	private JTextField usrTxtField;
	private JPasswordField passwordField;
	JButton loginButton,resetButton,cancelButton,changeButton;
	private JLabel lblNewLabel_3;
	private JButton signInButton;
	public Login() {
		setTitle("Login");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter User Name :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(40, 156, 228, 39);
		getContentPane().add(lblNewLabel);
		
		usrTxtField = new JTextField();
		usrTxtField.setBounds(40, 221, 228, 39);
		getContentPane().add(usrTxtField);
		usrTxtField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Password :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(40, 311, 228, 39);
		getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(40, 375, 228, 39);
		getContentPane().add(passwordField);
		
		loginButton = new JButton("Login");
		loginButton.setBackground(Color.GREEN);
		loginButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loginButton.setBounds(40, 486, 109, 39);
		loginButton.addActionListener(this);
		getContentPane().add(loginButton);
		
		resetButton = new JButton("Reset");
		resetButton.setBackground(Color.LIGHT_GRAY);
		resetButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resetButton.setBounds(193, 486, 109, 39);
		resetButton.addActionListener(this);
		getContentPane().add(resetButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setBackground(Color.RED);
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cancelButton.setBounds(355, 486, 109, 39);
		cancelButton.addActionListener(this);
		getContentPane().add(cancelButton);
		
		JLabel lblNewLabel_2 = new JLabel("ADMIN LOGIN");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setBounds(256, 45, 331, 63);
		getContentPane().add(lblNewLabel_2);
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/universitymanagementsystem/icons/login.png"));
		Image i2 = i1.getImage().getScaledInstance(399, 258,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(315, 156, 399, 258);
		getContentPane().add(image);
		
		lblNewLabel_3 = new JLabel("Dont have an Account ? No problem SignIn here ");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setBounds(40, 560, 300, 20);
		getContentPane().add(lblNewLabel_3);
		
		signInButton = new JButton("Sign In");
		signInButton.setBackground(Color.YELLOW);
		signInButton.setBounds(40, 590, 109, 39);
		signInButton.addActionListener(this);
		getContentPane().add(signInButton);
		
		changeButton = new JButton("Change");
		changeButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		changeButton.setBackground(Color.CYAN);
		changeButton.setBounds(515, 488, 109, 39);
		changeButton.addActionListener(this);
		getContentPane().add(changeButton);
		
		setLocation(400,70);
		setSize(770,700);
		setVisible(true);
		
//		while(true) {
//			lblNewLabel_2.setForeground(Color.RED);
//			lblNewLabel_2.setVisible(false);
//			try {
//				Thread.sleep(250);
//			}catch(Exception e) {
//				System.out.println(e);
//			}
//			lblNewLabel_2.setVisible(true);
//			lblNewLabel_2.setForeground(Color.BLUE);
//			try {
//				Thread.sleep(250);
//			}catch(Exception e) {
//				System.out.println(e);
//			}
//		}
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==loginButton) {
			if(usrTxtField.getText().equals("")||passwordField.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "ENTER VALUE OF ALL FIELDS !!!!");
			}else {
				if(passwordField.getText().length()>20) {
					JOptionPane.showMessageDialog(null, "INVALID PASSWORD !!!!");
				}else {
					try {
						Conn con = new Conn();
						ResultSet rs = con.s.executeQuery("select * from admin where username='"+usrTxtField.getText()+"' and passwrd='"+passwordField.getText()+"'");
						
						if(rs.next()) {
							setVisible(false);
							new DashBoard();
						}else {
							JOptionPane.showMessageDialog(null, "INVALID USERNAME OR PASSWORD !!!!");
						}
						
					}catch(Exception e) {
						System.out.println(e);
					}
				}
			}
		}else if(ae.getSource()==resetButton) {
			usrTxtField.setText(null);
			passwordField.setText(null);
		}else if(ae.getSource()==cancelButton) {
			try {
				Conn con = new Conn();
				con.c.close();
				setVisible(false);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()==signInButton) {
			setVisible(false);
			new Signin();
		}else if(ae.getSource()==changeButton) {
			setVisible(false);
			new ForgotPassword();
		}
	}
}
