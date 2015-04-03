package ru.bpr.onlinestore.portal.offers.models;

import java.io.Serializable;

public class OfferViewModel implements Serializable
{
    private String id;
    private String name;
    private String description;
    private String price;
    private String rating;

    public OfferViewModel()
    {
    }

    public OfferViewModel(String id, String name, String description, String price, String rating)
    {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.rating = rating;
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

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getPrice()
    {
        return price;
    }

    public void setPrice(String price)
    {
        this.price = price;
    }

    public String getRating()
    {
        return rating;
    }

    public void setRating(String rating)
    {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof OfferViewModel)
        {
            OfferViewModel other = (OfferViewModel) obj;
            return this.getId().equals(other.getId());
        }

        return false;
    }
}
