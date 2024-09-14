package universitymanagementsystem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

public class PayFee extends JFrame implements ActionListener {
	private JTextField studNametextField;
	private JTextField departIdtextField;
	private JTextField departNametextField;
	private JTextField courseIdtextField;
	private JTextField courseNametextField;
	private JTextField courseFeetextField;
	private JTextField amttextField;
	private JTextField dueDatetextField;
	private JTextField paidDatetextField;
	private JComboBox<String> comboBox;
	private JButton payButton,resetButton,cancelButton,updateButton;
	private JRadioButton paidRadioButton,pendingRadioButton;
	private ButtonGroup Feestatus;
	private JLabel lblNewLabel_12;
	private JTextField ramttextField;
	public PayFee() {
		setTitle("Fee Payment");
		getContentPane().setBackground(Color.WHITE);
		
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STUDENT FEE PAYMENT");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(374, 48, 329, 37);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Select Student ID :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(63, 133, 244, 37);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Student Name :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(63, 227, 244, 37);
		getContentPane().add(lblNewLabel_2);
		
		studNametextField = new JTextField();
		studNametextField.setBounds(63, 274, 256, 37);
		getContentPane().add(studNametextField);
		studNametextField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Department ID :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(63, 321, 244, 37);
		getContentPane().add(lblNewLabel_3);
		
		departIdtextField = new JTextField();
		departIdtextField.setBounds(63, 368, 256, 37);
		getContentPane().add(departIdtextField);
		departIdtextField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Department Name :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(63, 415, 244, 37);
		getContentPane().add(lblNewLabel_4);
		
		departNametextField = new JTextField();
		departNametextField.setBounds(63, 462, 244, 37);
		getContentPane().add(departNametextField);
		departNametextField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Course ID :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(63, 509, 244, 37);
		getContentPane().add(lblNewLabel_5);
		
		courseIdtextField = new JTextField();
		courseIdtextField.setBounds(63, 556, 256, 37);
		getContentPane().add(courseIdtextField);
		courseIdtextField.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Course Name :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(63, 603, 244, 37);
		getContentPane().add(lblNewLabel_6);
		
		courseNametextField = new JTextField();
		courseNametextField.setBounds(63, 650, 256, 37);
		getContentPane().add(courseNametextField);
		courseNametextField.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Course Fee :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(414, 133, 244, 37);
		getContentPane().add(lblNewLabel_7);
		
		courseFeetextField = new JTextField();
		courseFeetextField.setBounds(414, 180, 256, 37);
		getContentPane().add(courseFeetextField);
		courseFeetextField.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Enter Amount :");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(414, 227, 244, 37);
		getContentPane().add(lblNewLabel_8);
		
		amttextField = new JTextField();
		amttextField.setBounds(414, 274, 256, 37);
		getContentPane().add(amttextField);
		amttextField.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Fee Status :");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(414, 321, 244, 37);
		getContentPane().add(lblNewLabel_9);
		
		paidRadioButton = new JRadioButton("paid");
		paidRadioButton.setBackground(Color.WHITE);
		paidRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		paidRadioButton.setBounds(414, 368, 244, 37);
		getContentPane().add(paidRadioButton);
		
		pendingRadioButton = new JRadioButton("pending");
		pendingRadioButton.setBackground(Color.WHITE);
		pendingRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pendingRadioButton.setBounds(414, 415, 244, 37);
		getContentPane().add(pendingRadioButton);
		
		Feestatus = new ButtonGroup();
		Feestatus.add(pendingRadioButton);
		Feestatus.add(paidRadioButton);
		
		JLabel lblNewLabel_10 = new JLabel("Enter Due Date (YYYY-MM-DD):");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_10.setBounds(414, 462, 289, 37);
		getContentPane().add(lblNewLabel_10);
		
		dueDatetextField = new JTextField();
		dueDatetextField.setBounds(414, 509, 244, 37);
		getContentPane().add(dueDatetextField);
		dueDatetextField.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Enter Paid Date (YYYY-MM-DD):");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_11.setBounds(414, 556, 289, 37);
		getContentPane().add(lblNewLabel_11);
		
		paidDatetextField = new JTextField();
		paidDatetextField.setBounds(414, 603, 256, 37);
		getContentPane().add(paidDatetextField);
		paidDatetextField.setColumns(10);
		
		payButton = new JButton("Pay");
		payButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		payButton.setBackground(Color.GREEN);
		payButton.setBounds(414, 656, 101, 49);
		payButton.addActionListener(this);
		getContentPane().add(payButton);
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/universitymanagementsystem/icons/fee1.png"));
		Image i2 = i1.getImage().getScaledInstance(477,394,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(719, 227, 477, 413);
		getContentPane().add(image);
		
		resetButton = new JButton("Reset");
		resetButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resetButton.setBounds(696, 656, 101, 49);
		resetButton.addActionListener(this);
		getContentPane().add(resetButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setBackground(Color.RED);
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cancelButton.setBounds(838, 656, 101, 49);
		cancelButton.addActionListener(this);
		getContentPane().add(cancelButton);
		
		comboBox = new JComboBox<>();
		comboBox.setBounds(61, 180, 256, 37);
		comboBox.addActionListener(this);
		getContentPane().add(comboBox);
		
		updateButton = new JButton("Update");
		updateButton.setBackground(Color.GREEN);
		updateButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		updateButton.setBounds(557, 656, 101, 49);
		updateButton.addActionListener(this);
		getContentPane().add(updateButton);
		
		lblNewLabel_12 = new JLabel("Remaining Fee :");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_12.setBounds(752, 133, 244, 37);
		getContentPane().add(lblNewLabel_12);
		
		ramttextField = new JTextField();
		ramttextField.setBounds(752, 180, 256, 37);
		getContentPane().add(ramttextField);
		ramttextField.setColumns(10);
		
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
		
		setLocation(200,50);
		setSize(1245,764);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==comboBox) {
			//JOptionPane.showMessageDialog(null,comboBox.getSelectedItem());
			int sid = Integer.parseInt(""+comboBox.getSelectedItem());
			try {
				Conn con = new Conn();
				ResultSet rs = con.s.executeQuery("select * from student where stud_id = "+sid+" ");
				
				if(rs.next()) {
					studNametextField.setText(""+rs.getString("first_name")+" "+rs.getString("last_name"));
					departIdtextField.setText(""+rs.getString("depart_id"));
				}
//				String departid=departIdtextField.getText();
//				int did=Integer.parseInt(departid);
				rs=con.s.executeQuery("select depart_name from department where depart_id = '"+departIdtextField.getText()+"' ");
				
				if(rs.next()) {
					departNametextField.setText(rs.getString("depart_name"));
				}
				
				rs=con.s.executeQuery("select course_id from enrollment where stud_id = "+sid+" ");
				int cid=0;
				if(rs.next()) {
					cid=rs.getInt("course_id");
					courseIdtextField.setText(""+cid);
				}
				
				rs=con.s.executeQuery("select * from course where course_id = "+cid+" ");
				if(rs.next()) {
					courseNametextField.setText(rs.getString("course_name"));
					courseFeetextField.setText(""+rs.getFloat("fee"));
				}
				
				rs=con.s.executeQuery("select remain_amt from fee where stud_id = "+sid+" ");
				if(rs.next()) {
					ramttextField.setText(""+rs.getFloat("remain_amt"));
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()==payButton) {
			if(comboBox.getSelectedItem().equals("0")||studNametextField.getText().equals("")||departIdtextField.getText().equals("")||departNametextField.getText().equals("")||courseIdtextField.getText().equals("")||courseNametextField.getText().equals("")||courseFeetextField.getText().equals("")||amttextField.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"ENTER VALUES OF ALL FIELDS !!!!");
			}else {
				try {
					Conn con = new Conn();
					
					int sid = Integer.parseInt((String)comboBox.getSelectedItem());
					
					float amtt = Float.parseFloat(amttextField.getText()) ;
					float cfee = Float.parseFloat(courseFeetextField.getText());
					float ramt = cfee-amtt;
					
					String status="";
					if(paidRadioButton.isSelected()) {
						status="paid";
						
						int ans = con.s.executeUpdate("insert into fee (stud_id,amt,paid_date,staatus,remain_amt) values ("+sid+","+amtt+",'"+paidDatetextField.getText()+"','"+status+"',"+ramt+")");
						
						ResultSet rs = con.s.executeQuery("select fee_id from fee where stud_id = "+sid+" ");
						
						if(rs.next()) {
							JOptionPane.showMessageDialog(null,"FEE ID : "+rs.getInt("fee_id")+" STUDENT ID : "+sid+" STATUS : "+status+" REMAINIG FEE : "+ramt+" ");
						}
						
					}else if(pendingRadioButton.isSelected()) {
						status="pending";
					
					int ans = con.s.executeUpdate("insert into fee (stud_id,amt,due_date,paid_date,staatus,remain_amt) values ("+sid+","+amtt+",'"+dueDatetextField.getText()+"','"+paidDatetextField.getText()+"','"+status+"',"+ramt+")");
				
					ResultSet rs = con.s.executeQuery("select fee_id from fee where stud_id = "+sid+" ");
					
					if(rs.next()) {
						JOptionPane.showMessageDialog(null,"FEE ID : "+rs.getInt("fee_id")+" STUDENT ID : "+sid+" STATUS : "+status+" REMAINIG FEE : "+ramt+" ");
					}
					
				}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}else if(ae.getSource()==updateButton) {
			if(comboBox.getSelectedItem().equals("0")||studNametextField.getText().equals("")||departIdtextField.getText().equals("")||departNametextField.getText().equals("")||courseIdtextField.getText().equals("")||courseNametextField.getText().equals("")||courseFeetextField.getText().equals("")||amttextField.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"ENTER VALUES OF ALL FIELDS !!!!");
			}else {
				try {
					Conn con = new Conn();
					
					int sid = Integer.parseInt((String)comboBox.getSelectedItem());
					
					float amtt=Float.parseFloat(amttextField.getText()) ;
					float amt=0.0f;
					float cfee=0.0f; 
					float ramt=0.0f;
					
					ResultSet rs = con.s.executeQuery("select * from fee where stud_id ="+sid+" ");
					
					if(rs.next()) {
						amt=rs.getFloat("amt");
						ramt=rs.getFloat("remain_amt");
					}
					
					String status="";
					if(paidRadioButton.isSelected()) {
						status="paid";
						float newremain=ramt-amtt;
						float newamt=amt+amtt;
						int ans = con.s.executeUpdate("update fee set amt = "+newamt+" , remain_amt = "+newremain+" , staatus = '"+status+"' , due_date = null , paid_date = '"+paidDatetextField.getText()+"' where stud_id = "+sid+" ");
						
						rs = con.s.executeQuery("select fee_id from fee where stud_id = "+sid+" ");
						
						if(rs.next()) {
							JOptionPane.showMessageDialog(null,"FEE ID : "+rs.getInt("fee_id")+" STUDENT ID : "+sid+" STATUS : "+status+" REMAINIG FEE : "+newremain+" ");
						}
						
					}else if(pendingRadioButton.isSelected()) {
						status="pending";
						
					float newremain=ramt-amtt;
					float newamt=amt+amtt;
					int ans = con.s.executeUpdate("update fee set due_date = '"+dueDatetextField.getText()+"' , amt = "+newamt+" , remain_amt= "+newremain+" , paid_date = '"+paidDatetextField.getText()+"'  where stud_id = "+sid+" ");
				
					rs = con.s.executeQuery("select fee_id from fee where stud_id = "+sid+" ");
					
					if(rs.next()) {
						JOptionPane.showMessageDialog(null,"FEE ID : "+rs.getInt("fee_id")+" STUDENT ID : "+sid+" STATUS : "+status+" REMAINIG FEE : "+newremain+" ");
					}
					
				}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}else if(ae.getSource()==resetButton) {
			comboBox.setSelectedItem("0");
			studNametextField.setText(null);
			departIdtextField.setText(null);
			departNametextField.setText(null);
			courseIdtextField.setText(null);
			courseNametextField.setText(null);
			courseFeetextField.setText(null);
			amttextField.setText(null);
//			pendingRadioButton.setSelected(false);
//			paidRadioButton.setSelected(false);
			paidDatetextField.setText(null);
			dueDatetextField.setText(null);
		}else if(ae.getSource()==cancelButton) {
			setVisible(false);
		}
	}
}
