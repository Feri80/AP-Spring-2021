package Model;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Storage {

    private ArrayList<User> users;
    private ArrayList<Message> messages;
    private Semaphore semaphore;

    public Storage() {
        users = new ArrayList<> ();
        messages = new ArrayList<>();
        semaphore = new Semaphore (1);
    }

    public void addUser(User user) {
        try {
            semaphore.acquire ();
            if (user == null)
                return;
            users.add (user);
        } catch (InterruptedException e) {
            System.out.println (e.getMessage ());
        } finally {
            semaphore.release ();
        }
    }

    public void addMessage(Message message) {
        if (message == null){
            return;
        }
        messages.add(message);
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public User getUser (String username, String password) {
        try {
            semaphore.acquire ();
            User user1 = new User (username, password);
            for (User user : users) {
                if (user.equals (user1)) {
                    return user;
                }
            }
            return null;
        } catch (InterruptedException e) {
            System.out.println (e.getMessage());
            return null;
        } finally {
            semaphore.release ();
        }
    }

    public void printUsers() {
        for (User user : users){
            System.out.println(user);
        }
    }
}
