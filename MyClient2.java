package ttt;

import java.net.*;  
import java.io.*;  
class MyClient2{  
	public static void main(String args[])throws Exception{  
		Socket s=new Socket("localhost",3334);  
		DataInputStream din=new DataInputStream(s.getInputStream());  
		DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
		System.out.println("Client 127.0.0.1 3334");

		String str="",str2="";  
		int sum = 0;
		while(!str2.equals("stop")){  
			str = br.readLine();
			if (str.contains("[a-zA-Z]+") == false && str.length() > 0){
				str = "0";
			}
			sum += Integer.valueOf(str);
			str = String.valueOf(sum);
			dout.writeUTF(str);  
			dout.flush();  
			str2=din.readUTF();  
			System.out.println("Received sum is "+str + " from server");  
		}  

		dout.close();  
		s.close();  
	}}  
