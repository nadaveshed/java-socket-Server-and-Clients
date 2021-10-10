package ttt;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class ThreadServer {
	public static void main(String[] args) throws IOException {
		final int PORT = 4040;
		ServerSocket serverSocket = new ServerSocket(PORT);
		
		System.out.println("server");
		System.out.println("Listening on 127.0.0.1:4040");

		while (true) {
			Socket clientSocket = serverSocket.accept();
			Thread t = new Thread() {
				public void run() {
					try (
							PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
							Scanner in = new Scanner(clientSocket.getInputStream());
							) {
						while (in.hasNextLine()) {
							String input = in.nextLine();
							if (input.equalsIgnoreCase("exit")) {
								break;
							}
							System.out.println("Received " + input + " from client [" + "1" + "]");

							out.println("Received sum is " + input + " from server");
						}
					} catch (IOException e) { }
				}
			};
			t.start();
		}
	}   
}