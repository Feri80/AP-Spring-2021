import java.util.ArrayList;

public class Club 
{
    private String name;
    private Channel matchesChannel;
    private Channel clubChannel;
    private ArrayList<Match> matches;
    private ArrayList<Player> players;
    private ArrayList<Follower> followers;

    public Club(String name)
    {
        this.name = name;
        matchesChannel = new Channel();
        clubChannel = new Channel();
        matches = new ArrayList<Match>();
        players = new ArrayList<Player>();
        followers = new ArrayList<Follower>();
    }

    public void addMatch(Match match)
    {
        matches.add(match);
        matchesChannel.setReport(new Report(match.getOpponent(), match.getDate().toString()));
    }

    public void addPlayer(Player player)
    {
        players.add(player);
    }

    public void removePlayer(Player player)
    {
        players.remove(player);
    }

    public void addFollower(Follower follower)
    {
        followers.add(follower);
    }
    
    public void removeFollower(Follower follower)
    {
        followers.remove(follower);
    }

    public Channel getMatchesChannel()
    {
        return matchesChannel;
    }

    public Channel getClubChannel()
    {
        return clubChannel;
    }
}
