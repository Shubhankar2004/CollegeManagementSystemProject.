package universitymanagementsystem;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.sql.*;

public class FeeDetails extends JFrame implements ActionListener {
	private JTable table;
	private JButton showAllButton,ShowIdButton,resetButton,cancelButton;
	JComboBox<String>comboBox;
	
	public FeeDetails() {
		setTitle("Fee Details");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FEE DETAILS");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(430, 43, 276, 37);
		getContentPane().add(lblNewLabel);
		
		showAllButton = new JButton("Show All");
		showAllButton.setBackground(Color.GREEN);
		showAllButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		showAllButton.setBounds(56, 118, 101, 49);
		showAllButton.addActionListener(this);
		getContentPane().add(showAllButton);
		
		JLabel lblNewLabel_1 = new JLabel("Student ID :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(167, 118, 141, 49);
		getContentPane().add(lblNewLabel_1);
		
		comboBox = new JComboBox<>();
		comboBox.setBounds(318, 118, 126, 49);
		comboBox.addActionListener(this);
		getContentPane().add(comboBox);
		
		ShowIdButton = new JButton("Show");
		ShowIdButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ShowIdButton.setBackground(Color.GREEN);
		ShowIdButton.setBounds(483, 118, 101, 49);
		ShowIdButton.addActionListener(this);
		getContentPane().add(ShowIdButton);
		
		resetButton = new JButton("Reset");
		resetButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resetButton.setBounds(631, 118, 101, 49);
		resetButton.addActionListener(this);
		getContentPane().add(resetButton);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBackground(Color.RED);
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cancelButton.setBounds(780, 118, 101, 49);
		cancelButton.addActionListener(this);
		getContentPane().add(cancelButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 229, 1089, 445);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
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
		setSize(1195,764);
		setVisible(true);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		Conn con = new Conn();
		ResultSet rs;
		ResultSetMetaData rsmd;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		if(ae.getSource()==showAllButton) {
			try {
				
				rs = con.s.executeQuery("select * from fee inner join student on fee.stud_id = student.stud_id");
			
				rsmd=rs.getMetaData();
				
				int cols = rsmd.getColumnCount();
				Vector<String> colName = new Vector<String>();
				for(int i=0;i<cols;i++)
					colName.add(rsmd.getColumnName(i+1));
				
				model.setColumnIdentifiers(colName);
				String fid,sid,amt,ddate,pdate,stat,ramt,stid,fname,lname,dobb,eml,mob,addrss,did;
				
				while(rs.next()) {
					fid=rs.getString(1);
					sid=rs.getString(2);
					amt=rs.getString(3);
					ddate=rs.getString(4);
					pdate=rs.getString(5);
					stat=rs.getString(6);
					ramt=rs.getString(7);
					stid=rs.getString(8);
					fname=rs.getString(9);
					lname=rs.getString(10);
					dobb=rs.getString(11);
					eml=rs.getString(12);
					mob=rs.getString(13);
					addrss=rs.getString(14);
					did=rs.getString(15);
					//Vector<String>row=new Vector<String>();
					String[] row = {fid,sid,amt,ddate,pdate,stat,ramt,stid,fname,lname,dobb,eml,mob,addrss,did};
					model.addRow(row);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()==ShowIdButton) {
			try {
				
				int id = Integer.parseInt(""+comboBox.getSelectedItem());
				
				rs = con.s.executeQuery("select * from fee inner join student on fee.stud_id = student.stud_id where student.stud_id = "+id+" ");
			
				rsmd=rs.getMetaData();
				
				int cols = rsmd.getColumnCount();
				Vector<String> colName = new Vector<String>();
				for(int i=0;i<cols;i++)
					colName.add(rsmd.getColumnName(i+1));
				
				model.setColumnIdentifiers(colName);
				String fid,sid,amt,ddate,pdate,stat,ramt,stid,fname,lname,dobb,eml,mob,addrss,did;
				
				while(rs.next()) {
					fid=rs.getString(1);
					sid=rs.getString(2);
					amt=rs.getString(3);
					ddate=rs.getString(4);
					pdate=rs.getString(5);
					stat=rs.getString(6);
					ramt=rs.getString(7);
					stid=rs.getString(8);
					fname=rs.getString(9);
					lname=rs.getString(10);
					dobb=rs.getString(11);
					eml=rs.getString(12);
					mob=rs.getString(13);
					addrss=rs.getString(14);
					did=rs.getString(15);
					//Vector<String>row=new Vector<String>();
					String[] row = {fid,sid,amt,ddate,pdate,stat,ramt,stid,fname,lname,dobb,eml,mob,addrss,did};
					model.addRow(row);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(ae.getSource()==resetButton) {
			table.setModel(new DefaultTableModel());
		}else if(ae.getSource()==cancelButton) {
			setVisible(false);
		}
	}

}
