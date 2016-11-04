/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketsredes;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketImpl;
import java.net.UnknownHostException;
import java.nio.channels.DatagramChannel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLServerSocket;

/**
 *
 * @author bruno
 */
public class SocketsRedes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException {
        // TODO code application logic here
        System.err.println("Test");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        DatagramSocket client = new DatagramSocket();
        
        InetAddress IPAddress = null;
        try {
            IPAddress = InetAddress.getByName("uol.com.br");
        } catch (UnknownHostException ex) {
            Logger.getLogger(SocketsRedes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        
        DatagramPacket receivePacket = null;
        
        try {
            String sentence = in.readLine();
            // falout
            sendData = sentence.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);

            client.send(sendPacket);

            receivePacket = new DatagramPacket(receiveData, receiveData.length);

            client.receive(receivePacket);

            

        } catch (Exception e) {
        }
        
        String modified = new String(receivePacket.getData());
        
        System.err.println(modified);
        
        // server
        // ...
        
        // TCP
        try {
            ServerSocket welcomeSocket = new ServerSocket(123);
            
            Socket connectionSocket = welcomeSocket.accept();
            
        } catch (IOException ex) {
            Logger.getLogger(SocketsRedes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        // Cliente TCP
        
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        
        Socket clientSocket = new Socket("uol.com.br", 6789);
        
        BufferedReader inFromServer= new BufferedReader(...);
        
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        
        sentence = inFromUser.readLine();
        
        outToServer.writeBytes(sentence + '\n');
        
        
        // Server TCP
        ServerSocket welcomeSocket = new ServerSocket(6789);
        
        while(true) {
            
            Socket connectionSocket;
            try {
                connectionSocket = welcomeSocket.accept(); //qnd recebe pedido de conexao ele retorna o connection socket
            } catch (IOException ex) {
                Logger.getLogger(SocketsRedes.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            
            clientSentence = inFromClient
                
                
            
        }
                )
    }
    
}
