
import java.io.*;
import java.net.*;
import java.lang.*;
import java.util.*;

public class server {

public static void main (String[] args) throws IOException {

    try {
        int PORT = 8889;
        ServerSocket welcomeSocket = new ServerSocket(PORT);
        int count  = 0;
        while (true) {    
            // Create the Client Socket
            Socket clientSocket = welcomeSocket.accept();
            System.out.println("Socket Extablished...");
            count++;
            // Create input and output streams to client
            ObjectOutputStream outToClient = new ObjectOutputStream(clientSocket.getOutputStream());
            ObjectInputStream inFromClient = new ObjectInputStream(clientSocket.getInputStream());


            /* Create Message object and retrive information */
            LinkedList<String> inList = new LinkedList<String>();
            String inMsg = null;
            inList = (LinkedList<String>)inFromClient.readObject();
            inMsg = inList.pop();

            String outMsg = inMsg + " Ho Ho" + count;
            LinkedList<String> outList = new LinkedList<String>();
            outList.push(outMsg);

            /* Send the modified Message object back */
            outToClient.writeObject(outList);        

        }

    } catch (Exception e) {
        System.err.println("Server Error: " + e.getMessage());
        System.err.println("Localized: " + e.getLocalizedMessage());
        System.err.println("Stack Trace: " + e.getStackTrace());
        System.err.println("To String: " + e.toString());
    }
}
}
