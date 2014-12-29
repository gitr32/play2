package models;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by r128 on 28/12/14.
 */
public class Product {

    private static List<Product> products;

    static {
        products = new ArrayList<Product>();
        products.add(new Product("1111111111111", "Paperclips 1", "paperclips description 1"));
        products.add(new Product("2222222222222", "Paperclips 2", "paperclips description 2"));
        products.add(new Product("3333333333333", "Paperclips 3", "paperclips description 3"));
    }
    public String ean;
    public String name;
    public String description;

    public Product() {

    }

    public Product(String ean, String name, String description) {
        this.ean = ean;
        this.name = name;
        this.description = description;
    }

    public String toString() {
        return String.format("%s - %s", ean, name);
    }

    public static List<Product> findAll() {
        return new ArrayList<Product>(products);
    }

    public static Product findByEan(String ean) {
        for(Product candidate: products) {
            if(candidate.ean.equals(ean)) {
                return candidate;
            }
        }
        return null;
    }

    public static List<Product> findByName(String term) {
        final List<Product> results = new ArrayList<Product>();
        for(Product candidate: products) {
            if(candidate.name.toLowerCase().contains(term.toLowerCase())) {
                results.add(candidate);
            }
        }

        return results;
    }

    public static boolean remove(Product product) {
        return products.remove(product);
    }

    public void save() {
        products.remove(findByEan(this.ean));
        products.add(this);
    }
}
