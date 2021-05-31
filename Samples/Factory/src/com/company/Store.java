package com.company;


public class Store {

    private Product[] products;
    private int numberOfProducts;
    private int cap;

    public Store(int cap){
        this.cap=cap;
        numberOfProducts=0;
        products = new Product[cap];
    }


    public boolean addProduct (String name, int price){
        if(numberOfProducts < cap){
            products[numberOfProducts] = new Product(name, price);
            numberOfProducts++;
            return true;
        }
        else{
            return false;
        }
    }

    public int calcValue(){
        int output = 0;
        for(int i=0 ; i<numberOfProducts ; i++){
            output+=products[i].getPrice();
        }
        return output;
    }

    public void print(){
        for(int i=0 ; i<numberOfProducts ;i++){
            products[i].print();
        }
    }

}
