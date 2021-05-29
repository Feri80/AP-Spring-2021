/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinawebserver;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 *
 * @author V5-561G
 */
public class SinaWebServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080); // Open 127.0.0.1:8080 with your browser.
        while (true) {
            try (Socket socket = server.accept()) { 
                if(socket.getInputStream().available() > 0){
                    DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                    while(dis.available() > 0){
                        System.out.print((char)dis.readByte());
                    }
                }
                Date today = new Date();
                String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + today ;
                socket.getOutputStream().write(httpResponse.getBytes("UTF-8"));
            }
        }
    }
    
}
