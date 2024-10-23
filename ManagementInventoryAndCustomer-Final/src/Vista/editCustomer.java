
package Vista;

import Controller.CustomerController;
import Model.CustomerModel;
import java.awt.HeadlessException;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class editCustomer extends javax.swing.JFrame {
    
    DefaultTableModel ModelEditCustomer;
    CustomerModel customerModel;

    public editCustomer() {
        
    }
    
    
    
    
    public editCustomer(List<CustomerModel> customers) {
        
        initComponents();
        this.setLocationRelativeTo(null);
        
            String columnas[] = {"Customerid" ,"Name", "Mail","Nit"};
        
        ModelEditCustomer = new DefaultTableModel(columnas, 0);
        
        jTableEditCustomer.setModel(ModelEditCustomer);
        
        fillTable(customers);
        
        
        
        
    }
    
    public void fillTable(List<CustomerModel> customers){  // Method for load customer information in table for edit
        
        for (CustomerModel i : customers) {
            
            Object [] filas = new Object[4];
            
            filas[0] = i.getCustomerId();
            filas[1]=i.getName();
            filas[2]=i.getMail();
            filas[3]=i.getNit();
            
            ModelEditCustomer.addRow(filas); 
        }        
    } 
    
    

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEditCustomer = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Bradley Hand ITC", 1, 14)); // NOI18N
        jLabel6.setText("SU SOLUCIÓN EN ARTES GRÁFICAS");

        jLabel8.setFont(new java.awt.Font("Bradley Hand ITC", 1, 24)); // NOI18N
        jLabel8.setText("Pitalito-Huila");

        jButton1.setBackground(new java.awt.Color(255, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Edit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTableEditCustomer.setBackground(new java.awt.Color(153, 153, 255));
        jTableEditCustomer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableEditCustomer.setForeground(new java.awt.Color(255, 255, 255));
        jTableEditCustomer.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableEditCustomer);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Logo Gironza final.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(jLabel8)))
                        .addContainerGap(79, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(152, 152, 152))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(98, 98, 98))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel7)
                .addGap(27, 27, 27)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(165, 165, 165))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
        // CAPTURAR LOS CAMPOS DE LA FILA SELECCIONADA 
        
        int rowSelected = jTableEditCustomer.getSelectedRow();
        
        if(rowSelected >= 0 ){
            int customerId = Integer.parseInt(jTableEditCustomer.getValueAt(rowSelected, 0).toString());
            String Name = String.valueOf(jTableEditCustomer.getValueAt(rowSelected, 1));
            String Mail = String.valueOf(jTableEditCustomer.getValueAt(rowSelected, 2));
            String Nit = String.valueOf(jTableEditCustomer.getValueAt(rowSelected, 3));
           
            editCustomer1 editCustomer1 = new editCustomer1(customerId,Name, Mail, Nit); // MANDO POR CONSTRUCTOR LOS DATOS CAPTURADOS DE LA FILA DE LA TABLA AL FORMULARIO 
            
            
            editCustomer1.setVisible(true);
            // setiar datos capturados de la fila en el editCustomer1 para su edicion
            
            
            
        }
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEditCustomer;
    // End of variables declaration//GEN-END:variables
}
