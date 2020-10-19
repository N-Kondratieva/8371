package com.company;

public class Receipt {
    private int receiptId;
    private String receiptName;
    private String receiptIngredients;
    private String author;
    private int receiptSize;
    private String receiptCategory;
    private String algorithm;
    private String receiptTags;

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

    public int getReceiptSize() {
        return receiptSize;
    }

    public void setReceiptSize(int receiptSize) {
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

    public String getReceiptTags()
    {
        return receiptTags;
    }

    public void setReceiptTags(String receiptTags)
    {
        this.receiptTags = receiptTags;
    }
}
