import java.io.DataInputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * This class contains the client and its methods 
 * 
 * @author Farhad Aman
 * @version 1.0
 */
public class Client 
{
    
    /**
     * the main method of client that do most of its process
     * @param args
     */
    public static void main(String[] args) 
    {
        try 
        {
            Socket channel = new Socket("localhost",8080);
            
            DataInputStream in = new DataInputStream(channel.getInputStream());

            boolean isOver = false;
            while(isOver == false)
            {
                while(in.available() > 0)
                {
                    String s = in.readLine();
                    System.out.println(s);
                    isOver = true;
                }
                if(isOver == true)
                {
                    break;
                }
                Scanner input = new Scanner(System.in);
                String s = input.nextLine();
                channel.getOutputStream().write(toBytes(s + "\n"));     
                if(s.equals("over"))
                {
                    Thread.sleep(1000);
                }   
            }
            in.close();
            channel.close();
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
