// Original UDPSender class written on Java Sockets Programming worksheet
// found on University of Southampton module notes page for Distributed 
// Systems and Networks module notes page; modified portions commented

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class Ex3_UDPSender {
	public static void main(String [] args){
		try{
			InetAddress address = InetAddress.getByName("machine_name");
			DatagramPacket packet;
			DatagramSocket socket = new DatagramSocket();
			
			// Number of messages being sent increased and thread 
			// sleep call removed to speed up sender
			for(int i=0;i<100;i++){
				byte[] buf = String.valueOf(i).getBytes();
				packet = new DatagramPacket(buf, buf.length, address, 4321);
				socket.send(packet);
				
				System.out.println("send DatagramPacket "
				+ new String(packet.getData()) + " "
				+ packet.getAddress() + ":"
				+ packet.getPort());
			}
			socket.close();
		}
		catch(Exception e) {
			System.out.println("error");
		}
	}
}