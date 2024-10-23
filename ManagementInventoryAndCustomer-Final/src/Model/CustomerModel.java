
package Model;

import Controller.ConexionBd;
import Vista.editCustomer1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class CustomerModel {
    

    
    public int CustomerId;
    String Name;
    String Mail;
    String Nit;

    public CustomerModel() {
        
    }

   
    

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int CustomerId) {
        this.CustomerId = CustomerId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    public String getNit() {
        return Nit;
    }

    public void setNit(String Nit) {
        this.Nit = Nit;
    }
    
    

    public CustomerModel(int CustomerId, String Name, String Mail, String Nit) {
        this.CustomerId = CustomerId;
        this.Name = Name;
        this.Mail = Mail;
        this.Nit = Nit;
    }
    
    public String getCustomerById(int id){
        
        String query = "Select Name FROM Customer where CustomerId = ?";
        String customerName = "";
        
        try(Connection con = ConexionBd.getConnection();
                PreparedStatement ps = con.prepareStatement(query);
                ) {
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                customerName = rs.getString(1);
            }

            
        } catch (Exception e) {
            System.out.println("Error desde metodo getByCustomerId clase customerModel"+e.getMessage());
        }
        
        return customerName;
    }
    
    
    
    public List<CustomerModel> getAllCustomer(){
        
        String query = "SELECT * FROM Customer";
        
        List<CustomerModel> filas = new ArrayList<>();
        
        try(Connection con = ConexionBd.getConnection();
        PreparedStatement ps = con.prepareStatement(query)) {
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                int idCustomer = rs.getInt("CustomerId");
                String Name = rs.getString("Name");
                String Mail = rs.getString("Mail");
                String Nit = rs.getString("Nit");
                
                CustomerModel customer = new CustomerModel(idCustomer , Name, Mail, Nit);
                
                filas.add(customer);
                
            }
            
            
        } catch (Exception e) {
            System.out.println("Error desde modelo "+e.getMessage());
        }
        
        return filas;
    }
    
    
    public boolean updateCliente(int id){
        
        boolean bandera = false;
        
        String query = "UPDATE Customer SET Name = ?, Mail = ?, Nit = ? WHERE CustomerId = ?";
        
        try(Connection con = ConexionBd.getConnection();
              PreparedStatement ps = con.prepareStatement(query)) {
            
            ps.setString(1, this.Name);
            ps.setString(2, this.Mail);
            ps.setString(3, this.Nit);
            ps.setInt(4, id);
            
            
            int rowUpdated = ps.executeUpdate();
            
            if(rowUpdated > 0){
                JOptionPane.showMessageDialog(null, "Cliente actualizado con exito");
                bandera = true;
                System.out.println(bandera);
               
           
            }else{
                System.out.println("No se pudo actualizar cliente");
            }
            
        } catch (Exception e) {
            System.out.println("Error al actualizar el cliente "+e.getMessage());
        }
        
        return bandera;
        
    }
    
    public void deleteCustomer(int id){
        
        String query = "DELETE from Customer WHERE CustomerId = ?";
        String queryValidation = "SELECT COUNT(*) FROM Invoice WHERE CustomerId = ?";  // VALIDAR SI HAY ALGUN REGISTRO EN INVOICE 
        
        try(Connection con = ConexionBd.getConnection();
              PreparedStatement ps = con.prepareStatement(query);
              PreparedStatement psValidation = con.prepareStatement(queryValidation)  ) {
           
            ps.setInt(1, id); // pasamos el id del cliente a eliminar
            psValidation.setInt(1, id);
            
            ResultSet rs = psValidation.executeQuery();
            
            while (rs.next()) {                
                int count = rs.getInt(1);  // guardamos el resultado de la consulta del primer parametro de queryValidation
                
                if(count > 0){
                    JOptionPane.showMessageDialog(null, "No se puede eliminar el registro por conflictos contables");
                    
                } else {
                    
                        int rowAfected = ps.executeUpdate();

                        if(rowAfected > 0){
                            JOptionPane.showMessageDialog(null, "Cliente eliminado con exito");
                        } else{
                            JOptionPane.showMessageDialog(null, "No se pudo eliminar");
                        }
                    
                    
                }
                
            }
            
            
            
          
            
            
        } catch (Exception e) {
            System.out.println("Error desde metodo deleteCustomer en CustomerModel "+e);
        }
        
    }
    
    
}
