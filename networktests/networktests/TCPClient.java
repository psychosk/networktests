package networktests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {

	   public static void main(String args[]) {
		   String address = args[0];
		   int port = Integer.parseInt(args[1]);
		      try {
		         Socket skt = new Socket(address, port);
		         BufferedReader in = new BufferedReader(new
		            InputStreamReader(skt.getInputStream()));
		         System.out.print("Received string: '");

		         while (!in.ready()) {}
		         System.out.println(in.readLine()); // Read one line and output it

		         System.out.print("'\n");
		         in.close();
		      }
		      catch(Exception e) {
		         System.out.print("Whoops! It didn't work!\n");
		      }
		   }
	
}
