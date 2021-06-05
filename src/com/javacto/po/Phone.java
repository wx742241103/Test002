package com.javacto.po;

/**
 * WX742241103
 */
public class Phone{
    private int id;
    private String price;
    private String type;
    private String name;

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", price='" + price + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
