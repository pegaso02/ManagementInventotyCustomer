

package Service;

import Controller.ConexionBd;
import Vista.deleteProduct;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProductService {
    
//    DefaultTableModel modelDeleteProduct;
    
    boolean bandera = false;

    public boolean getBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

 
    public void newProduct(String productName,BigDecimal price, int Qty){   // Crear un nuevo producto
        String query = "INSERT INTO Product (ProductName,Price,qty) VALUES (?,?,?)";

        
        try(
        Connection con = ConexionBd.getConnection();
        PreparedStatement ps = con.prepareStatement(query);
                ) {
            
            ps.setString(1, productName);
            ps.setBigDecimal(2, price);
            ps.setInt(3, Qty);
            
            int row = ps.executeUpdate();
            
            if(row>0){
                System.out.println("Producto ingresado");
                this.bandera = true;
            }
            
        } catch (Exception e) {
            System.out.println("Producto no ingresado !! "+e);
        }
    }
    
    public List<Object []> updateProduct(){ // TRAEMOS LA INFORMACION DE LA TABLA PRODUCTOS
        
        List<Object[]> filas1 = new ArrayList<>();
        
        String query = "Select ProductId,ProductName,Price,Qty FROM Product";
        
        try(Connection con = ConexionBd.getConnection();
              PreparedStatement ps = con.prepareStatement(query);) {
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                int ProductId = rs.getInt("ProductId");
                String productName = rs.getString("ProductName"); // Traemos los datos de la bd a una variable
                Double price = rs.getDouble("Price");
                int qty = rs.getInt("Qty");
                
                Object filas[] = {ProductId,productName,price,qty};
                filas1.add(filas);
                
            }
            
        } catch (Exception e) {
            System.out.println("Error al traer la infor de bd al array"+e);
        }
        return filas1;
    }
    
    public void DeleteProduct(deleteProduct dp){
            
          String query = "DELETE FROM Product WHERE ProductId = ?";
          String queryValidacion = "SELECT COUNT(*) FROM InvoiceProduct WHERE ProductId = ?"; // validar si el producto fue facturado anteriormente, de ser asi no se puede eliminar ya que eliminaria el registro de factura y habria conflicto contable
        
 
        int rowSelected = dp.getjTableDeleteP().getSelectedRow(); // traemos la fila seleccionada en la tabla
        
        if(rowSelected >= 0){
            System.out.println("aqui llega");
            
            try(Connection con = ConexionBd.getConnection();
                 PreparedStatement ps = con.prepareStatement(query);
                 PreparedStatement psValidacion = con.prepareStatement(queryValidacion);
                 ){
                
                DefaultTableModel modelDeleteProduct =  dp.getModelDeleteProduct();
                int idProduct = Integer.parseInt( modelDeleteProduct.getValueAt(rowSelected, 0).toString()); // tomamos el valor del productId
                
                psValidacion.setInt(1, idProduct);
                
                ResultSet rs = psValidacion.executeQuery();
                
                while(rs.next()){
                    
                    int count = rs.getInt(1); // recibimos el resultado de count de la consulta en InvoiceProduct
                    
                    if(count > 0){
                        JOptionPane.showMessageDialog(null, "No se puede eliminar el producto por conflictos contables");
                    } else{
                                 ps.setInt(1, idProduct);
                
                                int filasAfectadas = ps.executeUpdate();

                                if(filasAfectadas > 0){
                                    JOptionPane.showMessageDialog(null, "Producto eliminado");
                                }else{
                                    JOptionPane.showMessageDialog(null, "Error al eliminar producto");
                                }
                    }
                    
                }
                

                
            } catch (Exception e) {
                
                System.out.println("Error al eliminar "+e.getMessage());
                
            }
        }
        
        
        
    }
    
    
    
}
