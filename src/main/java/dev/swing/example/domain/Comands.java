package dev.swing.example.domain;

/**
 * Clase ENUM para crear todas las constantes
 * @author Marcos Lopez
 */
public enum Comands { 
    JDBC_URL("jdbc:mysql://localhost:3306/ventas"),
    JDBC_USER("root"),
    JDBC_PASS("admin"), 
    SQL_SELECT("SELECT * FROM product"),
    SQL_INSERT("INSERT INTO product(product_id, name, price) VALUES(?, ?, ?)"),
    SQL_UPDATE("UPDATE product SET name = ?, price = ? WHERE product_id = ?"),
    SQL_DELETE("DELETE FROM product WHERE product_id = ?");
    
    //Parte que utiliza el Enum para mostrar estas 
    private String command;
    
     Comands(String command){
         this.command = command;
     }
     
     public String getCommand(){
         return command;
     }
}
