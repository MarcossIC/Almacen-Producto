package dev.swing.example.application;

import dev.swing.example.domain.Product;
import dev.swing.example.domain.ProductServicePort;
import dev.swing.example.infrastructure.InMemoryProductRepository;

import javax.swing.*;
import java.util.Collections;
import java.util.List;

public final class ProductService implements ProductServicePort {

    private final InMemoryProductRepository mysqlController;
    private List<Product> inMemoryList;

    public ProductService(){
        this.mysqlController = new InMemoryProductRepository();
        var optionalProducts = mysqlController.selectAll();
        
        if(optionalProducts.isPresent())
            optionalProducts.get().forEach(p-> this.inMemoryList.add( p));
    }

    @Override
    public void addProduct(Product product) {
        if(this.inMemoryList.contains(product) && product == null){
            JOptionPane.showMessageDialog(null, "El producto no se a agregado a la lista \n Motivo: Este ya existe, cambie el ID", "ERROR", 2);
            return;
        }
        this.mysqlController.insert(product);
        this.inMemoryList.add(product);
    }

    @Override
    public void updateProduct(Product product) {
        var optionalProduct = inMemoryList.stream().filter(p-> p.productId().equals(product.productId())).findAny();
        if(optionalProduct.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El ID que ingresaste no pertenece a ningun producto");
            return;
        }
        this.mysqlController.update(product);
        this.inMemoryList.remove(optionalProduct.get());
        this.inMemoryList.add(product);
    }

    @Override
    public void deleteProduct(Product p) {
        this.mysqlController.delete(p);
        this.inMemoryList.remove(p);
    }
    @Override
    public Product selectById(Integer id) {
        return inMemoryList.get(id);
    }

    @Override
    public List<Product> selectAllProducts() {
        return inMemoryList;
    }
}
