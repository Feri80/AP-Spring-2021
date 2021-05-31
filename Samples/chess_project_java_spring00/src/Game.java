import java.util.Random;
import java.util.Scanner;

public class Game
{
    private Board board;
    private int turn;
    private Scanner input;

    public Game()
    {
        input = new Scanner (System.in);
        Random random_generator = new Random ();
        this.turn = random_generator.nextInt (2) + 1;
        this.board = new Board ();
    }

    public void play()
    {
        while (!board.isBlackElementsEmpty () && !board.isWhiteElementsEmpty ())
        {
            System.out.printf ("\t\tplayer %s turn\n\n", (this.turn == 1)? "1 (white)" : "2 (black)");
            this.board.print_map ();
            System.out.println ("\nenter a command in a format like: src_row src_col dst_row dst_col");
            String[] command = input.nextLine ().split ("\\s+");

            if (command.length == 4)
            {
                if (Integer.parseInt (command[0]) < 0 || Integer.parseInt (command[0]) > 9)
                {
                    System.out.println ("wrong src, try Again!");
                    delay ();
                    System.out.println ("\n\n");
                    continue;
                }

                if (charToRow (command[1]) < 0 || charToRow (command[1]) > 4)
                {
                    System.out.println ("wrong src, try Again!");
                    delay ();
                    System.out.println ("\n\n");
                    continue;
                }

                if (Integer.parseInt (command[2]) < 0 || Integer.parseInt (command[2]) > 9)
                {
                    System.out.println ("wrong dst, try Again!");
                    delay ();
                    System.out.println ("\n\n");
                    continue;
                }

                if (charToRow (command[3]) < 0 || charToRow (command[3]) > 4)
                {
                    System.out.println ("wrong dst, try Again!");
                    delay ();
                    System.out.println ("\n\n");
                    continue;
                }



                Element src_element = board.getElement (Integer.parseInt (command[0]),
                        charToRow (command[1]));

                if (src_element == null || (src_element.getColor () == 'w' && turn == 2) ||
                        (src_element.getColor () == 'b' && turn == 1))
                {
                    System.out.println ("wrong src, try Again!");
                    delay ();
                    System.out.println ("\n\n");
                    continue;
                }

                if (!((Actions)src_element).move (Integer.parseInt (command[2]),
                        charToRow (command[3]), board))
                    {
                    System.out.println ("invalid move, try Again!");
                    delay ();
                    System.out.println ("\n\n");
                    continue;
                }
            }
            else
            {
                System.out.println ("wrong input, try Again!");
                delay ();
                System.out.println ("\n\n");
                continue;
            }

            if (turn == 1)
                turn = 2;
            else
                turn = 1;
            System.out.println ("\n\n");
        }

        if (board.isWhiteElementsEmpty ())
            System.out.println ("player 2 (Black) won");
        else
            System.out.println ("player 1 (white) won");
    }

    private void delay()
    {
        for (int i = 0; i < 100000; i++)
            for (int j = 0; j < 10000; j++)
                for (int k = 0; k < 1000; k++);
    }

    private int charToRow(String inp)
    {
        switch (inp)
        {
            case "A": return 0;
            case "B": return 1;
            case "C": return 2;
            case "D": return 3;
            case "E": return 4;
            default: return -1;
        }
    }
}
