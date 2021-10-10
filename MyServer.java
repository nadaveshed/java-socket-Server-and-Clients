package ttt;

import java.net.*;  
import java.io.*;  
class MyServer{  
	public static void main(String args[])throws Exception{  
		ServerSocket ss=new ServerSocket(3333);  
		Socket s=ss.accept();  
		DataInputStream din=new DataInputStream(s.getInputStream());  
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
		System.out.println("server");
		System.out.println("Listening on 127.0.0.1:3333");
		int rand = (int)(Math.random() * 10);  
		
		String str="",str2="";  
		while(!str.equals("stop")){  
			str=din.readUTF();  
			System.out.println("Received "+str + " from client [" + rand + "]");  
			str2=br.readLine();  
			dout.writeUTF(str2);  
			dout.flush();  
		}  
		din.close();  
		s.close();  
		ss.close();  
	}}  