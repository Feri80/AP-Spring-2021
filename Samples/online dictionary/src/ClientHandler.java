import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.HashSet;

public class ClientHandler implements Runnable
{

    private int client_id;
    private Socket connection;
    private HashMap<String, HashSet<String>> storage;

    public ClientHandler(Socket connection, int client_id, HashMap<String, HashSet<String>> storage)
    {
        this.connection = connection;
        this.client_id = client_id;
        this.storage = storage;
    }

    @Override
    public void run () {

        try (DataInputStream in = new DataInputStream (connection.getInputStream ());
                DataOutputStream out = new DataOutputStream (connection.getOutputStream ()))
        {
            while (true)
            {
                String word = in.readUTF ();
                if (word.equals ("!finish"))
                {
                    out.writeUTF ("good bye :)");
                    break;
                }
                else
                {
                    HashSet<String> meanings = storage.get (word);
                    if (meanings == null)
                        out.writeUTF ("Sorry word is not in data base\n");
                    else {
                        StringBuilder answer = new StringBuilder ();

                        for (String meaning : meanings)
                            answer.append ("-> ").append (meaning).append ('\n');

                        out.writeUTF (answer.toString ());
                    }

                }
            }
            System.out.println ("Server closed [Client-" + client_id + "] connection");
        }
        catch (SocketException e)
        {
            System.err.println ("[Client-" + client_id + "]" + " connection Terminated");
        } catch (IOException e) {
            System.err.println ("Some thing went wrong with [Client-" + client_id + "] in I/O");
        }
    }
}
