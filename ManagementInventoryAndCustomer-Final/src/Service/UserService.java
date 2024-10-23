
package Service;
import Controller.ConexionBd;
import Vista.Dashboard;
import Vista.Login;
import Vista.Register;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class UserService {
    
    static Boolean administrador = false;
    Boolean registro = false;
    Boolean login = false;

    public Boolean getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Boolean administrador) {
        this.administrador = administrador;
    }
    
    

    public Boolean getLogin() {
        return login;
    }

    public void setLogin(Boolean login) {
        this.login = login;
    }

    public Boolean getRegistro() {
        return registro;
    }

    public void setRegistro(Boolean registro) {
        this.registro = registro;
    }
    
    public void getAllUsers(){
        
        String query = "select * from Users";
        
        try(
                Connection con = ConexionBd.getConnection();
                PreparedStatement ps = con.prepareStatement(query); // para pasar la consulta
                ResultSet rs = ps.executeQuery() ) 
        { 
            
            while (rs.next()) {                
                System.out.println("Usuario "+rs.getString("Name"));
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
                                         /*Method register user*/
    
    public void registerUser(String userName, String password, String fullName, String email, int role){
        String query = "INSERT INTO Users (UserName,Password,FullName,Email,RoleId) VALUES (?, ?, ?, ?, ?)";
        
        try(
                Connection con = ConexionBd.getConnection();
                PreparedStatement ps = con.prepareStatement(query);
                ) 
            
        {
            
             // Validar que los valores no sean nulos ni vacíos
        if (userName == null || userName.trim().isEmpty() ||
            password == null || password.trim().isEmpty() ||
            fullName == null || fullName.trim().isEmpty() ||
            email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Los campos no pueden estar vacíos");
        }
            
           ps.setString(1, userName);
           ps.setString(2, password);
           ps.setString(3, fullName);
           ps.setString(4, email);
           ps.setInt(5, role);
           
           int row = ps.executeUpdate();
           
           if(row > 0){
               System.out.println("Registrado exitosamente!!");
               registro=true;
               if(role == 1){
                   this.administrador = true;
               }
           }
           
            
        } catch (Exception e) {
            
            System.out.println("Error: "+e);
        }
    }
    
     public String convertirSHA256(String password) {
                MessageDigest md = null;
                try {
                        md = MessageDigest.getInstance("SHA-256");
                } 
                catch (NoSuchAlgorithmException e) {		
                        e.printStackTrace();
                        return null;
                }

                byte[] hash = md.digest(password.getBytes());
                StringBuffer sb = new StringBuffer();

                for(byte b : hash) {        
                        sb.append(String.format("%02x", b));
                }

                return sb.toString();
        }
    
    public void Login(String Username, String Pass){
        
        String query = "select * from users where UserName = ?  ";
        
        try(Connection con = ConexionBd.getConnection();
             PreparedStatement pst = con.prepareStatement(query);
                ) {
          // Establecer los parámetros de la consulta (Declaracion preparada) Prepared Statement
          
          pst.setString(1, Username);
          
          
          
                   
          // Ejecutar la consulta y obtener los resultados.
          ResultSet rs = pst.executeQuery();
          
                if(rs.next()) {

                    // Obteniendo la contraseña de la bd
                   String passDb= rs.getString("Password");
                   int role = rs.getInt("RoleId");
                   

                   // Encriptando la contraseña recibida por parametro
                    String passEncr=convertirSHA256(Pass);


                    if(passDb.equals(passEncr)){

                        System.out.println("Login Exitoso!!");
                        login = true;
                        
                        if(role == 1){
                            this.administrador = true;
                        } 
                        
                        
                        
                    // vista de inicio



                    }else{
                        
                    System.out.println("Invalid username or password");
                }
                    
                      
                
                
            } else {
                System.out.println("Invalid username or password");
            }
            
        } catch (Exception e) {
            System.out.println("errrrr");
            e.printStackTrace();
        }
        
    }
    
}
