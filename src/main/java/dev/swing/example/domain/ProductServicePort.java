package dev.swing.example.domain;

import java.util.List;

public interface ProductServicePort {
    void addProduct(Product p);
    void updateProduct(Product p);
    void deleteProduct(Product p);
    List<Product> selectAllProducts();
    Product selectById(Integer Id);
}
