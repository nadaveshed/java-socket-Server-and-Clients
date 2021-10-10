package ttt;

import java.net.*;  
import java.io.*;  
class MyServer2{  
	public static void main(String args[])throws Exception{  
		ServerSocket ss=new ServerSocket(3334);  
		Socket s=ss.accept();  
		DataInputStream din=new DataInputStream(s.getInputStream());  
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
		System.out.println("server");
		System.out.println("Listening on 127.0.0.1:3334");
		int rand = (int)(Math.random() * 10);  

		String str="",str2="";  
		while(!str.equals("stop")){  
			str=din.readUTF();  
			System.out.println("Received "+str + " from client [" + rand + "]");  
//			str2=br.readLine();  
			dout.writeUTF(str);  
			dout.flush();  
		}  
		din.close();  
		s.close();  
		ss.close();  
	}}  