/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sinawebserver2;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author V5-561G
 */
public class SinaWebServer2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception { 
        String html = "<!DOCTYPE html>\n" + 
                    "<html>" +
                    "<head>" +
                    "<title>AUT LAB.</title>" +
                    "</head>" +
                    "<body >" +
                    "<b>Hello Students :)</b>" +
                    "<br/>" +
                    "<p>This is Sina Saadati :) <br/> I hope you the best! </p>" +
                    "<img src=\"https://s4.uupload.ir/files/sina_saadati_aqjn.jpg\"  width=\"500\" height=\"600\">" + 
                    "</body>" +
                    "</html>" ;
        
        ServerSocket server = new ServerSocket(8080); // Open 127.0.0.1:8080 with your browser.
        while(true){
            try(Socket channel = server.accept()){
                channel.getOutputStream().write( ("HTTP/1.1 200 OK\r\n\r\n" + html).getBytes("UTF-8") ) ;
            }
        }
                
                
    }
    
}
