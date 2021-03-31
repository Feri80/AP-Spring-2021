import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        String command;
        
        LinkedList linkedlist = new LinkedList();
        
        command = input.nextLine();
        
        while(!command.equals("finish"))
        {
            String splited[] = command.split(" ");
            if(splited.length == 1)
            {
                if(splited[0].equals("print"))
                {
                    linkedlist.print();
                }
                if(splited[0].equals("findMiddle"))
                {
                    linkedlist.findMiddle();
                }
                if(splited[0].equals("removeMiddle"))
                {
                    linkedlist.removeMiddle();
                }
            } 
            else
            {
                if(splited[0].equals("add"))
                {
                    linkedlist.add(Integer.parseInt(splited[1]));
                }
                if(splited[0].equals("addFirst"))
                {
                    linkedlist.addFirst(Integer.parseInt(splited[1]));
                }
                if(splited[0].equals("contains"))
                {
                    linkedlist.contains(Integer.parseInt(splited[1]));
                }
                if(splited[0].equals("removeIndex"))
                {
                    linkedlist.removeIndex(Integer.parseInt(splited[1]));
                }
            }
            command = input.nextLine();
        }
    }
}