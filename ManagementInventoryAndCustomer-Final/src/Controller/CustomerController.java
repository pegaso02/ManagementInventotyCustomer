
package Controller;

import Model.CustomerModel;
import Vista.ViewCustomer;
import Vista.deleteCustomer;
import Vista.editCustomer;
import Vista.editCustomer1;
import java.util.List;


public class CustomerController {
    
   
    
    
    
    CustomerModel customerModel; // MODELO
    editCustomer edit; // VISTA EDITAR TABLA
    editCustomer1 ec1; // VISTA FORMULARIO EDITAR
    deleteCustomer deleteCustomer; // Vista DeleteCustomer


    public CustomerController() {
    }
    
    
    public CustomerController(deleteCustomer deleteCustom) {
        this.deleteCustomer = deleteCustom;
    }
    

    public CustomerController(CustomerModel customerModel, editCustomer Edit,editCustomer1 ec1) {
        
        this.customerModel = customerModel;
        this.edit = Edit;
        this.ec1 = ec1;
        
        
    }
    
    public void fillTable(){ // METODO LLENAR TABLA
        
        // Obtener los datos desde el modelo
        List<CustomerModel> filas = customerModel.getAllCustomer();
        
        
        // Llenar la tabla en la vista con esos datos
        edit.fillTable(filas);
        
    }
    
    public void fillTableDelete(){
        
        List<CustomerModel> filas = customerModel.getAllCustomer();
        
        deleteCustomer.fillTable(filas);
        
    }
    
    
    
    public void updateCustomer(int id, String Name, String Mail, String Nit){
        
        try {
            
        customerModel = new CustomerModel(id, Name, Mail, Nit);
        boolean succes = customerModel.updateCliente(id);
        
        if(succes){
           this.ec1.clearFields();
            System.out.println("aqui pasa por controller");
        }
        
          
            
        } catch (Exception e) {
        }
        
        
    }
    
    
    public void deleteCustomer(int id){
        
        customerModel = new CustomerModel();
        System.out.println("llego aqui Controller");
        customerModel.deleteCustomer(id);
        
        
    }
    
    

    
}
