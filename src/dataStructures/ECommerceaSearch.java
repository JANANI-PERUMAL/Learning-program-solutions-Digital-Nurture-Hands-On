package dataStructures;

import java.util.Arrays;
import java.util.Comparator;

public class ECommerceaSearch 
{
    static class Product 
    {
        int productId;
        String productName;
        String category;

        public Product(int productId, String productName, String category) 
        {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        public void display() 
        {
            System.out.println("ID: " + productId + ", Name: " + productName + ", Category: " + category);
        }
}

   
    public static Product linearSearch(Product[] products, String targetName) 
    {
        for (Product product : products) 
        {
            if (product.productName.equalsIgnoreCase(targetName)) 
            {
                return product;
            }
        }
        return null;
    }

    
    public static Product binarySearch(Product[] products, String targetName) 
    {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) 
        {
            int mid = (low + high) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(targetName);

            if (cmp == 0) 
            {
                return products[mid];
            }
            else if (cmp < 0) 
            {
                low = mid + 1;
            } 
            else 
            {
                high = mid - 1;
            }
        }
        return null;
    }

   
    public static void sortProducts(Product[] products) 
    {
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));
    }

    
    public static void main(String[] args) 
    {
       
        Product[] products = 
        	{
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "T-shirt", "Clothing"),
            new Product(103, "Book", "Education"),
            new Product(104, "Phone", "Electronics"),
            new Product(105, "Shoes", "Footwear")
        };

        
        System.out.println(" Linear Search ");
        Product result1 = linearSearch(products, "Phone");
        if (result1 != null) 
        {
            result1.display();
        }
        else 
        {
            System.out.println("Product not found.");
        }

        
        System.out.println("\nBinary Search");
        sortProducts(products); 
        Product result2 = binarySearch(products, "Phone");
        if (result2 != null) 
        {
            result2.display();
        }
        else 
        {
            System.out.println("Product not found.");
        }

        
    }
}
