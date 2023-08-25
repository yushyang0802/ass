
package javapomsystem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SalesManager {
    private List<SalesEntry> salesEntries;
    
    public SalesManager(){
        salesEntries = new ArrayList<>();
    }
    
    public void addEntry(SalesEntry entry){
        salesEntries.add(entry);
    }
    
    public void deleteEntry(SalesEntry entry){
        salesEntries.remove(entry);
    }
    
    public void editEntry(SalesEntry entryToEdit, LocalDate newDate, Item newItem, int newQuantity) {
        entryToEdit.setDate(newDate);
        entryToEdit.setItem(newItem);
        entryToEdit.setQuantity(newQuantity);
    }
    
    public void displayEntries(){
        System.out.println("Sales Entries: ");
        for(SalesEntry entry : salesEntries){
            System.out.println("Date: "+ entry.getDate());
            System.out.println("Item: " + entry.getItem().getItemName());
            System.out.println("Quantity: " + entry.getQuantity());
            System.out.println("Price: $" + entry.getItem().getPrice());
            System.out.println("Total: $" + (entry.getItem().getPrice() * entry.getQuantity()));
            System.out.println("------------------------");
        }
    }
    
    public List<SalesEntry> searchEntriesByDate(LocalDate date) {
        List<SalesEntry> matchingEntries = new ArrayList<>();
        
        for (SalesEntry entry : salesEntries) {
            if (entry.getDate().equals(date)) {
                matchingEntries.add(entry);
            }
        }
        
        return matchingEntries;
    }
}
