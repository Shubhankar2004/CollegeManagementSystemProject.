package universitymanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class UpdateCourse extends JFrame implements ActionListener{
	private JTextField cnametextField;
	private JTextField creditstextField;
	private JTextField feetextField;
	private JButton cnameButton,creditsButton,feeButton,resetButton,cancelButton;
	private JComboBox<String>comboBox;

	public UpdateCourse() {
		setTitle("Update Course");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UPDATE COURSE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(267, 53, 254, 37);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Select Course ID :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(40, 136, 244, 37);
		getContentPane().add(lblNewLabel_1);
		
		comboBox = new JComboBox<>();
		comboBox.setBounds(40, 183, 256, 37);
		comboBox.addActionListener(this);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Course Name :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(40, 230, 244, 37);
		getContentPane().add(lblNewLabel_2);
		
		cnametextField = new JTextField();
		cnametextField.setBounds(40, 277, 256, 37);
		getContentPane().add(cnametextField);
		cnametextField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Course Credits :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(40, 324, 244, 37);
		getContentPane().add(lblNewLabel_3);
		
		creditstextField = new JTextField();
		creditstextField.setBounds(40, 371, 256, 37);
		getContentPane().add(creditstextField);
		creditstextField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Course Fee :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(40, 418, 244, 37);
		getContentPane().add(lblNewLabel_4);
		
		feetextField = new JTextField();
		feetextField.setBounds(40, 465, 256, 37);
		getContentPane().add(feetextField);
		feetextField.setColumns(10);
		
		resetButton = new JButton("Reset");
		resetButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resetButton.setBounds(40, 546, 101, 49);
		resetButton.addActionListener(this);
		getContentPane().add(resetButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setBackground(Color.RED);
		cancelButton.setBounds(40, 627, 101, 49);
		cancelButton.addActionListener(this);
		getContentPane().add(cancelButton);
		
		cnameButton = new JButton("Update");
		cnameButton.setBackground(Color.GREEN);
		cnameButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cnameButton.setBounds(331, 277, 85, 37);
		cnameButton.addActionListener(this);
		getContentPane().add(cnameButton);
		
		creditsButton = new JButton("Update");
		creditsButton.setBackground(Color.GREEN);
		creditsButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		creditsButton.setBounds(331, 371, 85, 37);
		creditsButton.addActionListener(this);
		getContentPane().add(creditsButton);
		
		feeButton = new JButton("Update");
		feeButton.setBackground(Color.GREEN);
		feeButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		feeButton.setBounds(331, 465, 85, 37);
		feeButton.addActionListener(this);
		getContentPane().add(feeButton);
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/universitymanagementsystem/icons/course2.png"));
		Image i2 = i1.getImage().getScaledInstance(322,498,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(440, 136, 318, 540);
		getContentPane().add(image);
		
		comboBox.addItem("0");
		
		try {
			Conn con = new Conn();
			ResultSet rs = con.s.executeQuery("select course_id from course");
			
			while(rs.next()) {
				String item = ""+rs.getInt("course_id");
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
		Conn con = new Conn();
		ResultSet rs;
		int cid = Integer.parseInt(""+comboBox.getSelectedItem());
		if(ae.getSource()==comboBox) {
			try {
				rs = con.s.executeQuery("select * from course where course_id = "+cid+" ");
				
				if(rs.next()) {
					cnametextField.setText(rs.getString("course_name"));
					creditstextField.setText(""+rs.getString("credits"));
					feetextField.setText(""+rs.getString("fee"));
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()==resetButton) {
			comboBox.setSelectedItem("0");
			cnametextField.setText(null);
			creditstextField.setText(null);
			feetextField.setText(null);
		}else if(ae.getSource()==cancelButton) {
			setVisible(false);
		}else if(ae.getSource()==cnameButton) {
			try {
				
				con.s.executeUpdate("update course set course_name = '"+cnametextField.getText()+"' where course_id = "+cid+" ");
				
				JOptionPane.showMessageDialog(null,"Updation Successful !!!!");
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()==creditsButton) {
			try {
				
				int credit = Integer.parseInt(creditstextField.getText());
				
				con.s.executeUpdate("update course set credits = "+credit+" where course_id = "+cid+" ");
				
				JOptionPane.showMessageDialog(null,"Updation Successful !!!!");
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()==feeButton) {
			try {
				
				float fee = Float.parseFloat(feetextField.getText());

				con.s.executeUpdate("update course set fee = "+fee+" where course_id = "+cid+" ");
				
				JOptionPane.showMessageDialog(null,"Updation Successful !!!!");
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
