package networktests;

import java.io.*;
import java.net.*;

class UDPServer {
	public static void main(String args[]) throws Exception {
		Integer port = Integer.parseInt(args[0]);
		DatagramSocket serverSocket = new DatagramSocket(port);
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		while (true) {
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);
			String sentence = new String(receivePacket.getData());
			System.out.println("RECEIVED: " + sentence);
			InetAddress IPAddress = receivePacket.getAddress();
			int returnPort = receivePacket.getPort();
			String capitalizedSentence = sentence.toUpperCase();
			sendData = capitalizedSentence.getBytes();
			System.out.println("Sending back to "+IPAddress.getHostAddress()+":"+returnPort);
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, returnPort);
			serverSocket.send(sendPacket);
		}
	}

}
