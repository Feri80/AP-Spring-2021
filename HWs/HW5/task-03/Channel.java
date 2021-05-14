import java.util.ArrayList;

public class Channel 
{
    private Report report;
    private ArrayList<Follower> followers;

    public Channel()
    {
        followers = new ArrayList<Follower>();
    }

    public void addFollower(Follower follower)
    {
        followers.add(follower);
        follower.addChannel(this);
    }

    public void removeFollower(Follower follower)
    {
        followers.remove(follower);
    }

    public void setReport(Report report)
    {
        this.report = report;
        notifyAllFollowers();
    }

    public Report getReport()
    {
        return report;
    }

    public void notifyAllFollowers()
    {
        for(Follower f : followers)
        {
            f.update(this);
        }
    }
}
