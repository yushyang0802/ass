
package javapomsystem;

import java.time.LocalDate;

public class SalesEntry {
    private LocalDate date;
    private Item item;
    private int quantity;
    
    public SalesEntry(LocalDate date, Item item, int quantity){
        this.date = date;
        this.item = item;
        this.quantity = quantity;
    }

    public LocalDate getDate() {
        return date;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
