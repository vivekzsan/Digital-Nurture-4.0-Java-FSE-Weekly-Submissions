import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ProductSearch {

    public static Product linearSearch(Product[] products, int id) {
        for (Product p : products) {
            if (p.id == id)
                return p;
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int id) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (products[mid].id == id)
                return products[mid];
            else if (products[mid].id < id)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total number of products: ");
        int n = sc.nextInt();
        sc.nextLine();

        Product[] products = new Product[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nProduct " + (i + 1) + ":");
            System.out.print("  ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("  Name: ");
            String name = sc.nextLine();
            System.out.print("  Category: ");
            String category = sc.nextLine();
            products[i] = new Product(id, name, category);
        }

        System.out.print("\nEnter the Product ID to search: ");
        int searchId = sc.nextInt();

        // Linear Search
        Product foundLinear = linearSearch(products, searchId);
        System.out.println("\n Linear Search Result:");
        System.out.println(foundLinear != null ? foundLinear : "Product not found.");

        // Sort before Binary Search
        Arrays.sort(products, Comparator.comparingInt(p -> p.id));

        // Binary Search
        Product foundBinary = binarySearch(products, searchId);
        System.out.println("\n Binary Search Result:");
        System.out.println(foundBinary != null ? foundBinary : "Product not found.");
    }
}
