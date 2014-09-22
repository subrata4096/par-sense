import java.io.*;
import java.net.*;
import java.lang.*;
import java.util.*;

public class client {

public static void main(String[] args) throws IOException {
    try {
        String HOST = "mensa.ecn.purdue.edu";
	int PORT = 8889; 
        // Create the socket
        Socket clientSocket = new Socket(HOST, PORT);
        // Create the input & output streams to the server
        ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
        ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());

        /* Create The Message Object to send */
        LinkedList<String> msgList = new LinkedList<String>();
        String msg  = new String("It is me");
        msgList.push(msg);

        /* Send the Message Object to the server */
        outToServer.writeObject(msgList);            

        /* Retrive the Message Object from server */
        LinkedList<String> inFromServerList = new LinkedList<String>();
        String msgFrmServer = null;
        inFromServerList = (LinkedList<String>)inFromServer.readObject();
        msgFrmServer = inFromServerList.pop();

        /* Print out the recived Message */
        System.out.println("Message: " + msgFrmServer);


        clientSocket.close();

    } catch (Exception e) {
        System.err.println("Client Error: " + e.getMessage());
        System.err.println("Localized: " + e.getLocalizedMessage());
        System.err.println("Stack Trace: " + e.getStackTrace());
    }
}
}
