/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javapomsystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;



public class Login extends Registration{
    
    public void Login(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Username: ");
        username = scanner.nextLine();
        
        
        System.out.println("Role: ");
        role = scanner.nextLine();
        
        
        System.out.println("Password: ");
        password = scanner.nextLine();
        
        validateLogin();
    }
    
    private void validateLogin(){
    
   
    String record;
    String file_name = "C:\\Users\\ACER\\Documents\\NetBeansProjects\\JavaAssignment\\src\\javaassignment\\staff.txt";

        
        try {
            FileReader fr;
            fr = new FileReader(file_name);
            BufferedReader br;
            br = new BufferedReader(fr);
            
            
            boolean check_exist = false;
            while ((record = br.readLine()) != null) {
                String[] line = record.split(",");

                if (username.equals(line[0]) && role.equals(line[1]) && password.equals(line[2])) {
                    check_exist = true;
                    break;
                }                                
            }        
            fr.close();
            br.close();
            
            if (check_exist) {
                 if (role=="Sales Manager"){
                    System.out.println("Welcome "+username);
                    
                 }
                 
                 else if (role=="Purchase Manager"){
                    System.out.println("Welcome "+username);
                    
                 }
                 
                 else if (role=="Admin"){
                    System.out.println("Welcome "+username);
                    
                 }
            }            
            
            else {
                System.out.println("Login Failed");
                
                
            }
        }
        catch (FileNotFoundException error) {
            System.out.println("File not found.");
        }
        catch (IOException error) {
            System.out.println("An error occured.");
        }
    }
}
