package ru.bpr.onlinestore.portal.services.models;

import javax.persistence.*;

@Entity
@Table(name = "offers")
public class Offer
{
    private int id;
    private String name;
    private int price;
    private Category category;

    @Id
    @Column(name = "id")
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Basic
    @Column(name = "price")
    public int getPrice()
    {
        return price;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Offer offer = (Offer) o;

        if (id != offer.id) return false;
        if (price != offer.price) return false;
        if (name != null ? !name.equals(offer.name) : offer.name != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }

    @OneToOne
    @JoinColumn(name = "category", referencedColumnName = "id", nullable = false)
    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }
}