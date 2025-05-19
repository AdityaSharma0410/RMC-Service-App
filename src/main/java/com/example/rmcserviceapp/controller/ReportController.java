package com.example.rmcserviceapp.controller;

import com.example.rmcserviceapp.DatabaseHelper;
import com.example.rmcserviceapp.model.ReportRow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.*;

public class ReportController {

    @FXML private TextField orderFilterField;
    @FXML private DatePicker dateFilterField;
    @FXML private TableView<ReportRow> reportTable;
    @FXML private TableColumn<ReportRow, String> orderCol;
    @FXML private TableColumn<ReportRow, String> nameCol;
    @FXML private TableColumn<ReportRow, String> dateCol;
    @FXML private TableColumn<ReportRow, String> siteCol;

    private final ObservableList<ReportRow> reportData = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        orderCol.setCellValueFactory(data -> data.getValue().orderNumberProperty());
        nameCol.setCellValueFactory(data -> data.getValue().nameProperty());
        dateCol.setCellValueFactory(data -> data.getValue().dateProperty());
        siteCol.setCellValueFactory(data -> data.getValue().siteNameProperty());

        loadAllData();
    }

    private void loadAllData() {
        reportData.clear();
        try (Connection conn = DatabaseHelper.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT order_no, name, date, site_name FROM customers")) {
            while (rs.next()) {
                reportData.add(new ReportRow(
                        rs.getString("order_no"),
                        rs.getString("name"),
                        rs.getString("date"),
                        rs.getString("site_name")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Load error: " + e.getMessage());
        }
        reportTable.setItems(reportData);
    }

    @FXML
    private void handleFilter() {
        String order = orderFilterField.getText().trim();
        String date = dateFilterField.getValue() != null ? dateFilterField.getValue().toString() : "";

        String sql = "SELECT order_no, name, date, site_name FROM customers WHERE 1=1";
        if (!order.isEmpty()) sql += " AND order_no = '" + order + "'";
        if (!date.isEmpty()) sql += " AND date = '" + date + "'";

        reportData.clear();
        try (Connection conn = DatabaseHelper.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                reportData.add(new ReportRow(
                        rs.getString("order_no"),
                        rs.getString("name"),
                        rs.getString("date"),
                        rs.getString("site_name")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Filter error: " + e.getMessage());
        }
        reportTable.setItems(reportData);
    }

    @FXML
    private void handleShowAll() {
        orderFilterField.clear();
        dateFilterField.setValue(null);
        loadAllData();
    }
}
