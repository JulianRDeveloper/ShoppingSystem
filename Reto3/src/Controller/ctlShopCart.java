
package Controller;
import Classes.ShopCart;
import Model.ModelShopCart;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ctlShopCart {
    private ModelShopCart modelCart;

    public ctlShopCart() {
        this.modelCart = new ModelShopCart();
    }

    public int newShopCart(ShopCart cart){
        try{
            return modelCart.newCart(cart);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "controller Problems");
            
        }return 0;
    }
    
    public boolean delShopCart(int cartID){
        try{
            this.modelCart.delCart(cartID);
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "controller Problems");
            
        }return false;
    }
    
    public ShopCart loadShopCart(int clientID){
        try{
            return this.modelCart.loadCart(clientID);
            //return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "controller Problems");
            
        }return null;
    }    
    
    public DefaultTableModel updateShopCart(JTable model, int cartID){
            //JModel = model
            try{
            return this.modelCart.updateCart(model, cartID);
            //return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "controller Problems");
            
        }return null;
    }
    
    public String getAmounts(){
        try{
            return this.modelCart.getAmounts();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "controller Problems");            
        }
        return null;
    }
    
    public String getTotalPrice(){
        try{
            return this.modelCart.getTotalPrice();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "controller Problems");            
        }
        return null;
    }
}
