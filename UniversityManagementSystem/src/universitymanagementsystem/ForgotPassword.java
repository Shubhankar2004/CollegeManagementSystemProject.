package universitymanagementsystem;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.PasswordAuthentication;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ForgotPassword extends JFrame implements ActionListener{
	private JTextField userTextField;
	private JTextField mobileTextField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JButton changeNewButton,resetNewButton,cancelNewButton;
	
	public ForgotPassword() {
		setTitle("Change Password");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel userLabel = new JLabel("Enter User Name :");
		userLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		userLabel.setBounds(61, 113, 168, 47);
		getContentPane().add(userLabel);
		
		userTextField = new JTextField();
		userTextField.setBounds(61, 170, 241, 47);
		getContentPane().add(userTextField);
		userTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Mobile Number :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(61, 227, 215, 47);
		getContentPane().add(lblNewLabel);
		
		mobileTextField = new JTextField();
		mobileTextField.setBounds(61, 284, 241, 47);
		getContentPane().add(mobileTextField);
		mobileTextField.setColumns(10);
		mobileTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Allow only digits (0-9)
                if (!Character.isDigit(c)) {
                    e.consume(); // Ignore the event (do not allow the character)
                }
            }
        });
		
		JLabel lblNewLabel_1 = new JLabel("Enter New Password :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(61, 341, 215, 47);
		getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(61, 398, 241, 47);
		getContentPane().add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("Confirm New Password :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(61, 455, 241, 47);
		getContentPane().add(lblNewLabel_2);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(61, 512, 241, 47);
		getContentPane().add(passwordField_1);
		
		changeNewButton = new JButton("Change");
		changeNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		changeNewButton.setBackground(Color.GREEN);
		changeNewButton.setBounds(61, 592, 110, 39);
		changeNewButton.addActionListener(this);
		getContentPane().add(changeNewButton);
		
		resetNewButton = new JButton("Reset");
		resetNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resetNewButton.setBackground(Color.LIGHT_GRAY);
		resetNewButton.setBounds(234, 592, 110, 39);
		resetNewButton.addActionListener(this);
		getContentPane().add(resetNewButton);
		
		cancelNewButton = new JButton("Exit");
		cancelNewButton.setBackground(Color.RED);
		cancelNewButton.setForeground(Color.WHITE);
		cancelNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cancelNewButton.setBounds(414, 594, 110, 39);
		cancelNewButton.addActionListener(this);
		getContentPane().add(cancelNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("CHANGE PASSWORD");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(222, 37, 312, 47);
		getContentPane().add(lblNewLabel_3);
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/universitymanagementsystem/icons/forgotpass.png"));
		Image i2 = i1.getImage().getScaledInstance(359, 446, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(350, 113, 359, 446);
		getContentPane().add(image);
		
		setLocation(400,70);
		setSize(770,700);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==changeNewButton) {
			if(userTextField.getText().equals("")||mobileTextField.getText().equals("")||passwordField.getText().equals("")||passwordField_1.getText().equals("")) {
				JOptionPane.showInternalMessageDialog(null,"ENTER VALUES FOR ALL FIELDS !!!!");
			}else {
				if(mobileTextField.getText().length()!=10) {
					JOptionPane.showMessageDialog(null, "INVALID PHONE NUMBER !!!!");
				}else {
					if(passwordField.getText().length()>20) {
						JOptionPane.showMessageDialog(null, "PASSWORD LENGTH SHOULD NOT EXCEED 20 !!!!");
					}else {
						if(passwordField.getText().equals(passwordField_1.getText())) {
							try {
								Conn con = new Conn();
								con.s.executeUpdate("update admin set passwrd='"+passwordField.getText()+"' where username='"+userTextField.getText()+"' and mobile='"+mobileTextField.getText()+"'");
								
								JOptionPane.showMessageDialog(null,"Pass word changed successfully !!!!");
								setVisible(false);
								new Login();
								
							}catch(Exception e){
								System.out.println(e);
							}
						}else {
							JOptionPane.showMessageDialog(null, "PASSWORD MISMATCH !!!!");
						}
					}
				}
			}
		}else if(ae.getSource()==resetNewButton) {
			userTextField.setText(null);
			mobileTextField.setText(null);
			passwordField.setText(null);
			passwordField_1.setText(null);
		}else if(ae.getSource()==cancelNewButton) {
			setVisible(false);
			new Login();
		}
	}
}
