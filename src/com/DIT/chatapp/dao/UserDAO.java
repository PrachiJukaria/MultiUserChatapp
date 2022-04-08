package com.DIT.chatapp.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.DIT.chatapp.dto.UserDTO;
import com.DIT.chatapp.dto.UserDTOLogin;
import com.DIT.chatapp.utils.Encryption;

//USER CURD
public class UserDAO {
	
	public boolean isLogin(UserDTOLogin userDTOLogin) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		final String SQL="Select userid from users where userid=? and password = ?";
		
		try {
			con=CommonDAO.createConnection();
			pstmt=con.prepareStatement(SQL);
			pstmt.setString(1, userDTOLogin.getUserId());
			String encryptedPwd=Encryption.passwordEncrypt(new String(userDTOLogin.getPassword()));
			pstmt.setString(2, encryptedPwd);
			rs=pstmt.executeQuery();
			return rs.next();
		}
		finally {
			if(rs!=null)
			{
				rs.close();
			}
			if(pstmt!=null)
			{
				pstmt.close();
			}
			if(con!=null)
			{
				con.close();
			}
		}
	}
	
	public int add(UserDTO userDTO) throws ClassNotFoundException, SQLException, Exception
	{
		System.out.println(userDTO.getPassword() + " "+ userDTO.getUserId());
		Connection connection=null;
		Statement stmt=null;  //query
		try {  //Guarded region
		connection=CommonDAO.createConnection();  //step 1-connection created
		//step 2 we do a query
		stmt=connection.createStatement();
		int record=stmt.executeUpdate("Insert into users (userid,password,email,phoneNo,city) values('"+userDTO.getUserId()+"' , '"+Encryption.passwordEncrypt(new String(userDTO.getPassword()))+"','"+userDTO.getEmail()+ "' , '"+userDTO.getPhone()+"' , '"+userDTO.getCity() + "' );");   //insert,delete,update query
		return record;
		}
		finally {//always execute  (Resource cleanup)
		if(stmt!=null)
		{
		stmt.close();
		}
		if(connection!=null)
		{
		connection.close();
		}
		}
	}
	
	public int resetPassword(UserDTOLogin userDTOLogin) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException
	{
		Connection con=null;
		Statement stmt=null;
		final String SQL= "update users set password = ? where userid=?";
		try {
			con=CommonDAO.createConnection();
			stmt=con.createStatement();
			String encryptedPwd=Encryption.passwordEncrypt(new String(userDTOLogin.getPassword()));
			int record=stmt.executeUpdate("update users set password ='"+encryptedPwd+"' where userid ='"+userDTOLogin.getUserId()+"';");
			return record;
		}
		finally {
			
			if(stmt!=null)
			{
				stmt.close();
			}
			if(con!=null)
			{
				con.close();
			}
		}
		
	}
}
