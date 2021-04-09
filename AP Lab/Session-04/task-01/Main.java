import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.lang.model.type.ArrayType;

public class Main 
{

    public static void main(String[] args)
    {
        VotingSystem votingSystem = new VotingSystem();

        ArrayList<String> c1 = new ArrayList<String>();

        c1.add("Yes");
        c1.add("No");

        ArrayList<String> c2 = new ArrayList<String>();

        c2.add("a");
        c2.add("b");
        c2.add("c");
        c2.add("d");

        votingSystem.createVoting("Is ?", 0, c1);
        votingSystem.createVoting("Which ?", 1, c2);
        //----------------------------------------------

        
        Person p1 = new Person("ali", "alavi");
        ArrayList<String> a1 = new ArrayList<String>();
        a1.add("a");
        a1.add("d");

        votingSystem.vote(1, p1, a1);

        Person p2 = new Person("farhad", "aman");
        ArrayList<String> a2 = new ArrayList<String>();
        a2.add("b");
        a2.add("d");

        votingSystem.vote(1, p2, a2);

        ArrayList<String> a3 = new ArrayList<String>();
        a3.add("Yes");

        votingSystem.vote(0, p2, a3);


        votingSystem.printResult(1);
        votingSystem.printResult(0);

    }
}
