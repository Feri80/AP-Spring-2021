package com.company;


public class FinancialSystem {

    private Store store;


    public FinancialSystem(int cap){
        store = new Store(cap);
    }

    public boolean addProduct(String name , int price){
        return store.addProduct(name , price);
    }

    public void printProducts(){
        store.print();
    }

}
