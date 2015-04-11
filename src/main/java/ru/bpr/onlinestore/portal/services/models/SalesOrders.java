package ru.bpr.onlinestore.portal.services.models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sales_orders", schema = "", catalog = "mydb")
public class SalesOrders
{
    private int id;
    private Timestamp date;
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
    @Column(name = "date")
    public Timestamp getDate()
    {
        return date;
    }

    public void setDate(Timestamp date)
    {
        this.date = date;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SalesOrders that = (SalesOrders) o;

        if (id != that.id) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
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
