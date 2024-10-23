
package Model;


public class Users {
    
    String FullName, Email, UserName, Password;
    int UserId; 
   

    public Users(String Name,  String Email, int UserId,  String username, String Pass) {
        this.FullName = Name;
        this.UserName = username;
        this.Password = Pass;      
        this.Email = Email;
        this.UserId = UserId;
       
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    

    public Users() {
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }




    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }


    
    
    
}
