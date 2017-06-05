/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remotedroidserver;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author MMHaq
 */
public class Server {
    private static ServerSocket server = null;
	private static Socket client = null;
	private static BufferedReader in = null;
	private static String line;
	private static boolean isConnected=true;
	private static Robot robot;
	private static final int SERVER_PORT = 11258;
        private String ipAddress;
        static InterfaceAddress addr;
        
        
            private String getYourIp(String defaultAddress) {

        String temp = defaultAddress.substring(0, 11);
        String ipToForward = "";

        TreeSet<String> ipAddrs = getIpAddressList();
        for (Iterator<String> iterator = ipAddrs.iterator(); iterator.hasNext();) {

            String tempIp = iterator.next();
            if (tempIp.contains(temp)) {
                ipToForward = tempIp;
                break;
            }
        }

        return ipToForward;

    }// ipForPortForwarding

private TreeSet<String> getIpAddressList() {
        TreeSet<String> ipAddrs = new TreeSet<String>();

        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface
                    .getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface iface = interfaces.nextElement();
                // filters out 127.0.0.1 and inactive interfaces
                if (iface.isLoopback() || !iface.isUp())
                    continue;

                Enumeration<InetAddress> addresses = iface.getInetAddresses();
                while (addresses.hasMoreElements()) {

                    InetAddress addr = addresses.nextElement();

                    ipAddrs.add(addr.getHostAddress());

                }// 2 nd while
            }// 1 st while
        } catch (SocketException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return ipAddrs;

    }// getIpAddressList

    // get default gateway address in java

    private String getDefaultGateWayAddress() {
        String defaultAddress = "";
        try {
            Process result = Runtime.getRuntime().exec("netstat -rn");

            BufferedReader output = new BufferedReader(new InputStreamReader(
                    result.getInputStream()));

            String line = output.readLine();
            while (line != null) {
                if (line.contains("0.0.0.0")) {

                    StringTokenizer stringTokenizer = new StringTokenizer(line);
                    stringTokenizer.nextElement();// first string is 0.0.0.0
                    stringTokenizer.nextElement();// second string is 0.0.0.0
                    defaultAddress = (String) stringTokenizer.nextElement(); // this is our default address
                    break;
                }

                line = output.readLine();

            }// while
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return defaultAddress;

    }// getDefaultAddress   
    
    //Prepare to make connections
    public static void actions(){
                    try{
	    		robot = new Robot();
                        isConnected = true;
			server = new ServerSocket(SERVER_PORT); //Create a server socket on port 8998
			client = server.accept(); //Listens for a connection to be made to this socket and accepts it
			System.out.println("Running");
                        in = new BufferedReader(new InputStreamReader(client.getInputStream())); //the input stream where data will come from client
		}catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}catch (AWTException e) {
			System.out.println("Error in creating robot instance");
			System.exit(-1);
		}
                    director();
    }	
    
    static void  director(){
		//read input from client while it is connected
	    while(isConnected){
	        try{
			line = in.readLine(); //read input from client
			System.out.println(line); //print whatever we get from client
			//Keyboard functions
                        if(line.equalsIgnoreCase("keyboard")){
                                isConnected = false;
                                Keyboard keyboard = new Keyboard();
                                client.close();
                                server.close();
                                System.out.println("Heading for keyboard");
                                keyboard.actions();
                        }
                        else if(line.equalsIgnoreCase("mouse")){
                                isConnected = false;
                                Mouse mouse = new Mouse();
                                client.close();
                                server.close();
                                System.out.println("Heading for mouse");
                                mouse.actions();
                                
                        }
                        else if(line.equalsIgnoreCase("gamepad")){
                            isConnected = false;
                            Gamepad gp = new Gamepad();
                            client.close();
                            server.close();
                            System.out.println("Gamepad");
                            gp.actions();
                        }
                        else if(line.equalsIgnoreCase("qrscanner")){
                            isConnected = false;
                            QRCode qr = new QRCode();
                            client.close();
                            server.close();
                            System.out.println("QRScanner");
                            qr.actions();
                        }else if(line.equalsIgnoreCase("exit")){
                            isConnected = false;
                            client.close();
                            server.close();
                            System.exit(0);
                        }
                        
                }catch(NullPointerException n){
                    System.out.println(n.getMessage()+n.getCause());
                }catch(IOException i){
                    System.out.println(i.getCause()+ i.getMessage());
                }
            
            }            
            
    
 
}
    
    public static void main(String[] args) {
	       
                //Stuff to get IP
                Server rmServer = new Server();
                String yourIP = rmServer.getYourIp(rmServer
                .getDefaultGateWayAddress());
                if(yourIP.isEmpty()){
                    try {
                        yourIP = Inet4Address.getLocalHost().getHostAddress();
                    } catch (UnknownHostException ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                System.out.println("YourIP is:" +yourIP);
                JOptionPane.showMessageDialog(null, "Enter this IP on your Phone: "+yourIP);
                actions();
        }
    
    
}
