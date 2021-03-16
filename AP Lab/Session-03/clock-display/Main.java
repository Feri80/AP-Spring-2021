import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main
{
    public static void sleep()
    {
        try
        {
            TimeUnit.SECONDS.sleep(1);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public static void clearScreen()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    public static void main(String[] args)
    {
        Date date = new Date(); 
        Calendar calendar = Calendar.getInstance(); 
        calendar.setTime(date);  
        int hour = calendar.get(Calendar.HOUR_OF_DAY); 
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        ClockDisplay clock = new ClockDisplay(hour, minute, second);

        while(true)
        {
            sleep();
            clock.timeTick();
            clearScreen();
            System.out.println(clock.getTime());
        }
    }
}
