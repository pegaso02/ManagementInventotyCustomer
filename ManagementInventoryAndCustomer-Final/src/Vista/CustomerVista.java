
package Vista;

import Service.CustomerService;
import java.util.HashSet;


public class CustomerVista extends javax.swing.JFrame {


    public CustomerVista() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("New Customer");
        
    }

 

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTfName = new javax.swing.JTextField();
        jTfMail = new javax.swing.JTextField();
        jTfNit = new javax.swing.JTextField();
        jBnSave = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 295, 98, 25));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("New Customer");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(529, 185, 364, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Mail");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 365, 98, 25));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Nit");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(511, 427, 98, 25));

        jTfName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTfName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfNameActionPerformed(evt);
            }
        });
        getContentPane().add(jTfName, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 290, 300, -1));

        jTfMail.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTfMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfMailActionPerformed(evt);
            }
        });
        getContentPane().add(jTfMail, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 360, 300, -1));

        jTfNit.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTfNit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfNitActionPerformed(evt);
            }
        });
        getContentPane().add(jTfNit, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 422, 300, -1));

        jBnSave.setBackground(new java.awt.Color(0, 51, 153));
        jBnSave.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jBnSave.setForeground(new java.awt.Color(255, 255, 255));
        jBnSave.setText("Save");
        jBnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBnSaveActionPerformed(evt);
            }
        });
        getContentPane().add(jBnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(693, 521, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 51, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 700));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Logo Gironza final.png"))); // NOI18N

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Bradley Hand ITC", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("SU SOLUCIÓN EN ARTES GRÁFICAS");

        jLabel8.setFont(new java.awt.Font("Bradley Hand ITC", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Pitalito-Huila");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(jLabel7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jLabel8)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(jLabel7)
                .addGap(27, 27, 27)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(87, 87, 87))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 702));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon user.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(646, 16, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBnSaveActionPerformed
        
        try {
        String name = jTfName.getText();
        String maill = jTfMail.getText();
        String nit = jTfNit.getText();
        
        CustomerService customer = new CustomerService();
        customer.createCustomer(name, maill, nit);
        
        
        } catch (Exception e) {
            System.out.println("Los datos no se recuperaron del text field");
        }
        
        jTfMail.setText("");
        jTfName.setText("");
        jTfNit.setText("");
        
        
        
        
    }//GEN-LAST:event_jBnSaveActionPerformed

    private void jTfNitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfNitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfNitActionPerformed

    private void jTfMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfMailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfMailActionPerformed

    private void jTfNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfNameActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTfMail;
    private javax.swing.JTextField jTfName;
    private javax.swing.JTextField jTfNit;
    // End of variables declaration//GEN-END:variables
}
