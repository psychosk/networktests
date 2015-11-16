package networktests;

import java.io.*;
import java.net.*;

public class UDPClient {

	public static void main(String args[]) throws Exception {
		String url = args[0];
		int port = Integer.parseInt(args[1]);
		

		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName(url);
		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];
		String sentence = "smartsense";
		sendData = sentence.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
		
		System.out.println("Sending to "+IPAddress.getHostAddress()+ ":"+port+"?"+sendPacket.getPort()+"?"+sendPacket.getSocketAddress()+"?"+clientSocket.getLocalPort());
		clientSocket.send(sendPacket);
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		clientSocket.receive(receivePacket);
		String modifiedSentence = new String(receivePacket.getData());
		System.out.println("FROM SERVER:" + modifiedSentence);
		clientSocket.close();
	}

}
