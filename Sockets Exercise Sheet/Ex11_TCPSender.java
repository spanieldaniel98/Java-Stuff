// Original TCPSender class written on Java Sockets Programming worksheet 
// found on University of Southampton module notes page for Distributed 
// Systems and Networks module notes page; modified portions commented

import java.io.*;
import java.net.*;

class Ex11_TCPSender {
	public static void main(String [] args) {
		try {
			Socket socket = new Socket("machine_name",4323);
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			
			for(int i=0;i<10;i++){
				
				// Send message
				out.println("TCP message "+i); 
				out.flush();
				System.out.println("TCP message "+i+" sent");
				
				try{
					// Sockets and BufferedReader instantiated for receiving
					// acknowledgement from receiver of receiving a message
					ServerSocket ss = new ServerSocket(4322);
					final Socket client = ss.accept();
					BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			
					// Receive acknowledgement from receiver that they have
					// received sent message, before sending next line
					while((in.readLine()) == "ack") {
						System.out.println("ack received");
					}
					client.close();
					
				} catch(Exception e) {}
				
				Thread.sleep(1000);
			}
			socket.close();
		} 
		catch(Exception e) {
			System.out.println("error"+e);
		}
	}
}