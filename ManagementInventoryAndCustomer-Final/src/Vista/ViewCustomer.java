
package Vista;

import Service.CustomerService;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.util.List;



public class ViewCustomer extends javax.swing.JFrame {
    
    DefaultTableModel modelCustomer;

    public ViewCustomer() {
      initComponents();  
    setLocationRelativeTo(null);  // Centrar la ventana en la pantalla

    // Columnas de la tabla 
    Object columnas[] = {"CustomerId", "Name", "Mail", "Nit"};

    // Creamos un modelo de tabla con las columnas
    DefaultTableModel modelCustomer = new DefaultTableModel(columnas, 0);

    // Asignamos el modelo creado a la tabla
    jTableViewCustomer.setModel(modelCustomer);

    // Servicio que obtiene los datos de los clientes
    CustomerService cs = new CustomerService();

    // Obtenemos la lista de filas de la base de datos
    List<Object[]> listaClientes = cs.viewCustomer();

    // Verificamos si la lista de clientes no está vacía
    System.out.println("Número de clientes obtenidos: " + listaClientes.size());

    // Agregamos cada fila al modelo de la tabla
    for (Object[] i : listaClientes) {
        modelCustomer.addRow(i);
    }

    // Actualizamos la vista de la tabla (si es necesario)
    modelCustomer.fireTableDataChanged();
         
        
        
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableViewCustomer = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableViewCustomer.setBackground(new java.awt.Color(153, 153, 255));
        jTableViewCustomer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableViewCustomer.setForeground(new java.awt.Color(255, 255, 255));
        jTableViewCustomer.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableViewCustomer);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(307, 11, 675, 610));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Bradley Hand ITC", 1, 14)); // NOI18N
        jLabel6.setText("SU SOLUCIÓN EN ARTES GRÁFICAS");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 382, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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
                        .addGap(78, 78, 78)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jLabel7)))
                .addContainerGap(733, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(146, 146, 146))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableViewCustomer;
    // End of variables declaration//GEN-END:variables
}
