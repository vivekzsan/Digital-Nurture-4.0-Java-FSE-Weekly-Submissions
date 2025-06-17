import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {
    private Map<Integer, Product> productMap;
    private Scanner sc;

    public Inventory() {
        productMap = new HashMap<>();
        sc = new Scanner(System.in);
    }

    public void addProduct() {
        char choice = 'y';
        while (choice == 'y' || choice == 'Y') {
            System.out.print("Enter Product ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Product Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Quantity: ");
            int qty = sc.nextInt();

            System.out.print("Enter Price: ");
            double price = sc.nextDouble();

            Product p = new Product(id, name, qty, price);
            productMap.put(id, p);
            System.out.println("Product added.");

            System.out.print("Add another product? (y/n): ");
            choice = sc.next().charAt(0);
            sc.nextLine();
        }
    }

    public void updateProduct() {
        System.out.print("Enter Product ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        Product p = productMap.get(id);
        if (p != null) {
            System.out.print("Enter New Name: ");
            String name = sc.nextLine();

            System.out.print("Enter New Quantity: ");
            int qty = sc.nextInt();

            System.out.print("Enter New Price: ");
            double price = sc.nextDouble();

            p.setProductName(name);
            p.setQuantity(qty);
            p.setPrice(price);

            System.out.println("Product updated.");
        } else {
            System.out.println("No product found with ID: " + id);
        }
    }

    public void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        int id = sc.nextInt();

        if (productMap.remove(id) != null) {
            System.out.println("Product deleted.");
        } else {
            System.out.println("Product ID not found.");
        }
    }

    public void displayProducts() {
        if (productMap.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Inventory:");
            for (Product p : productMap.values()) {
                System.out.println(p);
            }
        }
    }

    public void start() {
        boolean run = true;

        while (run) {
            System.out.print(
                "\n--- Menu ---\n1. Add Product  |  2. Update  |  3. Delete  |  4. View  |  5. Exit\nChoose (1-5): "
            );
            int opt = sc.nextInt();
            switch (opt) {
                case 1 -> addProduct();
                case 2 -> updateProduct();
                case 3 -> deleteProduct();
                case 4 -> displayProducts();
                case 5 -> {
                    run = false;
                    System.out.println("Exiting...");
                }
                default -> System.out.println("Invalid input. Try 1-5.");
            }
        }
    }

    public static void main(String[] args) {
        Inventory i = new Inventory();
        i.start();
    }
}