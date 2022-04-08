package com.DIT.chatapp.views;

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
import com.DIT.chatapp.dto.UserDTOLogin;

public class LoginScreen extends JFrame{
	private JPasswordField passwordField;
	private JTextField textUserID;

	/**
	 * Launch the application.
	 */
	
	private void login() {
		String userid=textUserID.getText();
		char[] password =passwordField.getPassword();
		UserDAO userDAO=new UserDAO();
//		System.out.println(userid+" "+password);  //ClassName@hashcode[hexa]
		UserDTOLogin userDTOLogin=new UserDTOLogin(userid,password);
		System.out.println(userid+" "+password);  //ClassName@hashcode[hexa]
//		UserDAO userDAO=new UserDAO();
		try {
			String message="";
			if(userDAO.isLogin(userDTOLogin)) {
				message="Welcome "+userid;
				JOptionPane.showMessageDialog(this, message);
				setVisible(false);   //to remove the previous screen
				dispose();  //to delete the screen
				Dashboard dashboard=new Dashboard(message);
				dashboard.setVisible(true);
			}
			else {
				message="Invalid userid or password";
				JOptionPane.showMessageDialog(this, message);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
//			LoginScreen window = new LoginScreen();
			
	}

	/**
	 * Create the application.
	 */
	public LoginScreen() {
		getContentPane().setLayout(null);
		
		JLabel SignIn = new JLabel("Login");
		SignIn.setHorizontalAlignment(SwingConstants.CENTER);
		SignIn.setFont(new Font("Tahoma", Font.BOLD, 28));
		SignIn.setBounds(129, 22, 184, 45);
		getContentPane().add(SignIn);
		
		JLabel userIdLbl = new JLabel("User ID");
		userIdLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		userIdLbl.setHorizontalAlignment(SwingConstants.CENTER);
		userIdLbl.setBounds(85, 106, 130, 34);
		getContentPane().add(userIdLbl);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 15));
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(241, 193, 130, 34);
		getContentPane().add(passwordField);
		
		JLabel pwdLbl = new JLabel("Password");
		pwdLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		pwdLbl.setHorizontalAlignment(SwingConstants.CENTER);
		pwdLbl.setBounds(85, 194, 130, 34);
		getContentPane().add(pwdLbl);
		
		textUserID = new JTextField();
		textUserID.setBounds(241, 106, 130, 34);
		getContentPane().add(textUserID);
		textUserID.setColumns(10);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});
		loginBtn.setBounds(85, 293, 130, 34);
		getContentPane().add(loginBtn);
		
		JButton forgetPwdBtn = new JButton("Forget Password");
		forgetPwdBtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		forgetPwdBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				ForgetPassword forgetPassword=new ForgetPassword();
				forgetPassword.setVisible(true);
			}
		});
		forgetPwdBtn.setBounds(241, 293, 189, 34);
		getContentPane().add(forgetPwdBtn);
		setSize(500,541);
		setLocationRelativeTo(null);
	}
}
