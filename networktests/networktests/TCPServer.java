package networktests;

import java.lang.*;
import java.io.*;
import java.net.*;

class TCPServer {
	public static void main(String args[]) {
		int port = Integer.parseInt(args[0]);
		String data = "Toobie ornaught toobie";
		try {
			ServerSocket srvr = new ServerSocket(port);
			while (true) {
				Socket skt = srvr.accept();
				System.out.print("Server has a connection from " + skt.getPort() +" : " + skt.getLocalPort());
				PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
				System.out.print("Sending string: '" + data + "'\n");
				out.print(data);
				out.close();
				skt.close();
			}			
			//srvr.close();
		} catch (Exception e) {
			System.out.print("Whoops! It didn't work!\n");
		}
	}
}