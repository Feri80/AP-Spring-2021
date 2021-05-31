package com.company;

public class Main {

    public static void main(String[] args) {
        FinancialSystem financialSystem = new FinancialSystem(2);
        financialSystem.addProduct("pr1" , 2000);
        financialSystem.addProduct("pr2", 3000);
        if(financialSystem.addProduct("pr3" , 4000) == false){
            System.out.println("no more cap");
        }
        financialSystem.printProducts();
        if(financialSystem instanceof FinancialSystem){
            System.out.println("FS");
        }


        int i = Integer.parseInt("12");
        System.out.println(i+1);

        
        Main toCallAtoi = new Main();
        System.out.println(toCallAtoi.atoi());
    }

    public  int atoi(){
        return 0;
    }
}
