package dev.swing.example.domain;

import java.util.List;
import java.util.Objects;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Marcos Lopez
 */
public class TableModel extends AbstractTableModel {

    private static final String[] COLUMNS = {"ID", "Nombre", "Precio"};
    private List<Product> productsInTable;
    
    public TableModel(List<Product> productsInTable) {
        this.productsInTable = productsInTable;
    }
    
    public void updateList(Product product){
        var oldRow = productsInTable.stream()
                .filter(p-> Objects.equals(p.productId(), product.productId()))
                .findAny();
        if(oldRow == null){
            productsInTable.add(product);
            return;
        }
        productsInTable.remove(oldRow);
        productsInTable.add(product);
    }
    public void remove(Product product){
        this.productsInTable.remove(product);
    }

    @Override
    public int getRowCount() {
        return this.productsInTable.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNS.length;
    }

    @Override
    public Object getValueAt(int index, int column) {
        switch (column) {
            case 0: return productsInTable.get(index).productId();
            case 1: return productsInTable.get(index).name();
            case 2: return productsInTable.get(index).price();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int index) {
        return COLUMNS[index];
    }
}
