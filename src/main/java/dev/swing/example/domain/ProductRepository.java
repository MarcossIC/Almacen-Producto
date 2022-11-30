
package dev.swing.example.domain;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Interfaz que crea los metodos que utiliza la base de datos
 * @author Marcos Lopez
 */
public interface ProductRepository {
    void insert(Product p) throws SQLException;
    void update(Product p) throws SQLException;
    void delete(Product p) throws SQLException;
    Optional<List<Product>> selectAll() throws SQLException;
}
