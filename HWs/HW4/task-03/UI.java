import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class UI 
{
    /**
     * the colors and chars for making the game visual
     */
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m"; 

    public static final String UPPER_LEFT = "\u250C";
    public static final String LOWER_LEFT = "\u2514";
    public static final String UPPER_RIGHT = "\u2510";
    public static final String LOWER_RIGHT = "\u2518";
    public static final String MIDDLE = "\u2500";
    
    public static final String UPPER_LEFT_FRAME = UPPER_LEFT + MIDDLE + MIDDLE + MIDDLE + MIDDLE;
    public static final String LOWER_LEFT_FRAME = LOWER_LEFT + MIDDLE + MIDDLE + MIDDLE + MIDDLE;
    public static final String UPPER_RIGHT_FRAME = MIDDLE + MIDDLE + MIDDLE + MIDDLE + UPPER_RIGHT;
    public static final String LOWER_RIGHT_FRAME = MIDDLE + MIDDLE + MIDDLE + MIDDLE + LOWER_RIGHT;

    public static final String LEFT_SPACE = "|    ";
    public static final String RIGHT_SPACE = "    |";

    /**
     * make a delay in the program
     * @param t
     */
    public static void delay(int t)
    {
        try 
        {
            TimeUnit.SECONDS.sleep(t);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * clears the screen
     */
    public static void clearScreen()
    {
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
    }

    /**
     * creates a object of game and add the playes to it
     * @return game
     */
    public static Game createPlayers()
    {
        Scanner input = new Scanner(System.in);
    
        int numberOfPlayers = 0;
        while(numberOfPlayers < 3 || numberOfPlayers > 5)
        {
            clearScreen();
            System.out.println("Please Enter The Number Of Players. (3 to 5)");
            numberOfPlayers = input.nextInt();
        }
        
        clearScreen();
    
        Game game = new Game(numberOfPlayers);
        System.out.println("You Are Player Number 1 Please Enter Your Name :");
        input.nextLine();
        String name = input.nextLine();
        clearScreen();
        game.addPlayer(new Player(name, false));
        for(int i = 0; i < numberOfPlayers - 1; i++)
        {
            game.addPlayer(new Player("Bot" + (i + 1), true));
        }
        return game;
    }

    /**
     * shows the final scores of the players sorted
     */
    public void showScores(Game game)
    {
        sort(game);

        clearScreen();

        int rank = 1;
        for(Player p : game.getPlayers())
        {
            System.out.println(ANSI_CYAN + "Rank " + rank + " : " + p.getName() + " Score : " + p.getTotalScore());
            rank++;
        }


    }

    /**
     * sorts the list of players with bubble sort
     * @param game
     */
    public void sort(Game game)
    {
        int n = game.getPlayers().size();
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < (n - 1); j++)
            {
                if(game.getPlayers().get(j).getTotalScore() > game.getPlayers().get(j + 1).getTotalScore())
                {
                    Player temp = game.getPlayers().get(j);
                    game.getPlayers().set(j, game.getPlayers().get(j + 1)); 
                    game.getPlayers().set(j + 1, temp);
                }
            }
        }
    }

    /**
     * waits to press enter to continue
     */
    public static void pressEnter()
    {
        System.out.println("Press Enter To Continue");
        try
        {
            System.in.read();
        }
        catch(Exception e){}
    }

    /**
     * main method of the UI that starts the whole game
     */
    public void play()
    {
        Game game = createPlayers();
        game.createCards();
        game.divideCards();
        game.chooseFirstCurrentCard();

        while(game.isAnyPlayerEmpty() == false)
        {
            UI.clearScreen();

            game.displayDefault();

            UI.delay(5);
            Card previousCard = game.getCurrentCard();
            Card c = game.chooseCard();

            if(previousCard instanceof Card7)
            {
                Card7 previousCard7 = (Card7)previousCard;
                int n = previousCard7.getPenaltyCards().size();
                if(c instanceof Card7)
                {
                    Card7 c7 = (Card7)c;
                    
                    for(int i = 0; i < n; i++)
                    {
                        c7.getPenaltyCards().add(previousCard7.getPenaltyCards().get(0));
                        previousCard7.getPenaltyCards().remove(0);
                    }
                    
                }
                else
                {
                    for(int i = 0; i < n; i++)
                    {
                        game.getPlayers().get(game.getCurrentPlayer()).getCardsList().add(previousCard7.getPenaltyCards().get(0));
                        previousCard7.getPenaltyCards().remove(0);
                    }
                }
            }

            System.out.println(UI.ANSI_PURPLE + game.getPlayers().get(game.getCurrentPlayer()).getName() + " Choice Is :");
            System.out.println(c);

            if(game.getPlayers().get(game.getCurrentPlayer()).getCardsList().size() == 0)
            {
                break;
            }

            if(c!= null && game.getCurrentCard() instanceof Actionable)
            {
                Actionable a = (Actionable)game.getCurrentCard();
                a.action(game);
            }

            game.turnStepForward();

            UI.delay(10);
        }   
        
        showScores(game);
    }

}
