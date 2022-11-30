package dev.swing.example.infrastructure;

import dev.swing.example.application.ProductService;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;

import dev.swing.example.domain.Product;
import dev.swing.example.domain.ProductServicePort;
import dev.swing.example.domain.TableModel;


/**
 *
 * @author Marcos Lopez
 */
public class PrincipalLayout extends javax.swing.JFrame {

    private ProductServicePort service;
    private TableModel model;

    public PrincipalLayout() {
        this.service = new ProductService();
        this.model = new TableModel(service.selectAllProducts());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPop = new javax.swing.JPopupMenu();
        itemEliminar = new javax.swing.JMenuItem();
        principalPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        formPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txfIdProduct = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txfName = new javax.swing.JTextField();
        txfPrice = new javax.swing.JTextField();
        cleanButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        botonActualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        itemEliminar.setText("Eliminar");
        itemEliminar.addActionListener((ActionEvent e)->{
            deleteProduct();
        });
        menuPop.add(itemEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Century", 1, 20)); // NOI18N
        jLabel1.setText("Ficha Producto");

        formPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(41, 43, 45)), "Regristro Productos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Century", 1, 14))); // NOI18N

        jLabel2.setText("ID");

        jLabel3.setText("Nombre");

        jLabel4.setText("Precio");

        cleanButton.setText("Limpiar");
        cleanButton.addActionListener((ActionEvent e) -> cleanAll() );

        saveButton.setText("Guardar");
        saveButton.addActionListener((ActionEvent e) -> saveProduct());

        botonActualizar.setText("Actualizar");
        botonActualizar.addActionListener((ActionEvent e)-> updateProduct());

        javax.swing.GroupLayout formPanelLayout = new javax.swing.GroupLayout(formPanel);
        formPanel.setLayout(formPanelLayout);
        formPanelLayout.setHorizontalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(cleanButton))
                .addGap(33, 33, 33)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfName, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfIdProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(botonActualizar)
                        .addGap(26, 26, 26))))
        );
        formPanelLayout.setVerticalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txfIdProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(botonActualizar)
                    .addComponent(cleanButton))
                .addGap(29, 29, 29))
        );

        table.setModel(model);
        table.setComponentPopupMenu(menuPop);
        table.getSelectionModel()
        .addListSelectionListener((ListSelectionEvent e) -> {
            int indice = table.getSelectedRow();
            fillTextFields(service.selectById(indice));
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout principalPanelLayout = new javax.swing.GroupLayout(principalPanel);
        principalPanel.setLayout(principalPanelLayout);
        principalPanelLayout.setHorizontalGroup(
            principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(principalPanelLayout.createSequentialGroup()
                .addGroup(principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(principalPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(formPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(principalPanelLayout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(jLabel1)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        principalPanelLayout.setVerticalGroup(
            principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, principalPanelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(formPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(principalPanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Limpio el TextField
    private void cleanAll() {
        txfIdProduct.setText("");
        txfName.setText("");
        txfPrice.setText("");
    }
    //Cargo un producto al TextField
    private void fillTextFields(Product p) {
        txfIdProduct.setText(String.valueOf(p.productId()));
        txfName.setText(p.name());
        txfPrice.setText(String.valueOf(p.price()));
    }

    //Retorna un producto en base a los datos del TextField
    private Product getProductInTxf() {
        return new Product(
                Integer.valueOf(txfIdProduct.getText()),
                txfName.getText(),
                Double.valueOf(txfPrice.getText()));
    }

    //Evia la peticion de Guardar
    private void saveProduct() {
        if (!ensureAllIsValid()) {
            return;
        }
        var product = getProductInTxf();
        this.service.addProduct(product);
        model.updateList(product);
        this.model.fireTableRowsInserted(
                this.service.selectAllProducts().size() - 1,
                this.service.selectAllProducts().size() - 1);
        cleanAll();
    }

    //Envia la peticion de actualizar
    private void updateProduct() {
        if (!ensureAllIsValid()) {
            return;
        }
        var product = getProductInTxf();
        this.service.updateProduct(product);
        model.updateList(product);
        this.table.repaint();
        cleanAll();
    }
    //Envia la peticion de eliminar un producto
    private void deleteProduct(){
        if (!ensureAllIsValid()) {
            return;
        }
        var product = this.service.selectById(this.table.getSelectedRow());
        this.service.deleteProduct(product);
        this.model.remove(product);
        cleanAll();
        this.table.repaint();
        
    }
    //Realiza las comprabaciones para realizar o no un metodo
    public boolean ensureAllIsValid() {
        var message = new StringBuilder();
        validateIsNotBlank(message);
        validateNumberFormat(message);

        if(!message.isEmpty()){
            JOptionPane.showMessageDialog(rootPane, message.toString());
            return false;
        }
        return true;
    }
    public void validateNumberFormat(StringBuilder message){
        try { Integer.valueOf(this.txfIdProduct.getText()); }
        catch (NumberFormatException ex) {
            message.append("Código no debe tener letras").append("\n");}
        try { Double.valueOf(txfPrice.getText()); }
        catch (NumberFormatException e) {
            message.append("Precio no puede contener letras").append("\n");}
    }
    public void validateIsNotBlank(StringBuilder message){
        if(this.txfIdProduct.getText().isBlank() )
            message.append("Codigo Vacio").append("\n");
        if(this.txfName.getText().isBlank())
            message.append("Nombre Vacio").append("\n");
        if(this.txfPrice.getText().isBlank())
            message.append("Precio Vacio").append("\n");
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PrincipalLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalLayout.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalLayout().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton cleanButton;
    private javax.swing.JPanel formPanel;
    private javax.swing.JMenuItem itemEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu menuPop;
    private javax.swing.JPanel principalPanel;
    private javax.swing.JButton saveButton;
    private javax.swing.JTable table;
    private javax.swing.JTextField txfIdProduct;
    private javax.swing.JTextField txfName;
    private javax.swing.JTextField txfPrice;
    // End of variables declaration//GEN-END:variables
}
