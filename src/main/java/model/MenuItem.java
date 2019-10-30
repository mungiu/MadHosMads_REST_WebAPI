package model;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import service.IUserService;

import java.sql.ResultSet;
import java.sql.SQLException;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "clientType")

public class MenuItem {
    private String name;
    private String description;
    private double price;

    public MenuItem() {
    }

    public MenuItem(String name, String description, double price) {
        this.name = name;
        this.description=description;
        this.price=price;
    }

    public MenuItem populateFromResultSet(ResultSet resultSet) throws SQLException {
        MenuItem menuItem = new MenuItem(
                resultSet.getString("name"),
                resultSet.getString("description"),
                resultSet.getDouble("price")
        );

        return menuItem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}