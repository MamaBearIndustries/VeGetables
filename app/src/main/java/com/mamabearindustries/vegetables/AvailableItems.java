package com.mamabearindustries.vegetables;

/**
 * Created by gopinathans on 4/17/18.
 */

public class AvailableItems
{
    private Food food;
    private GroceryStore groceryStore;

    public AvailableItems(Food food, GroceryStore groceryStore)
    {
        this.food = food;
        this.groceryStore = groceryStore;
    }

    /**
     * Gets the food item
     * @return the food item
     */
    public Food getFood()
    {
        return food;
    }

    /**
     * Sets the food item
     * @param food the food item
     */
    public void setFood(Food food)
    {
        this.food = food;
    }

    /**
     * Gets the groceryStore item
     * @return the groceryStore item
     */
    public GroceryStore getGroceryStore()
    {
        return groceryStore;
    }

    /**
     * Sets the groceryStore item
     * @param groceryStore the groceryStore item
     */
    public void setGroceryStore(GroceryStore groceryStore)
    {
        this.groceryStore = groceryStore;
    }
}
