package com.DIT.chatapp.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.DIT.chatapp.dao.UserDAO;
import com.DIT.chatapp.dto.UserDTO;

public class UserScreen extends JFrame {
	private JTextField useridtextField;
	private JPasswordField passwordtextField;

	public static void main(String[] args) {
		UserScreen window = new UserScreen();

	}
	
	UserDAO userDAO=new UserDAO();
	private JTextField textFieldemail;
	private JTextField txtCity;
	private JTextField textPhone;
	
//	private void doLogin() {
//		String userid=useridtextField.getText();
//		char[] password =passwordtextField.getPassword();
////		System.out.println(userid+" "+password);  //ClassName@hashcode[hexa]
//		UserDTO userDTO=new UserDTO(userid,password);
//		try {
//			String message="";
//			if(userDAO.isLogin(userDTO)) {
//				message="Welcome "+userid;
//				JOptionPane.showMessageDialog(this, message);
//				setVisible(false);   //to remove the previous screen
//				dispose();  //to delete the screen
//				Dashboard dashboard=new Dashboard(message);
//				dashboard.setVisible(true);
//			}
//			else {
//				message="Invalid userid or password";
//				JOptionPane.showMessageDialog(this, message);
//			}
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NoSuchAlgorithmException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	private void register() {
		String userid=useridtextField.getText();
		char[] password =passwordtextField.getPassword();
		String email=textFieldemail.getText();
		String city =txtCity.getText();
		String phone=textPhone.getText();
		
//		System.out.println(userid+" "+password);  //ClassName@hashcode[hexa]
		UserDTO userDTO=new UserDTO(userid,password,email,city,phone);
		System.out.println(userid+" "+password);  //ClassName@hashcode[hexa]
//		UserDAO userDAO=new UserDAO();
		try {
		int result=userDAO.add(userDTO);
		if(result>0)
		{
			JOptionPane.showMessageDialog(this,"Register Successfully");
//			System.out.println("Record added");
		}
		else {
			System.out.println("Record not added");
		}
		}
		catch(ClassNotFoundException | SQLException ex)
		{
			System.out.println("DB Issue...");
			ex.printStackTrace();
		}
		catch(Exception ex)
		{
			System.out.println("Some generic exception...");
			ex.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public UserScreen() {
		setTitle("Login");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblNewLabel.setBounds(136, 24, 184, 45);
		getContentPane().add(lblNewLabel);
		
		useridtextField = new JTextField();
		useridtextField.setBounds(253, 79, 155, 30);
		getContentPane().add(useridtextField);
		useridtextField.setColumns(10);
		
		JLabel userIDlbl = new JLabel("User ID");
		userIDlbl.setHorizontalAlignment(SwingConstants.CENTER);
		userIDlbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		userIDlbl.setBounds(58, 79, 130, 30);
		getContentPane().add(userIDlbl);
		
		JLabel passwordlbl = new JLabel("Password");
		passwordlbl.setHorizontalAlignment(SwingConstants.CENTER);
		passwordlbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordlbl.setBounds(58, 304, 130, 30);
		getContentPane().add(passwordlbl);
		
		passwordtextField = new JPasswordField();
		passwordtextField.setBounds(253, 304, 150, 30);
		getContentPane().add(passwordtextField);
		passwordtextField.setColumns(10);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);   //to remove the previous screen
				dispose();  //to delete the screen
				LoginScreen loginScreen=new LoginScreen();
				loginScreen.setVisible(true);
			}
		});
		loginBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		loginBtn.setBounds(107, 380, 98, 30);
		getContentPane().add(loginBtn);
		
		JButton registerBtn = new JButton("Register");
		registerBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				register();
			}
		});
		registerBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		registerBtn.setBounds(267, 380, 98, 30);
		getContentPane().add(registerBtn);
		
		JLabel emailLbl = new JLabel("Email");
		emailLbl.setHorizontalAlignment(SwingConstants.CENTER);
		emailLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		emailLbl.setBounds(58, 132, 130, 30);
		getContentPane().add(emailLbl);
		
		textFieldemail = new JTextField();
		textFieldemail.setBounds(253, 132, 155, 30);
		getContentPane().add(textFieldemail);
		textFieldemail.setColumns(10);
		
		JLabel PhoneNoLbl = new JLabel("Phone No.");
		PhoneNoLbl.setHorizontalAlignment(SwingConstants.CENTER);
		PhoneNoLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		PhoneNoLbl.setBounds(59, 244, 130, 30);
		getContentPane().add(PhoneNoLbl);
		
		JLabel cityLbl = new JLabel("City");
		cityLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		cityLbl.setHorizontalAlignment(SwingConstants.CENTER);
		cityLbl.setBounds(58, 180, 130, 30);
		getContentPane().add(cityLbl);
		
		txtCity = new JTextField();
		txtCity.setBounds(253, 180, 155, 30);
		getContentPane().add(txtCity);
		txtCity.setColumns(10);
		
		textPhone = new JTextField();
		textPhone.setBounds(253, 244, 155, 30);
		getContentPane().add(textPhone);
		textPhone.setColumns(10);
		setSize(500,541);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
