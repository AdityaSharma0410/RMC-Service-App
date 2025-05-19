package com.example.rmcserviceapp.controller;

import com.example.rmcserviceapp.DatabaseHelper;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import com.example.rmcserviceapp.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerFormController {

    @FXML private DatePicker dateField;
    @FXML private TextField timeField, orderField, customerNameField, addressField, contactField, siteNameField;

    @FXML
    private void handleSave() {
        Customer customer = new Customer(
                dateField.getValue(),
                timeField.getText(),
                orderField.getText(),
                customerNameField.getText(),
                addressField.getText(),
                contactField.getText(),
                siteNameField.getText()
        );

        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement stmt = conn.prepareStatement(
                     "INSERT INTO customers(date, time, order_no, name, address, contact, site_name) VALUES(?, ?, ?, ?, ?, ?, ?)"
             )) {
            stmt.setString(1, customer.getDate().toString());
            stmt.setString(2, customer.getTime());
            stmt.setString(3, customer.getOrderNumber());
            stmt.setString(4, customer.getName());
            stmt.setString(5, customer.getAddress());
            stmt.setString(6, customer.getContact());
            stmt.setString(7, customer.getSiteName());
            stmt.executeUpdate();
            System.out.println("Customer saved to DB.");
        } catch (SQLException e) {
            System.err.println("DB Error: " + e.getMessage());
        }
    }

}
