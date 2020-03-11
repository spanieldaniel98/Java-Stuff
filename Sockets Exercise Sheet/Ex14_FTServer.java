// Original FTServer class written on Java Sockets Programming worksheet
// found on University of Southampton module notes page for Distributed 
// Systems and Networks module notes page; modified portions commented

import java.io.*;
import java.net.*;
public class Ex14_FTServer {
	public static void main(String[] args) throws IOException {
		try{
			ServerSocket ss = new ServerSocket(4323);
			
			for(;;){
					try{
						System.out.println("waiting for connection");
						Socket client = ss.accept();
						System.out.println("connected");
							
						InputStream in = client.getInputStream();
						byte[] buf = new byte[1000]; 
						int buflen = in.read(buf);
							
						String firstBuffer = new String(buf,0,buflen);
						int firstSpace = firstBuffer.indexOf(" ");
						String command = firstBuffer.substring(0,firstSpace);
							
						// If server is notified by client that input file given as argument to 
						// put command doesn't exist, print out error message
						if(command.equals("noput")) {
							String fileName = firstBuffer.substring(firstSpace+1);
							System.out.println("Put request sent but could not locate input file " + fileName);
							ss.close();
							return;
						}
						
						// If server is notified by client that input file given as argument to 
						// get command doesn't exist, print out error message
						if(command.equals("noget")) {
							String fileName = firstBuffer.substring(firstSpace+1);
							System.out.println("Get request sent but could not locate input file " + fileName);
							ss.close();
							return;
						}
							
						if(command.equals("put")) {
							System.out.println("command "+command);
								
							int secondSpace = firstBuffer.indexOf(" ",firstSpace+1);
							String fileName = firstBuffer.substring(firstSpace+1,secondSpace);
								
							System.out.println("fileName "+fileName);
								
							File outputFile = new File(fileName);
							FileOutputStream out = new FileOutputStream(outputFile);
								
							out.write(buf,secondSpace+1,buflen-secondSpace-1);
								
							while ((buflen = in.read(buf)) != -1) {
								System.out.print("*");
								out.write(buf,0,buflen);
							}
								
							in.close(); 
							client.close(); 
							out.close();
						} 
							
						else if(command.equals("get")) {
							System.out.println("command "+command);
								
							int secondSpace = firstBuffer.indexOf(" ",firstSpace+1);
							String fileName = firstBuffer.substring(firstSpace+1,secondSpace);
							
							System.out.println("fileName "+fileName);
								
							File inputFile = new File(fileName);
							FileInputStream inf = new FileInputStream(inputFile);
							OutputStream out = client.getOutputStream();
								
							while ((buflen=inf.read(buf)) != -1) {
								System.out.print("*");
								out.write(buf,0,buflen);
							}
								
							in.close(); 
							inf.close(); 
							client.close(); 
							out.close();
						} 
							
						else {
							System.out.println("unrecognised command");
							ss.close();
						}
					} catch(Exception e) {
						System.out.println("error "+e);
					}
		}
	} catch(Exception e) {
		System.out.println("error "+e);
	}
	System.out.println();
	}
}