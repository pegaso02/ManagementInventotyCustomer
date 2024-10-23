
package Vista;

import Service.ProductService;
import javax.swing.table.DefaultTableModel;
import java.util.List;


public class updateProduct extends javax.swing.JFrame {
    
    DefaultTableModel modelProduct;
  
    public updateProduct() {
        initComponents();
        
             
        String columnas[] = {"ProductId","ProductName","Price", "Qty"}; // Columnas de la tabla a editar
        
        modelProduct = new DefaultTableModel(columnas, 0); // le pasamos al modelo las columnas
        
        jTableUpdateProduct.setModel(modelProduct); // setiamos modelo a la tabla
        
        ProductService ps = new ProductService();
        
        List<Object[]> filas2 = ps.updateProduct(); // recibimos las filas de la tabla productos
        
        for(int i = 0; i < filas2.size();i++){
            modelProduct.addRow(filas2.get(i)); // iteramos en el arraylist y guardamos cada fila en la tabla
        }
        
        
//        int rowSelect = jTableUpdateProduct.getSelectedRow();
        
//        if(rowSelect>0){
//            
//        }
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUpdateProduct = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableUpdateProduct.setBackground(new java.awt.Color(153, 153, 255));
        jTableUpdateProduct.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableUpdateProduct.setForeground(new java.awt.Color(255, 255, 255));
        jTableUpdateProduct.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableUpdateProduct);

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Edit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Bradley Hand ITC", 1, 14)); // NOI18N
        jLabel6.setText("SU SOLUCIÓN EN ARTES GRÁFICAS");

        jLabel8.setFont(new java.awt.Font("Bradley Hand ITC", 1, 24)); // NOI18N
        jLabel8.setText("Pitalito-Huila");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Logo Gironza final.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(50, 50, 50))
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(87, 87, 87)))
                        .addGap(54, 54, 54))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(89, 89, 89)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel7)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel6)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel8)
                        .addGap(31, 31, 31)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(143, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // traer los datos de la fila seleccionada en las cajas de texto para poderlas modificar
        
         int rowSelect = jTableUpdateProduct.getSelectedRow(); // Guardamos la fila seleccionada
         
         if(rowSelect >= 0){ // Si selecciono alguna
             
            int ProductId = Integer.parseInt(jTableUpdateProduct.getValueAt(rowSelect, 0).toString());
            String productName = jTableUpdateProduct.getValueAt(rowSelect, 1).toString(); // Guardamos las columnas de la fila seleccionada en variables 
            Double price = Double.parseDouble(jTableUpdateProduct.getValueAt(rowSelect, 2).toString());
            int qty = Integer.parseInt(jTableUpdateProduct.getValueAt(rowSelect, 3).toString());
             
            EditProduct epc = new EditProduct(ProductId,productName, price, qty);// Pasamos por parametros los valores de las columnas de la fila
            
            epc.setVisible(true);
     

          }
      
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

  


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableUpdateProduct;
    // End of variables declaration//GEN-END:variables
}
