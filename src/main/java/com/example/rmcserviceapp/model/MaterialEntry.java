package com.example.rmcserviceapp.model;

public class MaterialEntry {
    private String orderNumber;
    private double dustSet, dustActual;
    private double aggregateSet, aggregateActual;
    private double cementSet, cementActual;

    public MaterialEntry(String orderNumber,
                         double dustSet, double dustActual,
                         double aggregateSet, double aggregateActual,
                         double cementSet, double cementActual) {
        this.orderNumber = orderNumber;
        this.dustSet = dustSet;
        this.dustActual = dustActual;
        this.aggregateSet = aggregateSet;
        this.aggregateActual = aggregateActual;
        this.cementSet = cementSet;
        this.cementActual = cementActual;
    }

    @Override
    public String toString() {
        return "MaterialEntry{" +
                "orderNumber='" + orderNumber + '\'' +
                ", dustSet=" + dustSet +
                ", dustActual=" + dustActual +
                ", aggregateSet=" + aggregateSet +
                ", aggregateActual=" + aggregateActual +
                ", cementSet=" + cementSet +
                ", cementActual=" + cementActual +
                '}';
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public double getDustSet() {
        return dustSet;
    }

    public void setDustSet(double dustSet) {
        this.dustSet = dustSet;
    }

    public double getDustActual() {
        return dustActual;
    }

    public void setDustActual(double dustActual) {
        this.dustActual = dustActual;
    }

    public double getAggregateSet() {
        return aggregateSet;
    }

    public void setAggregateSet(double aggregateSet) {
        this.aggregateSet = aggregateSet;
    }

    public double getAggregateActual() {
        return aggregateActual;
    }

    public void setAggregateActual(double aggregateActual) {
        this.aggregateActual = aggregateActual;
    }

    public double getCementSet() {
        return cementSet;
    }

    public void setCementSet(double cementSet) {
        this.cementSet = cementSet;
    }

    public double getCementActual() {
        return cementActual;
    }

    public void setCementActual(double cementActual) {
        this.cementActual = cementActual;
    }
}
