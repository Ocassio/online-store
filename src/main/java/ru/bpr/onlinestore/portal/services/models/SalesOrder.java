package ru.bpr.onlinestore.portal.services.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sales_orders")
public class SalesOrder
{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "id")
    private User user;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }
}
