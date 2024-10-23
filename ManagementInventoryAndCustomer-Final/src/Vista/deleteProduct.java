
package Vista;

import Service.ProductService;
import java.util.Optional;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class deleteProduct extends javax.swing.JFrame {
    
     DefaultTableModel modelDeleteProduct;

    public DefaultTableModel getModelDeleteProduct() {
        return modelDeleteProduct;
    }

    public void setModelDeleteProduct(DefaultTableModel modelDeleteProduct) {
        this.modelDeleteProduct = modelDeleteProduct;
    }
     
     

    public JTable getjTableDeleteP() {
        return jTableDeleteP;
    }

    public void setjTableDeleteP(JTable jTableDeleteP) {
        this.jTableDeleteP = jTableDeleteP;
    }
    
   
    public deleteProduct() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        
        String columsName[] = {"Product Id", "Product Name", "Price", "Quantity"};
        
        modelDeleteProduct = new DefaultTableModel(columsName, 0);
        
        jTableDeleteP.setModel(modelDeleteProduct);
        
        ProductService ps = new ProductService();
        List<Object[]>filas =ps.updateProduct();
        
        for(int i = 0;i < filas.size();i++){
            modelDeleteProduct.addRow(filas.get(i));
        }
        
        
        
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButtonDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDeleteP = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButtonDelete.setBackground(new java.awt.Color(255, 0, 0));
        jButtonDelete.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonDelete.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jTableDeleteP.setBackground(new java.awt.Color(153, 153, 255));
        jTableDeleteP.setForeground(new java.awt.Color(255, 255, 255));
        jTableDeleteP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableDeleteP);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Bradley Hand ITC", 1, 14)); // NOI18N
        jLabel6.setText("SU SOLUCIÓN EN ARTES GRÁFICAS");

        jLabel8.setFont(new java.awt.Font("Bradley Hand ITC", 1, 24)); // NOI18N
        jLabel8.setText("Pitalito-Huila");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Logo Gironza final.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(181, 181, 181)
                                .addComponent(jLabel8))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(210, 210, 210)
                                .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 118, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(135, 135, 135))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(95, 95, 95)))))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(139, 139, 139))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel7)
                .addGap(36, 36, 36)
                .addComponent(jLabel6)
                .addGap(31, 31, 31)
                .addComponent(jLabel8)
                .addGap(57, 57, 57)
                .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
       
        // LOGICA ELIMINAR
        ProductService ps = new ProductService();
        ps.DeleteProduct(this); // Pasamos 'this' que es la instancia actual de deleteProduct
        
        
    }//GEN-LAST:event_jButtonDeleteActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableDeleteP;
    // End of variables declaration//GEN-END:variables
}
