package com.example.courseworkbackend.dao;

import com.example.courseworkbackend.SQL.ConnectionPGAdmin;
import models.categories;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class Categories implements ConnectionPGAdmin {

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

    public List<categories> categories() {
        List<categories> categories = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "Select * from categories";
            ResultSet resultSet = statement.executeQuery(SQL);
            System.out.println(resultSet);
            while (resultSet.next()) {
                categories categories1 = new categories();
                categories1.setId(resultSet.getInt("id_categories"));
                categories1.setCategories(resultSet.getString("title"));

                categories.add(categories1);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return categories;
    }

}
