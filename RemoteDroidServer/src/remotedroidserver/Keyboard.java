/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remotedroidserver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InterfaceAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author MMHaq
 */
public class Keyboard {
        private static ServerSocket server = null;
	private static Socket client = null;
	private static BufferedReader in = null;
	private static String line;
	private static boolean isConnected=true;
	private static Robot robot;
	private static final int SERVER_PORT = 8998;
        private String ipAddress;
        static InterfaceAddress addr;

public static void actions(){
                    try{
                        isConnected = true;
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
			//Keyboard functions
                        		//Keyboard functions
                        
                        //small alphabets
			if(line.equalsIgnoreCase("q")){
				//Simulate press and release of key 'q'
				robot.keyPress(KeyEvent.VK_Q);
				robot.keyRelease(KeyEvent.VK_Q);
			}
			
			else if(line.equalsIgnoreCase("w")){
				//Simulate press and release of key 'w'
				robot.keyPress(KeyEvent.VK_W);
				robot.keyRelease(KeyEvent.VK_W);		        	
			}
                        else if(line.equalsIgnoreCase("e")){
				//Simulate press and release of key 'e'
				robot.keyPress(KeyEvent.VK_E);
				robot.keyRelease(KeyEvent.VK_E);		        	
			}
                        else if(line.equalsIgnoreCase("r")){
				//Simulate press and release of key 'r'
				robot.keyPress(KeyEvent.VK_R);
				robot.keyRelease(KeyEvent.VK_R);		        	
			}
                        else if(line.equalsIgnoreCase("t")){
				//Simulate press and release of key 't'
				robot.keyPress(KeyEvent.VK_T);
				robot.keyRelease(KeyEvent.VK_T);		        	
			}
                        else if(line.equalsIgnoreCase("y")){
				//Simulate press and release of key 'y'
				robot.keyPress(KeyEvent.VK_Y);
				robot.keyRelease(KeyEvent.VK_Y);		        	
			}
                        else if(line.equalsIgnoreCase("u")){
				//Simulate press and release of key 'u'
				robot.keyPress(KeyEvent.VK_U);
				robot.keyRelease(KeyEvent.VK_U);		        	
			}
                        else if(line.equalsIgnoreCase("i")){
				//Simulate press and release of key 'i'
				robot.keyPress(KeyEvent.VK_I);
				robot.keyRelease(KeyEvent.VK_I);		        	
			}
                        else if(line.equalsIgnoreCase("o")){
				//Simulate press and release of key 'o'
				robot.keyPress(KeyEvent.VK_O);
				robot.keyRelease(KeyEvent.VK_O);		        	
			}
                        else if(line.equalsIgnoreCase("p")){
				//Simulate press and release of key 'p'
				robot.keyPress(KeyEvent.VK_P);
				robot.keyRelease(KeyEvent.VK_P);		        	
			}
                        else if(line.equalsIgnoreCase("a")){
				//Simulate press and release of key 'a'
				robot.keyPress(KeyEvent.VK_A);
				robot.keyRelease(KeyEvent.VK_A);		        	
			}
                        else if(line.equalsIgnoreCase("s")){
				//Simulate press and release of key 's'
				robot.keyPress(KeyEvent.VK_S);
				robot.keyRelease(KeyEvent.VK_S);		        	
			}
                        else if(line.equalsIgnoreCase("d")){
				//Simulate press and release of key 'd'
				robot.keyPress(KeyEvent.VK_D);
				robot.keyRelease(KeyEvent.VK_D);		        	
			}else if(line.equalsIgnoreCase("f")){
				//Simulate press and release of key 'f'
				robot.keyPress(KeyEvent.VK_F);
				robot.keyRelease(KeyEvent.VK_F);		        	
			}else if(line.equalsIgnoreCase("g")){
				//Simulate press and release of key 'g'
				robot.keyPress(KeyEvent.VK_G);
				robot.keyRelease(KeyEvent.VK_G);		        	
			}else if(line.equalsIgnoreCase("h")){
				//Simulate press and release of key 'h'
				robot.keyPress(KeyEvent.VK_H);
				robot.keyRelease(KeyEvent.VK_H);		        	
			}else if(line.equalsIgnoreCase("j")){
				//Simulate press and release of key 'j'
				robot.keyPress(KeyEvent.VK_J);
				robot.keyRelease(KeyEvent.VK_J);
                                }
                        else if(line.equalsIgnoreCase("k")){
				//Simulate press and release of key 'k'
				robot.keyPress(KeyEvent.VK_K);
				robot.keyRelease(KeyEvent.VK_K);		        	
			}
                        else if(line.equalsIgnoreCase("l")){
				//Simulate press and release of key 'l'
				robot.keyPress(KeyEvent.VK_L);
				robot.keyRelease(KeyEvent.VK_L);		        	
			}else if(line.equalsIgnoreCase("z")){
				//Simulate press and release of key 'z'
				robot.keyPress(KeyEvent.VK_Z);
				robot.keyRelease(KeyEvent.VK_Z);		        	
			}else if(line.equalsIgnoreCase("x")){
				//Simulate press and release of key 'x'
				robot.keyPress(KeyEvent.VK_X);
				robot.keyRelease(KeyEvent.VK_X);		        	
			}else if(line.equalsIgnoreCase("c")){
				//Simulate press and release of key 'c'
				robot.keyPress(KeyEvent.VK_C);
				robot.keyRelease(KeyEvent.VK_C);		        	
			}else if(line.equalsIgnoreCase("v")){
				//Simulate press and release of key 'v'
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);		        	
			}else if(line.equalsIgnoreCase("b")){
				//Simulate press and release of key 'b'
				robot.keyPress(KeyEvent.VK_B);
				robot.keyRelease(KeyEvent.VK_B);		        	
			}else if(line.equalsIgnoreCase("n")){
				//Simulate press and release of key 'n'
				robot.keyPress(KeyEvent.VK_N);
				robot.keyRelease(KeyEvent.VK_N);		        	
			}else if(line.equalsIgnoreCase("m")){
				//Simulate press and release of key 'm'
				robot.keyPress(KeyEvent.VK_M);
				robot.keyRelease(KeyEvent.VK_M);		        	
			}
                        //Uppercase
                        else if(line.equalsIgnoreCase("Q_caps")){
				
                                robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_Q);
				robot.keyRelease(KeyEvent.VK_Q);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
			}
                        else if(line.equalsIgnoreCase("W_caps")){
				
                                robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_W);
				robot.keyRelease(KeyEvent.VK_W);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
			}
                        else if(line.equalsIgnoreCase("E_caps")){
				
                                robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_E);
				robot.keyRelease(KeyEvent.VK_E);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
			}
                        else if(line.equalsIgnoreCase("R_caps")){
				
                                robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_R);
				robot.keyRelease(KeyEvent.VK_R);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
			}
                        else if(line.equalsIgnoreCase("T_caps")){
				
                                robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_T);
				robot.keyRelease(KeyEvent.VK_T);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
			}
                        else if(line.equalsIgnoreCase("Y_caps")){
				
                                robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_Y);
				robot.keyRelease(KeyEvent.VK_Y);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
			}
                        else if(line.equalsIgnoreCase("U_caps")){
				
                                robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_U);
				robot.keyRelease(KeyEvent.VK_U);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
			}
                        else if(line.equalsIgnoreCase("I_caps")){
				
                                robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_I);
				robot.keyRelease(KeyEvent.VK_I);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
			}
                        else if(line.equalsIgnoreCase("O_caps")){
				
                                robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_O);
				robot.keyRelease(KeyEvent.VK_O);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
			}
                        else if(line.equalsIgnoreCase("P_caps")){
				
                                robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_P);
				robot.keyRelease(KeyEvent.VK_P);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
			}
                        else if(line.equalsIgnoreCase("A_caps")){
				
                                robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_A);
				robot.keyRelease(KeyEvent.VK_A);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
			}
                        else if(line.equalsIgnoreCase("S_caps")){
				
                                robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_S);
				robot.keyRelease(KeyEvent.VK_S);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
			}
                        else if(line.equalsIgnoreCase("D_caps")){
				
                                robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_D);
				robot.keyRelease(KeyEvent.VK_D);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
			}
                        else if(line.equalsIgnoreCase("F_caps")){
				
                                robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_F);
				robot.keyRelease(KeyEvent.VK_F);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
			}
                        else if(line.equalsIgnoreCase("G_caps")){
				
                                robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_G);
				robot.keyRelease(KeyEvent.VK_G);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
			}
                        else if(line.equalsIgnoreCase("H_caps")){
				
                                robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_H);
				robot.keyRelease(KeyEvent.VK_H);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
			}
                        else if(line.equalsIgnoreCase("J_caps")){
				
                                robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_J);
				robot.keyRelease(KeyEvent.VK_J);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
			}
                        else if(line.equalsIgnoreCase("K_caps")){
				
                                robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_K);
				robot.keyRelease(KeyEvent.VK_K);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
			}
                        else if(line.equalsIgnoreCase("L_caps")){
				
                                robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_L);
				robot.keyRelease(KeyEvent.VK_L);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
			}
                        else if(line.equalsIgnoreCase("Z_caps")){
				
                                robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_Z);
				robot.keyRelease(KeyEvent.VK_Z);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
			}
                        else if(line.equalsIgnoreCase("X_caps")){
				
                                robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_X);
				robot.keyRelease(KeyEvent.VK_X);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
			}
                        else if(line.equalsIgnoreCase("C_caps")){
				
                                robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_C);
				robot.keyRelease(KeyEvent.VK_C);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
			}
                        else if(line.equalsIgnoreCase("V_caps")){
				
                                robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
			}
                        else if(line.equalsIgnoreCase("B_caps")){
				
                                robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_B);
				robot.keyRelease(KeyEvent.VK_B);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
			}
                        else if(line.equalsIgnoreCase("N_caps")){
				
                                robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_N);
				robot.keyRelease(KeyEvent.VK_N);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
			}
                        else if(line.equalsIgnoreCase("M_caps")){
				
                                robot.keyPress(KeyEvent.VK_SHIFT);
				robot.keyPress(KeyEvent.VK_M);
				robot.keyRelease(KeyEvent.VK_M);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
			}
                        //Numeric keypresses
                        else if(line.equalsIgnoreCase("0")){
                                robot.keyPress(KeyEvent.VK_0);
                                robot.keyRelease(KeyEvent.VK_0);
                        }
                        else if(line.equalsIgnoreCase("1")){
                                robot.keyPress(KeyEvent.VK_1);
                                robot.keyRelease(KeyEvent.VK_1);
                        }
                        else if(line.equalsIgnoreCase("2")){
                                robot.keyPress(KeyEvent.VK_2);
                                robot.keyRelease(KeyEvent.VK_2);
                        }
                        else if(line.equalsIgnoreCase("3")){
                                robot.keyPress(KeyEvent.VK_3);
                                robot.keyRelease(KeyEvent.VK_3);
                        }
                        else if(line.equalsIgnoreCase("4")){
                                robot.keyPress(KeyEvent.VK_4);
                                robot.keyRelease(KeyEvent.VK_4);
                        }
                        else if(line.equalsIgnoreCase("5")){
                                robot.keyPress(KeyEvent.VK_5);
                                robot.keyRelease(KeyEvent.VK_5);
                        }
                        else if(line.equalsIgnoreCase("6")){
                                robot.keyPress(KeyEvent.VK_6);
                                robot.keyRelease(KeyEvent.VK_6);
                        }
                        else if(line.equalsIgnoreCase("7")){
                                robot.keyPress(KeyEvent.VK_7);
                                robot.keyRelease(KeyEvent.VK_7);
                        }
                        else if(line.equalsIgnoreCase("8")){
                                robot.keyPress(KeyEvent.VK_8);
                                robot.keyRelease(KeyEvent.VK_8);
                        }
                        else if(line.equalsIgnoreCase("9")){
                                robot.keyPress(KeyEvent.VK_9);
                                robot.keyRelease(KeyEvent.VK_9);
                        }
                        //Symbols
                        
                        else if(line.equalsIgnoreCase("!")){
                                robot.keyPress(KeyEvent.VK_SHIFT);
                                robot.keyPress(KeyEvent.VK_1);
                                robot.keyRelease(KeyEvent.VK_1);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
                        } 
                        else if(line.equalsIgnoreCase("@")){
                                robot.keyPress(KeyEvent.VK_AT);
                                robot.keyRelease(KeyEvent.VK_AT);
                                }
                        else if(line.equalsIgnoreCase("#")){
                                robot.keyPress(KeyEvent.VK_SHIFT);
                                robot.keyPress(KeyEvent.VK_3);
                                robot.keyRelease(KeyEvent.VK_3);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        else if(line.equalsIgnoreCase("$")){
                                robot.keyPress(KeyEvent.VK_SHIFT);
                                robot.keyPress(KeyEvent.VK_4);
                                robot.keyRelease(KeyEvent.VK_4);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        else if(line.equalsIgnoreCase("%")){
                                robot.keyPress(KeyEvent.VK_SHIFT);
                                robot.keyPress(KeyEvent.VK_5);
                                robot.keyRelease(KeyEvent.VK_5);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        else if(line.equalsIgnoreCase("^")){
                                robot.keyPress(KeyEvent.VK_SHIFT);
                                robot.keyPress(KeyEvent.VK_6);
                                robot.keyRelease(KeyEvent.VK_6);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        else if(line.equalsIgnoreCase("&")){
                                robot.keyPress(KeyEvent.VK_SHIFT);
                                robot.keyPress(KeyEvent.VK_7);
                                robot.keyRelease(KeyEvent.VK_7);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        else if(line.equalsIgnoreCase("*")){
                                robot.keyPress(KeyEvent.VK_SHIFT);
                                robot.keyPress(KeyEvent.VK_8);
                                robot.keyRelease(KeyEvent.VK_8);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        else if(line.equalsIgnoreCase("(")){
                                robot.keyPress(KeyEvent.VK_SHIFT);
                                robot.keyPress(KeyEvent.VK_9);
                                robot.keyRelease(KeyEvent.VK_9);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        else if(line.equalsIgnoreCase(")")){
                                robot.keyPress(KeyEvent.VK_SHIFT);
                                robot.keyPress(KeyEvent.VK_0);
                                robot.keyRelease(KeyEvent.VK_0);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        else if(line.equalsIgnoreCase("_")){
                                robot.keyPress(KeyEvent.VK_SHIFT);
                                robot.keyPress(KeyEvent.VK_MINUS);
                                robot.keyRelease(KeyEvent.VK_MINUS);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        else if(line.equalsIgnoreCase("-")){
                                robot.keyPress(KeyEvent.VK_MINUS);
                                robot.keyRelease(KeyEvent.VK_MINUS);
                        }
                        else if(line.equalsIgnoreCase("=")){
                                robot.keyPress(KeyEvent.VK_EQUALS);
                                robot.keyRelease(KeyEvent.VK_EQUALS);
                        }
                        else if(line.equalsIgnoreCase("+")){
                                robot.keyPress(KeyEvent.VK_SHIFT);
                                robot.keyPress(KeyEvent.VK_EQUALS);
                                robot.keyRelease(KeyEvent.VK_EQUALS);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        else if(line.equalsIgnoreCase("{")){
                                robot.keyPress(KeyEvent.VK_SHIFT);
                                robot.keyPress(KeyEvent.VK_BRACELEFT);
                                robot.keyRelease(KeyEvent.VK_BRACELEFT);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        else if(line.equalsIgnoreCase("}")){
                                robot.keyPress(KeyEvent.VK_SHIFT);
                                robot.keyPress(KeyEvent.VK_BRACERIGHT);
                                robot.keyRelease(KeyEvent.VK_BRACERIGHT);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        else if(line.equalsIgnoreCase(":")){
                                robot.keyPress(KeyEvent.VK_SHIFT);
                                robot.keyPress(KeyEvent.VK_SEMICOLON);
                                robot.keyRelease(KeyEvent.VK_SEMICOLON);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        else if(line.equalsIgnoreCase("\"")){
                                robot.keyPress(KeyEvent.VK_QUOTEDBL);
                                robot.keyRelease(KeyEvent.VK_QUOTEDBL);
                        }
                        else if(line.equalsIgnoreCase("<")){
                                robot.keyPress(KeyEvent.VK_SHIFT);
                                robot.keyPress(KeyEvent.VK_COMMA);
                                robot.keyRelease(KeyEvent.VK_COMMA);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        else if(line.equalsIgnoreCase(">")){
                                robot.keyPress(KeyEvent.VK_SHIFT);
                                robot.keyPress(KeyEvent.VK_PERIOD);
                                robot.keyRelease(KeyEvent.VK_PERIOD);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        else if(line.equalsIgnoreCase("?")){
                                robot.keyPress(KeyEvent.VK_SHIFT);
                                robot.keyPress(KeyEvent.VK_SLASH);
                                robot.keyRelease(KeyEvent.VK_SLASH);
                                robot.keyRelease(KeyEvent.VK_SHIFT);
                        }
                        else if(line.equalsIgnoreCase("[")){
                                robot.keyPress(KeyEvent.VK_BRACELEFT);
                                robot.keyRelease(KeyEvent.VK_BRACELEFT);
                        }
                        else if(line.equalsIgnoreCase("]")){
                                robot.keyPress(KeyEvent.VK_BRACERIGHT);
                                robot.keyRelease(KeyEvent.VK_BRACERIGHT);
                        }
                        
                        else if(line.equalsIgnoreCase(";")){
                                robot.keyPress(KeyEvent.VK_SEMICOLON);
                                robot.keyRelease(KeyEvent.VK_SEMICOLON);
                        }
                        else if(line.equalsIgnoreCase("'")){
                                robot.keyPress(KeyEvent.VK_QUOTE);
                                robot.keyRelease(KeyEvent.VK_QUOTE);
                        }
                        else if(line.equalsIgnoreCase(",")){
                                robot.keyPress(KeyEvent.VK_COMMA);
                                robot.keyRelease(KeyEvent.VK_COMMA);
                        }
                        else if(line.equalsIgnoreCase(".")){
                                robot.keyPress(KeyEvent.VK_PERIOD);
                                robot.keyRelease(KeyEvent.VK_PERIOD);
                        }
                        else if(line.equalsIgnoreCase("/")){
                                robot.keyPress(KeyEvent.VK_SLASH);
                                robot.keyRelease(KeyEvent.VK_SLASH);
                        }
                        else if(line.equalsIgnoreCase("\\")){
                                robot.keyPress(KeyEvent.VK_BACK_SLASH);
                                robot.keyRelease(KeyEvent.VK_BACK_SLASH);
                        }
                        else if(line.equalsIgnoreCase("enter")){
                                robot.keyPress(KeyEvent.VK_ENTER);
                                robot.keyRelease(KeyEvent.VK_ENTER);
                        }
                        else if(line.equalsIgnoreCase("backspace")){
                                robot.keyPress(KeyEvent.VK_BACK_SPACE);
                                robot.keyRelease(KeyEvent.VK_BACK_SPACE);
                        }
                        else if(line.equalsIgnoreCase("space")){
                                robot.keyPress(KeyEvent.VK_SPACE);
                                robot.keyRelease(KeyEvent.VK_SPACE);
                        }else if(line.equalsIgnoreCase("openMouse")){
                                isConnected = false;
                                Mouse mouse = new Mouse();
                                client.close();
                                server.close();
                                mouse.actions();
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
