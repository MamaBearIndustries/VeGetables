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
     * Returns the information of the food item.
     * @return the information of the food item.
     */
    public Food getFood()
    {
        return food;
    }

    /**
     * Sets the information of the food item.
     * @param food the information of the food item.
     */
    public void setFood(Food food)
    {
        this.food = food;
    }

    /**
     * Returns the information of the grocery store providing the food item.
     * @return the information of the grocery store providing the food item.
     */
    public GroceryStore getGroceryStore()
    {
        return groceryStore;
    }

    /**
     * Sets the information of the grocery store.
     * @param groceryStore the information of the grocery store.
     */
    public void setGroceryStore(GroceryStore groceryStore)
    {
        this.groceryStore = groceryStore;
    }

    /**
     * Returns the information of the food pantry.
     * @return the information of the food pantry.
     */
    public FoodPantry getFoodPantry()
    {
        return foodPantry;
    }

    /**
     * Sets the information of the food pantry.
     * @param foodPantry the information of the food pantry.
     */
    public void setFoodPantry(FoodPantry foodPantry)
    {
        this.foodPantry = foodPantry;
    }

}
