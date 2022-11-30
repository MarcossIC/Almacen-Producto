package dev.swing.example.domain;

/**
 *
 * @author Marcos Lopez
 */
public record Product(Integer productId, String name, Double price){
    public Product(Integer productId) {
        this(productId, "", (double) 0);
    }
}
