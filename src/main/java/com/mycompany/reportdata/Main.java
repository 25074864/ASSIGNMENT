/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reportdata;

/**Names: Phuluwa Mulalo
 * student number: 25074864
 *
 * @author User
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Products app = new Products();
        
        System.out.println("BRIGHT FUTURE TECHNOLOGIES APPLICATION");
        System.out.println("**************************************");
        System.out.println("Enter (1) to launch menu or any other key to exit");
        System.out.print("Selection >> ");
        
        String input = scanner.nextLine();
        if (input.equals("1")) {
            app.DisplayMenu();
        } else {
            app.ExitApplication();
        }
        
        scanner.close();
    }
}


