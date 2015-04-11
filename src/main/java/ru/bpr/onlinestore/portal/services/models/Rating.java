package ru.bpr.onlinestore.portal.services.models;

import javax.persistence.*;


@Entity
@Table(name = "ratings")
public class Rating
{
    private int id;
    private int rating;
    private String comment;
    private Offer offer;
    private User user;

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
    @Column(name = "rating")
    public int getRating()
    {
        return rating;
    }

    public void setRating(int rating)
    {
        this.rating = rating;
    }

    @Basic
    @Column(name = "comment")
    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rating rating = (Rating) o;

        if (id != rating.id) return false;
        if (this.rating != rating.rating) return false;
        if (comment != null ? !comment.equals(rating.comment) : rating.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + rating;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }

    @OneToOne
    @JoinColumn(name = "offer", referencedColumnName = "id", nullable = false)
    public Offer getOffer()
    {
        return offer;
    }

    public void setOffer(Offer offer)
    {
        this.offer = offer;
    }

    @OneToOne
    @JoinColumn(name = "user", referencedColumnName = "id", nullable = false)
    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
