package universitymanagementsystem;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;

public class AddStudent extends JFrame implements ActionListener{
	private JTextField fnametextField;
	private JTextField lnametextField;
	private JTextField dobtextField;
	private JTextField emailtextField;
	private JTextField mobiletextField;
	private JTextField enrollDatetextField;
	private JTextField didtextField;
	private JTextField cidtextField;
	private JTextField adresstextField;
	private JComboBox<String> comboBox,comboBox_1;
	private JButton enrollButton,resetButton,cancelButton;
	public AddStudent() {
		setTitle("Student Enrollment");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ENROLL STUDENT");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(243, 36, 256, 37);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Student First Name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(45, 96, 244, 31);
		getContentPane().add(lblNewLabel_1);
		
		fnametextField = new JTextField();
		fnametextField.setBounds(45, 137, 256, 31);
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
		
		JLabel lblNewLabel_2 = new JLabel("Enter Student Last Name :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(45, 178, 244, 31);
		getContentPane().add(lblNewLabel_2);
		
		lnametextField = new JTextField();
		lnametextField.setBounds(45, 219, 256, 31);
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
		
		JLabel lblNewLabel_3 = new JLabel("Enter Date Of Birth :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(45, 260, 244, 31);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("(YYYY-MM-DD)");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(45, 301, 244, 31);
		getContentPane().add(lblNewLabel_4);
		
		dobtextField = new JTextField();
		dobtextField.setBounds(45, 342, 256, 31);
		getContentPane().add(dobtextField);
		dobtextField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Enter Student Email :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(45, 383, 244, 31);
		getContentPane().add(lblNewLabel_5);
		
		emailtextField = new JTextField();
		emailtextField.setBounds(45, 424, 256, 31);
		getContentPane().add(emailtextField);
		emailtextField.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Enter Student Mobile :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(45, 465, 244, 31);
		getContentPane().add(lblNewLabel_6);
		
		mobiletextField = new JTextField();
		mobiletextField.setBounds(45, 506, 256, 31);
		getContentPane().add(mobiletextField);
		mobiletextField.setColumns(10);
		mobiletextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Allow only digits (0-9)
                if (!Character.isDigit(c)) {
                    e.consume(); // Ignore the event (do not allow the character)
                }
            }
        });
		
		JLabel lblNewLabel_7 = new JLabel("Enter Student Address :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(45, 547, 244, 31);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Enter Enrollment Date :");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(45, 629, 256, 31);
		getContentPane().add(lblNewLabel_8);
		
		enrollDatetextField = new JTextField();
		enrollDatetextField.setBounds(45, 670, 256, 31);
		getContentPane().add(enrollDatetextField);
		enrollDatetextField.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Select Department :");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(372, 96, 244, 31);
		getContentPane().add(lblNewLabel_9);
		
		comboBox = new JComboBox<>();
		comboBox.setBounds(372, 137, 256, 31);
		comboBox.addActionListener(this);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel_10 = new JLabel("Department ID :");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_10.setBounds(372, 178, 244, 31);
		getContentPane().add(lblNewLabel_10);
		
		didtextField = new JTextField();
		didtextField.setBounds(372, 219, 256, 31);
		getContentPane().add(didtextField);
		didtextField.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Select Course :");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_11.setBounds(372, 260, 244, 31);
		getContentPane().add(lblNewLabel_11);
		
		comboBox_1 = new JComboBox<>();
		comboBox_1.setBounds(372, 301, 256, 31);
		comboBox_1.addActionListener(this);
		getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_12 = new JLabel("Course ID :");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_12.setBounds(372, 342, 256, 31);
		getContentPane().add(lblNewLabel_12);
		
		cidtextField = new JTextField();
		cidtextField.setBounds(372, 383, 256, 31);
		getContentPane().add(cidtextField);
		cidtextField.setColumns(10);
		
		enrollButton = new JButton("Enroll");
		enrollButton.setBackground(Color.GREEN);
		enrollButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		enrollButton.setBounds(372, 434, 101, 49);
		enrollButton.addActionListener(this);
		getContentPane().add(enrollButton);
		
		resetButton = new JButton("Reset");
		resetButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resetButton.setBounds(372, 511, 101, 49);
		resetButton.addActionListener(this);
		getContentPane().add(resetButton);
		
		cancelButton = new JButton("Exit");
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setBackground(Color.RED);
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cancelButton.setBounds(372, 590, 101, 49);
		cancelButton.addActionListener(this);
		getContentPane().add(cancelButton);
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/universitymanagementsystem/icons/stud1.png"));
		Image i2 = i1.getImage().getScaledInstance(454,605,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(680, 96, 454, 605);
		getContentPane().add(image);
		
		adresstextField = new JTextField();
		adresstextField.setBounds(45, 588, 256, 31);
		getContentPane().add(adresstextField);
		adresstextField.setColumns(10);
		
		comboBox.addItem("null");
		comboBox_1.addItem("null");
		
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
		
		try {
			Conn con = new Conn();
			ResultSet rs1 = con.s.executeQuery("select course_name from course");
			
			while(rs1.next()) {
			String item = rs1.getString("course_name");
			comboBox_1.addItem(item);
		}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		setLocation(200,50);
		setSize(1195,764);
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
		}else if(ae.getSource()==comboBox_1) {
			String cname = (String)comboBox_1.getSelectedItem();
			try {
				Conn con = new Conn();
				ResultSet rs = con.s.executeQuery("select course_id from course where course_name = '"+cname+"'");
				
				if(rs.next()) {
					cidtextField.setText(""+rs.getInt("course_id"));
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()==enrollButton) {
			if(fnametextField.getText().equals("")||lnametextField.getText().equals("")||dobtextField.getText().equals("")||emailtextField.getText().equals("")||mobiletextField.getText().equals("")||enrollDatetextField.getText().equals("")||adresstextField.getText().equals("")||didtextField.getText().equals("")||cidtextField.getText().equals("")||comboBox.getSelectedItem().equals("null")||comboBox_1.getSelectedItem().equals("")) {
				JOptionPane.showMessageDialog(null,"ENTER VALUES OF ALL FIELDS !!!!");
			}else {
				try {
					Conn con = new Conn();
					int ans = con.s.executeUpdate("insert into student (first_name,last_name,dob,email,mobile,address,depart_id) values ('"+fnametextField.getText()+"','"+lnametextField.getText()+"','"+dobtextField.getText()+"','"+emailtextField.getText()+"','"+mobiletextField.getText()+"','"+adresstextField.getText()+"','"+didtextField.getText()+"')");
					ResultSet rs = con.s.executeQuery("select stud_id from student where first_name = '"+fnametextField.getText()+"' and last_name = '"+lnametextField.getText()+"' ");
				
					int sid=0;
					if(rs.next()) {
						sid = rs.getInt("stud_id");
					}
					int cid = Integer.parseInt((String)cidtextField.getText());
					int ans1 = con.s.executeUpdate("insert into enrollment (stud_id,course_id,enroll_date) values ("+sid+","+cid+",'"+enrollDatetextField.getText()+"')");
					rs=con.s.executeQuery("select enroll_id from enrollment where stud_id = "+sid+" ");
					
					if(rs.next()) {
						JOptionPane.showMessageDialog(null,"Student ID : "+sid+" Enrollment ID : "+rs.getInt("enroll_id")+" Student Name : "+fnametextField.getText()+" "+lnametextField.getText());
					}
					
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}else if(ae.getSource()==resetButton) {
			fnametextField.setText(null);
			lnametextField.setText(null);
			dobtextField.setText(null);
			emailtextField.setText(null);
			mobiletextField.setText(null);
			enrollDatetextField.setText(null);
			adresstextField.setText(null);
			comboBox.setSelectedItem("null");
			comboBox_1.setSelectedItem("null");
			didtextField.setText(null);
			cidtextField.setText(null);
		}else if(ae.getSource()==cancelButton) {
			setVisible(false);
		}
	}
}
