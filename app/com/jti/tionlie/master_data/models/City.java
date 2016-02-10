package com.jti.tionlie.master_data.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by User on 2/9/2016.
 */
@Entity
@Table(name = "mtd_city")
public class City {
    @Id
    @Column(name = "id_city",nullable = false)
    private String id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "postcal_code",nullable = false)
    private String postalCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
