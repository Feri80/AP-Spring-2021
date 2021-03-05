import java.util.Scanner;

public class Main 
{


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String code = input.nextLine();
        int codeNum = Integer.parseInt(code,2);
        String query = input.nextLine();
        int sz = query.length();
        int[] ans = new int[sz];
        for (int i = 0; i < sz; i++)
        {
            int c = query.charAt(i);
            ans[i] = codeNum ^ c;
        }
        for (int i = 0; i < sz; i++) 
        {
            System.out.print(Integer.toBinaryString(ans[i]) + " ");    
        }
    }
}