
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author manthanhd
 */
public class MessageListener extends Thread {
	
	public String line = "";
    private String name;
    ServerSocket server;
    int port = 8877;
    WritableGUI gui;
    public boolean turn = true;
    
    public MessageListener(WritableGUI gui, int port, String name){
        this.port = port;
        this.gui = gui;
        this.name = name;
        try {
            server = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(MessageListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public MessageListener(){
        try {
            server = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(MessageListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String gLine() {
    	return line;
    }
    
    @Override
    public void run() {
        Socket clientSocket;
        try {
            while((clientSocket = server.accept()) != null){
                InputStream is = clientSocket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is)); 
                line = br.readLine();
                if(line != null && !line.equals("X1")&& !line.equals("X2")&& !line.equals("X3")&& !line.equals("X4")&& !line.equals("X5")&& !line.equals("X6")
                																			   && !line.equals("X7")&& !line.equals("X8")&& !line.equals("X9")
                			    && !line.equals("O1")&& !line.equals("O2")&& !line.equals("O3")&& !line.equals("O4")&& !line.equals("O5")&& !line.equals("O6")
                																			   && !line.equals("O7")&& !line.equals("O8")&& !line.equals("O9")									   
                				&& !line.equals("Good job player O you won!") && !line.equals("Good job player X you won!") && !line.equals("Its a tie!")){
                    gui.write(name + ": " + line);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(MessageListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}