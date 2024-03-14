/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection_practice;

import java.sql.Date;

/**
 *
 * @author h
 */
public class soldCar {
    private String id;
    private String name;
    private double price;
    private Date date;

    public soldCar(String id, String name, double price, Date date) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }
    
}
