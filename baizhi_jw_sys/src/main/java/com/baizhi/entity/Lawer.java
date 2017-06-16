package com.baizhi.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class Lawer implements Serializable{
    private String id;

    private String name;

    private String address;

    private String year;

    private String number;

    private String workspace;

    private String description;

    private BigDecimal wordprice;

    private BigDecimal phoneprice;

    private String photo;

    private String status;


    //维护关系属性
    private List<Lawertype> lawertypes;
    private List<Order> orders;
    private List<User> users;
    private List<Redpackage> redpackages;



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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getWorkspace() {
        return workspace;
    }

    public void setWorkspace(String workspace) {
        this.workspace = workspace;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getWordprice() {
        return wordprice;
    }

    public void setWordprice(BigDecimal wordprice) {
        this.wordprice = wordprice;
    }

    public BigDecimal getPhoneprice() {
        return phoneprice;
    }

    public void setPhoneprice(BigDecimal phoneprice) {
        this.phoneprice = phoneprice;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Lawertype> getLawertypes() {
        return lawertypes;
    }

    public void setLawertypes(List<Lawertype> lawertypes) {
        this.lawertypes = lawertypes;
    }


    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Redpackage> getRedpackages() {
        return redpackages;
    }

    public void setRedpackages(List<Redpackage> redpackages) {
        this.redpackages = redpackages;
    }

    @Override
    public String toString() {
        return "Lawer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", year='" + year + '\'' +
                ", number='" + number + '\'' +
                ", workspace='" + workspace + '\'' +
                ", description='" + description + '\'' +
                ", wordprice=" + wordprice +
                ", phoneprice=" + phoneprice +
                ", photo='" + photo + '\'' +
                ", status='" + status + '\'' +
                ", lawertypes=" + lawertypes +
                '}';
    }

}