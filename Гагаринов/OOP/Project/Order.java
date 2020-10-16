package com.company;

import java.io.File;

public class Order {
    private int id;
    private int serviceId;
    private int employeeId;
    private String customerFIO;
    private String customerEmail;
    private int durationMaterial;
    private int cost;
    private int inDate;
    private int approximateDate;
    private boolean status;
    private File inputMaterial;

    public Order(int id,
                 int serviceId,
                 int employeeId,
                 String customerFIO,
                 String customerEmail,
                 int durationMaterial,
                 int cost,
                 int inDate,
                 int approximateDate,
                 boolean status,
                 File inputMaterial) {
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

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
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

    public int getInDate() {
        return inDate;
    }

    public void setInDate(int inDate) {
        this.inDate = inDate;
    }

    public int getApproximateDate() {
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

    public File getInputMaterial() {
        return inputMaterial;
    }

    public void setInputMaterial(File inputMaterial) {
        this.inputMaterial = inputMaterial;
    }
}
