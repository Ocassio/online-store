package ru.bpr.onlinestore.portal.models.user;

import java.io.Serializable;

public class UserViewModel implements Serializable
{
    private String id;
    private String name;
    private String surname;
    private String email;
    private String address;

    public UserViewModel()
    {
    }

    public UserViewModel(String id, String name, String surname, String email, String address)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }
}
