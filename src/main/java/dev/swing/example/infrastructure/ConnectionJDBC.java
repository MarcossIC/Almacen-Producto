package dev.swing.example.infrastructure;

import java.sql.*;

import dev.swing.example.domain.Comands;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

/**
 * Clase para crear la conexion
 * @author Marcos Lopez
 */
public final class ConnectionJDBC {
    //Atributo
    private static BasicDataSource dataSource;
    
    private ConnectionJDBC(){
        throw new IllegalStateException("Utility class");
    }

    //Retorna una conexion personalizada
    public static DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl(Comands.JDBC_URL.getCommand());
            dataSource.setUsername(Comands.JDBC_USER.getCommand());
            dataSource.setPassword(Comands.JDBC_PASS.getCommand());
            dataSource.setDefaultAutoCommit(false);
            dataSource.setInitialSize(5);
        }
        return dataSource;
    }
    
    //Metodo para recuperar la conexion
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    //Metodos para cerrar los flujos
    public static void close(ResultSet resultSet) {
        try {
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(PreparedStatement preparedStatement) {
        try {
            preparedStatement.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar el preparedStatement");
            throw new RuntimeException(ex);
        }
    }

    public static void close(Connection connection){
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexion");
            throw new RuntimeException(ex);
        }
    }
}
