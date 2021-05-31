public class ClientMain
{
    public static void main (String[] args) {
        Client client = new Client ();
        client.startClient ("127.0.0.1", 8080);
    }
}
