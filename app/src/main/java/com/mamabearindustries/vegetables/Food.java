package com.mamabearindustries.vegetables;

/**
 * Created by tfan on 4/2/18.
 */

public class Food
{
    private String NameItem = "";
    private int Quantity = 0;
    private String ExpirationDate = "";
    private String RequestedDate = "";

    public Food(String NameItem, int Quantity, String ExpirationDate)
    {
        this.NameItem = NameItem;
        this.Quantity = Quantity;
        this.ExpirationDate = ExpirationDate;
    }

    /**
     * Returns the item name.
     * @return the item name.
     */
    public String getNameItem()
    {
        return NameItem;
    }

    /**
     * Sets the food item name
     * @param NameItem the name of the food item.
     */
    public void setNameItem(String NameItem)
    {
        this.NameItem = NameItem;
    }

    /**
     * Returns the item quantity
     * @return the item quantity
     */
    public int getQuantity()
    {
        return Quantity;
    }

    /**
     * Sets the food item quantity.
     * @param Quantity the quantity of the food item.
     */
    public void setQuantity(int Quantity)
    {
        this.Quantity = Quantity;
    }

    /**
     * Returns the expiration date.
     * @return the expiration date.
     */
    public String getExpirationDate() {
        return ExpirationDate;
    }

    /**
     * Sets the food item expiration date.
     * @param ExpirationDate the expiration date of the food item.
     */
    public void setExpirationDate(String ExpirationDate)
    {
        this.ExpirationDate = ExpirationDate;
    }

    /**
     * Returns the requested date of the food item.
     * @return the requested date of the food item.
     */
    public String getRequestedDate()
    {
        return RequestedDate;
    }

    /**
     * Sets the requested date of the food item.
     * @param RequestedDate the requested date of the food item.
     */
    public void setRequestedDate(String RequestedDate)
    {
        this.RequestedDate = RequestedDate;
    }

}