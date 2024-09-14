package universitymanagementsystem;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.DecimalFormat;

public class AddCourse extends JFrame implements ActionListener{
	private JTextField courseNametextField;
	private JTextField credittextField;
	private JTextField didtextField;
	private JTextField feetextField;
	private JComboBox<String> comboBox;
	private JButton addButton,resetButton,cancelButton;
	
	public AddCourse() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("Add Course");
		
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD COURSE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(276, 63, 190, 37);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Course Name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(53, 156, 203, 31);
		getContentPane().add(lblNewLabel_1);
		
		courseNametextField = new JTextField();
		courseNametextField.setBounds(53, 197, 213, 37);
		getContentPane().add(courseNametextField);
		courseNametextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Course Credits :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(53, 244, 203, 31);
		getContentPane().add(lblNewLabel_2);
		
		credittextField = new JTextField();
		credittextField.setBounds(53, 285, 213, 37);
		getContentPane().add(credittextField);
		credittextField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Select Department :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(53, 332, 203, 31);
		getContentPane().add(lblNewLabel_3);
		
		comboBox = new JComboBox<>();
		comboBox.setBounds(53, 373, 213, 31);
		comboBox.addActionListener(this);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Department ID :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(53, 414, 203, 31);
		getContentPane().add(lblNewLabel_4);
		
		didtextField = new JTextField();
		didtextField.setBounds(53, 455, 213, 37);
		getContentPane().add(didtextField);
		didtextField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Fee :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(53, 502, 203, 31);
		getContentPane().add(lblNewLabel_5);
		
		feetextField = new JTextField();
		feetextField.setBounds(53, 543, 213, 37);
		getContentPane().add(feetextField);
		feetextField.setColumns(10);
		
		addButton = new JButton("Add");
		addButton.setBackground(Color.GREEN);
		addButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addButton.setBounds(53, 624, 116, 49);
		addButton.addActionListener(this);
		getContentPane().add(addButton);
		
		resetButton = new JButton("Reset");
		resetButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resetButton.setBounds(218, 624, 116, 49);
		resetButton.addActionListener(this);
		getContentPane().add(resetButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setBackground(Color.RED);
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cancelButton.setBounds(382, 624, 116, 49);
		cancelButton.addActionListener(this);
		getContentPane().add(cancelButton);
		
		comboBox.addItem("null");
		
		try {
			Conn con = new Conn();
			ResultSet rs = con.s.executeQuery("select depart_name from department");
			
			while(rs.next()) {
				String item = rs.getString("depart_name");
				comboBox.addItem(item);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/universitymanagementsystem/icons/course.png"));
		Image i2 = i1.getImage().getScaledInstance(406,431,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(322, 149, 406, 431);
		getContentPane().add(image);
		
		setLocation(400,50);
		setSize(806,764);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==comboBox) {
			//JOptionPane.showMessageDialog(null,comboBox.getSelectedItem());
			String dname = (String)comboBox.getSelectedItem();
			try {
				Conn con = new Conn();
				ResultSet rs = con.s.executeQuery("select depart_id from department where depart_name = '"+dname+"'");
				
				if(rs.next()) {
					didtextField.setText(""+rs.getInt("depart_id"));
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()==addButton) {
			if(courseNametextField.getText().equals("")||credittextField.getText().equals("")||comboBox.getSelectedItem().equals("null")||feetextField.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"ENTER VALUES OF ALL FIELDS !!!!");
			}else {
				try {
					Conn con = new Conn();
					int ans = con.s.executeUpdate("insert into course (course_name,credits,depart_id,fee) values ('"+courseNametextField.getText()+"',"+Integer.parseInt(credittextField.getText())+","+Integer.parseInt(didtextField.getText())+","+Float.parseFloat(feetextField.getText())+")");
					ResultSet rs = con.s.executeQuery("select * from course where course_name = '"+courseNametextField.getText()+"' ");
					
					if(rs.next()) {
						JOptionPane.showMessageDialog(null,"ID : "+rs.getInt("course_id")+" Name : "+courseNametextField.getText());
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}else if(ae.getSource()==resetButton) {
			courseNametextField.setText(null);
			credittextField.setText(null);
			comboBox.setSelectedItem("null");
			didtextField.setText(null);
			feetextField.setText(null);
		}else if(ae.getSource()==cancelButton) {
			setVisible(false);
			//new DashBoard();
		}
	}
}
