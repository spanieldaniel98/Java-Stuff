// Original UDPReceiver class written on Java Sockets Programming worksheet
// found on University of Southampton module notes page for Distributed 
// Systems and Networks module notes page; modified portions commented

import java.net.DatagramPacket;
import java.net.DatagramSocket;

class Ex3_UDPReceiver {
	public static void main(String [] args) {
		try {
			DatagramSocket socket = new DatagramSocket(4321);
			DatagramPacket packet;
			byte[] buf = new byte[256];
			
			// Number of messages being received increased and thread 
			// sleep call added to slow down receiver
			for(int i=0;i<100;i++){
				packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);
				
				System.out.println("receive DatagramPacket "
				+ (new String(packet.getData())).trim() + " "
				+ packet.getAddress() + ":"
				+ packet.getPort());
				
				Thread.sleep(2000);
			}
			socket.close();
		} 
		catch(Exception e) {
			System.out.println("error "+e);
		}
	}
}