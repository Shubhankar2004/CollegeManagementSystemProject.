package universitymanagementsystem;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Signin extends JFrame implements ActionListener{
	private JTextField nameField;
	private JTextField mobileField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField userField;
	private JButton signinButton,resetButton,cancelButton;
	
	public Signin() {
		setTitle("Sign Up");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Name :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(44, 99, 204, 42);
		getContentPane().add(lblNewLabel);
		
		nameField = new JTextField();
		nameField.setBounds(44, 151, 234, 41);
		getContentPane().add(nameField);
		nameField.setColumns(10);
		
		nameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Allow only alphabetic characters (A-Z, a-z) and spaces
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                    e.consume(); // Ignore the event (do not allow the character)
                }
            }
        });
		
		JLabel lblNewLabel_1 = new JLabel("Enter Mobile Number :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(42, 305, 217, 42);
		getContentPane().add(lblNewLabel_1);
		
		mobileField = new JTextField();
		mobileField.setBounds(44, 357, 234, 41);
		getContentPane().add(mobileField);
		mobileField.setColumns(10);
		mobileField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Allow only digits (0-9)
                if (!Character.isDigit(c)) {
                    e.consume(); // Ignore the event (do not allow the character)
                }
            }
        });
		
		JLabel lblNewLabel_2 = new JLabel("Enter Password :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(44, 408, 204, 42);
		getContentPane().add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(44, 460, 234, 41);
		getContentPane().add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("Confirm Passoword :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(44, 511, 204, 42);
		getContentPane().add(lblNewLabel_3);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(44, 563, 234, 41);
		getContentPane().add(passwordField_1);
		
		JLabel lblNewLabel_4 = new JLabel("SIGN UP");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setBounds(319, 10, 304, 74);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Enter User Name :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(44, 202, 204, 42);
		getContentPane().add(lblNewLabel_5);
		
		userField = new JTextField();
		userField.setBounds(44, 254, 234, 41);
		getContentPane().add(userField);
		userField.setColumns(10);
		
		signinButton = new JButton("Sign In");
		signinButton.setBackground(Color.GREEN);
		signinButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		signinButton.setBounds(335, 563, 103, 41);
		signinButton.addActionListener(this);
		getContentPane().add(signinButton);
		
		resetButton = new JButton("Reset");
		resetButton.setBackground(Color.LIGHT_GRAY);
		resetButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resetButton.setBounds(475, 563, 103, 41);
		resetButton.addActionListener(this);
		getContentPane().add(resetButton);
		
		cancelButton = new JButton("Exit");
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setBackground(Color.RED);
		cancelButton.setBounds(615, 563, 103, 41);
		cancelButton.addActionListener(this);
		getContentPane().add(cancelButton);
		
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/universitymanagementsystem/icons/signin.png"));
		Image i2 = i1.getImage().getScaledInstance(389,424,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(329, 99, 389, 424);
		getContentPane().add(image);
				
		setLocation(400,70);
		setSize(770,700);
		setVisible(true);
				
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==signinButton) {
			if(nameField.getText().equals("")||userField.getText().equals("")||mobileField.getText().equals("")||passwordField.getText().equals("")||passwordField_1.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"ENTER VALUES OF ALL FIELDS !!!!");
			}else {
				if(mobileField.getText().length()!=10) {
					JOptionPane.showMessageDialog(null,"INVALID MOBILE NUMBER !!!!");
				}else {
					if(passwordField.getText().length()>20) {
						JOptionPane.showMessageDialog(null,"PASSWORD LENGTH SHOULD NOT BE MORE THAN 20 !!!!");
					}else {
						if(passwordField.getText().equals(passwordField_1.getText())) {	
							try {
								Conn con = new Conn();
								con.s.executeUpdate("insert into admin values('"+nameField.getText()+"','"+userField.getText()+"','"+mobileField.getText()+"','"+passwordField.getText()+"')");
								
								JOptionPane.showMessageDialog(null,"SignUp Successfull : UserName : "+userField.getText()+" PassWord : "+passwordField.getText());
								setVisible(false);
								new Login();
							}catch(Exception e) {
								JOptionPane.showMessageDialog(null,"Oops,Something went wrong try again");
								System.out.println(e);
							}
						}else{
							JOptionPane.showMessageDialog(null,"MISMATCH IN PASSWORDS !!!!");
						}
					}
				}
			}
		}else if(ae.getSource()==resetButton) {
			nameField.setText(null);
			userField.setText(null);
			mobileField.setText(null);
			passwordField.setText(null);
			passwordField_1.setText(null);
		}else if(ae.getSource()==cancelButton) {
			setVisible(false);
			new Login();
		}
	}
}
