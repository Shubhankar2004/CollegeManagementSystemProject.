package universitymanagementsystem;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DashBoard extends JFrame implements ActionListener{
	
	JMenuBar menuBar;
	JMenu InformationMenu;
	JMenuItem enrollStudMenuItem,addProfMenuItem,addDepartMenuItem,addCourseMenuItem;
	private JMenu feeMenu;
	private JMenuItem payMenuItem;
	private JMenuItem feeDetailsMenuItem;
	private JMenu updateMenu;
	private JMenuItem updateStudMenuItem;
	private JMenuItem updateProfMenuItem;
	private JMenuItem updateDepartMenuItem;
	private JMenuItem updateCourseMenuItem;
	private JMenu viewDetailsMenu;
	private JMenu utilitiesMenu;
	private JMenu exitMenu;
	private JMenuItem LogOutMenuItem;
	private JMenuItem studDetailsMenuItem;
	private JMenuItem profDetailsMenuItem;
	private JMenuItem departDetailsMenuItem;
	private JMenuItem courseDetailsMenuItem;
	private JMenuItem calMenuItem;
	private JMenuItem notepadMenuItem;
	
	public DashBoard() {
		setTitle("Dashboard");
		getContentPane().setBackground(Color.WHITE);
		
		ImageIcon i1 = new ImageIcon(getClass().getResource("/universitymanagementsystem/icons/college6.png"));
		Image i2 = i1.getImage().getScaledInstance(806,764,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		getContentPane().add(image);
		
		
		setExtendedState(MAXIMIZED_BOTH);
		
//		setLocation(400,50);
//		setSize(806,764);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		InformationMenu = new JMenu("Add Information");
		InformationMenu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(InformationMenu);
		
		enrollStudMenuItem = new JMenuItem("Add Student");
		enrollStudMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		enrollStudMenuItem.addActionListener(this);
		InformationMenu.add(enrollStudMenuItem);
		
		addProfMenuItem = new JMenuItem("Add Professor");
		addProfMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		addProfMenuItem.addActionListener(this);
		InformationMenu.add(addProfMenuItem);
		
		addDepartMenuItem = new JMenuItem("Add Department");
		addDepartMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		addDepartMenuItem.addActionListener(this);
		InformationMenu.add(addDepartMenuItem);
		
		addCourseMenuItem = new JMenuItem("Add Course");
		addCourseMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		addCourseMenuItem.addActionListener(this);
		InformationMenu.add(addCourseMenuItem);
		
		feeMenu = new JMenu("Fee");
		feeMenu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(feeMenu);
		
		payMenuItem = new JMenuItem("Payment");
		payMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		payMenuItem.addActionListener(this);
		feeMenu.add(payMenuItem);
		
		feeDetailsMenuItem = new JMenuItem("View Fee Details");
		feeDetailsMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		feeDetailsMenuItem.addActionListener(this);
		feeMenu.add(feeDetailsMenuItem);
		
		updateMenu = new JMenu("Update Details");
		updateMenu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(updateMenu);
		
		updateStudMenuItem = new JMenuItem("Student");
		updateStudMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		updateStudMenuItem.addActionListener(this);
		updateMenu.add(updateStudMenuItem);
		
		updateProfMenuItem = new JMenuItem("Professor");
		updateProfMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		updateProfMenuItem.addActionListener(this);
		updateMenu.add(updateProfMenuItem);
		
		updateDepartMenuItem = new JMenuItem("Department");
		updateDepartMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		updateDepartMenuItem.addActionListener(this);
		updateMenu.add(updateDepartMenuItem);
		
		updateCourseMenuItem = new JMenuItem("Course");
		updateCourseMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		updateCourseMenuItem.addActionListener(this);
		updateMenu.add(updateCourseMenuItem);
		
		viewDetailsMenu = new JMenu("View Details");
		viewDetailsMenu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(viewDetailsMenu);
		
		studDetailsMenuItem = new JMenuItem("Student");
		studDetailsMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		studDetailsMenuItem.addActionListener(this);
		viewDetailsMenu.add(studDetailsMenuItem);
		
		profDetailsMenuItem = new JMenuItem("Professor");
		profDetailsMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		profDetailsMenuItem.addActionListener(this);
		viewDetailsMenu.add(profDetailsMenuItem);
		
		departDetailsMenuItem = new JMenuItem("Department");
		departDetailsMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		departDetailsMenuItem.addActionListener(this);
		viewDetailsMenu.add(departDetailsMenuItem);
		
		courseDetailsMenuItem = new JMenuItem("Course");
		courseDetailsMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		courseDetailsMenuItem.addActionListener(this);
		viewDetailsMenu.add(courseDetailsMenuItem);
		
		utilitiesMenu = new JMenu("Utilities");
		utilitiesMenu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(utilitiesMenu);
		
		calMenuItem = new JMenuItem("Calculator");
		calMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		calMenuItem.addActionListener(this);
		utilitiesMenu.add(calMenuItem);
		
		notepadMenuItem = new JMenuItem("Notepad");
		notepadMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		notepadMenuItem.addActionListener(this);
		utilitiesMenu.add(notepadMenuItem);
		
		exitMenu = new JMenu("Exit");
		exitMenu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		menuBar.add(exitMenu);
		
		LogOutMenuItem = new JMenuItem("Log Out");
		LogOutMenuItem.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		LogOutMenuItem.addActionListener(this);
		exitMenu.add(LogOutMenuItem);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
			if(ae.getSource()==addDepartMenuItem) {
				//setVisible(false);
				new AddDepartment();
			}else if(ae.getSource()==addCourseMenuItem) {
				//setVisible(false);
				new AddCourse();
			}else if(ae.getSource()==addProfMenuItem) {
				new AddProfessor();
			}else if(ae.getSource()==enrollStudMenuItem) {
				new AddStudent();
			}else if(ae.getSource()==payMenuItem) {
				new PayFee();
			}else if(ae.getSource()==feeDetailsMenuItem) {
				new FeeDetails();
			}else if(ae.getSource()==updateStudMenuItem) {
				new UpdateStudent();
			}else if(ae.getSource()==updateProfMenuItem) {
				new UpdateProfessor();
			}else if(ae.getSource()==updateDepartMenuItem) {
				new UpdateDepartment();
			}else if(ae.getSource()==updateCourseMenuItem) {
				new UpdateCourse();
			}else if(ae.getSource()==studDetailsMenuItem) {
				new StudentDetails();
			}else if(ae.getSource()==profDetailsMenuItem) {
				new ProfessorDetails();
			}else if(ae.getSource()==departDetailsMenuItem) {
				new DepartmentDetails();
			}else if(ae.getSource()==courseDetailsMenuItem) {
				new CourseDetails();
			}else if(ae.getSource()==LogOutMenuItem) {
				try {
					Conn con = new Conn();
					con.c.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				setVisible(false);
				
			}else if(ae.getSource()==calMenuItem) {
				try {
					Runtime.getRuntime().exec("calc.exe");
				}catch(Exception e) {
					e.printStackTrace();
				}
			}else if(ae.getSource()==notepadMenuItem) {
				try {
					Runtime.getRuntime().exec("notepad.exe");
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
	}
}
