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
     * Returns the name of the grocery store.
     * @return the name of the grocery store.
     */
    public String getStoreName()
    {
        return StoreName;
    }

    /**
     * Sets the name of the grocery store.
     * @param StoreName the name of the grocery store.
     */
    public void setStoreName(String StoreName)
    {
        this.StoreName = StoreName;
    }

    /**
     * Returns the address of the grocery store.
     * @return the address of the grocery store.
     */
    public String getAddress()
    {
        return Address;
    }

    /**
     * Sets the address of the grocery store.
     * @param Address the address of the grocery store.
     */
    public void setAddress(String Address)
    {
        this.Address = Address;
    }

    /**
     * Returns the contact phone number of the grocery store.
     * @return the contact phone number of the grocery store.
     */
    public String getPhoneNumber()
    {
        return PhoneNumber;
    }

    /**
     * Sets the phone number of the grocery store.
     * @param PhoneNumber the phone number of the grocery store.
     */
    public void setPhoneNumber(String PhoneNumber)
    {
        this.PhoneNumber = PhoneNumber;
    }

    /**
     * Returns the contact name of the grocery store.
     * @return the contact name of the grocery store.
     */
    public String getContactName()
    {
        return ContactName;
    }

    /**
     * Sets the contact name of the grocery store.
     * @param ContactName the contact name of the grocery store.
     */
    public void setContactName(String ContactName)
    {
        this.ContactName = ContactName;
    }

    /**
     * Returns the contact email of the grocery store.
     * @return the contact email of the grocery store.
     */
    public String getContactEmail()
    {
        return ContactEmail;
    }

    /**
     * Sets the contasct email of the grocery store.
     * @param ContactEmail the contact email of the grocery store.
     */
    public void setContactEmail(String ContactEmail)
    {
        this.ContactEmail = ContactEmail;
    }

    /**
     * Returns the username of the grocery store.
     * @return the username of the grocery store.
     */
    public String getUsername()
    {
        return Username;
    }

    /**
     * Sets the username of the grocery store.
     * @param Username the username of the grocery store.
     */
    public void setUsername(String Username)
    {
        this.Username = Username;
    }

    /**
     * Returns the password of the grocery store.
     * @return the password of the grocery store.
     */
    public String getPassword()
    {
        return Password;
    }

    public void setPassword()
    {
        this.Password = Password;
    }
}
