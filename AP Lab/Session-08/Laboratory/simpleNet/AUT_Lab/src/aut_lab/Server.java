/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aut_lab;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author V5-561G
 */
public class Server {
    
    public Server(){
        this.start();
    }
    
    
    public void start(){
        try {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Server is listening.");
            Socket channel = server.accept();
            System.out.println("A new Channel started.");
            DataInputStream in = new DataInputStream(new BufferedInputStream(channel.getInputStream()));
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(channel.getOutputStream()));
            while(true){
                while(in.available() > 0){
                    System.out.println(in.readLine());
                    channel.getOutputStream().write(this.toBytes("Received. \n"));
                }
            }
        } catch (IOException ex) {
            System.err.println(ex.toString());
        }
    }
    
    
    
    
    public byte [] toBytes(String text){
        char [] chars = text.toCharArray();
        byte [] bytes = new byte[chars.length] ; 
        for (int i = 0; i < bytes.length ; i++) {
            bytes[i] = (byte) chars[i] ; 
        }
        return bytes ; 
    }
    
    
    
}
