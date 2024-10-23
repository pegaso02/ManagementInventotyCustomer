
package Model;


public class Product {
    String productName;
    Double price;

    public Product(String productName, Double price) {
        this.productName = productName;
        this.price = price;
    }
    
    public Product() {
     
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
    
    
    
}
