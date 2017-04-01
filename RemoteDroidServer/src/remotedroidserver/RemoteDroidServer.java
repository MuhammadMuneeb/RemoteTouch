import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
 
public class RemoteDroidServer {
	
	private static ServerSocket server = null;
	private static Socket client = null;
	private static BufferedReader in = null;
	private static String line;
	private static boolean isConnected=true;
	private static Robot robot;
	private static final int SERVER_PORT = 8998;
        private String ipAddress;
 
	public static void main(String[] args) {
		boolean leftpressed=false;
		boolean rightpressed=false;
 
	    try{
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
			
			//Keyboard functions
			if(line.equalsIgnoreCase("q")){
				//Simulate press and release of key 'n'
				robot.keyPress(KeyEvent.VK_Q);
				robot.keyRelease(KeyEvent.VK_Q);
			}
			else if(line.equalsIgnoreCase("Q_caps")){
				//Simulate press and release of key 'p'
				robot.keyPress(KeyEvent.VK_SHIFT);
                                robot.keyPress(KeyEvent.VK_Q);
				
                                robot.keyRelease(KeyEvent.VK_Q);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
                                
                        }
			else if(line.equalsIgnoreCase("w")){
				//Simulate press and release of key 'p'
				robot.keyPress(KeyEvent.VK_W);
				robot.keyRelease(KeyEvent.VK_W);		        	
			}
                        else if(line.equalsIgnoreCase("e")){
				//Simulate press and release of key 'p'
				robot.keyPress(KeyEvent.VK_E);
				robot.keyRelease(KeyEvent.VK_E);		        	
			}
                        else if(line.equalsIgnoreCase("r")){
				//Simulate press and release of key 'p'
				robot.keyPress(KeyEvent.VK_R);
				robot.keyRelease(KeyEvent.VK_R);		        	
			}
                        else if(line.equalsIgnoreCase("t")){
				//Simulate press and release of key 'p'
				robot.keyPress(KeyEvent.VK_T);
				robot.keyRelease(KeyEvent.VK_T);		        	
			}
                        else if(line.equalsIgnoreCase("y")){
				//Simulate press and release of key 'p'
				robot.keyPress(KeyEvent.VK_Y);
				robot.keyRelease(KeyEvent.VK_Y);		        	
			}
                        else if(line.equalsIgnoreCase("a")){
				//Simulate press and release of key 'p'
				robot.keyPress(KeyEvent.VK_A);
				robot.keyRelease(KeyEvent.VK_A);		        	
			}
                        else if(line.equalsIgnoreCase("s")){
				//Simulate press and release of key 'p'
				robot.keyPress(KeyEvent.VK_S);
				robot.keyRelease(KeyEvent.VK_S);		        	
			}
                        else if(line.equalsIgnoreCase("d")){
				//Simulate press and release of key 'p'
				robot.keyPress(KeyEvent.VK_D);
				robot.keyRelease(KeyEvent.VK_D);		        	
			}else if(line.equalsIgnoreCase("f")){
				//Simulate press and release of key 'p'
				robot.keyPress(KeyEvent.VK_F);
				robot.keyRelease(KeyEvent.VK_F);		        	
			}else if(line.equalsIgnoreCase("g")){
				//Simulate press and release of key 'p'
				robot.keyPress(KeyEvent.VK_G);
				robot.keyRelease(KeyEvent.VK_G);		        	
			}else if(line.equalsIgnoreCase("h")){
				//Simulate press and release of key 'p'
				robot.keyPress(KeyEvent.VK_H);
				robot.keyRelease(KeyEvent.VK_H);		        	
			}else if(line.equalsIgnoreCase("j")){
				//Simulate press and release of key 'p'
				robot.keyPress(KeyEvent.VK_J);
				robot.keyRelease(KeyEvent.VK_J);		        	
			}else if(line.equalsIgnoreCase("l")){
				//Simulate press and release of key 'p'
				robot.keyPress(KeyEvent.VK_L);
				robot.keyRelease(KeyEvent.VK_L);		        	
			}else if(line.equalsIgnoreCase("z")){
				//Simulate press and release of key 'p'
				robot.keyPress(KeyEvent.VK_Z);
				robot.keyRelease(KeyEvent.VK_Z);		        	
			}else if(line.equalsIgnoreCase("x")){
				//Simulate press and release of key 'p'
				robot.keyPress(KeyEvent.VK_X);
				robot.keyRelease(KeyEvent.VK_X);		        	
			}else if(line.equalsIgnoreCase("c")){
				//Simulate press and release of key 'p'
				robot.keyPress(KeyEvent.VK_C);
				robot.keyRelease(KeyEvent.VK_C);		        	
			}else if(line.equalsIgnoreCase("v")){
				//Simulate press and release of key 'p'
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);		        	
			}else if(line.equalsIgnoreCase("b")){
				//Simulate press and release of key 'p'
				robot.keyPress(KeyEvent.VK_B);
				robot.keyRelease(KeyEvent.VK_B);		        	
			}else if(line.equalsIgnoreCase("n")){
				//Simulate press and release of key 'p'
				robot.keyPress(KeyEvent.VK_N);
				robot.keyRelease(KeyEvent.VK_N);		        	
			}else if(line.equalsIgnoreCase("m")){
				//Simulate press and release of key 'p'
				robot.keyPress(KeyEvent.VK_M);
				robot.keyRelease(KeyEvent.VK_M);		        	
			}
                        
                        
                        
                        //Mouse functions
                //if user taps on mousepad to simulate a left click
			else if(line.contains("right_click")){
				//Simulate press and release of mouse button 1(makes sure correct button is pressed based on user's dexterity)
				robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
			}

            //if user taps on mousepad to simulate a left click
			else if(line.contains("left_click")){
				//Simulate press and release of mouse button 1(makes sure correct button is pressed based on user's dexterity)
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			}
    
            //input will come in x,y format if user moves mouse on mousepad
			else if(line.contains(",")){
				float movex=Float.parseFloat(line.split(",")[0]);//extract movement in x direction
				float movey=Float.parseFloat(line.split(",")[1]);//extract movement in y direction
				Point point = MouseInfo.getPointerInfo().getLocation(); //Get current mouse position
				float nowx=point.x;
				float nowy=point.y;
				robot.mouseMove((int)(nowx+movex),(int)(nowy+movey));//Move mouse pointer to new location
			}
			//Exit if user ends the connection
			else if(line.equalsIgnoreCase("exit")){
				isConnected=false;
				//Close server and client socket
				server.close();
				client.close();
			}
	        } catch (IOException e) {
				System.out.println("Read failed");
				System.exit(-1);
	        }
      	}
 
//      InetAddress ip = null;
//            try {
//                ip = InetAddress.getLocalHost();
//            } catch (UnknownHostException ex) {
//                Logger.getLogger(RemoteDroidServer.class.getName()).log(Level.SEVERE, null, ex);
//            }
//      String add  = ip.getHostAddress();
//      System.out.println(add);
//            
 
}

        @SuppressWarnings("Convert2Lambda")
        public static void showGui(){
    if(!SystemTray.isSupported()){
        System.out.println("SystemTray is not supported");
            return;
    }
//    final PopupMenu popup = new PopupMenu();
//        final TrayIcon trayIcon =
//                new TrayIcon(createImage("images/bulb.gif", "tray icon"));
//        final SystemTray tray = SystemTray.getSystemTray();
//         // Create a popup menu components
//        MenuItem disIP = new MenuItem("Enter this in Device"+Inet4Address.getLocalHost().getHostAddress());
//        MenuItem exitItem = new MenuItem("Exit");
//        
//         //Add components to popup menu
//        popup.add(disIP);
//        popup.add(exitItem);
//        
//        trayIcon.setPopupMenu(popup);
//         exitItem.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                tray.remove(trayIcon);
//                System.exit(0);
//            }
//
//         
//         });
//                        }
//    
//    //Obtain the image URL
//    protected static Image createImage(String path, String description) {
//        URL imageURL = RemoteDroidServer.class.getResource(path);
//        
//        if (imageURL == null) {
//            System.err.println("Resource not found: " + path);
//            return null;
//        } else {
//            return (new ImageIcon(imageURL, description)).getImage();
//        }
//    }

}
}
