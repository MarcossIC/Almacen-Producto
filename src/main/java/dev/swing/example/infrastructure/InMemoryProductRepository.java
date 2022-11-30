package dev.swing.example.infrastructure;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import java.util.List;

import dev.swing.example.domain.ProductRepository;
import dev.swing.example.domain.Product;

import static dev.swing.example.domain.Comands.*;
import java.util.Collections;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Repositorio MySQL para product
 * @author Marcos Lopez
 */
public final class InMemoryProductRepository implements ProductRepository {

    private static final Logger LOG = Logger.getLogger("dev.swing.example");

    /**
     * Inserta un producto a la base de datos
     * @param product
     */
    @Override
    public void insert(Product product) {
        try {
            PreparedStatement prepareStatement = ConnectionJDBC
                    .getConnection().prepareStatement(SQL_INSERT.getCommand());

            prepareStatement.setInt(   1, product.productId());
            prepareStatement.setString(2, product.name());
            prepareStatement.setDouble(3, product.price());

            prepareStatement.executeUpdate();

            ConnectionJDBC.close(prepareStatement);
            ConnectionJDBC.close(ConnectionJDBC.getConnection());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al ejecutar Insert", "ERROR", 0);
        }
        
    }

    /**
     * Actualiza la base de datos
     * @param product
     */
    @Override
    public void update(Product product) {
        try {
            PreparedStatement prepareStatement = ConnectionJDBC
                    .getConnection().prepareStatement(SQL_UPDATE.getCommand());

            prepareStatement.setString(1, product.name());
            prepareStatement.setDouble(2, product.price());
            prepareStatement.setInt(   3, product.productId());
            prepareStatement.executeUpdate();

            ConnectionJDBC.close(prepareStatement);
            ConnectionJDBC.close(ConnectionJDBC.getConnection());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al ejecutar Update", "ERROR", 0);
        }
    }
    
    /**
     * Elimina un producto de la base de datos
     * @param p
     */
    @Override
    public void delete(Product p) {
        try {
            PreparedStatement preparedStatement = ConnectionJDBC
                    .getConnection().prepareStatement(SQL_DELETE.getCommand());

            preparedStatement.setInt(1, p.productId());
            preparedStatement.executeUpdate();

            ConnectionJDBC.close(preparedStatement);
            ConnectionJDBC.close(ConnectionJDBC.getConnection());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al ejecutar delete", "ERROR", 0);
        }
    }

    /**
     * Recupera toda la tabla de la base de datos
     * @return 
     */
    @Override
    public Optional<List<Product>> selectAll() {
        List<Product> products = Collections.emptyList();

        try {
            PreparedStatement preparedStatement = ConnectionJDBC
                    .getConnection().prepareStatement(SQL_SELECT.getCommand());
            ResultSet resultSet = preparedStatement.executeQuery();
     
            while (resultSet.next()) {
                var product = new Product(
                        resultSet.getInt("product_id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price")
                );
                products.add(product);
            }

            ConnectionJDBC.close(resultSet);
            ConnectionJDBC.close(preparedStatement);
            ConnectionJDBC.close(ConnectionJDBC.getConnection());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al ejecutar SellectAll", "ERROR", 0);
        }
       
        LOG.log(Level.INFO, "Product is null: "+products);
        return Optional.of(products);
    }
}
