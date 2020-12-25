package com.company;

public class Receipt {
    private int receiptId;
    private String receiptName;
    private String receiptIngredients;
    private String author;
    private String receiptSize;
    private String receiptCategory;
    private String algorithm;

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    private String picturePath;

    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    public String getReceiptName() {
        return receiptName;
    }

    public void setReceiptName(String receiptName) {
        this.receiptName = receiptName;
    }

    public String getReceiptIngredients() {
        return receiptIngredients;
    }

    public void setReceiptIngredients(String receiptIngredients) {
        this.receiptIngredients = receiptIngredients;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getReceiptSize() {
        return receiptSize;
    }

    public void setReceiptSize(String receiptSize) {
        this.receiptSize = receiptSize;
    }

    public String getReceiptCategory()
    {
        return receiptCategory;
    }

    public void setReceiptCategory(String receiptCategory)
    {
        this.receiptCategory = receiptCategory;
    }

    public String getAlgorithm()
    {
        return algorithm;
    }

    public void setAlgorithm(String algorithm)
    {
        this.algorithm = algorithm;
    }
    
}
