
package Vista;

import Model.CustomerModel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import javax.swing.table.DefaultTableModel;


public class FormatPrinter extends javax.swing.JFrame implements Printable{
    
    DefaultTableModel modelFormatPrinter;

    public FormatPrinter(Order order) {
        initComponents();
        setLocationRelativeTo(null);
        
        String columnas[] = {"Product Name", "Quantity", "Price"};
        
        modelFormatPrinter = new DefaultTableModel(columnas, 0);
        
        jTableImpresion.setModel(modelFormatPrinter);
        
        loadData(order);
    }
    
    public void loadData(Order order){
        
        
        DefaultTableModel modelCarrito = order.defaultTableModelCarrito;
        
        if(modelCarrito.getRowCount() >0 ){
            
           String customerId = order.getcustomerId(); // traemos el customer Id para hacer una consulta
          
            CustomerModel cm = new CustomerModel(); // Instanciamos CustomerModel
            String customerName = cm.getCustomerById(Integer.parseInt(customerId)); // LLamamos a CustomerModel con el metodo getCustomerById
            
            jTfCustomerName.setText(customerName); // Setiamos el customerName en el campo de texto de la factura a imprimir
            
            
            
            double total = 0;
            
           for(int i = 0; i < modelCarrito.getRowCount(); i++){
           
            String productName = String.valueOf(modelCarrito.getValueAt(i, 1));
               System.out.println(productName);
            int qty = Integer.parseInt(modelCarrito.getValueAt(i, 2).toString());
               
            double price = Double.parseDouble(modelCarrito.getValueAt(i, 3).toString());
               
            
            Object filas [] = {productName,qty,price};
            modelFormatPrinter.addRow(filas);
            
            double operacion = qty * price;
            total += operacion;
               
            
       }
           jTfTotal.setText(String.valueOf(total));
        } else{
            System.out.println("El carrito de compras esta vacio");
        }
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFactura = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableImpresion = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTfCustomerName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTfTotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelFactura.setBackground(new java.awt.Color(204, 204, 204));
        jPanelFactura.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gironza Impresiones");
        jPanelFactura.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 41, 242, 66));

        jTableImpresion.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableImpresion);

        jPanelFactura.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 234, 537, 378));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Total");
        jPanelFactura.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(497, 637, -1, -1));

        jTfCustomerName.setBackground(new java.awt.Color(255, 255, 255));
        jTfCustomerName.setForeground(new java.awt.Color(0, 0, 0));
        jPanelFactura.add(jTfCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 168, 131, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Customer Name:");
        jPanelFactura.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 175, -1, -1));

        jTfTotal.setBackground(new java.awt.Color(255, 255, 255));
        jTfTotal.setForeground(new java.awt.Color(0, 0, 0));
        jPanelFactura.add(jTfTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 630, 131, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Logo Gironza.png"))); // NOI18N
        jPanelFactura.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 59, -1, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFactura, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFactura, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanelFactura;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableImpresion;
    private javax.swing.JTextField jTfCustomerName;
    private javax.swing.JTextField jTfTotal;
    // End of variables declaration//GEN-END:variables

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        
        if(pageIndex > 0){
            return NO_SUCH_PAGE;
        }
        
        Graphics2D interfaz = (Graphics2D) graphics;
    
    // Obtener las dimensiones del área imprimible
    double areaImprimibleAncho = pageFormat.getImageableWidth();
    double areaImprimibleAlto = pageFormat.getImageableHeight();
    
    // Obtener las dimensiones del panel que se va a imprimir
    double panelAncho = jPanelFactura.getWidth();
    double panelAlto = jPanelFactura.getHeight();
    
    // Calcular la escala en base a las proporciones de la página y del panel
    double escalaAncho = areaImprimibleAncho / panelAncho;
    double escalaAlto = areaImprimibleAlto / panelAlto;
    
    // Usar la menor escala para mantener la proporción y que quepa en la página
    double escala = Math.min(escalaAncho, escalaAlto);
    
    // Traducir las coordenadas iniciales y aplicar la escala
    interfaz.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
    interfaz.scale(escala, escala);
    
    // Imprimir el contenido del panel
    jPanelFactura.printAll(graphics);
    
    return PAGE_EXISTS;
        
    }
    
    
}
