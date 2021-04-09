import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * This class contains a voting and its details
 * 
 * @author Farhad Aman
 * @version 1.0
 */
public class Voting 
{
    /**
     * type of the voting
     */
    private int type;
    /**
     * question of the voting
     */
    private String question;
    /**
     * list of voters
     */
    private ArrayList<Person> voters;
    /**
     * list of polls
     */
    private HashMap<String, HashSet<Vote>> polls;

    /**
     * creates a new voting
     * @param type
     * @param question
     */
    public Voting(int type, String question)
    {
        this.type = type;
        this.question = question;
        voters = new ArrayList<Person>();
        polls = new HashMap<String, HashSet<Vote>>();
    }

    /**
     * returns question
     * @return question
     */
    public String getQuestion()
    {
        return question;
    }

    /**
     * creates a new poll
     * @param choice
     */
    public void createPoll(String choice)
    {
        polls.put(choice, new HashSet<Vote>());
    }

    /**
     * submits a new vote
     * @param person
     * @param choices
     */
    public void vote(Person person, ArrayList<String> choices)
    {
        if(voters.size() > 0)
        {
            if(voters.contains(person))
            {
                System.out.println("This person already voted.");
                return;
            }
        }
        if(type == 0)
        {
            if(choices.size() > 1)
            {
                System.out.println("Just One Choice.");
                return;
            }
        }
        for(String s : choices)
        {
            Vote vote = new Vote(person);
            polls.get(s).add(vote);
        }
        voters.add(person);
    }

    /**
     * returns voters
     * @return voters
     */
    public ArrayList<Person> getVoters()
    {
        return voters;
    }

    /**
     * returns polls
     * @return polls
     */
    public HashMap<String, HashSet<Vote>> getPolls()
    {
        return polls;
    }

    /**
     * print result of voting
     */
    public void printResult()
    {
        System.out.println(question);
        for(String key : polls.keySet())
        {
            System.out.println(key + " : " + polls.get(key).size());
        }
        System.out.println();
    }
}
