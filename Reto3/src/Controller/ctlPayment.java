package Controller;

import Classes.Payment;
import Model.ModelPayment;
import javax.swing.JOptionPane;


public class ctlPayment {
   Payment pay;
   ModelPayment modelPay;

    public ctlPayment() {
        modelPay = new ModelPayment();
    }
   
   
   
   
public int addPayment(Payment pay){
    try{
        return modelPay.addPayment(pay);
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "System Error");
    }return 0;
}
   
public boolean delPayment(int payID){
    try{
        return modelPay.delPayment(payID);
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "System Error");
    }return false;
}
 
       public boolean updateOrderStatus(int payID){
        try{
            return modelPay.updateOrderStatus(payID);
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, "System Error");
        }return false;
    } 
       
    public Payment loadPayment(int orderID){
        try{
            return modelPay.loadPayment(orderID);
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, "System Error");
        }return null;
    }
}
