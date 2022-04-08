package com.DIT.chatapp.views;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UserView extends JFrame{
	int count;
	public UserView(){
		count=0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		setResizable(false);  //to avoid changing the size of the frame;
		setTitle("Login");
//		setLocation(500,150);
		setLocationRelativeTo(null);  //to display the screen in center
		JLabel welcome=new JLabel("Login");
		welcome.setFont(new Font("Arial",Font.BOLD,40));
		Container container=this.getContentPane();
		container.setLayout(null);
		welcome.setBounds(100,70,200,60);
		container.add(welcome);
		JButton  button = new JButton("Count");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event)
			{
				count++;
				welcome.setText("Count "+count);
			}
		});
		button.setBounds(100,300,200,50);
		container.add(button);
		
		setVisible(true);   //to make the frame visible
	}
	public static void main(String[] args)
	{
		UserView userView= new UserView();
	}
}
