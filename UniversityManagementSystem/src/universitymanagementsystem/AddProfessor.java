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

public class AddProfessor extends JFrame implements ActionListener{
	private JTextField firstNametextField;
	private JTextField lastNametextField;
	private JTextField emailtextField;
	private JTextField mobiletextField;
	private JTextField didtextField;
	private JComboBox<String> comboBox;
	private JButton addButton,resetButton,cancelButton;
	
	public AddProfessor() {
		setTitle("Add Professor");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD PROFESSOR");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(259, 62, 246, 31);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Professor First Name : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(58, 130, 257, 37);
		getContentPane().add(lblNewLabel_1);
		
		firstNametextField = new JTextField();
		firstNametextField.setBounds(58, 177, 269, 37);
		getContentPane().add(firstNametextField);
		firstNametextField.setColumns(10);
		firstNametextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Allow only alphabetic characters (A-Z, a-z) and spaces
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                    e.consume(); // Ignore the event (do not allow the character)
                }
            }
        });
		
		JLabel lblNewLabel_2 = new JLabel("Enter Professor Last Name :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(58, 224, 257, 37);
		getContentPane().add(lblNewLabel_2);
		
		lastNametextField = new JTextField();
		lastNametextField.setBounds(58, 271, 269, 37);
		getContentPane().add(lastNametextField);
		lastNametextField.setColumns(10);
		lastNametextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Allow only alphabetic characters (A-Z, a-z) and spaces
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                    e.consume(); // Ignore the event (do not allow the character)
                }
            }
        });
		
		JLabel lblNewLabel_3 = new JLabel("Enter Professor Email :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(58, 318, 257, 31);
		getContentPane().add(lblNewLabel_3);
		
		emailtextField = new JTextField();
		emailtextField.setBounds(58, 359, 269, 37);
		getContentPane().add(emailtextField);
		emailtextField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Enter Professor Mobile :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(58, 406, 257, 37);
		getContentPane().add(lblNewLabel_4);
		
		mobiletextField = new JTextField();
		mobiletextField.setBounds(58, 453, 269, 37);
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
		
		JLabel lblNewLabel_5 = new JLabel("Select Department :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(58, 500, 257, 37);
		getContentPane().add(lblNewLabel_5);
		
		comboBox = new JComboBox<>();
		comboBox.setBounds(58, 547, 269, 37);
		comboBox.addActionListener(this);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel_6 = new JLabel("Department ID :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(58, 594, 257, 37);
		getContentPane().add(lblNewLabel_6);
		
		didtextField = new JTextField();
		didtextField.setBounds(58, 641, 269, 37);
		getContentPane().add(didtextField);
		didtextField.setColumns(10);
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/universitymanagementsystem/icons/prof1.png"));
		Image i2 = i1.getImage().getScaledInstance(406,501,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(354, 130, 406, 501);
		getContentPane().add(image);
		
		addButton = new JButton("Add");
		addButton.setBackground(Color.GREEN);
		addButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addButton.setBounds(364, 641, 101, 49);
		addButton.addActionListener(this);
		getContentPane().add(addButton);
		
		resetButton = new JButton("Reset");
		resetButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resetButton.setBounds(500, 641, 101, 49);
		resetButton.addActionListener(this);
		getContentPane().add(resetButton);
		
		cancelButton = new JButton("Exit");
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cancelButton.setBackground(Color.RED);
		cancelButton.setBounds(634, 641, 101, 49);
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
			if(firstNametextField.getText().equals("")||lastNametextField.getText().equals("")||emailtextField.getText().equals("")||mobiletextField.getText().equals("")||comboBox.getSelectedItem().equals("null")||didtextField.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"ENTER VALUES OF ALL FIELDS !!!!");
			}else {
				try {
					Conn con = new Conn();
					con.s.executeUpdate("insert into professor (first_name,last_name,email,mobile,depart_id) values ('"+firstNametextField.getText()+"','"+lastNametextField.getText()+"','"+emailtextField.getText()+"','"+mobiletextField.getText()+"',"+Integer.parseInt(didtextField.getText())+")");
					ResultSet rs = con.s.executeQuery("select * from professor where first_name = '"+firstNametextField.getText()+"' and last_name = '"+lastNametextField.getText()+"' ");
				
					if(rs.next()) {
						JOptionPane.showMessageDialog(null,"ID : "+rs.getInt("prof_id")+" Name : "+firstNametextField.getText()+" "+lastNametextField.getText());
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}else if(ae.getSource()==resetButton) {
			firstNametextField.setText(null);
			lastNametextField.setText(null);
			emailtextField.setText(null);
			mobiletextField.setText(null);
			comboBox.setSelectedItem("null");
			didtextField.setText(null);
		}else if(ae.getSource()==cancelButton) {
			setVisible(false);
		}
	}
}
