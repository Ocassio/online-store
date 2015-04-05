package ru.bpr.onlinestore.portal.services.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "offers")
public class Offer implements Serializable
{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "category")
    private Category category;
}
