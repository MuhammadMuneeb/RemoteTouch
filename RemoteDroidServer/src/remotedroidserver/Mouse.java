/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remotedroidserver;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InterfaceAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Mouse {
    
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
                        if(line.contains("right_click")){
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
                        
                        else if(line.contains("div")){
                                try{
                                float scrollY = Float.parseFloat(line.split("d")[0]);
//                                String meh = line.split("-")[1];
//                                System.out.println(meh);
                                Point point = MouseInfo.getPointerInfo().getLocation(); //Get current mouse position
				float nowY = point.y;
                                if(scrollY>0){
                                 robot.mouseWheel(1);
                                            }
                                else{
                                    robot.mouseWheel(-1);
                                    }
                                }catch(NumberFormatException e){
                                e.getMessage();
                                }
                                
                        }
                else if(line.contains("copy")){
				                
                    robot.keyPress(KeyEvent.VK_CONTROL);
                    robot.keyPress(KeyEvent.VK_C);
                    robot.keyRelease(KeyEvent.VK_C);
                    robot.keyRelease(KeyEvent.VK_CONTROL);
			}
                else if(line.contains("paste")){
                    robot.keyPress(KeyEvent.VK_CONTROL);
                    robot.keyPress(KeyEvent.VK_V);
                    robot.keyRelease(KeyEvent.VK_V);
                    robot.keyRelease(KeyEvent.VK_CONTROL);			
                }else if(line.equalsIgnoreCase("openKeyboard")){
                                isConnected = false;
                                Keyboard keyboard = new Keyboard();
                                client.close();
                                server.close();
                                keyboard.actions();
                }else if(line.equalsIgnoreCase("went_back")){
                                isConnected = false;
                                Server serv = new Server();
                                client.close();
                                server.close();
                                serv.actions();
                        }
                        
                       
                        
                }catch (IOException e) {
				System.out.println("Read failed");
				System.exit(-1);
	        }catch(NullPointerException n){
                            System.out.println(n.getCause());
                }
}
}
}
