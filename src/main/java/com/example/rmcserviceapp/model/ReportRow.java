package com.example.rmcserviceapp.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ReportRow {
    private final StringProperty orderNumber;
    private final StringProperty name;
    private final StringProperty date;
    private final StringProperty siteName;

    public ReportRow(String orderNumber, String name, String date, String siteName) {
        this.orderNumber = new SimpleStringProperty(orderNumber);
        this.name = new SimpleStringProperty(name);
        this.date = new SimpleStringProperty(date);
        this.siteName = new SimpleStringProperty(siteName);
    }

    public StringProperty orderNumberProperty() { return orderNumber; }
    public StringProperty nameProperty() { return name; }
    public StringProperty dateProperty() { return date; }
    public StringProperty siteNameProperty() { return siteName; }
}
