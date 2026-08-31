/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reportdata;

/**Names: Phuluwa M
 * Student number: 25074864
 *
 * @author User
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Products {
    private ArrayList<ReportData> productList = new ArrayList<ReportData>();
    private Scanner scanner = new Scanner(System.in);

    public void DisplayMenu() {
        boolean running = true;
        
        while (running) {
            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("(1) Capture a new product.");
            System.out.println("(2) Search for a product.");
            System.out.println("(3) Update a product.");
            System.out.println("(4) Delete a product.");
            System.out.println("(5) Print report.");
            System.out.println("(6) Exit Application.");
            System.out.print("Selection >> ");
            
            String choice = scanner.nextLine();
            
            if (choice.equals("1")) {
                CaptureProduct();
            } else if (choice.equals("2")) {
                SearchProduct();
            } else if (choice.equals("3")) {
                UpdateProduct();
            } else if (choice.equals("4")) {
                DeleteProduct();
            } else if (choice.equals("5")) {
                PrintReport();
            } else if (choice.equals("6")) {
                ExitApplication();
                running = false;
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
            
            if (running) {
                System.out.println("\nEnter (1) to launch menu or any other key to exit");
                String launchChoice = scanner.nextLine();
                if (!launchChoice.equals("1")) {
                    ExitApplication();
                    running = false;
                }
            }
        }
    }

    public void CaptureProduct() {
        System.out.println("\nCAPTURE A NEW PRODUCT");
        System.out.println("***********************");
        
        System.out.print("Enter the product code: ");
        String code = scanner.nextLine();
        
        System.out.print("Enter the product name: ");
        String name = scanner.nextLine();
        
        String category = "";
        boolean validCategory = false;
        
        while (validCategory == false) {
            System.out.println("Select the product category:");
            System.out.println("Desktop Computer - 1");
            System.out.println("Laptop - 2");
            System.out.println("Tablet - 3");
            System.out.println("Printer - 4");
            System.out.println("Gaming Console - 5");
            System.out.print("Product Category >> ");
            String catChoice = scanner.nextLine();
            
            if (catChoice.equals("1")) {
                category = "Desktop Computer";
                validCategory = true;
            } else if (catChoice.equals("2")) {
                category = "Laptop";
                validCategory = true;
            } else if (catChoice.equals("3")) {
                category = "Tablet";
                validCategory = true;
            } else if (catChoice.equals("4")) {
                category = "Printer";
                validCategory = true;
            } else if (catChoice.equals("5")) {
                category = "Gaming Console";
                validCategory = true;
            } else {
                System.out.println("Invalid choice. Please enter a valid product category.\n");
            }
        }
        
        System.out.println("Indicate the product warranty. Enter (1) for 6 months or any other key for 2 years.");
        System.out.print("Warranty choice >> ");
        String warrantyChoice = scanner.nextLine();
        String warranty = "";
        
        if (warrantyChoice.equals("1")) {
            warranty = "6 months";
        } else {
            warranty = "2 years";
        }
        
        System.out.print("Enter the price for " + name + " >> ");
        double price = Double.parseDouble(scanner.nextLine());
        
        System.out.print("Enter the stock level for " + name + " >> ");
        int stock = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Enter the supplier for " + name + " >> ");
        String supplier = scanner.nextLine();
        
        ReportData p = new ReportData(code, name, category, warranty, price, stock, supplier);
        SaveProduct(p);
    }

    public void SaveProduct(ReportData product) {
        productList.add(product);
        System.out.println("Product details has been saved successfully!!!");
    }

    public void SearchProduct() {
        System.out.print("Please enter the product code to search: ");
        String code = scanner.nextLine();
        
        ReportData product = null;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductCode().equalsIgnoreCase(code)) {
                product = productList.get(i);
            }
        }
        
        if (product != null) {
            System.out.println("**************************************************************************");
            System.out.println("PRODUCT SEARCH RESULTS");
            System.out.println("**************************************************************************");
            System.out.println("PRODUCT CODE:\t\t" + product.getProductCode());
            System.out.println("PRODUCT NAME:\t\t" + product.getProductName());
            System.out.println("PRODUCT WARRANTY:\t" + product.getCategory()); 
            System.out.println("PRODUCT CATEGORY:\t" + product.getWarranty());
            System.out.println("PRODUCT PRICE:\t\tR " + product.getPrice());
            System.out.println("PRODUCT STOCK LEVELS:\t" + product.getStockLevel());
            System.out.println("PRODUCT SUPPLIER:\t" + product.getSupplier());
            System.out.println("**************************************************************************");
        } else {
            System.out.println("The product cannot be located. Invalid Product");
        }
    }

    public void UpdateProduct() {
        System.out.print("Please enter the product code to update: ");
        String code = scanner.nextLine();
        
        ReportData product = null;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductCode().equalsIgnoreCase(code)) {
                product = productList.get(i);
            }
        }
        
        if (product == null) {
            System.out.println("The product cannot be located. Invalid Product");
            return;
        }
        
        System.out.print("Update the warranty? (y) Yes, (n) No: ");
        String upWarranty = scanner.nextLine().toLowerCase();
        if (upWarranty.equals("y")) {
            System.out.println("Enter (1) for 6 months or any other key for 2 years.");
            String warrantyChoice = scanner.nextLine();
            if (warrantyChoice.equals("1")) {
                product.setWarranty("6 months");
            } else {
                product.setWarranty("2 years");
            }
        }
        
        System.out.print("Update the product price? (y) Yes, (n) No: ");
        String upPrice = scanner.nextLine().toLowerCase();
        if (upPrice.equals("y")) {
            System.out.print("Enter the new price for " + product.getProductName() + " >> ");
            double newPrice = Double.parseDouble(scanner.nextLine());
            product.setPrice(newPrice);
        }
        
        System.out.print("Update the stock level? (y) Yes, (n) No: ");
        String upStock = scanner.nextLine().toLowerCase();
        if (upStock.equals("y")) {
            System.out.print("Enter the new stock level >> ");
            int newStock = Integer.parseInt(scanner.nextLine());
            product.setStockLevel(newStock);
        }
        
        System.out.println("Product details has been updated successfully!!!");
    }

    public void DeleteProduct() {
        System.out.print("Please enter the product code to delete: ");
        String code = scanner.nextLine();
        
        ReportData product = null;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductCode().equalsIgnoreCase(code)) {
                product = productList.get(i);
            }
        }
        
        if (product == null) {
            System.out.println("The product cannot be located. Invalid Product");
            return;
        }
        
        System.out.print("Are you sure you want to delete product " + code + "? (y) Yes, (n) No: ");
        String confirmation = scanner.nextLine().toLowerCase();
        
        if (confirmation.equals("y")) {
            productList.remove(product);
            System.out.println("Product has been deleted successfully!");
        } else {
            System.out.println("Deletion cancelled.");
        }
    }

    public void PrintReport() {
        if (productList.size() == 0) {
            System.out.println("No product data available to generate a report.");
            return;
        }
        
        System.out.println("PRODUCT REPORT");
        System.out.println("==========================================================================");
        
        double totalValue = 0;
        
        for (int i = 0; i < productList.size(); i++) {
            ReportData p = productList.get(i);
            System.out.println("PRODUCT " + (i + 1));
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("PRODUCT CODE >>\t\t" + p.getProductCode());
            System.out.println("PRODUCT NAME >>\t\t" + p.getProductName());
            System.out.println("PRODUCT CATEGORY >>\t" + p.getWarranty());
        }
    }

    void ExitApplication() {
System.out.println("Application closed.");
System.exit(0);

}
    
}

