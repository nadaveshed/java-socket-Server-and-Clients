package ttt;

import java.net.*;  
import java.io.*;  
class MyClient{  
	public static void main(String args[])throws Exception{  
		Socket s=new Socket("localhost",3333);  
		DataInputStream din=new DataInputStream(s.getInputStream());  
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
		System.out.println("Client 127.0.0.1 3333");

		String str="",str2="";  
		while(!str2.equals("stop")){  
			int rand = (int)(Math.random() * 10);  
			str = String.valueOf(rand);
			dout.writeUTF(str);  
			dout.flush();  
			str2=din.readUTF();  
			System.out.println("Received "+str + " from server");  
		}  

		dout.close();  
		s.close();  
	}}  
