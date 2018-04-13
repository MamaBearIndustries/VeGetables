package com.mamabearindustries.vegetables;

/**
 * Created by admin on 4/11/18.
 */

public class Request
{
    private Food food;
    private GroceryStore groceryStore;
    private FoodPantry foodPantry;

    public Request(Food food, GroceryStore groceryStore, FoodPantry foodPantry)
    {
        this.food = food;
        this.groceryStore = groceryStore;
        this.foodPantry = foodPantry;
    }

    /**
     *
     * @return the food item information
     */
    public Food getFood()
    {
        return food;
    }

    /***
     *
     * @return the grocery store information
     */
    public GroceryStore groceryStore()
    {
        return groceryStore;
    }

    /**
     *
     * @return the food pantry information
     */
    public FoodPantry getFoodPantry()
    {
        return foodPantry;
    }

}
