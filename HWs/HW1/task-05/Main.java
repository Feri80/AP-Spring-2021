import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

public class Main 
{
    public static int a;
    public static int b;
    public static int x;
    public static int y;

    public static void add()
    {
        int c = a + x;
        int d = b + y;
        System.out.print(c);
        if(d == 1)
        {
            System.out.println("+i");
        }
        else if(d == -1)
        {
            System.out.println("-i");
        }
        else if(d > 1)
        {
            System.out.println("+" + d + "i");
        }
        else if(d == 0)
        {
            System.out.println("+" + 0 + "i");
        }
        else 
        {   
            System.out.println(d + "i");
        }
    }
    public static void delta()
    {
        int c = a - x;
        int d = b - y;
        System.out.print(c);
        if(d == 1)
        {
            System.out.println("+i");
        }
        else if(d == -1)
        {
            System.out.println("-i");
        }
        else if(d > 1)
        {
            System.out.println("+" + d + "i");
        }
        else if(d == 0)
        {
            System.out.println("+" + 0 + "i");
        }
        else 
        {   
            System.out.println(d + "i");
        }
    }
    public static void mult()
    {
        int c = (a * x) - (b * y);
        int d = (a * y) + (b * x);
        System.out.print(c);
        if(d == 1)
        {
            System.out.println("+i");
        }
        else if(d == -1)
        {
            System.out.println("-i");
        }
        else if(d > 1)
        {
            System.out.println("+" + d + "i");
        }
        else if(d == 0)
        {
            System.out.println("+" + 0 + "i");
        }
        else 
        {   
            System.out.println(d + "i");
        }
    }
    public static void div()
    {
        double c = (((double)a * x) + (b * y)) / ((x * x) + (y * y));
        double d = (((double)b * x) - (a * y)) / ((x * x) + (y * y));
        System.out.printf("%.2f", c);
        if(d == 1)
        {
            System.out.println("+i");
        }
        else if(d == -1)
        {
            System.out.println("-i");
        }
        else if(d > 1)
        {
            System.out.printf("+%.2fi\n",d);
        }
        else if(d == 0)
        {
            System.out.println("+" + 0 + "i");
        }
        else 
        {   
            System.out.printf("%.2fi\n",d);
        }
    }

    public static void main(String[] args) 
    {
        char[] arr = new char[100000];
        Scanner input = new Scanner(System.in);
        a = input.nextInt();
        b = input.nextInt();
        x = input.nextInt();
        y = input.nextInt();
        String temp = input.nextLine();
        int i=0;
        char c='0';
        do
        {
            String s = input.nextLine();
            c = s.charAt(0);
            arr[i] = c;
            i++;
        }
        while(c != '#');
        i--;
        for(int j = 0 ; j < i ; j++)
        {
            if(arr[j] == '+')
            {
                add();   
            }
            if(arr[j] == '-')
            {
                delta();   
            }
            if(arr[j] == '*')
            {
                
                mult();   
            }
            if(arr[j] == '/')
            {
                div();   
            }
        }
    }
}