package com.mamabearindustries.vegetables;

/**
 * Created by tfan on 4/2/18.
 */

public class Food
{
    private String NameItem = "";
    private int Quantity = 0;
    private String NameGrocery = "";
    private String ExpirationDate = "";
    private String RequestedDate = "";

    public Food(String NameItem, String NameGrocery, int Quantity, String ExpirationDate)
    {
        this.NameItem = NameItem;
        this.NameGrocery = NameGrocery;
        this.Quantity = Quantity;
        this.ExpirationDate = ExpirationDate;
    }

    public String getNameItem()
    {
        return NameItem;
    }

    public String getNameGrocery()
    {
        return NameGrocery;
    }

    public int getQuantity()
    {
        return Quantity;
    }

    public String getExpirationDate() {
        return ExpirationDate;
    }

    private String getRequestedDate()
    {
        return RequestedDate;
    }

}