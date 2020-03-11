// Original TCPReceiverThreaded class written on Java Sockets Programming 
// worksheet found on University of Southampton module notes page for Distributed 
// Systems and Networks module notes page; modified portions commented

import java.io.*;
import java.net.*;

class Ex11_TCPReceiverThreaded {
	public static void main(String [] args){
		try{
			ServerSocket ss = new ServerSocket(4323);
			for(;;){
				try{
					final Socket client = ss.accept();
					
					new Thread(new Runnable(){
						public void run(){
							try{
								
								// Socket and PrintWriter instantiated for sending 
								// acknowledgement of receiving a message to sender
								Socket socket = new Socket("machine_name",4322);
								PrintWriter out = new PrintWriter(socket.getOutputStream());
								
								BufferedReader in = new BufferedReader(
								new InputStreamReader(client.getInputStream()));
								String line;
								
								while((line = in.readLine()) != null) {
									System.out.println(line+" received");
									
									// Send acknowledgement of receiving a message to sender
									out.println("ack"); 
									out.flush();
								}
								socket.close();
								
							} catch(Exception e) {}
						}
					}).start();
					
				} catch(Exception e) {
					System.out.println("error "+e);
				}
			}
		} catch(Exception e) {
			System.out.println("error "+e);
		}
	}
}