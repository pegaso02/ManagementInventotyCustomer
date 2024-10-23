
package Service;

import Controller.ConexionBd;
import Model.orderItems;
import com.mysql.cj.jdbc.StatementImpl;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.time.LocalDate;
import java.sql.ResultSet;
import javax.swing.JOptionPane;



public class invoiceService {
    
    
    private boolean bandera = false;
    private int facturaid;

    public int getfacturaid() {
        return facturaid;
    }

    public void setfacturaid(int facturaid) {
        this.facturaid = facturaid;
    }
    
    public void setBandera(boolean bandera){
        this.bandera = bandera;
    }
    
       public boolean getBandera(){
        return this.bandera;
    }
    
    
    public void createInvoice(int customerId,double total){
        
        LocalDate fecha = LocalDate.now();
        
        Date fechasql = Date.valueOf(fecha);
        
        double total1 = total;
        
        String query = "INSERT INTO Invoice(Date, Total,CustomerId) VALUES (?,?,?)";
        
        // LOGICA PARA ALMACENAR INFORMACION EN LA TABLA INVOICE
        try( Connection con = ConexionBd.getConnection();
              PreparedStatement ps = con.prepareStatement(query, StatementImpl.RETURN_GENERATED_KEYS);
                ) {
            
            ps.setDate(1, fechasql);
            ps.setDouble(2, total);
            ps.setInt(3, customerId);

            
            int row = ps.executeUpdate();
            
            if(row > 0){
                JOptionPane.showMessageDialog(null, "Factura creada con exito");
                
                          // OBTENEMOS EL VALOR DEL CUSTOMERID
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                this.facturaid = rs.getInt(1);
                }

                
            } else{
                 JOptionPane.showMessageDialog(null, "Por favor valida que los datos ingresados sean correctos");
            }
            
  

        } catch (Exception e) {
            System.out.println("Conexion a base de datos fallida desde el invoiceService: "+e);
        }
        
    }
    
    public String customerName(int customerId){
        return null;
    }

    
}
