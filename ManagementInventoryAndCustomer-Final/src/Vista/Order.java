
package Vista;

import Controller.ConexionBd;
import Model.orderItems;
import Service.invoiceService;
import java.awt.List;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.math.BigDecimal;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.TableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Order extends javax.swing.JFrame {
    
    // CREAMOS EL MODELO PARA LA TABLA PRODUCTOS
    DefaultTableModel defaultTableModelProductos;
    
    // CREAMOS EL MODELO PARA LA TABLA CARRITO
    DefaultTableModel defaultTableModelCarrito;


    public Order() {
        initComponents();
        setLocationRelativeTo(null);
        
        // CREAMOS ARRAY CON EL NOMBRE DE LAS COLUMNAS PARA LAS TABLAS PRODUCTOS Y CARRITO
        String [] columnsTable = {"ProductId", "ProductName","qty","Price" };
        
        // CREAMOS INSTANCIA DEL MODELO DE PRODUCTOS Y LE PASAMOS EL ARRAY CON LOS NOMBRES DE COLUMNAS
        defaultTableModelProductos = new DefaultTableModel(columnsTable, 0);
        
        
        // SETIAMOS EN LA TABLA PRODUCTOS EL MODELO INSTANCIADO
        jTableProductos.setModel(defaultTableModelProductos);
        
        // CARGAMOS LA INFORMACION CON EL METODO LOAD DATA
        loadData();
        
        // CREAMOS INSTANCIA TABLEMODEL PARA LA TABLA CARRITO Y LE PASAMOS EL NOMBRE DE LAS COLUMNAS
        defaultTableModelCarrito = new DefaultTableModel(columnsTable,0);
        jTableCarrito.setModel(defaultTableModelCarrito);
    }
    
    
    
    
    public void loadData(){
        
        String query = "SELECT ProductId, ProductName, Qty,Price FROM Product";
        
        try(
                Connection con = ConexionBd.getConnection();
                PreparedStatement ps = con.prepareStatement(query);
                ) {
            
           ResultSet rs = ps.executeQuery();
           
            while (rs.next()) {                
                String productId = rs.getString("ProductId");
                String productName = rs.getString("ProductName");
                BigDecimal Price = rs.getBigDecimal("Price");
                int qty = rs.getInt("Qty");
                
                Object []filas = {productId,productName,qty,Price};
                
                defaultTableModelProductos.addRow(filas);
                
                
            }
            
            
            
        } catch (Exception e) {
        }
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable();
        jBtnAddCart = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableCarrito = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTfCustomerId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jBtnCreateOrder = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jBtnImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 51, 153));

        jTableProductos.setBackground(new java.awt.Color(0, 51, 153));
        jTableProductos.setForeground(new java.awt.Color(255, 255, 255));
        jTableProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProductos);

        jBtnAddCart.setBackground(new java.awt.Color(255, 255, 255));
        jBtnAddCart.setText("> > ");
        jBtnAddCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAddCartActionPerformed(evt);
            }
        });

        jTableCarrito.setBackground(new java.awt.Color(0, 51, 153));
        jTableCarrito.setForeground(new java.awt.Color(255, 255, 255));
        jTableCarrito.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTableCarrito);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CustomerID");

        jTfCustomerId.setPreferredSize(new java.awt.Dimension(6, 30));
        jTfCustomerId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfCustomerIdActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha");

        jBtnCreateOrder.setBackground(new java.awt.Color(255, 255, 255));
        jBtnCreateOrder.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBtnCreateOrder.setText("Create Invoice");
        jBtnCreateOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCreateOrderActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Logo Gironza.png"))); // NOI18N

        jBtnImprimir.setBackground(new java.awt.Color(255, 255, 255));
        jBtnImprimir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBtnImprimir.setText("Print");
        jBtnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jLabel2)
                                .addGap(36, 36, 36))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(jTfCustomerId, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtnAddCart)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBtnCreateOrder)
                        .addGap(42, 42, 42)
                        .addComponent(jBtnImprimir)
                        .addGap(61, 61, 61)))
                .addGap(99, 99, 99))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTfCustomerId, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnAddCart)
                        .addGap(302, 302, 302))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 57, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnCreateOrder)
                    .addComponent(jBtnImprimir))
                .addGap(107, 107, 107))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductosMouseClicked
        /*El usuario hace clic en una fila de la tabla de productos.
            El programa detecta el clic y obtiene los datos de esa fila.
            Los datos se copian a la tabla del carrito de compras.*/
        

        
    }//GEN-LAST:event_jTableProductosMouseClicked

    private void jBtnAddCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAddCartActionPerformed
        
        agregarAlCarrito();
        
       
    }//GEN-LAST:event_jBtnAddCartActionPerformed

    // BOTON CREAR FACTURA
    
    String customerId;
    
    public String getcustomerId(){
        return this.customerId;
    }
    
    private void jBtnCreateOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCreateOrderActionPerformed
        
         customerId = jTfCustomerId.getText();

        
        // Validar si el cliente existe en base de datos, para hacer el pedido
        String consulta = "SELECT * from Customer WHERE CustomerId = ?";
        
               
        try(Connection con = ConexionBd.getConnection();
                
                PreparedStatement ps = con.prepareStatement(consulta);
                
               ) {
            

     
             if(!customerId.trim().isEmpty() && customerId != null){
                 
                 
                             int customIdInt = Integer.parseInt(customerId);
                 
                            ps.setInt(1, customIdInt);
                            ResultSet rs = ps.executeQuery();
            
            
                            if (rs.next()  ) {  // SI EXISTE EL CLIENTE GENERAMOS LA FACTURA
                
                            
                           double total = calcularTotal();
                      
                           invoiceService service = new invoiceService();  // INSTANCIA INVOICE SERVICE

                           service.createInvoice(customIdInt, total);
                           
                           
                           
                            // INSERTAR DETALLE EN LA TABLA InvoiceProduct Y DESCONTAR LAS CANTIDADES AL INVENTARIO
                           
                           String query1 = "INSERT INTO InvoiceProduct (InvoiceId,ProductId,Quantity,Price,ProductName) VALUES (?,?,?,?,?)";
                           
                           PreparedStatement psInvoiceProduct = con.prepareStatement(query1);
                           
                           DefaultTableModel modelCarrito = (DefaultTableModel)jTableCarrito.getModel();
                           
                           int row = modelCarrito.getRowCount(); // Obtenemos la cantidad de filas de la tabla carrito
                           
                           psInvoiceProduct.setInt(1, service.getfacturaid());
                           
                                System.out.println("llego hasta aqui");
                                
                            // Instancia de invoice service para traer el valor de bandera
                                 invoiceService invoice = new invoiceService();
                                
                           for(int i = 0 ; i < row ; i++){
                               
                               // ITERAR SOBRE LAS FILAS CARRITO
                               int productId = Integer.parseInt(jTableCarrito.getValueAt(i, 0).toString());
                               int quantity = Integer.parseInt(jTableCarrito.getValueAt(i, 2).toString());
                               String productName = String.valueOf(jTableCarrito.getValueAt(i, 1));
                               Double price = Double.parseDouble(jTableCarrito.getValueAt(i, 3).toString());
                               Double total1 = quantity * price;
                               
                               // ESTABLECER PARAMETROS SOBRE LA CONSULTA SQL
                               psInvoiceProduct.setInt(2, productId);
                               psInvoiceProduct.setInt(3, quantity);
                               psInvoiceProduct.setDouble(4, total1);
                               psInvoiceProduct.setString(5, productName);
                         
                            
                               
                               int filasAfectadas = psInvoiceProduct.executeUpdate();
                               
                    
                               
                              
                                 
                               if(filasAfectadas > 0){
                                   System.out.println("Datos ingresados con exito");
                                   
                                   // TRAER LOS PRODUCT ID DE LAS FILAS DE CARRITO PARA DESCONTAR EN PRODUCT
                                 // DESCONTAR INVENTARIO
                                  String queryDescontarQty = "UPDATE Product set Qty = ? WHERE ProductId = ?";
                                  
                                  // query validar cantidades para restarle las pedidas en carrito
                                  String queryQtyInventario = "SELECT Qty FROM Product WHERE ProductId = ?";
                                  PreparedStatement psQtyInventario = con.prepareStatement(queryQtyInventario);
                                  
                                  psQtyInventario.setInt(1, productId);
                                  ResultSet rsQtyInventario = psQtyInventario.executeQuery();
                                  int QtyInventario = 0;
                                   if(rsQtyInventario.next()){
                                       QtyInventario = rsQtyInventario.getInt("Qty");
                                   }
                                  
                                  
                                  PreparedStatement psDescontarQty = con.prepareStatement(queryDescontarQty);
                                  
                                  psDescontarQty.setInt(1, QtyInventario-quantity);// pasar la cantidad del inventario para restarle y quede la diferencia
                                  psDescontarQty.setInt(2, productId);
                               
                              int filasAfectadasInventario = psDescontarQty.executeUpdate();
                              if(filasAfectadasInventario > 0){
                                  System.out.println("Se desconto del inventario Correctamente");
                              } else{
                                  System.out.println("Ninguna fila fue afectada en inventario");
                              }
                              
                               } else{
                                   System.out.println("Ninguna fila fue afectada");
                               }
                               
                               
                           }
                           
                        
                           
                          
                           
              
            } else{
                JOptionPane.showMessageDialog(null, "No existe el cliente ");
            }
             } else{
                 JOptionPane.showMessageDialog(null, "idCustomer no existe ");
             }
            
            
        } catch (Exception e) {
            
            System.out.println("error desde order"+e.getMessage());
        }
        
        
        
       

        

        
    }//GEN-LAST:event_jBtnCreateOrderActionPerformed

    private void jBtnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnImprimirActionPerformed
        FormatPrinter fp = new FormatPrinter(this);
        fp.setVisible(true);
        
         try {
             PrinterJob printer = PrinterJob.getPrinterJob();
            printer.setPrintable(fp);
            
            boolean cuadroDialogoImprimir = printer.printDialog(); // SI se da en el boton imprimir da verdadero, si cancel falso
            
            if(cuadroDialogoImprimir){
                printer.print();
            }
            
            
        } catch (PrinterException e) {
            JOptionPane.showMessageDialog(null, "error desde metodo Imprimir en order clase"+e);
        }
        
    }//GEN-LAST:event_jBtnImprimirActionPerformed

    private void jTfCustomerIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfCustomerIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfCustomerIdActionPerformed


    
        public double  calcularTotal(){
        
        DefaultTableModel modelCarrito = (DefaultTableModel)jTableCarrito.getModel();
        Double total = 0.0;
        
        int cantidadFilas = modelCarrito.getRowCount();
        
        for(int i = 0; i < cantidadFilas; i++){
            
            Object precioObject = modelCarrito.getValueAt(i, 3); // Iterar sobre todas las filas y la columna Precio 
            int cantidadCarrito = (int) modelCarrito.getValueAt(i, 2); // Iterar sobre todas las filas y la columna Cantidad
            
              if(precioObject instanceof Number){
                  
                  double precio = ((Number) precioObject).doubleValue(); // Guardamos el valor precio de cada fila en una nueva variable de tipo double
                  System.out.println(cantidadCarrito);
                  double Precioqty =precio * cantidadCarrito; 
                  
                  // MULTIPLICAR POR CANTIDAD DE PRODUCTOS FILA 4 EN LA TABLA CARRITO
                  
                  total += Precioqty;
                  System.out.println(total);
                  
                  
              }else if(precioObject instanceof String){
                  System.out.println("es string");
                  double precio = Double.parseDouble((String)precioObject);
                  total += precio;
              }
        }
        
      return total;
        
    }
    
    public void agregarAlCarrito(){
        
        int fila = jTableProductos.getSelectedRow(); // OBTENEMOS LA FILA QUE SELECCIONEMOS
        
        if(fila >= 0){
                    
            TableModel modeloproductos = jTableProductos.getModel();
            DefaultTableModel modeloCarrito = (DefaultTableModel) jTableCarrito.getModel();

                    

            Object productId = jTableProductos.getValueAt(fila, 0);
            Object productName = jTableProductos.getValueAt(fila, 1);
            Object price = jTableProductos.getValueAt(fila, 3);
            Object qty = jTableProductos.getValueAt(fila, 2);
            

              // Verificamos la cantidad del producto antes de agregarlo al carrito


              int cantidadSolicitada = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la cantidad requerida: "));


               // Consulta para verificar el inventario del producto

               String queryProduct = "SELECT * from Product where ProductId = ?";

                try(Connection con = ConexionBd.getConnection()) {   

                    PreparedStatement ps = con.prepareStatement(queryProduct);

                    // PRIMERO SE PREPARA LA CONSULTA Y DESPUES SE EJECUTA CON RESULTSET

                    ps.setObject(1, productId);


                    ResultSet rst = ps.executeQuery();

                    
                    if(rst.next()){

                        int cantidadDisponible = rst.getInt("Qty");

                        // COMPARAMOS LA CANTIDAD DISPONIBLE CON LA INGRESADA POR EL USUARIO

                        if(cantidadSolicitada > 0 && cantidadSolicitada <= cantidadDisponible){

                            modeloCarrito.addRow(new Object[]{productId,productName,cantidadSolicitada,price});  //ANIADIMOS LA FILA DEL PRODUCTO CON LAS CANTIDADES SOLICITADAS
                            


                        } else{
                            JOptionPane.showMessageDialog(null, "cantidad no disponible");
                        }
                    }

                } catch (Exception e) {


                }




//            Object[] filaProductos = new Object [modeloproductos.getColumnCount()];
//
//
//            for(int i = 0; i < modeloproductos.getColumnCount();i++){
//
//                filaProductos[i] = modeloproductos.getValueAt(fila, i);
//
//
//            }
//
//            modeloCarrito.addRow(filaProductos);
        
        
        }
        
        

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAddCart;
    private javax.swing.JButton jBtnCreateOrder;
    private javax.swing.JButton jBtnImprimir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableCarrito;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JTextField jTfCustomerId;
    // End of variables declaration//GEN-END:variables
}
