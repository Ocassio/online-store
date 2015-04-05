package ru.bpr.onlinestore.portal.offers.models;

import java.io.Serializable;

public class CredentialsModel implements Serializable
{
    private String email;
    private String password;

    public CredentialsModel()
    {
    }

    public CredentialsModel(String email, String password)
    {
        this.email = email;
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
