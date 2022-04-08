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

public class ForgetPassword extends JFrame{
	private JTextField userIDField;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	private void forgetPassword() {
		String userID=userIDField.getText();
		char[] password=passwordField.getPassword();
		UserDAO userDAO=new UserDAO();
		UserDTOLogin userDTOLogin=new UserDTOLogin(userID,password);
		try {
			String message="";
			if(userDAO.resetPassword(userDTOLogin)>0)
			{
				message+= "Password updated successfully!";
				JOptionPane.showMessageDialog(this, message);
				setVisible(false);   //to remove the previous screen
				dispose();  //to delete the screen
				LoginScreen loginScreen=new LoginScreen();
				loginScreen.setVisible(true);
			}
			else
			{
				message="Invalid User ID";
				JOptionPane.showMessageDialog(this, message);
			}
		}catch (ClassNotFoundException e) {
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
		
		ForgetPassword window = new ForgetPassword();
		window.setVisible(true);
				
	}

	/**
	 * Create the application.
	 */
	public ForgetPassword() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel userIdLbl = new JLabel("User ID");
		userIdLbl.setHorizontalAlignment(SwingConstants.CENTER);
		userIdLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		userIdLbl.setBounds(51, 59, 141, 30);
		getContentPane().add(userIdLbl);
		
		JLabel pwdLbl = new JLabel("New Password");
		pwdLbl.setHorizontalAlignment(SwingConstants.CENTER);
		pwdLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		pwdLbl.setBounds(51, 131, 141, 30);
		getContentPane().add(pwdLbl);
		
		userIDField = new JTextField();
		userIDField.setBounds(251, 59, 124, 27);
		getContentPane().add(userIDField);
		userIDField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(251, 131, 124, 30);
		getContentPane().add(passwordField);
		
		JButton resetButton = new JButton("Reset Password");
		resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				forgetPassword();
			}
			
		});
		resetButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		resetButton.setBounds(87, 201, 255, 37);
		getContentPane().add(resetButton);
		
		JLabel lblNewLabel = new JLabel("Reset Password Window");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(48, 10, 327, 30);
		getContentPane().add(lblNewLabel);
	}

}
