import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        int n; // size of the input

        n = input.nextInt();

        LinkedList linkedList = new LinkedList();

        for(int i = 0; i < n; i++)
        {
            int k = input.nextInt();
            linkedList.add(k);
        }

        Stack s = new Stack();

        for(int i = 0; i < n; i++)
        {
            s.push(linkedList.get(i));
        }

        LinkedList reversedLinkedList = new LinkedList();

        while(!s.isEmpty())
        {
            reversedLinkedList.add(s.pop());
        }

        reversedLinkedList.print();
    }
}