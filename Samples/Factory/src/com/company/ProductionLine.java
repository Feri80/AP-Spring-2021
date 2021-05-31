package com.company;

public class ProductionLine {

    private String name;
    private Product type;

    public ProductionLine(String name, String productName , int price){
        this.name=name;
        type = new Product(productName, price);
    }

    public void print(){
        System.out.println("Name : "+ name +" | Product : " + type.getName());
    }
}
