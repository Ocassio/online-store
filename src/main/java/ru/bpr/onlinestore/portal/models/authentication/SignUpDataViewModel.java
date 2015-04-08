package ru.bpr.onlinestore.portal.models.authentication;

import java.io.Serializable;

public class SignUpDataViewModel extends CredentialsViewModel implements Serializable
{
    private String name;
    private String surname;
    private String address;

    public SignUpDataViewModel()
    {
    }

    public SignUpDataViewModel(String email, String password)
    {
        super(email, password);
    }

    public SignUpDataViewModel(String email, String password, String name, String surname, String address)
    {
        super(email, password);
        this.name = name;
        this.surname = surname;
        this.address = address;
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

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }
}
