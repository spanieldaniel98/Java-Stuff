// Original UDPSender class written on Java Sockets Programming worksheet
// found on University of Southampton module notes page for Distributed 
// Systems and Networks module notes page; modified portions commented

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

class Ex5_UDPSender {
	public static void main(String [] args){
		try{
			InetAddress address = InetAddress.getByName("machine_name");
			DatagramSocket socket = new DatagramSocket(4322);
			DatagramPacket packet;
			byte[] buf;
			
			for(int i=0;i<10;i++){
				buf = String.valueOf(i).getBytes();
				packet = new DatagramPacket(buf, buf.length, address, 4323);
				socket.send(packet);
				
				System.out.println("send DatagramPacket "
				+ new String(packet.getData()) + " "
				+ packet.getAddress() + ":"
				+ packet.getPort());
				
				// Sender waits for acknowledgement from receiver that a message
				// was sent before sending the next message
				buf = new byte[256];
				socket.receive(new DatagramPacket(buf, buf.length));
				System.out.println("received acknowledgement; sending next packet...");
				
				Thread.sleep(2000);
			}
			socket.close();
		}
		catch(Exception e) {
			System.out.println("error");
		}
	}
}