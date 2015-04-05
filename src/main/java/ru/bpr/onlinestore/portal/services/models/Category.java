package ru.bpr.onlinestore.portal.services.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "categories")
public class Category implements Serializable
{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
}
