import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server
{

    private boolean running;

    public Server()
    {
        this.running = true;
    }

    private HashMap<String, HashSet<String>> loadStorage ()
    {
        HashMap<String, HashSet<String>> storage = new HashMap<> ();
        try (Scanner in = new Scanner (new FileReader ("data/storage.txt"))){
            while (in.hasNext ())
            {
                String[] input = in.nextLine ().toLowerCase ().
                        replaceAll ("\\s+", "").split (":");

                String[] meanings_array = input[1].split(",");
                HashSet<String> meanings = new HashSet<String>(Arrays.asList(meanings_array));
                storage.put (input[0], meanings);
            }
            return storage;
        }
        catch (FileNotFoundException e)
        {
            System.err.println ("storage.txt File Not Found");
            return storage;
        }
    }

    public void startServer (int port)
    {
        HashMap<String, HashSet<String>> storage = loadStorage ();
        ExecutorService pool = Executors.newCachedThreadPool ();

        try (ServerSocket welcomingConnection = new ServerSocket (port)) {

            System.out.println ("Server with port : " + port +
                    " Started \nWaiting for Client .....");

            int client_counter = 1;

            while (running)
            {
                pool.execute (new ClientHandler (welcomingConnection.accept (),
                        client_counter,storage));
                System.out.println ("Server connected to new Client [Client-" + client_counter + "]");
                client_counter++;
            }

            pool.shutdown ();

        } catch (IOException e)
        {
            System.err.println ("Some thing went wrong with Server in I/O");
        }
    }

    public void downServer()
    {
        running = false;
    }

}
