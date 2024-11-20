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
  
class Fabric {
    public String id;
    public String type;
    public String color;
    public double pricePerMeter;

    public Fabric(String id, String type, String color, double pricePerMeter) {
        this.id = id;
        this.type = type;
        this.color = color;
        this.pricePerMeter = pricePerMeter;
    }

    public double calculateCost(double meters) {
        return pricePerMeter * meters;
    }
}

class Supplier {
    public String id;
    public String name;
    public String contactInfo;
    public List<Fabric> suppliedFabrics;

    public Supplier(String id, String name, String contactInfo) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
        this.suppliedFabrics = new ArrayList<>();
    }

    public void addFabric(Fabric fabric) {
        suppliedFabrics.add(fabric);
    }

    public List<Fabric> getSuppliedFabrics() {
        return suppliedFabrics;
    }
}

class Order {
    public String orderId;
    public Date orderDate;
    public List<Garment> garments;
    private double totalAmount; 

    public Order(String orderId) {
        this.orderId = orderId;
        this.orderDate = new Date();
        this.garments = new ArrayList<>();
        this.totalAmount = 0.0;
    }

    public void addGarment(Garment garment) {
        garments.add(garment);
        totalAmount += garment.calculateDiscountPrice(5); 
    }

    public double calculateTotalAmount() {
        return totalAmount;
    }

    public void printOrderDetails() {
        System.out.println("Order ID: " + orderId + ", Date: " + orderDate);
        System.out.println("Items in the order:");
        garments.forEach(g -> System.out.println(g.getDetails()));
        System.out.println("Total Amount: " + totalAmount);
    }
}

class Customer {
    public String customerId;
    public String name;
    public String email;
    public String phone;
    public List<Order> orders;

    public Customer(String customerId, String name, String email, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.orders = new ArrayList<>();
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public List<Order> viewOrders() {
        return orders;
    }
}

public class GarmentManagementSys{
    public static void main(String[] args) {
        Garment garment1 = new Garment("GR1", "Sweater", "Warm woolen sweater", "XL", "Red", 800, 10);
        Garment garment2 = new Garment("GR2", "Shorts", "Comfortable summer shorts", "S", "Green", 350, 25);

        Fabric fabric1 = new Fabric("FB1", "Wool", "Gray", 300);

        Supplier fabricSupplier = new Supplier("SUP1", "Bashir Supplies", "01987654321");
        fabricSupplier.addFabric(fabric1);

        Customer buyer = new Customer("CUS1", "Ahmed", "ahmed@example.com", "018XXXXXXXX");
        Order newOrder = new Order("ORD1");
        
        newOrder.addGarment(garment1);
        newOrder.addGarment(garment2);
        buyer.placeOrder(newOrder);
        newOrder.printOrderDetails();
    }
}
    