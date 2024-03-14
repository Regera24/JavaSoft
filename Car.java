/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection_practice;

/**
 *
 * @author h
 */
public class Car {
    private String ID; 
    private String brand;
    private String name;
    private String version;
    private double price;
    private String color;
    private String date;
    private String engine;
    private int sales;
    private int inventory;

    public Car(String ID, String brand, String name, String version, double price, String color, String date, String engine, int sales, int inventory) {
        this.ID = ID;
        this.brand = brand;
        this.name = name;
        this.version = version;
        this.price = price;
        this.color = color;
        this.date = date;
        this.engine = engine;
        this.sales = sales;
        this.inventory = inventory;
    }

    

    

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getVersion() {
        return version;
    }

    public double getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public String getDate() {
        return date;
    }

    public int getSales() {
        return sales;
    }

    public int getInventory() {
        return inventory;
    }

    public String getEngine() {
        return engine;
    }
    
}
