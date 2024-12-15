package universitymanagementsystem;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.sql.*;

public class AddDepartment extends JFrame implements ActionListener{
	private JTextField departNametextField;
	private JTextField departHeadtextField;
	private JButton addButton,resetButton,cancelButton;
	
	public AddDepartment() {
		setTitle("Add Department");
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("ADD DEPARTMENT");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(257, 51, 257, 39);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Department Name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(33, 166, 275, 31);
		getContentPane().add(lblNewLabel_1);
		
		departNametextField = new JTextField();
		departNametextField.setBounds(33, 207, 275, 41);
		getContentPane().add(departNametextField);
		departNametextField.setColumns(10);
		departNametextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Allow only alphabetic characters (A-Z, a-z) and spaces
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                    e.consume(); // Ignore the event (do not allow the character)
                }
            }
        });
		
		JLabel lblNewLabel_2 = new JLabel("Enter Department Head : ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(33, 277, 275, 39);
		getContentPane().add(lblNewLabel_2);
		
		departHeadtextField = new JTextField();
		departHeadtextField.setBounds(33, 326, 275, 41);
		getContentPane().add(departHeadtextField);
		departHeadtextField.setColumns(10);
		departHeadtextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Allow only alphabetic characters (A-Z, a-z) and spaces
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                    e.consume(); // Ignore the event (do not allow the character)
                }
            }
        });
		
		addButton = new JButton("Add");
		addButton.setBackground(Color.GREEN);
		addButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addButton.setBounds(33, 423, 132, 39);
		addButton.addActionListener(this);
		getContentPane().add(addButton);
		
		resetButton = new JButton("Reset");
		resetButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resetButton.setBounds(33, 512, 132, 39);
		resetButton.addActionListener(this);
		getContentPane().add(resetButton);
		
		cancelButton = new JButton("Exit");
		cancelButton.setBackground(Color.RED);
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setBounds(33, 600, 132, 39);
		cancelButton.addActionListener(this);
		getContentPane().add(cancelButton);
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/universitymanagementsystem/icons/depart1.jpg"));
		Image i2 = i1.getImage().getScaledInstance(387,473,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(355, 166, 387, 473);
		getContentPane().add(image);
		
		
		
		setLocation(400,50);
		setSize(806,764);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==addButton) {
			if(departNametextField.getText().equals("")||departHeadtextField.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"ENTER VALUES OF ALL FIELDS !!!!");
			}else {
				try {
					Conn con = new Conn();
					con.s.executeUpdate("insert into department (depart_name,depart_head) values ('"+departNametextField.getText()+"','"+departHeadtextField.getText()+"')");
					ResultSet rs = con.s.executeQuery("select depart_id from department where depart_name = '"+departNametextField.getText()+"' ");
				
					if(rs.next()) {
						JOptionPane.showMessageDialog(null,"DEPARTMENT ADDED SUCCESSFULLY !!! ID :"+rs.getInt(1)+" NAME :"+departNametextField.getText()+" HEAD : "+departHeadtextField.getText());
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}else if(ae.getSource()==resetButton) {
			departNametextField.setText(null);
			departHeadtextField.setText(null);
		}else if(ae.getSource()==cancelButton) {
			setVisible(false);
			//new DashBoard();
		}
	}
}
