package Model;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class ClientHandler implements Runnable{
    private Socket connection;
    private int id;
    private int port;
    private Storage storage;


    public ClientHandler (Socket connection, int id, int port, Storage storage)
    {
        this.connection = connection;
        this.id = id;
        this.port = port;
        this.storage = storage;
    }

    @Override
    public void run () {

        try (DataInputStream in = new DataInputStream (connection.getInputStream ());
             ObjectOutputStream out = new ObjectOutputStream (connection.getOutputStream ()))
        {
                // receive
            User user = null;
            System.out.println ("<- data received from client " + id);
            String message = in.readUTF ();
            String[] split = message.split ("\\*");

            if (split[0].equals ("Login")) {
                user = storage.getUser(split[1], split[2]);

                // send to client
                out.writeObject (user);
                System.out.println (port + "-> data sent to client " + id);
            }
            else if (split[0].equals ("SignUp")){
                // must be checked that user does not already exist!
                user = new User (split[1], split[2]);
                storage.addUser (user);

                // send to client
                out.writeObject (user);
                System.out.println (port + "-> data sent to client " + id);
            }
            else if (split[0].equals ("send")){
                Message textMessage = new Message (split[1], split[2], split[3]);
                storage.addMessage (textMessage);

                //An acknowledgment must be sent
                System.out.println (port + "<- message received from client: " + split[1]);

            }
            else if (split[0].equals ("rec")){
                System.out.println("Messages");
                System.out.println(storage.getMessages());
                out.writeObject (storage.getMessages());
                System.out.println (port + "-> messages sent to client: " + storage.getMessages());

            }

        } catch (SocketException e) {
            System.err.println (port
                    + "Client " + id + " 's connection Terminated");
        } catch (IOException e) {
            System.err.println (port
                    + "Some thing went wrong with Client " + id);
        } finally {
            try {
                connection.close ();
                System.out.println (port
                        + "Client " + id + " closed");
            }
            catch (SocketException ignore) {
            }
            catch (IOException e) {
                System.err.println (port
                        + "Some thing went wrong in closing client " + id +
                        " connection");
            }
        }
    }
}
