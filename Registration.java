
package javapomsystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Registration {
    String username;
    String role;
    String password;
    String confirm;
    
    public void Register(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Registration Process!");
        
        System.out.println("Enter a username: ");
        username = scanner.nextLine();
        
        while (!username.matches("[a-zA-Z]+")){
            System.out.println("Username only accepts alphabet!");
            username = scanner.nextLine();
        }
        
        System.out.println("Enter a role: ");
        role = scanner.nextLine();
        
        System.out.println("Enter a password: ");
        password = scanner.nextLine();
        
        System.out.println("Reconfirm your password: ");
        confirm = scanner.nextLine();
        
        while(!confirm.equals(password)){
            System.out.println("Retype your password: ");
            confirm = scanner.nextLine();
        }
        
        savetoFile();
        
        
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }
    
    
    private void savetoFile(){
         try {
                String record;
                String file_name = "C:\\Users\\ACER\\Documents\\NetBeansProjects\\JavaPOMSystem\\src\\javapomsystem\\account.txt";

                FileReader fr;
                fr = new FileReader(file_name);
                BufferedReader br;
                br = new BufferedReader(fr);

                boolean check_exist = false;
                while ((record = br.readLine()) != null) {
                    String[] line = record.split(",");

                    if (username.equals(line[0])) {
                        check_exist = true;
                        break;
                    }                                        
                }        
                fr.close();
                br.close();

                if (check_exist) {
                    System.out.println("User already existed!");                   
                    
                }
                else {
                    FileWriter fw;
                    fw = new FileWriter(file_name, true);

                    PrintWriter pw;
                    pw = new PrintWriter(fw);
                    pw.write(username + "," + role + "," + password + "\n");
                    System.out.println("Registration Successful!");

                    fw.close();
                    pw.close();
                }
            }
            catch (IOException error) {
                System.out.println("An error occured.");
            }
    }
    
    public static void main(String[] args) {
        Registration registration = new Registration();
        registration.Register();
        
        System.out.println("Username: "+registration.getUsername());
        System.out.println("Role: "+registration.getRole());
        
    }

}
