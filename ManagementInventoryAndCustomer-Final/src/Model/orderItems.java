
package Model;

import java.math.BigDecimal;
import java.util.Date;


public class orderItems {
    
    int customerId;
    String productName;
    int qty;
    Date date;
    BigDecimal price;
    BigDecimal total;
    
    public orderItems(int customId,int Qty,Date date, BigDecimal total){
        this.customerId = customId;
        this.qty = Qty;
        this.date = date;
        this.total = total;
        
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    
    
    public orderItems(){
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    
    
    
}
