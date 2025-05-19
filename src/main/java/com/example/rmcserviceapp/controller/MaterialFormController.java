package com.example.rmcserviceapp.controller;

import com.example.rmcserviceapp.DatabaseHelper;
import com.example.rmcserviceapp.model.MaterialEntry;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MaterialFormController {

    @FXML private TextField orderField;

    @FXML private TextField dustSetField;
    @FXML private TextField dustActualField;

    @FXML private TextField aggSetField;
    @FXML private TextField aggActualField;

    @FXML private TextField cementSetField;
    @FXML private TextField cementActualField;

    @FXML
    private void handleSave() {
        try {
            MaterialEntry entry = new MaterialEntry(
                    orderField.getText(),
                    Double.parseDouble(dustSetField.getText()),
                    Double.parseDouble(dustActualField.getText()),
                    Double.parseDouble(aggSetField.getText()),
                    Double.parseDouble(aggActualField.getText()),
                    Double.parseDouble(cementSetField.getText()),
                    Double.parseDouble(cementActualField.getText())
            );

            try (Connection conn = DatabaseHelper.connect();
                 PreparedStatement stmt = conn.prepareStatement(
                         "INSERT INTO materials(order_no, dust_set, dust_actual, agg_set, agg_actual, cement_set, cement_actual) VALUES (?, ?, ?, ?, ?, ?, ?)"
                 )) {
                stmt.setString(1, entry.getOrderNumber());
                stmt.setDouble(2, entry.getDustSet());
                stmt.setDouble(3, entry.getDustActual());
                stmt.setDouble(4, entry.getAggregateSet());
                stmt.setDouble(5, entry.getAggregateActual());
                stmt.setDouble(6, entry.getCementSet());
                stmt.setDouble(7, entry.getCementActual());
                stmt.executeUpdate();
                System.out.println("Material entry saved to DB.");
            }

        } catch (NumberFormatException | SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
