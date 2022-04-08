package com.DIT.chatapp.network;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import com.DIT.chatapp.utils.configReader;

public class Client {
	Socket socket;
	public Client() throws UnknownHostException, IOException {
		int PORT=Integer.parseInt(configReader.getValue("PORTNO"));
		socket=new Socket(configReader.getValue("SERVER_IP"),PORT);
		System.out.println("Client comes..");
		System.out.print("Enter the message to send to the server....");
		Scanner sc=new Scanner(System.in);
		String message=sc.nextLine();
		OutputStream out=socket.getOutputStream();  //write bytes on the network
		out.write(message.getBytes());
		System.out.println("Message send to the server");
		sc.close();
		out.close();
		socket.close();
	}
	public static void main(String[] args) throws UnknownHostException, IOException
	{
		Client client=new Client();
		
	}
}
