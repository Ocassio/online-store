package ru.bpr.onlinestore.portal.services.models;

import javax.persistence.*;

@Entity
@Table(name = "sales_order_entries", schema = "", catalog = "mydb")
public class SalesOrderEntry
{
    private int id;
    private int count;
    private Offer offer;
    private SalesOrders salesOrder;

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
    @Column(name = "count")
    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SalesOrderEntry that = (SalesOrderEntry) o;

        if (count != that.count) return false;
        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = id;
        result = 31 * result + count;
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
    @JoinColumn(name = "sales_order", referencedColumnName = "id", nullable = false)
    public SalesOrders getSalesOrder()
    {
        return salesOrder;
    }

    public void setSalesOrder(SalesOrders salesOrder)
    {
        this.salesOrder = salesOrder;
    }
}
