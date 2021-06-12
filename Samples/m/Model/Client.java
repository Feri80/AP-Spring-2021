package Model;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;

public class Client implements Runnable {
    private String ip;
    private int port;
    private String request;
    private User user;
    private String username;
    private String password;
    private boolean finished = false;


    public Client (String ip, String username, String password, String request) {
        this.ip = ip;
        this.port = 8083;
        this.request = request;
        this.username = username;
        this.password = password;
    }
    @Override
    public void run () {

        try (Socket connection = new Socket (ip,port);
             ObjectInputStream in = new ObjectInputStream (connection.getInputStream ());
             DataOutputStream out = new DataOutputStream (connection.getOutputStream ())) {

            String data = request + "*" + username + "*" + password;
            out.writeUTF(data);
            out.flush ();
            System.out.println ("-> data sent to Server : " + data);

            // receive from server:
            user = (User) in.readObject ();
            System.out.println ("<- data received from Server : " + user);
            finished = true;

        }
        catch (ConnectException e) {
            System.err.println ("Couldn't connect to Server");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace ();
        } catch (SocketException e) {
            System.err.println ("Server Not Responding");
        } catch (IOException e) {
            System.err.println ("Something went Wrong");
        }
    }

    public User getResult() {
        if (finished) {
            return user;
        }
        else
            return null;
    }
}
