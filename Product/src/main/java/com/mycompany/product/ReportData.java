/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
// Names: Phuluwa Mulalo
//Student no: 25074864
package com.mycompany.product;

/**
 *
 * @author User
 */
import java.util.ArrayList;
import java.util.Scanner;

public class ReportData {
    private String productCode;
    private String productName;
    private String productCategory;
    private String productWarranty;
    private double productPrice;
    private int stockLevel;
    private String productSupplier;
    
    ArrayList<ReportData>productList = new ArrayList<>();
    
    // Default Contructor
    public ReportData(){
        
    }
    public ReportData(String productCode,String productName, String productCategory,String productWarranty, double productPrice, int stockLevel,String productSupplier){
        this.productCode = productCode;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productWarranty = productWarranty;
        this.productPrice = productPrice;
        this.stockLevel = stockLevel;
        this.productSupplier = productSupplier;
    }
     //Getters and Setters
    public String getProductCode(){
        return productCode;
    }
    public void setProductCode(String productCode){
        this.productCode = productCode;
    }
    public String getProductName(){
        return productName;
    }
    public void setProductName(String productName){
        this.productName = productName;
    }
    public String getProductCategory(){
        return productCategory;
    }
    public void setProductCategory(String productCategory){
        this.productCategory = productCategory;
    }
    public String getProductWarranty(){
        return productWarranty;
    }
    public void setProductWarranty(String productWarranty){
        this.productWarranty = productWarranty;
    }
    public double getProductPrice(){
        return productPrice;
    }
    public void setProductPrice(double productPrice){
        this.productPrice = productPrice;
    }
    public int getStockLevel(){
        return stockLevel;
    }
    public void setStockLevel(int stockLevel){
        this.stockLevel = stockLevel;
    }
    public String getProductSupplier(){
        return productSupplier;
    }
    public void setProductSupplier(String productSupplier){
        this.productSupplier = productSupplier;
    }
   }

// Q1.2Products class containing all working methods
class Products{
    private ArrayList<ReportData> productList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    
    //Temporary fields to support zero-argument SaveProduct() specification
    private String tempCode;
    private String tempName;
    private String tempCategory;
    private String tempWarranty;
    private double tempPrice;
    private int tempStock;
    private String tempSupplier;
    
    //Q.1.1: Launch Application Structure
    public void startApplication(){
        System.out.println("BRIGHT FUTURE TECHNOLOGIES APPLICATION");
        System.out.println("*************************************");
        System.out.println("Enter (1) to launch menu or any other key to exit: ");
        String choice = scanner.nextLine();
        
        if(choice.equals("1")){
            DisplayMenu();
        }else{
            ExitApplication();
        }
    }
    
    //Display Menu method
    public void DisplayMenu(){
        while(true){
            System.out.println("\n Please select one of the following menu items");
            System.out.println("(1)Capture a new product");
            System.out.println("(2)Search for a product");
            System.out.println("(3)Update a product");
            System.out.println("(4)Delete a product");
            System.out.println("(5)Print report");
            System.out.println("(6)Exit Application");
            System.out.print("Selection: ");
            
            String choice = scanner.nextLine();
            switch (choice){
                case "1":CaptureProduct();
                break;
                case "2":SearchProduct();
                break;
                case "3":UpdateProduct();
                break;
                case "4":DeleteProduct();
                break;
                case "5":PrintReport();
                break;
                case "6":ExitApplication();
                return;
                default:
                    System.out.println("Invalid selection.Please try again.");
                    continue;
            }
            
            System.out.print("\nEnter (1) to launch menu or any other key to exit:");
            if(!scanner.nextLine().equals("1")){
                ExitApplication();
                return;
            }
        }
    }
    
    //Capture product method
    public void CaptureProduct(){
        System.out.println("\nCAPTURE A NEW PRODUCT");
        System.out.println("***********************");
        
        System.out.print("Enter the product code: ");
        tempCode = scanner.nextLine();
        
        System.out.print("Enter the product name: ");
                tempName = scanner.nextLine();
                        
                
         //Q1.4 & Q1.5: Category selection and Input validation loop
         tempCategory = "";
         while(tempCategory.isEmpty()) {
             System.out.println("Select the product category:");
             System.out.println("Desktop Computer -1");
             System.out.println("Laptop -2 ");
             System.out.println("Tablet -3");
             System.out.println("Printer -4");
             System.out.println("Gaming Console-5");
             System.out.print("Product Category>>");
             String catChoice = scanner.nextLine();
             
             switch (catChoice){
                 case "1": tempCategory = "Desktop Computer";break;
                 case "2": tempCategory = "Laptop";break;
                 case "3": tempCategory = "Tablet";break;
                 case "4": tempCategory = "Printer";break;
                 case "5": tempCategory = "Gaming Console";break;
                 default:
                     System.out.println("Invalid selection!Please enter a valid product category");
             }
         }
          //Q.1.6: Product Warranty options
          System.out.println("Indicate the product warranty.Enter(1) for 6 months or any other key for 2 years");
          System.out.print("Warranty choice>> ");
          String warrantyChoice = scanner.nextLine();
          tempWarranty = warrantyChoice.equals("1")? "6 months": "2 years";
          
          //Numeric validation for price
          while(true){
              try{
                  System.out.print("Enter the price for" + tempName+">>");
                  tempPrice = Integer.parseInt(scanner.nextLine());
                  if(tempPrice < 0){
                      System.out.println("Price cannot be negative.Please enter a valid price.");
                      continue;
                  }
                  break;
              }catch(NumberFormatException e){
                  System.out.println("Invalid number format.Please enter a valid price.");
              }
                     }
          
          //Numeric validation for stock levels
          while(true){
              try{
                  System.out.print("Enter the stock level for"+tempName+">>");
                  tempStock = Integer.parseInt(scanner.nextLine());
                  if(tempStock<0){
                      System.out.println("Stock level cannot be negative.Please enter a valid integer.");
                      continue;
                  }
                  break;
              }catch(NumberFormatException e){
                  System.out.println("Invalid number format.Please enter a valid integer");
              }
          }
          System.out.println("Enter the supplier for"+ tempName+ ">>");
          tempSupplier = scanner.nextLine();
          
          SaveProduct();
    
    }
    //SaveProduct Method
    public void SaveProduct() {
        ReportData Products = new ReportData(tempCode, tempName,tempCategory,tempWarranty,tempPrice,tempStock,tempSupplier);
        productList.add(Products);
        System.out.println("Product details has been saved successfully!!!");
    }
    
    //SearchProductMethod
    public void SearchProduct(){
        System.out.println("Please enter the product code to search:");
        String code = scanner.nextLine();
        
        ReportData Products = findProductByCode(code);
        
        if (Products != null){
            
            System.out.println("*******************************************************************");
            System.out.println("PRODUCT SEARCH RESULTS");
            System.out.println("******************************************************************************");
            System.out.println("PRODUCT CODE:     "+ Products.getProductCode());
            System.out.println("PRODUCT NAME:     "+Products.getProductName());
            System.out.println("PRODUCT WARRANTY:  "+Products.getProductWarranty());
            System.out.println("PRODUCT CATEGORY:   R"+Products.getProductCategory());
            System.out.println("PRODUCT PRICE:    R"+Products.getProductPrice());
            System.out.println("PRODUCT STOCK LEVELS" +Products.getStockLevel());
            System.out.println("PRODUCT SUPPLIER:   "+Products.getProductSupplier());
            
            System.out.println("********************************************************************************");
        }else{
            System.out.println("The product cannot be located.Invalid product");
        }
    }
    
    //Update product method
    public void UpdateProduct(){
        System.out.print("Please enter the product code to update:");
        String code = scanner.nextLine();
        
        ReportData Products = findProductByCode(code);
        
        if (Products != null){
            System.out.print("Update the warranty?(y) Yes,(n) No >>");
            if(scanner.nextLine().equalsIgnoreCase("y")) {
                System.out.println("Enter(1) for 6 months or any other key for 2 years.");
                String choice = scanner.nextLine();
                Products.setProductWarranty(choice.equals("1")? "6 months": "2years");
            }
            
            System.out.print("Update the product price?(y) Yes, (n)No>>");
            if(scanner.nextLine().equalsIgnoreCase("y")){
                while(true){
                    try{
                        System.out.print("Enter the new price for"+Products.getProductName()+">>");
                        double newPrice = Double.parseDouble(scanner.nextLine());
                        if(newPrice<0) {
                            System.out.println("Price cannot be negative.Please enter a valid price");
                            continue;
                        }
                        Products.setProductPrice(newPrice);
                        break;
                    }catch(NumberFormatException e){
                        System.out.println("Invalid number format.Please enter a valid price.");
                    }
                }
            }
            
            System.out.print("Update the stock level? (y) Yes, (n) No>>");
            if(scanner.nextLine().equalsIgnoreCase("y")){
                while(true){
                    try{
                        System.out.print("Enter the new stock level for"+Products.getProductName()+ ">>");
                        int newStock = Integer.parseInt(scanner.nextLine());
                        if(newStock<0){
                            System.out.println("Stock level cannot be negative.Please enter a valid integer.");
                            continue;
                        }
                        Products.setStockLevel(newStock);
                        break;
                    }catch(NumberFormatException e){
                        System.out.println("Invalid number format.Please enter a valid integer.");
                    }
                }
        }
            System.out.print("Update the supplier?(y) Yes,(n) No >>");
            if(scanner.nextLine().equalsIgnoreCase("y")){
                System.out.print("Enter the new supplier for"+Products.getProductName() + ">>");
                Products.setProductSupplier(scanner.nextLine());
            }
            System.out.println("Product details have been updated successfully!!!");
    }else{
            System.out.println("The product cannot be located.Invalid Product");
        }
}
    //Delete Product Method
    public void DeleteProduct() {
        System.out.print("Please enter the product code to delete:");
        String code = scanner.nextLine();
        
        ReportData Products = findProductByCode(code);
        
        if(Products != null){
            System.out.print("Are you sure you want to delete"+Products.getProductName()+ "?(y) Yes, (n) No >>");
            if(scanner.nextLine().equalsIgnoreCase("y")){
                productList.remove(Products);
                System.out.println("Product has been deleted successfully!!!");
            }else{
                System.out.println("Delete cancelled.");
            }
        }else{
            System.out.println("The product cannot be located.Invalid Product");
        }
    }
    
//PrintReport Method
    public void PrintReport(){
        if(productList.isEmpty()){
            System.out.println("There are no products to report on.");
            return;
        }
        
        System.out.println("*************************************************************************************");
        System.out.println("BRIGHT FUTURE TECHNOLOGIES - PRODUCT REPORT");
        System.out.println("**************************************************************************************");
        System.out.printf("%-10s %-20s %-18s %-10s %10s %8s %-15s%n", "CODE","NAME", "CATEGORY","WARRANTY","PRICE","STOCK","SUPPLIER");
        System.out.println("---------------------------------------------------------------------------------------------------------");
        
        double totalStockValue = 0.0;
        for(ReportData Products: productList){
            System.out.printf("%-10s %-20s %-18s %-10s %10.2f %8d %-15s%n", Products.getProductCode(),Products.getProductName(),Products.getProductCategory(),Products.getProductWarranty(),
            Products.getProductPrice(),Products.getStockLevel(),Products.getProductSupplier());
            totalStockValue += Products.getProductPrice()*Products.getStockLevel();
        }
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("Total number of products:"+productList.size());
     System.out.printf("Total stock value: R %.2f%n",totalStockValue);
     
     System.out.println("***************************************************************************************************");
    }
    
//ExitApplication Method
    public void ExitApplication(){
        System.out.println("\nThank you for using the Bright Future Tehcnologies application.Goodbye!");
        scanner.close();
    }
    
//Helper Method: find a product by its product code (case-insensitive)
    private ReportData findProductByCode(String code){
        for(ReportData Products: productList){
            if(Products.getProductCode().equalsIgnoreCase(code)){
                return Products;
            }
        }
        return null;
    }
        //Entry point for the application
            public static void main(String[] args){
                Products app = new Products();
                app.startApplication();
            }
        }

        


    

