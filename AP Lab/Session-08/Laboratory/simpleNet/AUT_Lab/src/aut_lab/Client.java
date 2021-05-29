/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aut_lab;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author V5-561G
 */
public class Client {
    
    public Client(){
        this.connect();
    }
    
    
    
    
    public void connect(){
        try { 
            Socket channel = new Socket("192.168.1.4" , 8080) ;
            channel.getOutputStream().write(this.toBytes("Hello Friend! \n"));
            while(true){
                while(channel.getInputStream().available() > 0){
                    DataInputStream dis = new DataInputStream(new BufferedInputStream(channel.getInputStream()));
                    System.out.println(dis.readLine());
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
