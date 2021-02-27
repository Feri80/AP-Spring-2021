import java.util.Scanner;

public class Main
{
    public static int gcd(int a,int b)
    {
        if(b==0)
        {
            return a;
        }
        return gcd(b,a % b);
    }
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int a=input.nextInt();
        int b=input.nextInt();
        
        if(gcd(a, b)==1)
        {
            System.out.println("Avval");
        }
        else
        {
            System.out.println("No !!!");
        }
    }
}
