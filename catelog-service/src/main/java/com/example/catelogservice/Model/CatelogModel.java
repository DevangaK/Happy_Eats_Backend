package com.example.catelogservice.Model;

import jakarta.persistence.*;

@Entity
@Table(name="Products")
public class CatelogModel {
    public CatelogModel() {
    }
    //id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    //fname
    @Column(name="ProductName")
    private String PName;

    //lname
    @Column(name="VegorNon")
    private String VegOrNon;

    @Column(name="Description")
    private String Description;

    //age
    @Column(name="Price")
    private Float Price;

    //age
    @Column(name="Image")
    private String Image;

    @Column(name="dietary")
    private String dietary;

    @Column(name="cousin")
    private String cousin;

    @Column(name="allergies")
    private String allergies;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getPName() {
        return PName;
    }

    public void setPName(String PName) {
        this.PName = PName;
    }

    public String getVegOrNon() {
        return VegOrNon;
    }

    public void setVegOrNon(String vegOrNon) {
        VegOrNon = vegOrNon;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Float getPrice() {
        return Price;
    }

    public void setPrice(Float price) {
        Price = price;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getdietary() {
        return dietary;
    }

    public void setDietary(String dietary) {
        this.dietary = dietary;
    }

    public String getcousin() {
        return cousin;
    }

    public void setcousin(String cousin) {
        this.cousin = cousin;
    }

    public String getallergies() {
        return allergies;
    }

    public void setallergies(String allergies) {
        this.allergies = allergies;
    }
}
