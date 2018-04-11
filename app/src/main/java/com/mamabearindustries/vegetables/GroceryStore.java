package com.mamabearindustries.vegetables;

/**
 * Created by tfan on 4/10/18.
 */

public class GroceryStore {

    private String StoreName = "";
    private String Address = "";
    private String PhoneNumber = "";
    private String ContactName = "";
    private String ContactEmail = "";
    private String Username = "";
    private String Password = "";

    public GroceryStore(String StoreName, String Address, String PhoneNumber, String ContactName, String ContactEmail, String Username, String Password)
    {
        this.StoreName = StoreName;
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
    public String getStoreName()
    {
        return StoreName;
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
