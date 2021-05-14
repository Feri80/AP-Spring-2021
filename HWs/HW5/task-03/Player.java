public class Player 
{
    private String name;
    private int age;
    private String id;
    private Channel channel;

    public Player(String name, int age, String id)
    {
        this.name = name;
        this.age = age;
        this.id = id;
        this.channel = new Channel();
    }

    public Channel getChannel()
    {
        return channel;
    }
}
