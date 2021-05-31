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

            int clientCounter = 0;

            while(clientCounter < 5)
            {
                Socket channel = server.accept();
                System.out.println("A New Client Accepted.");
                Thread thread = new Thread(new ClientHandler(channel));
                thread.start();
                clientCounter++;
            }     
            server.close();
        } 
        catch(Exception e) 
        {
            e.printStackTrace();
        }
    }

    
}
