package pl.ug.edu.fiszkord.domain;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Customer {
    private Long id;
    private String name;
    private float money;
    private Date date;

    public Customer() {}

    public Customer(String name, float money, Date date) {
        this.name = name;
        this.money = money;
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
