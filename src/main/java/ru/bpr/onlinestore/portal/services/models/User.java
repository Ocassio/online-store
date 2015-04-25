package ru.bpr.onlinestore.portal.services.models;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "users")
public class User
{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private BigInteger id;

    @Column(name = "email", unique = true, length = 50)
    private String email;

    @Column(name = "password", length = 50)
    private String password;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "surname", length = 50)
    private String surname;

    @Column(name = "address", length = 255)
    private String address;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Rating> rating;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<SalesOrder> salesOrders;

    public BigInteger getId()
    {
        return id;
    }

    public void setId(BigInteger id)
    {
        this.id = id;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public List<Rating> getRating()
    {
        return rating;
    }

    public void setRating(List<Rating> rating)
    {
        this.rating = rating;
    }

    public List<SalesOrder> getSalesOrders()
    {
        return salesOrders;
    }

    public void setSalesOrders(List<SalesOrder> salesOrders)
    {
        this.salesOrders = salesOrders;
    }
}
/**
 *`id` INT NOT NULL AUTO_INCREMENT,
 * `email` VARCHAR(50) NOT NULL,
 * `password` VARCHAR(50) NOT NULL,
 * `name` VARCHAR(50) NULL,
 * `surname` VARCHAR(50) NULL,
 * `address` VARCHAR(255) NULL,
 */
