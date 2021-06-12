package Model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private boolean running;
    private int clientId;
    private ExecutorService pool;
    private int port;
    private Storage storage;

    public Server (int port) {
        pool = Executors.newCachedThreadPool ();
        running = true;
        clientId = 0;
        this.port = port;
        this.storage = new Storage();
    }


    public void startServer () {
        try (ServerSocket welcomingConnection = new ServerSocket (port)) {
            System.out.println ("Server with port : " + port + " Started \nWaiting for Client .....");

            while (running)
            {
                Socket connection = welcomingConnection.accept();
                pool.execute (new ClientHandler (connection, clientId, port, storage));
                System.out.println ("Server with port : " + port + " connected to new Client : Client " + clientId);
                clientId++;

                storage.printUsers();
            }
            pool.shutdown ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
}

class ServerRun {
    public static void main(String[] args) {
        Server server = new Server(8083);
        server.startServer();
    }
}
