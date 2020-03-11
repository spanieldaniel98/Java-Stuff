// Original FTClient class written on Java Sockets Programming worksheet
// found on University of Southampton module notes page for Distributed 
// Systems and Networks module notes page; modified portions commented

import java.io.*;
import java.net.*;

public class Ex14_FTClient {
	public static void main(String[] args) throws IOException {
		
		System.out.println(args[0]+" "+args[1]+" "+args[2]+" "+args[3]);
		
		if(args[1].equals("put")) {
			
			// Check if input file needed to execute put command exists, and 
			// if not, print  out error message and notify the server
			if(!new File(args[2]).exists()) {
				Socket socket = new Socket(args[0],4323);
				OutputStream out = socket.getOutputStream();
				System.out.println("Could not locate input file " + args[2]);
				out.write(("noput " + args[2]).getBytes());
				out.close();
				socket.close();
				return;
			}
			
			File inputFile = new File(args[2]);
			FileInputStream in = new FileInputStream(inputFile);
			try {
				Socket socket = new Socket(args[0],4323);
				OutputStream out = socket.getOutputStream();
				
				out.write(("put"+" "+args[3]+" ").getBytes());
				byte[] buf = new byte[1000]; int buflen;
				
				while ((buflen=in.read(buf)) != -1){
				System.out.print("*");
				out.write(buf,0,buflen);
				}
				out.close();
				socket.close();
			
			} catch(Exception e) {
				System.out.println("error"+e);
			}
			
			System.out.println();
			in.close();
		} 
		
		else if(args[1].equals("get")) {
			
			// Check if input file needed to execute get command exists, and 
		    // if not, print  out error message and notify the server
			if(!new File(args[3]).exists()) {
				Socket socket = new Socket(args[0],4323);
				OutputStream out = socket.getOutputStream();
				System.out.println("Could not locate input file " + args[3]);
				out.write(("noget " + args[3]).getBytes());
				out.close();
				socket.close();
				return;
			}
			
			File outputFile = new File(args[2]);
			FileOutputStream outf = new FileOutputStream(outputFile);
			
			try{
				Socket socket = new Socket(args[0],4323);
				OutputStream out = socket.getOutputStream();
				InputStream in = socket.getInputStream();
				
				out.write(("get"+" "+args[3]+" ").getBytes());
				byte[] buf = new byte[1000]; int buflen;
				
				while ((buflen=in.read(buf)) != -1){
				System.out.print("*");
				outf.write(buf,0,buflen);
				}
				out.close();
				in.close();
				socket.close();
				
			} catch(Exception e) {
				System.out.println("error"+e);
			}
			
			System.out.println();
			outf.close();
		}
		
		else { 
			System.out.println("unrecognised command");
		}
	}
}