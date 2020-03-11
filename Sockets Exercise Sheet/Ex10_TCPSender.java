// Original TCPSender class written on Java Sockets Programming worksheet
// found on University of Southampton module notes page for Distributed 
// Systems and Networks module notes page; modified portions commented

import java.io.*;
import java.net.*;

class Ex10_TCPSender {
	public static void main(String [] args) {
		try {
			Socket socket = new Socket("machine_name",4322);
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			
			for(int i=0;i<10;i++){
				out.println("TCP message "+i); 
				out.flush();
				
				// Print out details of the machine which has connected to the sender
				System.out.println("TCP message "+i+" sent" + " from " +  socket.getInetAddress());
				
				Thread.sleep(1000);
			}
			
			socket.close();
		} 
		catch(Exception e) {
			System.out.println("error"+e);
		}
	}
}