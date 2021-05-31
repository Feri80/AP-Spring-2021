import java.io.DataInputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * This class handles a new client with multithreading
 * 
 * @author Farhad Aman  
 * @version 1.0
 */
public class ClientHandler implements Runnable
{
    private Socket channel; 

    public ClientHandler(Socket channel)
    {
        this.channel = channel;
    }

    @Override
    public void run() 
    {
        try 
        {
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
                    out.write(toBytes("received" + "\n"));
                }
            }
            out.close();
            in.close();
            channel.close();
        } 
        catch (Exception e) 
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