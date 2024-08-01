

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Product{
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId,String productName,int quantity,double price){
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.price = price;
    }

    public String getProductId(){
        return productId;
    }
    public String getProductName(){
        return productName;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int q){
        this.quantity = q;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(int p){
        this.price = p;
    }
    @Override
    public String toString() {
        return "Product [ID=" + productId + ", Name=" + productName + ", Quantity=" + quantity + ", Price=" + price + "]";
    }
}

public class InventoryManagementSystem {
    private Map<String , Product> inventory;
    public InventoryManagementSystem(){
        inventory = new HashMap<>();
        
    }
    public void addProduct(Product product){
        inventory.put(product.getProductId(),product);
    }
    public void updateProduct(Product product){
        if(inventory.containsKey(product.getProductId())){
            inventory.put(product.getProductId(),product);
        }
        else{
            System.out.println("Not found");
        }
    }
    public void deleteProduct(String productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
        } else {
            System.out.println("Product not found.");
        }
    }

    public void displayInventory() {
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    
    }
    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();
        
        int choice;
        Scanner sc = new Scanner(System.in);
        while(true){
        System.out.println("1. Enter new Product:");
        System.out.println("2. Update Product");
        System.out.println("3. Delete Product");
        System.out.println("4. Show Inventory");
        System.out.println("Enter your choice:");
        choice = sc.nextInt();
        if (choice == -1) {
            break;
        }
        String id, name;
        int quant;
        double price;
        switch(choice){
            case 1: 
                System.out.println("Enter product id:");
                id = sc.next();
                System.out.println("Enter product name:");
                name = sc.next();
                System.out.println("Enter product quantity:");
                quant = sc.nextInt();
                System.out.println("Enter product price:");
                price = sc.nextDouble();
                ims.addProduct(new Product(id,name,quant,price));
                break;
            case 2:
                System.out.println("Enter product id:");
                id = sc.next();
                System.out.println("Enter product name:");
                name = sc.next();
                System.out.println("Enter product quantity:");
                quant = sc.nextInt();
                System.out.println("Enter product price:");
                price = sc.nextDouble();
                ims.updateProduct(new Product(id,name,quant,price));
                break;
            case 3:  
                System.out.println("Enter product id:");
                id = sc.nextLine();
                ims.deleteProduct(id);
                break;
            case 4:
                ims.displayInventory();
                break;
        }
       
    }
    sc.close();
    }
    
}
