package ru.bpr.onlinestore.portal.offers.models;

import java.io.Serializable;

public class CategoryViewModel implements Serializable
{
    private String id;
    private String name;

    public CategoryViewModel()
    {
    }

    public CategoryViewModel(String id, String name)
    {
        this.id = id;
        this.name = name;
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
}
