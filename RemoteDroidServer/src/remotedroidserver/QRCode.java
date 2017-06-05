    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remotedroidserver;
import java.net.HttpURLConnection;
import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InterfaceAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URI;
import java.net.URLConnection;

/**
 *
 * @author MMHaq
 */
public class QRCode {
              private static ServerSocket server = null;
	private static Socket client = null;
	private static BufferedReader in = null;
	private static String line;
	private static boolean isConnected=true;
	private static Robot robot;
	private static final int SERVER_PORT = 11258;
        private String ipAddress;
        static InterfaceAddress addr;

public static void actions(){
                    try{
                        isConnected=true;
	    		robot = new Robot();
			server = new ServerSocket(SERVER_PORT); //Create a server socket on port 8998
			client = server.accept(); //Listens for a connection to be made to this socket and accepts it
			in = new BufferedReader(new InputStreamReader(client.getInputStream())); //the input stream where data will come from client
		}catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}catch (AWTException e) {
			System.out.println("Error in creating robot instance");
			System.exit(-1);
		}
			
		//read input from client while it is connected
	    while(isConnected){
	        try{
			line = in.readLine(); //read input from client
			System.out.println(line); //print whatever we get from client
			System.out.println("We got connected");
                        if(line.contains("URL")){
                    String str = line;
                    String[] parts = str.split("~");
                    String url = parts[1];
                    
                    System.out.println("The url is: "+url);
//                    Desktop desktop = Desktop.getDesktop();
//                    desktop.browse(URI.create(url));
                    Runtime rt = Runtime.getRuntime();
                    rt.exec( "rundll32 url.dll,FileProtocolHandler " + url);
                        }else if(line.equalsIgnoreCase("went_back")){
                                isConnected = false;
                                Server serv = new Server();
                                client.close();
                                server.close();
                                serv.actions();
                        }
                } catch (IOException e) {
				System.out.println("Read failed");
				System.exit(-1);
	        }catch(NullPointerException n){
                            System.out.println(n.getCause());
                }
                
    
}
}
}
