
package Service;

import Controller.ConexionBd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import java.util.List;


public class CustomerService {
    
    public void createCustomer(String name,String mail,String nit){
        
        String query = "INSERT INTO Customer(Name,Mail,Nit) VALUES (?, ?, ?)";
        
        try(
              Connection  con = ConexionBd.getConnection();
                PreparedStatement ps = con.prepareCall(query);
                ) {
            
            ps.setString(1, name);
            ps.setString(2, mail);
            ps.setString(3, nit);
            
            
            // Guardar cantidad de filas afectadas
            int row = ps.executeUpdate();
            
            if(row > 0){
                System.out.println("registrado con exito !! ");
            }
                
        } catch (Exception e) {
            
            System.out.println("No se pudo regustrar ccliente");
        }
        
        
        
    }
    
    // metodo visualizar clientes en jTable
    public List<Object[]> viewCustomer(){
        String query = "SELECT CustomerId,Name,Mail,Nit FROM Customer";
         List<Object[]>filas = new ArrayList<>();
        try(Connection con = ConexionBd.getConnection();
              PreparedStatement ps = con.prepareStatement(query);
                              
                ) {
            
           
            // ejecutamos query
            ResultSet rs =ps.executeQuery();
            
            // Si encuentra algo
            while(rs.next()){
                
                // Traemos infor de base de datos 
                
                int customerId = rs.getInt("CustomerId");
                String name = rs.getString("Name");
                String mail = rs.getString("Mail");
                String Nit = rs.getString("Nit");
                
                Object fila [] = {customerId,name,mail,Nit};
                
                filas.add(fila);
                
                //Validacion
                
                System.out.println("cliente "+name +" ");
            }
            
        } catch (Exception e) {
            System.out.println("No puedo mostrar los datos"+e);
        }
        
       
        return filas;
       
    
    }
    
    public void editCustomer(){
        // traer los datos de la vista a editar
        
    }
    
    // agregar modificacion y eliminacion 
    
}
