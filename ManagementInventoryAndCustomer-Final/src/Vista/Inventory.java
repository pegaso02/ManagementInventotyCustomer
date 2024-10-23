
package Vista;

import Controller.ConexionBd;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Inventory extends javax.swing.JFrame {
    
    DefaultTableModel tableModel;

    public JTable getjTable1() {
        return jTable1;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }
    
    

 
    public Inventory() {
        initComponents(); // Inicializa los componentes generados por NetBeans
        setTitle("Inventory");
        setLocationRelativeTo(null);
        
        // Definir las columnas para la tabla
        String[] ColumnsTable = {"ProductId", "ProductName", "Price", "Qty"};
        
        // Configurar el modelo de la tabla con las columnas
        tableModel = new DefaultTableModel(ColumnsTable, 0);
        
        // Establecer el modelo de la tabla en jTable1 que ya fue creado por el GUI Builder
        jTable1.setModel(tableModel);
        
        // Llamar al método para cargar los datos
        loadData();
        
    }

    private void loadData(){
        String query = "SELECT ProductId,ProductName,Price,Qty FROM Product";
        
        try(
                Connection con = ConexionBd.getConnection();
                PreparedStatement ps = con.prepareStatement(query);
                
                ) {
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                // Traemos la informacion de base de datos
                
                int productId = rs.getInt("ProductId");
                String productName = rs.getString("ProductName");
                Double price = rs.getDouble("Price");
                int qty = rs.getInt("Qty");
                
                Object [] fila ={productId,productName,price,qty};
                
                tableModel.addRow(fila);
                
                
            }
            
        } catch (Exception e) {
            System.out.println("no puedo mostrar los datos");
        }
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 689, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 685, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 692, -1, -1));

        jTable1.setBackground(new java.awt.Color(153, 153, 255));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setGridColor(new java.awt.Color(0, 51, 153));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 31, 668, 570));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Bradley Hand ITC", 1, 14)); // NOI18N
        jLabel6.setText("SU SOLUCIÓN EN ARTES GRÁFICAS");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 420, -1, -1));

        jLabel8.setFont(new java.awt.Font("Bradley Hand ITC", 1, 24)); // NOI18N
        jLabel8.setText("Pitalito-Huila");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 570, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Logo Gironza final.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(732, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(68, 68, 68))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(jLabel7)
                .addContainerGap(310, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
  


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}


