package universitymanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UpdateStudent extends JFrame implements ActionListener {
	private JTextField fnametextField;
	private JTextField lnametextField;
	private JTextField dobtextField;
	private JTextField emailtextField;
	private JTextField mobtextField;
	private JTextField addresstextField;
	private JButton updtfnmButton,updtlnmButton,dobButton,emailButton,mobButton,addressButton,resetButton,cancelButton;
	private JComboBox<String>comboBox;
	
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
		
		JLabel lblNewLabel_3 = new JLabel("Student Last Name :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(27, 318, 244, 37);
		getContentPane().add(lblNewLabel_3);
		
		lnametextField = new JTextField();
		lnametextField.setBounds(27, 365, 256, 37);
		getContentPane().add(lnametextField);
		lnametextField.setColumns(10);
		
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
		
		updtfnmButton = new JButton("Update");
		updtfnmButton.setBackground(Color.GREEN);
		updtfnmButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		updtfnmButton.setBounds(309, 271, 85, 37);
		updtfnmButton.addActionListener(this);
		getContentPane().add(updtfnmButton);
		
		updtlnmButton = new JButton("Update");
		updtlnmButton.setBackground(Color.GREEN);
		updtlnmButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		updtlnmButton.setBounds(309, 365, 85, 37);
		updtlnmButton.addActionListener(this);
		getContentPane().add(updtlnmButton);
		
		dobButton = new JButton("Update");
		dobButton.setBackground(Color.GREEN);
		dobButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dobButton.setBounds(309, 457, 85, 37);
		dobButton.addActionListener(this);
		getContentPane().add(dobButton);
		
		emailButton = new JButton("Update");
		emailButton.setBackground(Color.GREEN);
		emailButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		emailButton.setBounds(309, 551, 85, 37);
		emailButton.addActionListener(this);
		getContentPane().add(emailButton);
		
		JLabel lblNewLabel_7 = new JLabel("Student Mobile :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(27, 600, 244, 37);
		getContentPane().add(lblNewLabel_7);
		
		mobtextField = new JTextField();
		mobtextField.setBounds(27, 647, 256, 37);
		getContentPane().add(mobtextField);
		mobtextField.setColumns(10);
		
		mobButton = new JButton("Update");
		mobButton.setBackground(Color.GREEN);
		mobButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mobButton.setBounds(309, 645, 85, 37);
		mobButton.addActionListener(this);
		getContentPane().add(mobButton);
		
		JLabel lblNewLabel_8 = new JLabel("Student Address :");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(404, 130, 244, 37);
		getContentPane().add(lblNewLabel_8);
		
		addresstextField = new JTextField();
		addresstextField.setBounds(404, 177, 256, 37);
		getContentPane().add(addresstextField);
		addresstextField.setColumns(10);
		
		addressButton = new JButton("Update");
		addressButton.setBackground(Color.GREEN);
		addressButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addressButton.setBounds(680, 177, 85, 37);
		addressButton.addActionListener(this);
		getContentPane().add(addressButton);
		
		resetButton = new JButton("Reset");
		resetButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resetButton.setBounds(404, 224, 101, 49);
		resetButton.addActionListener(this);
		getContentPane().add(resetButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setBackground(Color.RED);
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cancelButton.setBounds(530, 224, 101, 49);
		cancelButton.addActionListener(this);
		getContentPane().add(cancelButton);
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/universitymanagementsystem/icons/stud2.png"));
		Image i2 = i1.getImage().getScaledInstance(378,401,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(404, 283, 378, 401);
		getContentPane().add(image);
		
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
		}else if(ae.getSource()==updtfnmButton) {
			try {
				con.s.executeUpdate("update student set first_name = '"+fnametextField.getText()+"' where stud_id = "+sid+"  ");
			
				JOptionPane.showMessageDialog(null,"Updation Successful !!!!");
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()==updtlnmButton) {
			try {
				con.s.executeUpdate("update student set last_name = '"+lnametextField.getText()+"' where stud_id = "+sid+"  ");
			
				JOptionPane.showMessageDialog(null,"Updation Successful !!!!");
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()==dobButton) {
			try {
				con.s.executeUpdate("update student set dob = '"+dobtextField.getText()+"' where stud_id = "+sid+"  ");
			
				JOptionPane.showMessageDialog(null,"Updation Successful !!!!");
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()==emailButton) {
			try {
				con.s.executeUpdate("update student set email = '"+emailtextField.getText()+"' where stud_id = "+sid+"  ");
			
				JOptionPane.showMessageDialog(null,"Updation Successful !!!!");
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()==mobButton) {
			try {
				con.s.executeUpdate("update student set mobile = '"+mobtextField.getText()+"' where stud_id = "+sid+"  ");
			
				JOptionPane.showMessageDialog(null,"Updation Successful !!!!");
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()==addressButton) {
			try {
				con.s.executeUpdate("update student set address = '"+addresstextField.getText()+"' where stud_id = "+sid+"  ");
			
				JOptionPane.showMessageDialog(null,"Updation Successful !!!!");
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
