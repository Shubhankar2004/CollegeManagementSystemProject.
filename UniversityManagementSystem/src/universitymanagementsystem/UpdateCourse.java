package universitymanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;

public class UpdateCourse extends JFrame implements ActionListener{
	private JTextField cnametextField;
	private JTextField creditstextField;
	private JTextField feetextField;
	private JButton resetButton,cancelButton;
	private JComboBox<String>comboBox;
	private JButton updateButton;

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
		cnametextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Allow only alphabetic characters (A-Z, a-z) and spaces
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                    e.consume(); // Ignore the event (do not allow the character)
                }
            }
        });
		
		JLabel lblNewLabel_3 = new JLabel("Course Credits :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(40, 324, 244, 37);
		getContentPane().add(lblNewLabel_3);
		
		creditstextField = new JTextField();
		creditstextField.setBounds(40, 371, 256, 37);
		getContentPane().add(creditstextField);
		creditstextField.setColumns(10);
		creditstextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Allow only digits (0-9)
                if (!Character.isDigit(c)) {
                    e.consume(); // Ignore the event (do not allow the character)
                }
            }
        });
		
		JLabel lblNewLabel_4 = new JLabel("Course Fee :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(40, 418, 244, 37);
		getContentPane().add(lblNewLabel_4);
		
		feetextField = new JTextField();
		feetextField.setBounds(40, 465, 256, 37);
		getContentPane().add(feetextField);
		feetextField.setColumns(10);
		feetextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Allow only digits (0-9)
                if (!Character.isDigit(c)) {
                    e.consume(); // Ignore the event (do not allow the character)
                }
            }
        });
		
		resetButton = new JButton("Reset");
		resetButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resetButton.setBounds(174, 546, 101, 49);
		resetButton.addActionListener(this);
		getContentPane().add(resetButton);
		
		cancelButton = new JButton("Exit");
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setBackground(Color.RED);
		cancelButton.setBounds(315, 546, 101, 49);
		cancelButton.addActionListener(this);
		getContentPane().add(cancelButton);
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/universitymanagementsystem/icons/course2.png"));
		Image i2 = i1.getImage().getScaledInstance(322,498,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(325, 136, 433, 395);
		getContentPane().add(image);
		
		updateButton = new JButton("Update");
		updateButton.setBackground(Color.GREEN);
		updateButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		updateButton.setBounds(40, 546, 101, 49);
		updateButton.addActionListener(this);
		getContentPane().add(updateButton);
		
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
		}else if(ae.getSource()==updateButton) {
			try {
				int credit = Integer.parseInt(creditstextField.getText());
				float fee = Float.parseFloat(feetextField.getText());

				con.s.executeUpdate("update course set course_name = '"+cnametextField.getText()+"' , credits = "+credit+" , fee = "+fee+" where course_id = "+cid+" ");
				
				JOptionPane.showMessageDialog(null,"Updation Successful !!!!");
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
