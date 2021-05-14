import java.util.Date;

public class Main 
{
    

    public static void main(String[] args) 
    {
        Club c1 = new Club("Real Madrid");
        Club c2 = new Club("Barcelona");

        Player p1 = new Player("Messi", 20, "1111");
        Player p2 = new Player("Ramos", 20, "2222");
        Player p3 = new Player("Griezmann", 20, "3333");
        Player p4 = new Player("Benzema", 20, "4444");

        c1.addPlayer(p2);
        c1.addPlayer(p4);
        c2.addPlayer(p1);
        c2.addPlayer(p3);

        Follower f1 = new Follower("ali", "1234");
        Follower f2 = new Follower("mohammad", "1111");
        Follower f3 = new Follower("mahdi", "2222");

        c1.addFollower(f1);
        c1.addFollower(f2);
        c2.addFollower(f1);
        c2.addFollower(f3);
        
        c1.getClubChannel().addFollower(f1);
        c1.getMatchesChannel().addFollower(f1);
        c2.getClubChannel().addFollower(f1);
        p3.getChannel().addFollower(f1);

        p2.getChannel().addFollower(f2);
        p4.getChannel().addFollower(f2);
        c1.getClubChannel().addFollower(f2);
       
        p1.getChannel().addFollower(f3);
        c2.getClubChannel().addFollower(f3);
        c2.getMatchesChannel().addFollower(f3);

        p1.getChannel().setReport(new Report("delivery", "aaaaaaa"));
        p2.getChannel().setReport(new Report("delivery", "bbbbbbb"));
        p3.getChannel().setReport(new Report("delivery", "ccccccc"));
        p4.getChannel().setReport(new Report("delivery", "ddddddd"));

        c1.addMatch(new Match("Barcelona", new Date()));
        c2.addMatch(new Match("Real Madrid", new Date()));

        c1.getClubChannel().setReport(new Report("new player", "aaaaaaaaaaa"));
        c2.getClubChannel().setReport(new Report("new player", "bbbbbbbbbbb"));
    }
}
