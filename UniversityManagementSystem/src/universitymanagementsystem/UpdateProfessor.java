package universitymanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;

public class UpdateProfessor extends JFrame implements ActionListener {
	private JTextField fnametextField;
	private JTextField lnametextField;
	private JTextField emailtextField;
	private JTextField mobtextField;
	private JButton resetButton,cancelButton;
	private JComboBox<String>comboBox;
	private JButton updateButton;
	
	public UpdateProfessor() {
		setTitle("Update Professor");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UPDATE PROFESSOR");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(230, 52, 302, 37);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Select Professor ID :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(48, 134, 244, 37);
		getContentPane().add(lblNewLabel_1);
		
		comboBox = new JComboBox<>();
		comboBox.setBounds(48, 181, 256, 37);
		comboBox.addActionListener(this);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Professor First Name :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(48, 228, 244, 37);
		getContentPane().add(lblNewLabel_2);
		
		fnametextField = new JTextField();
		fnametextField.setBounds(48, 275, 256, 37);
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
		
		JLabel lblNewLabel_3 = new JLabel("Professor Last Name :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(48, 322, 244, 37);
		getContentPane().add(lblNewLabel_3);
		
		lnametextField = new JTextField();
		lnametextField.setBounds(48, 369, 256, 37);
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
		
		JLabel lblNewLabel_4 = new JLabel("Professor Email :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(48, 416, 244, 37);
		getContentPane().add(lblNewLabel_4);
		
		emailtextField = new JTextField();
		emailtextField.setBounds(48, 463, 256, 37);
		getContentPane().add(emailtextField);
		emailtextField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Professor Mobile :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(48, 510, 244, 37);
		getContentPane().add(lblNewLabel_5);
		
		mobtextField = new JTextField();
		mobtextField.setBounds(48, 557, 256, 37);
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
		
		resetButton = new JButton("Reset");
		resetButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resetButton.setBounds(183, 635, 101, 49);
		resetButton.addActionListener(this);
		getContentPane().add(resetButton);
		
		cancelButton = new JButton("Exit");
		cancelButton.setForeground(Color.WHITE);
		cancelButton.setBackground(Color.RED);
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cancelButton.setBounds(322, 635, 101, 49);
		cancelButton.addActionListener(this);
		getContentPane().add(cancelButton);
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/universitymanagementsystem/icons/teacher.jpg"));
		Image i2 = i1.getImage().getScaledInstance(322,498,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(322, 134, 444, 491);
		getContentPane().add(image);
		
		updateButton = new JButton("Update");
		updateButton.setBackground(Color.GREEN);
		updateButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		updateButton.setBounds(48, 635, 101, 49);
		updateButton.addActionListener(this);
		getContentPane().add(updateButton);
		
		comboBox.addItem("0");
		
		try {
			Conn con = new Conn();
			ResultSet rs = con.s.executeQuery("select prof_id from professor");
			
			while(rs.next()) {
				String item = ""+rs.getInt("prof_id");
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
		int pid = Integer.parseInt(""+comboBox.getSelectedItem());
		Conn con = new Conn();
		ResultSet rs;
		if(ae.getSource()==comboBox) {
			try {
				rs = con.s.executeQuery("select * from professor where prof_id = "+pid+" ");
				
				if(rs.next()) {
					fnametextField.setText(rs.getString("first_name"));
					lnametextField.setText(rs.getString("last_name"));
					emailtextField.setText(rs.getString("email"));
					mobtextField.setText(rs.getString("mobile"));
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()==resetButton) {
			comboBox.setSelectedItem("0");
			fnametextField.setText(null);
			lnametextField.setText(null);
			emailtextField.setText(null);
			mobtextField.setText(null);
		}else if(ae.getSource()==cancelButton) {
			setVisible(false);
		}else if(ae.getSource()==updateButton) {
			try {

				con.s.executeUpdate("update professor set first_name = '"+fnametextField.getText()+"' , last_name = '"+lnametextField.getText()+"' , email = '"+emailtextField.getText()+"' , mobile = '"+mobtextField.getText()+"' where prof_id = "+pid+" ");
			
				JOptionPane.showMessageDialog(null,"Updation Successful !!!!");
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
