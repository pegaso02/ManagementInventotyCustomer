
package Service;
import Controller.ConexionBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ReportService {
    
    public List<Object []> loadDatabilling(){
        
          List<Object[]> columnasArray = new ArrayList<>();
        
        String query = "SELECT Invoice.InvoiceId, Invoice.Date,Customer.Name, Customer.CustomerId, InvoiceProduct.ProductName,InvoiceProduct.Quantity, Invoice.Total\n" +
                                "from Customer left join Invoice on Customer.CustomerId = Invoice.CustomerId left join InvoiceProduct on Invoice.InvoiceId = InvoiceProduct.InvoiceId";
                
                
        try(Connection con = ConexionBd.getConnection();
              PreparedStatement ps = con.prepareStatement(query);
               
                ) {
            
             
             ResultSet rs = ps.executeQuery(); // Retorna un boolean 
             
             while(rs.next()){  // Si encuentra algo
                 
                 DecimalFormat df = new DecimalFormat("#.00"); // Dos decimales
                 
                 int invoiceId = rs.getInt("InvoiceId");
                 Date date = rs.getDate("Date");
                 String name = rs.getString("Name");
//                 int customerId = rs.getInt("CustomerId");
                 String productName = rs.getString("ProductName");
                 int qty = rs.getInt("Quantity");
                 Double total = rs.getDouble("Total");
               
                 //Vector
               Object columnas[] = {invoiceId,date,name,productName,qty,df.format(total)};
               
               // aniadimos el vector  a el array
               columnasArray.add(columnas);
                 
             }
             
             
        } catch (Exception e) {
            System.out.println("No se pueden mostrar los datos desde ReportService "+ e.fillInStackTrace());
        }
        
        return columnasArray;
    }
    
}
