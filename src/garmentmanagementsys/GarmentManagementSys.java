package garmentmanagementsys;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Garment {
    public String id;
    public String name;
    public String description;
    public String size;
    public String color;
    public double price;
    public int stockQuantity; 

    public Garment(String id, String name, String description, String size, String color, double price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.size = size;
        this.color = color;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public void updateStock(int quantity) {
        stockQuantity += quantity;
    }

    public double calculateDiscountPrice(double discountPercentage) {
        return price - (price * discountPercentage / 100);
    }

    public String getDetails() {
        return "Garment ID: " + id + ", Name: " + name + ", Price: " + price + ", Stock: " + stockQuantity;
    }
}
  
    
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

public class GarmentManagementSys {


    public static void main(String[] args) {
        
        
    }
    
}

