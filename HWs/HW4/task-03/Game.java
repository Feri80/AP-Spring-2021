import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * this class contains the whole system of the game and details
 * 
 * @author Farhad Aman
 * @version 1.0
 */
public class Game 
{
    /**
     * the players in the game
     */
    private ArrayList<Player> players;

    /**
     * the storage of the cards
     */
    private ArrayList<Card> storage;

    /**
     * the displayed card in current turn
     */
    private Card currentCard;

    /**
     * the direction of the game
     */
    private int direction;

    /**
     * the number of current player in the game
     */
    private int currentPlayer;

    /**
     * the displayed number in current turn
     */
    private String currentNumber;

    /**
     * the displayed color in current turn
     */
    private String currentColor;

    /**
     * the number of players
     */
    private int numberOfPlayers;

    /**
     * creates a new Game
     * @param numberOfPlayers
     */
    public Game(int numberOfPlayers)
    {
        this.numberOfPlayers = numberOfPlayers;
        players = new ArrayList<Player>();
        storage = new ArrayList<Card>();
        direction = +1;
        Random random = new Random();
        currentPlayer = random.nextInt(numberOfPlayers);
    }

    /**
     * @return this method do the process of choosing a card to play for current player.
     * and also handles the availablity to play for a players
     */
    public Card chooseCard()
    {
        Random random = new Random();
        Scanner input = new Scanner(System.in);

        if(getNumberOfAvailableCards() > 0)
        {
            if(players.get(currentPlayer).getIsBot())
            {
                int k = random.nextInt(getNumberOfAvailableCards());
                for(Card c : players.get(currentPlayer).getCardsList())
                {
                    if(isAvailableCard(c))
                    {
                        if(k == 0)
                        {
                            storage.add(currentCard);
                            currentCard = c;
                            currentColor = c.getColor();
                            currentNumber = c.getNumber();
                            players.get(currentPlayer).getCardsList().remove(c);
                            return c;
                        }
                        else
                        {
                            k--;
                        }
                    }
                }
            }
            else
            {
                Card c = null;
                while(c == null || isAvailableCard(c) == false)
                {
                    int k = -1;
                    while(k < 0 || k >= players.get(currentPlayer).getCardsList().size())
                    {
                        System.out.println("Please Enter An Available Card Number : ");
                        k = input.nextInt();
                    }
                    c = players.get(currentPlayer).getCardsList().get(k);
                }
                storage.add(currentCard);
                currentCard = c;
                currentColor = c.getColor();
                currentNumber = c.getNumber();
                players.get(currentPlayer).getCardsList().remove(c);
                System.out.println("Chosen Card Accepted.");
                return c;
            }
        }
        else
        {
            if(!players.get(currentPlayer).getIsBot())
            {
                System.out.println("Your Dont Have Any Available Card.");
            }    
            players.get(currentPlayer).addCard(storage.get(0));
            storage.remove(0);
            UI.delay(3);
            UI.clearScreen();
            displayDefault();
            if(getNumberOfAvailableCards() > 0)
            {
                if(players.get(currentPlayer).getIsBot())
                {
                    for(Card c : players.get(currentPlayer).getCardsList())
                    {
                        if(isAvailableCard(c))
                        {
                            storage.add(currentCard);
                            currentCard = c;
                            currentColor = c.getColor();
                            currentNumber = c.getNumber();
                            players.get(currentPlayer).getCardsList().remove(c);
                            return c;
                        }
                    }
                }
                else
                {
                    Card c = null;
                    while(c == null || isAvailableCard(c) == false)
                    {
                        int k = -1;
                        while(k < 0 || k >= players.get(currentPlayer).getCardsList().size())
                        {
                            System.out.println("Please Enter An Available Card Number : ");
                            k = input.nextInt();
                        }
                        c = players.get(currentPlayer).getCardsList().get(k);
                    }
                    storage.add(currentCard);
                    currentCard = c;
                    currentColor = c.getColor();
                    currentNumber = c.getNumber();
                    players.get(currentPlayer).getCardsList().remove(c);
                    System.out.println("Chosen Card Accepted.");
                    return c;
                }
            }
            else
            {
                if(!players.get(currentPlayer).getIsBot())
                {
                    System.out.println("Your Dont Have Any Available Card.");
                }
                return null;
            }
        }
        return null;
    }

    /**
     * @param card
     * @return check if the given card is valid to play in current situation
     */
    public boolean isAvailableCard(Card card)
    {
        if(card.getColor().equals(currentColor) || card.getNumber().equals(currentNumber))
        {
            return true;
        }
        return false;
    }

    /**
     * @return the number of valid cards to play
     */
    public int getNumberOfAvailableCards()
    {
        int numberOfAvailableCards = 0;
        for(Card c : players.get(currentPlayer).getCardsList())
        {
            if(c.getColor().equals(currentColor) || c.getNumber().equals(currentNumber))
            {
                numberOfAvailableCards++;
            }
        }
        return numberOfAvailableCards;
    }
    
    /**
     * creates the 52 normal card of the game and adds them to the list
     */
    public void createCards()
    {
        storage.add(new RegularCard(3, "3", "black"));
        storage.add(new RegularCard(3, "3", "red"));
        storage.add(new RegularCard(3, "3", "green"));
        storage.add(new RegularCard(3, "3", "blue"));
        
        storage.add(new RegularCard(4, "4", "black"));
        storage.add(new RegularCard(4, "4", "red"));
        storage.add(new RegularCard(4, "4", "green"));
        storage.add(new RegularCard(4, "4", "blue"));
        
        storage.add(new RegularCard(5, "5", "black"));
        storage.add(new RegularCard(5, "5", "red"));
        storage.add(new RegularCard(5, "5", "green"));
        storage.add(new RegularCard(5, "5", "blue"));

        storage.add(new RegularCard(6, "6", "black"));
        storage.add(new RegularCard(6, "6", "red"));
        storage.add(new RegularCard(6, "6", "green"));
        storage.add(new RegularCard(6, "6", "blue"));

        storage.add(new RegularCard(9, "9", "black"));
        storage.add(new RegularCard(9, "9", "red"));
        storage.add(new RegularCard(9, "9", "green"));
        storage.add(new RegularCard(9, "9", "blue"));

        storage.add(new RegularCard(12, "C", "black"));
        storage.add(new RegularCard(12, "C", "red"));
        storage.add(new RegularCard(12, "C", "green"));
        storage.add(new RegularCard(12, "C", "blue"));

        storage.add(new RegularCard(13, "D", "black"));
        storage.add(new RegularCard(13, "D", "red"));
        storage.add(new RegularCard(13, "D", "green"));
        storage.add(new RegularCard(13, "D", "blue"));
     
        storage.add(new Card2("black"));
        storage.add(new Card2("red"));
        storage.add(new Card2("green"));
        storage.add(new Card2("blue"));

        storage.add(new Card7("black"));
        storage.add(new Card7("red"));
        storage.add(new Card7("green"));
        storage.add(new Card7("blue"));

        storage.add(new Card8("black"));
        storage.add(new Card8("red"));
        storage.add(new Card8("green"));
        storage.add(new Card8("blue"));

        storage.add(new Card10("black"));
        storage.add(new Card10("red"));
        storage.add(new Card10("green"));
        storage.add(new Card10("blue"));

        storage.add(new CardA("black"));
        storage.add(new CardA("red"));
        storage.add(new CardA("green"));
        storage.add(new CardA("blue"));

        storage.add(new CardB("black"));
        storage.add(new CardB("red"));
        storage.add(new CardB("green"));
        storage.add(new CardB("blue"));

        Collections.shuffle(storage);
    }

    /**
     * changes the direction of the game
     */
    public void changeDirection()
    {
        direction *= -1;
    }

    /**
     * gives the turn to the next player
     */
    public void turnStepForward()
    {
        if(direction == +1)
        {
            currentPlayer++;
            currentPlayer %= numberOfPlayers;
        }
        else
        {
            currentPlayer--;
            if(currentPlayer < 0)
            {
                currentPlayer += numberOfPlayers;
            }
        }
    }

    /**
     * gives the turn to the previous player
     */
    public void turnStepBackward()
    {
        if(direction == +1)
        {
            currentPlayer--;
            if(currentPlayer < 0)
            {
                currentPlayer += numberOfPlayers;
            }
        }
        else
        {
            currentPlayer++;
            currentPlayer %= numberOfPlayers;
        }
    }

    /*
     * @return checks if any player is empty of cards
     */
    public boolean isAnyPlayerEmpty()
    {
        for(Player p : players)
        {
            if(p.getCardsList().isEmpty())
            {
                return true;
            }
        }
        return false;
    }

    /**
     * divides the card of the storage between players randomly
     */
    public void divideCards()
    {
        Random random = new Random();
        for(int i = 0; i < numberOfPlayers; i++)
        {
            for(int j = 0; j < 7; j++)
            {
                int newRandom = random.nextInt(storage.size());
                players.get(i).addCard(storage.get(newRandom));
                storage.remove(newRandom);
            }
        }
    }

    /**
     * choose the first card to start the game randomly
     */
    public void chooseFirstCurrentCard()
    {
        Random random = new Random();
        Card c = null;
        while(c == null || c instanceof Actionable)
        {
            c = storage.get(random.nextInt(storage.size()));
        }
        storage.remove(c);
        currentCard = c;
        currentColor = c.getColor();
        currentNumber = c.getNumber();
    }

    /**
     * adds a new player to players
     * @param player
     */
    public void addPlayer(Player player)
    {
        players.add(player);
    }

    /**
     * @return the list of players
     */
    public ArrayList<Player> getPlayers()
    {
        return players;

    }

    /**
     * @return the storage
     */
    public ArrayList<Card> getStorage()
    {
        return storage;
    }

    /**
     * @return the current card
     */
    public Card getCurrentCard()
    {
        return currentCard;
    }

    /**
     * @return the direction of the game
     */
    public int getDirection()
    {
        return direction;
    }

    /**
     * @return the number of current player
     */
    public int getCurrentPlayer()
    {
        return currentPlayer;
    }

    /**
     * sets the color of the game
     * @param color
     */
    public void setCurrentColor(String color)
    {
        currentColor = color;
    }

    /**
     * sets the number of the game
     * @param number
     */
    public void setCurrentNumber(String number)
    {
        currentNumber = number;
    }

    /**
     * displays the dedault inforamtion for starting the game
     */
    public void displayDefault()
    {
        String dir = direction == +1 ? "Clockwise" : "Counter Clockwise";
        System.out.println(UI.ANSI_PURPLE + "Turn : " + players.get(currentPlayer).getName() + "\tGame Direction : " + dir + "\t Color : " + currentColor);
        System.out.println(currentCard);
        System.out.println(UI.ANSI_CYAN + "-----------------------");
        for(int i = 0; i < numberOfPlayers; i++)
        {
            System.out.println(UI.ANSI_PURPLE + players.get(i).getName() + " : " + players.get(i).getCardsList().size());
        }   
        System.out.println(UI.ANSI_CYAN + "-----------------------");
        players.get(0).displayCards();
        System.out.println(UI.ANSI_CYAN + "---------------------------------------");
    }
}



