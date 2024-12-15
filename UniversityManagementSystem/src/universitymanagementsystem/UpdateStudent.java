package universitymanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;

public class UpdateStudent extends JFrame implements ActionListener {
	private JTextField fnametextField;
	private JTextField lnametextField;
	private JTextField dobtextField;
	private JTextField emailtextField;
	private JTextField mobtextField;
	private JTextField addresstextField;
	private JButton resetButton,cancelButton;
	private JComboBox<String>comboBox;
	private JButton updateButton;
	
	public UpdateStudent() {
		setTitle("Update Student");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UPDATE STUDENT");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(255, 52, 259, 37);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Select Student ID :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(27, 130, 244, 37);
		getContentPane().add(lblNewLabel_1);
		
		comboBox = new JComboBox<>();
		comboBox.setBounds(27, 177, 256, 37);
		comboBox.addActionListener(this);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Student First Name :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(27, 224, 244, 37);
		getContentPane().add(lblNewLabel_2);
		
		fnametextField = new JTextField();
		fnametextField.setBounds(27, 271, 256, 37);
		getContentPane().add(fnametextField);
		fnametextField.setColumns(10);
		fnametextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Allow only alphabetic characters (A-Z, a-z) and spaces
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                    e.consume(); // Ignore the event (do not allow the character)
                }
            }
        });
		
		JLabel lblNewLabel_3 = new JLabel("Student Last Name :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(27, 318, 244, 37);
		getContentPane().add(lblNewLabel_3);
		
		lnametextField = new JTextField();
		lnametextField.setBounds(27, 365, 256, 37);
		getContentPane().add(lnametextField);
		lnametextField.setColumns(10);
		lnametextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Allow only alphabetic characters (A-Z, a-z) and spaces
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                    e.consume(); // Ignore the event (do not allow the character)
                }
            }
        });
		
		JLabel lblNewLabel_4 = new JLabel("Date Of Birth(YYYY-MM-DD):");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(27, 412, 268, 37);
		getContentPane().add(lblNewLabel_4);
		
		dobtextField = new JTextField();
		dobtextField.setBounds(27, 459, 256, 37);
		getContentPane().add(dobtextField);
		dobtextField.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Student Email :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(27, 506, 244, 37);
		getContentPane().add(lblNewLabel_6);
		
		emailtextField = new JTextField();
		emailtextField.setBounds(27, 553, 256, 37);
		getContentPane().add(emailtextField);
		emailtextField.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Student Mobile :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(27, 600, 244, 37);
		getContentPane().add(lblNewLabel_7);
		
		mobtextField = new JTextField();
		mobtextField.setBounds(27, 647, 256, 37);
		getContentPane().add(mobtextField);
		mobtextField.setColumns(10);
		mobtextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Allow only digits (0-9)
                if (!Character.isDigit(c)) {
                    e.consume(); // Ignore the event (do not allow the character)
                }
            }
        });
		
		JLabel lblNewLabel_8 = new JLabel("Student Address :");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(404, 130, 244, 37);
		getContentPane().add(lblNewLabel_8);
		
		addresstextField = new JTextField();
		addresstextField.setBounds(404, 177, 256, 37);
		getContentPane().add(addresstextField);
		addresstextField.setColumns(10);
		
		resetButton = new JButton("Reset");
		resetButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resetButton.setBounds(534, 224, 101, 49);
		resetButton.addActionListener(this);
		getContentPane().add(resetButton);
		
		cancelButton = new JButton("Exit");
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setBackground(Color.RED);
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cancelButton.setBounds(664, 224, 101, 49);
		cancelButton.addActionListener(this);
		getContentPane().add(cancelButton);
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/universitymanagementsystem/icons/stud2.png"));
		Image i2 = i1.getImage().getScaledInstance(378,401,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(316, 283, 466, 401);
		getContentPane().add(image);
		
		updateButton = new JButton("Update");
		updateButton.setBackground(Color.GREEN);
		updateButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		updateButton.setBounds(404, 224, 101, 49);
		updateButton.addActionListener(this);
		getContentPane().add(updateButton);
		
		comboBox.addItem("0");
		
		try {
			Conn con = new Conn();
			ResultSet rs = con.s.executeQuery("select stud_id from student");
			
			while(rs.next()) {
				String item = ""+rs.getInt("stud_id");
				comboBox.addItem(item);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		setLocation(400,50);
		setSize(806,764);
		setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		ResultSet rs;
		Conn con = new Conn();
		int sid = Integer.parseInt(""+comboBox.getSelectedItem());
		if(ae.getSource()==comboBox) {
			try {
				rs = con.s.executeQuery("select * from student where stud_id = "+sid+" ");
				
				if(rs.next()) {
					fnametextField.setText(rs.getString("first_name"));
					lnametextField.setText(rs.getString("last_name"));
					dobtextField.setText(rs.getString("dob"));
					emailtextField.setText(rs.getString("email"));
					mobtextField.setText(rs.getString("mobile"));
					addresstextField.setText(rs.getString("address"));
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()==resetButton) {
			comboBox.setSelectedItem("0");
			fnametextField.setText(null);
			lnametextField.setText(null);
			dobtextField.setText(null);
			emailtextField.setText(null);
			mobtextField.setText(null);
			addresstextField.setText(null);
		}else if(ae.getSource()==cancelButton) {
			setVisible(false);
		}else if(ae.getSource()==updateButton) {
			try {
				con.s.executeUpdate("update student set first_name = '"+fnametextField.getText()+"' , last_name = '"+lnametextField.getText()+"' , dob = '"+dobtextField.getText()+"' , email = '"+emailtextField.getText()+"' , mobile = '"+mobtextField.getText()+"' , address = '"+addresstextField.getText()+"' where stud_id = "+sid+"  ");
			
				JOptionPane.showMessageDialog(null,"Updation Successful !!!!");
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
