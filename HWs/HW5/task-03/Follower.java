import java.util.ArrayList;

public class Follower 
{
    private String name;
    private String id;
    private ArrayList<Channel> channels;

    public Follower(String name, String id)
    {
        this.name = name;
        this.id = id;
        channels = new ArrayList<Channel>();
    }

    public void update(Channel channel)
    {
        System.out.println("\nName : " + name + "\n" + channel.getReport() + "\n");
    }

    public void addChannel(Channel channel)
    {
        channels.add(channel);
    }

    public void removeChannel(Channel channel)
    {
        channels.remove(channel);
    }
}
