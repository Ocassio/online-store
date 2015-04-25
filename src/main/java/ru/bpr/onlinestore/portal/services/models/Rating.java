package ru.bpr.onlinestore.portal.services.models;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "ratings")
public class Rating
{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private BigInteger id;

    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "comment")
    private String comment;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user", referencedColumnName = "id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "offer", referencedColumnName = "id")
    private Offer offer;

    public BigInteger getId()
    {
        return id;
    }

    public void setId(BigInteger id)
    {
        this.id = id;
    }

    public int getRating()
    {
        return rating;
    }

    public void setRating(int rating)
    {
        this.rating = rating;
    }

    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Offer getOffer()
    {
        return offer;
    }

    public void setOffer(Offer offer)
    {
        this.offer = offer;
    }
}