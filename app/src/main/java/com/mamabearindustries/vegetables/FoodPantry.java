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
     *
     * @return the name of the grocery store.
     */
    public String getPantryName()
    {
        return PantryName;
    }

    /**
     *
     * @return the address of the grocery store.
     */
    public String getAddress()
    {
        return Address;
    }

    /**
     *
     * @return the contact phone number of the grocery store.
     */
    public String getPhoneNumber()
    {
        return PhoneNumber;
    }

    /**
     *
     * @return the contact person's name
     */
    public String getContactName()
    {
        return ContactName;
    }

    /**
     *
     * @return the contact person's email.
     */
    public String getContactEmail()
    {
        return ContactEmail;
    }

    /**
     *
     * @return the username of the grocery store.
     */
    public String getUsername()
    {
        return Username;
    }

    /**
     *
     * @return the password of the grocery store.
     */
    public String getPassword()
    {
        return Password;
    }
}