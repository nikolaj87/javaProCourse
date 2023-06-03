package main.java.javamain.testSecondModule.task3;

import java.util.HashMap;
import java.util.Map;

public class ProductManager {

    private Map<Integer, Product> products = new HashMap<>();

    public Map<Integer, Product> getProducts() {
        return products;
    }
    public void setProducts(Map<Integer, Product> products) {
        this.products = products;
    }

    public void addProduct (int id, Product product) {
        if(!products.containsKey(id)) {
            products.put(id, product);
            System.out.println("product " + product.getName() + " added");
        } else
            System.out.println(product.getName() + " already exists");
    }

    public void deleteProduct (int id) {
        if(!products.containsKey(id)) {
            products.remove(id);
            System.out.println("product with id " + id + " deleted");
        } else
            System.out.println(id + " not exists");
    }

    public Product findProduct (int id) {
        if(!products.containsKey(id)) {
            return products.get(id);
        } else
            System.out.println(id + " not exists");
        return null;
    }



}
