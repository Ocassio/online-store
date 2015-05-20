package ru.bpr.onlinestore.portal.models.catalog;

import ru.bpr.onlinestore.portal.models.FIleModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OfferViewModel implements Serializable
{
    private String id;
    private String name;
    private CategoryViewModel category;
    private String description;
    private String price;
    private String rating;
    private List<FIleModel> images;

    public OfferViewModel()
    {
    }

    public OfferViewModel(String id, String name, CategoryViewModel category, String description, String price, String rating)
    {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.rating = rating;
    }

    public OfferViewModel(String id, String name, CategoryViewModel category, String description, String price, String rating, List<FIleModel> images)
    {
        this(id, name, category, description, price, rating);
        this.images = images;
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

    public CategoryViewModel getCategory()
    {
        return category;
    }

    public void setCategory(CategoryViewModel category)
    {
        this.category = category;
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

    public List<FIleModel> getImages()
    {
        if (images == null)
        {
            images = new ArrayList<>();
        }

        return images;
    }

    public void setImages(List<FIleModel> images)
    {
        this.images = images;
    }

    public void addImage(FIleModel image)
    {
        getImages().add(image);
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
