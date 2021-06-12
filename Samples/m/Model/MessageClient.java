package Model;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

public class MessageClient implements Runnable {
    private String ip;
    private int port;
    private String data;
    private String request;
    private ArrayList<Message> messages;
    private boolean finished = false;


    public MessageClient (String request, String data) {
        messages = new ArrayList<>();
        this.ip = "127.0.0.1";
        this.port = 8083;
        this.data = data;
        this.request = request;

    }
    @Override
    public void run () {

        try (Socket connection = new Socket (ip,port);
             ObjectInputStream in = new ObjectInputStream (connection.getInputStream ());
             DataOutputStream out = new DataOutputStream (connection.getOutputStream ())) {

            String mes = request + "*" + data;
            out.writeUTF(mes);
            out.flush ();
            System.out.println ("-> data sent to Server : " + mes);

            // receive from server:
            if (request.equals("rec")) {
                messages = (ArrayList<Message>) in.readObject();
                System.out.println("<- data received from Server : " + messages);
                finished = true;
            }

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

    public ArrayList<Message> getResult() {
        if (finished) {
            return messages;
        }
        else
            return null;
    }
}
