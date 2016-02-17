package Sockets;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class ReceptorDatagram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			DatagramSocket serverSocket = new DatagramSocket(5555);
	        byte[] receiveData = new byte[255];
	        byte[] sendData = new byte[8];
	        
	        for (int i = 0; i <= 1; i++) {
	        	DatagramPacket receivePacket = new DatagramPacket(
	        			receiveData, receiveData.length);
		        serverSocket.receive(receivePacket);
		        String sentence = new String( receivePacket.getData());
		        System.out.println("RECEIVED: " + sentence);
		        InetAddress IPAddress = InetAddress.getByName("localhost");
		        DatagramPacket sendPacket = new DatagramPacket(
		        		sendData, sendData.length, IPAddress, 5555);
		        serverSocket.send(sendPacket);
			}
	        serverSocket.close();
	        
	        /*
	        System.out.println("Creando socket datagrama");
			InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
			DatagramSocket datagramSocket = new DatagramSocket(addr);
			
			System.out.println("Recibiendo mensaje");
			byte[] mensaje = new byte[25];
			DatagramPacket datagramal = new DatagramPacket(mensaje, 25);
			datagramSocket.receive(datagramal) ;
			
			System.out.println("Mensaje recibido: "+new String(mensaje));
			System.out.println("Enviando mensaje");
			InetAddress addr2 = InetAddress.getByName("localhost");
			DatagramPacket datagrama2 = new DatagramPacket(mensaje, mensaje.length, addr2 , 5556);
			datagramSocket.send(datagrama2 ) ;
			
			System.out.println("Mensaje enviado");
			System.out.println("Cerrando el socket datagrama");
			datagramSocket.close() ;
			System.out.println("Terminado");
	        */
	        
		}catch (IOException e) {
			e.printStackTrace();
		}

	}

}
