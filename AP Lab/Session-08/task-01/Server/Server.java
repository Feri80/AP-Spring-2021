import java.io.DataInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class contains the server and its methods
 * 
 * @author Farhad Aman
 * @version 1.0
 */
public class Server 
{
    

    /**
     * the main metod of the server that contain most of the servers process
     */
    public static void main(String[] args) 
    {
        try 
        {
            ServerSocket server = new ServerSocket(8080);
            System.out.println("Wait For A Client To Join.");
            Socket channel = server.accept();
            System.out.println("Client Accepted.");

            DataInputStream in = new DataInputStream(channel.getInputStream());
            OutputStream out = channel.getOutputStream();

            String finalOutput = "";
            boolean isOver = false;
            while(isOver == false)
            {                

                while(in.available() > 0)
                {
                    String s = in.readLine();
                    finalOutput += s + " ";
                    if(s.equals("over"))
                    {
                        out.write(toBytes(finalOutput + "\n"));
                    }
                    System.out.println(s);
                }
            }
            out.close();
            in.close();
            channel.close();
            server.close();
        } 
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }

    /**
     * converts a String to a buffer of bytes
     * @param text
     * @return a buffer of bytes
     */
    public static byte[] toBytes(String text)
    {
        char[] chars = text.toCharArray();
        byte[] bytes = new byte[chars.length]; 
        for(int i = 0; i < bytes.length; i++) 
        {
            bytes[i] = (byte)chars[i] ; 
        }
        return bytes; 
    }
}
