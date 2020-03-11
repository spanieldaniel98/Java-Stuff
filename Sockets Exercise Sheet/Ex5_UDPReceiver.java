// Original UDPReceiver class written on Java Sockets Programming worksheet
// found on University of Southampton module notes page for Distributed 
// Systems and Networks module notes page; modified portions commented

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class Ex5_UDPReceiver {
	public static void main(String [] args) {
		try {
			InetAddress address = InetAddress.getByName("machine_name");
			DatagramSocket socket = new DatagramSocket(4323);
			DatagramPacket packet;
			byte[] buf = new byte[256];
			int ackCount = 0;
			
			for(int i=0;i<10;i++){
				packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);
				
				System.out.println("receive DatagramPacket "
				+ (new String(packet.getData())).trim() + " "
				+ packet.getAddress() + ":"
				+ packet.getPort());
				
				// Receiver sends reply to sender to acknowledge the receipt of each message
				ackCount += 1;
				buf = String.valueOf("ack" + ackCount).getBytes();
				packet = new DatagramPacket(buf, buf.length, address, 4322);
				socket.send(packet);
			}
			socket.close();
		} 
		catch(Exception e) {
			System.out.println("error "+e);
		}
	}
}