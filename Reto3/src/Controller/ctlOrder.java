package Controller;
import Classes.Order;
import Model.ModelOrder;
import javax.swing.JOptionPane;

public class ctlOrder {
    private ModelOrder ModOrder;

    public ctlOrder() {
        this.ModOrder = new ModelOrder();
    }
    
    public int newOrder(Order order){
     try{
            return this.ModOrder.addOrder(order);
           }catch(Exception e){
                JOptionPane.showMessageDialog(null, "System Error");
           }return 0;   
    }
    
    public boolean delOrder(int orderID){
        try{
            return this.ModOrder.delOrder(orderID);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "System Error");
        }return false;
    }
    
    public Order loadOrder(int clientID){
        try{
            return ModOrder.loadOrder(clientID);
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, "System Error");
        }return null;
    }
    
}
