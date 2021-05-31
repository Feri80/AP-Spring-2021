import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Client
{
    public void startClient(String ip_addr, int port) {
        try (Socket connection = new Socket (ip_addr, port);
             DataInputStream in = new DataInputStream (connection.getInputStream ());
             DataOutputStream out = new DataOutputStream (connection.getOutputStream ())) {

            Scanner scanner = new Scanner (System.in);
            System.out.println ("connected to Server");
            while (true) {
                System.out.print ("enter word : ");
                String input = scanner.nextLine ().toLowerCase ().trim ();

                out.writeUTF (input);
                
                System.out.println (in.readUTF ());

                if (input.equals ("!finish")) {
                    break;
                }
            }

        } catch (IllegalArgumentException e) {
            System.err.println ("Some went Wrong in Client starting");
        } catch (ConnectException e) {
            System.err.println ("Couldn't connect to Server");
        } catch (SocketException e) {
            System.err.println ("Server Not Responding");
        } catch (IOException e) {
            System.err.println ("Some went Wrong in I/O");
        }
    }
}
