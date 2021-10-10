package ttt;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author 5442
 */
public class ThreadClient {
	public static void main(String[] args) throws IOException {
		final String HOST = "127.0.0.1";
		final int PORT = 4040;
		int sum = 1;
		int id = (int)(Math.random() * 10);  

		System.out.println("Client 127.0.0.1 4040.");
		System.out.println(String.valueOf(id));
		
		try (
				Socket socket = new Socket(HOST, PORT);
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

				Scanner in = new Scanner(socket.getInputStream());
				Scanner s = new Scanner(System.in);
				
				) {
			while (true) {
				System.out.print("Input: ");
				String input = s.nextLine();
				sum *= Integer.valueOf(input);
				input = String.valueOf(sum);
				out.println(sum);

				if (input.equalsIgnoreCase("exit")) break;
				System.out.println(in.nextLine());
			}
		}
	}

}