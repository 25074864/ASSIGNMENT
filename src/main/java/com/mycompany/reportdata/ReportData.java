/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.reportdata;

/**Names: Phuluwa Mulalo
 *Student number:25074864
 * @author User
 */

public class ReportData {
    private String productCode;
    private String productName;
    private String category;
    private String warranty;
    private double price;
    private int stockLevel;
    private String supplier;

    public ReportData(String productCode, String productName, String category, 
                      String warranty, double price, int stockLevel, String supplier) {
        this.productCode = productCode;
        this.productName = productName;
        this.category = category;
        this.warranty = warranty;
        this.price = price;
        this.stockLevel = stockLevel;
        this.supplier = supplier;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
