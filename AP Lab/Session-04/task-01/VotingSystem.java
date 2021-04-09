import java.util.ArrayList;
import java.util.HashSet;

/**
 * This class contains the whole voting system
 * 
 * @author Farhad Aman
 * @version 1.0
 */
public class VotingSystem 
{
    /**
     * list of votings
     */
    private ArrayList<Voting> votingList;

    /**
     * creates a new voting system
     */
    public VotingSystem()
    {
        votingList = new ArrayList<Voting>();
    }

    /**
     * creates a new voting
     * @param question
     * @param type
     * @param choices
     */
    public void createVoting(String question, int type, ArrayList<String> choices)
    {
        Voting v = new Voting(type, question);
        for(String s : choices)
        {
            v.createPoll(s);
        }
        votingList.add(v);
    }

    /**
     * print list of voting questions
     */
    public void printListOfVotings()
    {
        int i = 1;
        for(Voting v : votingList)
        {
            System.out.println("Voting Number " + i + " : " + v.getQuestion());
            i++;
        }
    }

    /**
     * print a voting question and choices
     * @param index
     */
    public void printVoting(int index)
    {
        Voting v = votingList.get(index);
        System.out.println("Questiong : " + v.getQuestion());
        int i = 1;
        for(String s : v.getPolls().keySet())
        {
            System.out.println(i + " : " + s);
            i++;
        }
    }

    /**
     * submits a new vote
     * @param index
     * @param person
     * @param choices
     */
    public void vote(int index, Person person, ArrayList<String> choices)
    {
        votingList.get(index).vote(person, choices);
    }

    /**
     * print result of a voting
     * @param index
     */
    public void printResult(int index)
    {
        votingList.get(index).printResult();
    }
}
