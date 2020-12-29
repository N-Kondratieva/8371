package com.company;

import java.io.File;

public class Order {
    private int id;
    private String serviceId;
    private String employeeId;
    private String customerFIO;
    private String customerEmail;
    private int durationMaterial;
    private int cost;
    private long inDate;
    private long approximateDate;
    private boolean status;
    private String inputMaterial;

    public Order(int id,
                 String serviceId,
                 String employeeId,
                 String customerFIO,
                 String customerEmail,
                 int durationMaterial,
                 int cost,
                 long inDate,
                 long approximateDate,
                 boolean status,
                 String inputMaterial) {
        this.id = id;
        this.serviceId = serviceId;
        this.employeeId = employeeId;
        this.customerFIO = customerFIO;
        this.customerEmail = customerEmail;
        this.durationMaterial = durationMaterial;
        this.cost = cost;
        this.inDate = inDate;
        this.approximateDate = approximateDate;
        this.status = status;
        this.inputMaterial = inputMaterial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getCustomerFIO() {
        return customerFIO;
    }

    public void setCustomerFIO(String customerFIO) {
        this.customerFIO = customerFIO;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public int getDurationMaterial() {
        return durationMaterial;
    }

    public void setDurationMaterial(int durationMaterial) {
        this.durationMaterial = durationMaterial;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public long getInDate() {
        return inDate;
    }

    public void setInDate(int inDate) {
        this.inDate = inDate;
    }

    public long getApproximateDate() {
        return approximateDate;
    }

    public void setApproximateDate(int approximateDate) {
        this.approximateDate = approximateDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getInputMaterial() {
        return inputMaterial;
    }

    public void setInputMaterial(String inputMaterial) {
        this.inputMaterial = inputMaterial;
    }
}
