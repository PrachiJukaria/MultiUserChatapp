package com.DIT.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.DIT.chatapp.utils.configReader;

public class Server {
	ServerSocket serverSocket;
	public Server() throws IOException {
		int PORT=Integer.parseInt(configReader.getValue("PORTNO"));
		serverSocket=new ServerSocket(PORT);
		System.out.println("Server Started and waiting for the client connection......");
		Socket socket=serverSocket.accept();  //accepts the connection from client also known as handshaking
		System.out.println("Client join the server");
		InputStream in=socket.getInputStream();  //reads bytes from the network
		byte arr[]=in.readAllBytes();
		String message=new String(arr);   //Bytes convert into string
		System.out.println("Message recieved from the client "+message);
		in.close();
		socket.close();
		
	}

	public static void main(String[] args) throws IOException {
		Server server=new Server();
	}

}
