package com.company;

public class Product {


    private String name;
    private int price;

    public Product(String name , int productPrice){
        this.name = name;
        price = productPrice;
    }
    public String getName()
    {
        return name;
    }

    public void print(){
        System.out.println("Name : " +name + " Price : "+ price);
    }
























//
//    public Product(String name , int price){
//        this.name=name;
//        this.price=price;
//    }
//
//    public String getName(){
//        return name;
//    }
//
    public int getPrice() {
        return price;
    }
}
