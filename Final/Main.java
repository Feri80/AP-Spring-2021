import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class InputReader 
{
    private int columnCount;
    private int rowCount;
    private final Scanner reader;
    private final ArrayList<String[]> creatures = new ArrayList<>();
    private final ArrayList<String[]> weapons = new ArrayList<>();
    private final ArrayList<String[]> commands = new ArrayList<>();

    InputReader() 
    {
        reader = new Scanner(System.in);
        readInputs();
    }

    private void readInputs() 
    {
        String[] parts = reader.nextLine().split(" ");
        rowCount = Integer.parseInt(parts[0]);
        columnCount = Integer.parseInt(parts[1]);
        int count = Integer.parseInt(reader.nextLine());
        readNextInputs(count, creatures);
        count = Integer.parseInt(reader.nextLine());
        readNextInputs(count, weapons);
        count = Integer.parseInt(reader.nextLine());
        readNextInputs(count, commands);
    }

    private void readNextInputs(int count, ArrayList<String[]> list) 
    {
        for (int i = 0; i < count; i++) 
        {
            String line = reader.nextLine();
            list.add(line.split(" "));
        }
    }

    public int getColumnCount() 
    {
        return columnCount;
    }

    public int getRowCount() 
    {
        return rowCount;
    }

    public ArrayList<String[]> getCreatures() 
    {
        return creatures;
    }

    public ArrayList<String[]> getWeapons() 
    {
        return weapons;
    }

    public ArrayList<String[]> getCommands() 
    {
        return commands;
    }
}

class Location 
{
    private final int row;
    private final int column;

    public Location(int row, int column) 
    {
        this.row = row;
        this.column = column;
    }

    public int getRow() 
    {
        return row;
    }

    public int getColumn() 
    {
        return column;
    }

    public static Location stringToLocation(String location) 
    {
        String[] parts = location.replace("(", "").replace(")", "").split(",");
        return new Location(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (obj instanceof Location) 
        {
            Location loc = (Location) obj;
            return getRow() == loc.getRow() && getColumn() == loc.getColumn();
        } 
        else
            return false;
    }
}

class Field
{
    private final int rows;

    private final int columns;

    private ArrayList<Creature> creatures;

    public Field(int rows, int columns)
    {
        this.rows = rows;
        this.columns = columns;
        creatures = new ArrayList<>();
    }

    public void intializeCreatures(ArrayList<String[]> strings)
    {
        for(String[] s : strings)
        {
            if(s[0].equals("Apple"))
            {
                addCreature(new Apple(s[1], Location.stringToLocation(s[2]), Integer.parseInt(s[3]), Integer.parseInt(s[4])));
            }
            else if(s[0].equals("Chicken"))
            {
                addCreature(new Chicken(s[1], Location.stringToLocation(s[2]), Integer.parseInt(s[3]), Integer.parseInt(s[4])));
            }
        }
    }

    private void addCreature(Creature creature)
    {
        int row = creature.getLocation().getRow();
        int column = creature.getLocation().getColumn();
        if((row >= 0) && (row < rows) && (column >= 0) && (column < columns))
        {
            creatures.add(creature);
        }
    }

    public Creature getAtLocationCreature(Location location)
    {
        for(Creature c : creatures)
        {
            if(c.isAlive() && c.getLocation().equals(location))
            {
                return c;   
            }
        }
        return null;
    }

    public int calculate()
    {
        int totalValues = 0;
        for(Creature c : creatures)
        {
            if(c.isAlive())
            {
                totalValues += c.calculateValue();
            }
        }
        return totalValues;
    }

    public void print()
    {
        for(Creature c : creatures)
        {
            if(c.isAlive())
            {
                System.out.println(c.getId() + "(" + c.calculateValue() + ")");
            }
        }
    }

    public int getRows()
    {
        return rows;
    }

    public int getColumns()
    {
        return columns;
    }
}

abstract class Creature 
{
    private final String id;

    private final Location location;

    private boolean alive;

    public Creature(String id, Location location)
    {
        this.id = id;
        this.location = location;
        this.alive = true;
    }

    public abstract int calculateValue();

    public void kill()
    {
        alive = false;
    }

    public String getId()
    {
        return id;
    }

    public Location getLocation()
    {
        return location;
    }

    public boolean isAlive()
    {
        return alive;
    }
}

class Apple extends Creature
{
    private final int age;

    private final int fruit;

    public Apple(String id, Location location, int age, int fruit) 
    {
        super(id, location);
        this.age = age;
        this.fruit = fruit;
    }

    @Override
    public int calculateValue() 
    {
        return (age * 5) + fruit;    
    }
}

class Chicken extends Creature
{
    private final int weight;

    private final int eggs;

    public Chicken(String id, Location location, int weight, int eggs) 
    {
        super(id, location);
        this.weight = weight;
        this.eggs = eggs;
    }

    @Override
    public int calculateValue() 
    {
        return weight + eggs;
    }
}

class Enemy
{
    private ArrayList<Weapon> weapons;

    public Enemy()
    {
        weapons = new ArrayList<>();
    }

    public void intializeWeopens(ArrayList<String[]> strings)
    {
        for(String[] s : strings)
        {
            if(s[0].equals("Gun"))
            {
                addWeapon(new Gun(s[1], Integer.parseInt(s[2])));
            }
            else if(s[0].equals("Shell"))
            {
                addWeapon(new Shell(s[1], Integer.parseInt(s[2])));
            }
        }
    }

    public void shoot(Field field, String weaponId, Location location)
    {
        Weapon weapon = null;
        for(Weapon w : weapons)
        {
            if(w.getId().equals(weaponId))
            {
                weapon = w;
            }
        }
        if(weapon != null && weapon.getBullets() > 0 ) 
        {
            Creature creature = field.getAtLocationCreature(location);
            if(creature != null)
            {
                if(weapon instanceof Gun)
                {
                    if(creature instanceof Chicken)
                    {
                        creature.kill();
                        weapon.shoot();
                    }
                }
                else if(weapon instanceof Shell)
                {
                    creature.kill();
                    weapon.shoot();
                }
            }
        }
    }

    private void addWeapon(Weapon weapon)
    {
        weapons.add(weapon);
    }
}

abstract class Weapon
{
    private String id;

    private int bullets;

    public Weapon(String id, int bullets)
    {
        this.id = id;
        this.bullets = bullets;
    }

    public void shoot()
    {
        if(bullets > 0)
        {
            bullets--;
        }
    }

    public String getId()
    {
        return id;
    }

    public int getBullets()
    {
        return bullets;
    }
}

class Gun extends Weapon
{
    public Gun(String id, int bullets) 
    {
        super(id, bullets);
    }
}

class Shell extends Weapon
{
    public Shell(String id, int bullets) 
    {
        super(id, bullets);
    }
}

class Game
{
    private Field field;

    private Enemy enemy;

    public Game(Field field, Enemy enemy)
    {
        this.field = field;
        this.enemy = enemy;
    }

    public void startGmae(ArrayList<String[]> commands)
    {
        for(String[] s : commands)
        {
            if(s[0].equals("Calculate"))
            {
                System.out.println(field.calculate());
            }
            else if(s[0].equals("Print"))
            {
                field.print();
            }
            else if(s[0].equals("Shoot"))
            {
                enemy.shoot(field, s[1], Location.stringToLocation(s[2]));
            }
        }
    }
}


public class Main 
{
    public static void main(String[] args) 
    {
        InputReader reader = new InputReader();

        Field field = new Field(reader.getRowCount(), reader.getColumnCount());
        field.intializeCreatures(reader.getCreatures());

        Enemy enemy = new Enemy();
        enemy.intializeWeopens(reader.getWeapons());

        Game game = new Game(field, enemy);

        game.startGmae(reader.getCommands());
    }
}