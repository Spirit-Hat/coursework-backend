package com.example.courseworkbackend.dao;

import com.example.courseworkbackend.SQL.ConnectionPGAdmin;
import models.categories;
import models.product;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class Product implements ConnectionPGAdmin {

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
             connection = DriverManager.getConnection(URL, USER, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<product> getproduct(int id){
        List<product> productList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "select id,product.title,price,new_product,bestseller,logos,logos_alt from product inner join categories on \n" +
                    "product.id_categories = categories.id_categories \n" +
                    "where categories.id_categories ="+id+";";
            ResultSet resultSet =  statement.executeQuery(SQL);
            while (resultSet.next()){
                product product = new product();
                product.setId(resultSet.getInt("id"));
                product.setTitle(resultSet.getString("title"));
                product.setPrice(resultSet.getDouble("price"));
                product.setNew_product(resultSet.getBoolean("new_product"));
                product.setBestseller(resultSet.getBoolean("bestseller"));
                product.setLogos(resultSet.getString("logos"));
                product.setLogos_alt(resultSet.getString("logos_alt"));


                productList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return productList;
    }



}
