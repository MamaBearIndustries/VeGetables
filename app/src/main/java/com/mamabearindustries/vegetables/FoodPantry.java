package com.mamabearindustries.vegetables;

/**
 * Created by tfan on 4/11/18/
 */

public class FoodPantry {

    private String PantryName = "";
    private String Address = "";
    private String PhoneNumber = "";
    private String ContactName = "";
    private String ContactEmail = "";
    private String Username = "";
    private String Password = "";

    public FoodPantry(String PantryName, String Address, String PhoneNumber, String ContactName, String ContactEmail, String Username, String Password)
    {
        this.PantryName = PantryName;
        this.Address = Address;
        this.PhoneNumber = PhoneNumber;
        this.ContactName = ContactName;
        this.ContactEmail = ContactEmail;
        this.Username = Username;
        this.Password = Password;
    }

    /**
     * return the name of the food pantry
     * @return the name of the food pantry
     */
    public String getPantryName()
    {
        return PantryName;
    }

    /**
     * Sets the name of the food pantry.
     * @param PantryName the name of the food pantry
     */
    public void setPantryName(String PantryName)
    {
        this.PantryName = PantryName;
    }

    /**
     * Returns the address of the food pantry.
     * @return the address of the food pantry.
     */
    public String getAddress()
    {
        return Address;
    }

    /**
     * Sets the address of the food pantry.
     * @param Address the address of the food pantry.
     */
    public void setAddress(String Address)
    {
        this.Address = Address;
    }

    /**
     * Returns the contact phone number of the food pantry.
     * @return the contact phone number of the food pantry.
     */
    public String getPhoneNumber()
    {
        return PhoneNumber;
    }

    /**
     * Sets the contact phone number of the food pantry.
     * @param PhoneNumber the contact phone number of the food pantry.
     */
    public void setPhoneNumber(String PhoneNumber)
    {
        this.PhoneNumber = PhoneNumber;
    }

    /**
     * Returns the contact name of the food pantry.
     * @return the contact name of the food pantry.
     */
    public String getContactName()
    {
        return ContactName;
    }

    /**
     * Sets the contact name of the food pantry.
     * @param ContactName the contact name of the food pantry.
     */
    public void setContactName(String ContactName)
    {
        this.ContactName = ContactName;
    }

    /**
     * Returns the contact email of the food pantry.
     * @return the contact email of the food pantry.
     */
    public String getContactEmail()
    {
        return ContactEmail;
    }

    /**
     * Sets the contact email of the food pantry.
     * @param ContactEmail the contact email of the food pantry.
     */
    public void setContactEmail(String ContactEmail)
    {
        this.ContactEmail = ContactEmail;
    }

    /**
     * Returns the username of the food pantry.
     * @return the username of the food pantry.
     */
    public String getUsername()
    {
        return Username;
    }

    /**
     * Sets the username of the food pantry.
     * @param Username the username of the food pantry.
     */
    public void setUsername(String Username)
    {
        this.Username = Username;
    }

    /**
     * Returns the password of the food pantry.
     * @return the password of the food pantry.
     */
    public String getPassword()
    {
        return Password;
    }

    /**
     * Sets the password of the food pantry.
     * @param Password the password of the food pantry.
     */
    public void setPassword(String Password)
    {
        this.Password = Password;
    }

    /**
     * Created by Mary on 4/25/18.
     */

    public static class FoodPantrySignUp {
    }
}