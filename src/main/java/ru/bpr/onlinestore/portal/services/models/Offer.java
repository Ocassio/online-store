package ru.bpr.onlinestore.portal.services.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "offers")
public class Offer
{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private int price;


    @ManyToOne
    @JoinColumn(name = "category", referencedColumnName = "id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "offer", cascade = CascadeType.ALL)
    private List<Rating> ratings;

    @OneToMany(mappedBy = "offer", cascade = CascadeType.ALL)
    private List<SalesOrderEntry> salesOrderEntries;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
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

    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    public List<Rating> getRatings()
    {
        return ratings;
    }

    public void setRatings(List<Rating> ratings)
    {
        this.ratings = ratings;
    }

    public List<SalesOrderEntry> getSalesOrderEntries()
    {
        return salesOrderEntries;
    }

    public void setSalesOrderEntries(List<SalesOrderEntry> salesOrderEntries)
    {
        this.salesOrderEntries = salesOrderEntries;
    }
}
