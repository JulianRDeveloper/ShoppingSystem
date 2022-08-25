package Model;

import Classes.ShopCart;
import Controller.Conect;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ModelShopCart {
    ConData conData;
    ShopCart shopCart;
    DefaultTableModel table;
    int idCart;
    
    public ModelShopCart(){
       this.conData = new ConData();
       this.table = new DefaultTableModel();
    }
   
    public int newCart(ShopCart cart){
        try (Connection conn = DriverManager.getConnection(conData.getUrl(), conData.getUser(), conData.getPassword())){
            if(conn != null){
              System.out.println("Connection from ModelShopCart.newShopCart");
            } 
            String query = "INSERT INTO shop_cart (cart_date, client_id) VALUES (?,?)";
            PreparedStatement stCart = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stCart.setString(1, cart.getCartDate());
            stCart.setInt(2, cart.getClient_id());
            int rows = stCart.executeUpdate();
            System.out.println(rows);
            if(rows > 0){
                ResultSet generatedKeys = stCart.getGeneratedKeys();
                if(generatedKeys.next()){
                    int cart_id= generatedKeys.getInt(1);
                    System.out.println("new shopCart key: "+cart_id);
                    return cart_id;
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Service Problems -newCart");            
        }return 0;        
    }
    
    public boolean delCart(int cartID){      
        try(Connection conn = DriverManager.getConnection(conData.getUrl(), conData.getUser(), conData.getPassword())){
            //conn = conect.getConnection();
            if(conn != null){
                System.out.println("Connection from ModelShopCart.delShopCart ");
                
            }
            String query = "DELETE FROM shop_cart WHERE id = ?";
            PreparedStatement stCart = conn.prepareStatement(query);
            stCart.setInt(1, cartID);
            int rows= stCart.executeUpdate();
            if(rows>0){
                System.out.println("shopCart deleted");
                return true;
            }
        }catch(Exception e){   
            JOptionPane.showMessageDialog(null, "Service Problems");
                    
        }return false;               
        }
        
    public ShopCart loadCart(int clientID){
            try(Connection conn = DriverManager.getConnection(conData.getUrl(), conData.getUser(), conData.getPassword())){
            //conn = conect.getConnection();
            if(conn != null){
                System.out.println("Connection from ModelShopCart.loadShopCart");
            }
            String query = "SELECT * FROM shop_cart WHERE client_id = ?";
            PreparedStatement stCart = conn.prepareStatement(query);
            stCart.setInt(1, clientID);
            ResultSet rs = stCart.executeQuery();
            if(rs.next()){
                int id= rs.getInt("id");                
                String date= rs.getString("cart_date");                
                int client_id = rs.getInt("client_id");                
                shopCart = new ShopCart(id, date, client_id);
                System.out.println("loaded shopCart key: "+id);
                return shopCart;
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error in the conection");
            }
        return null;       
    }     
    
    public DefaultTableModel updateCart(JTable model, int cartID){        
        try(Connection conn = DriverManager.getConnection(conData.getUrl(), conData.getUser(), conData.getPassword())){
            if(conn != null){
                System.out.println("Connection from ModelShopCart.updateCart");
            }
        String query = "SELECT item.id, item.category, item.supplier, item_line.amount, item_line.cost FROM item_line INNER JOIN shop_cart ON shop_cart.id = item_line.shopCart_id INNER JOIN item on item.id = item_line.item_id WHERE shop_cart.id = ?";
        PreparedStatement stLoadCart = conn.prepareStatement(query);
        stLoadCart.setInt(1, cartID);
        ResultSet rs = stLoadCart.executeQuery();
        Object[] cartItems = new Object[5];
        table= (DefaultTableModel)model.getModel();
        while(rs.next()){
            cartItems[0]= rs.getString("id");
            cartItems[1]= rs.getInt("amount");
            cartItems[2]= rs.getString("category");
            cartItems[3]= rs.getString("supplier");
            cartItems[4]= rs.getDouble("cost");            
            table.addRow(cartItems);            
        }
        return table;
        //cartTable.setModel(cartStock);    
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error in the connection");
        }
    return null;
    }  
   
    public String getAmounts(){
        Conect conect = new Conect();
        Connection conn;
        try { 
            conn = conect.getConnection();
            if(conect != null){
                System.out.println("Connected from ModelCartShop.getAmounts");                
            }
            String query = "SELECT SUM(item_line.amount) FROM item_line INNER JOIN shop_cart on item_line.shopCart_id = shop_cart.id";
            Statement stAmounts = conn.createStatement();
            ResultSet rs = stAmounts.executeQuery(query);
            if(rs.next()){
              String amounts = rs.getString("SUM(item_line.amount)");
              return amounts;            
            }else{
                return null;
            }                       
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "cloud calculation error");
    }
    return null;
    }

public String getTotalPrice(){
    Conect conect = new Conect();
    Connection conn;
    try{ 
            conn = conect.getConnection();
            if(conect != null){
                System.out.println("Connected from ModelCartShop.getTotalPrice");                
            }
            String query = "SELECT SUM(item_line.cost) FROM item_line INNER JOIN shop_cart on item_line.shopCart_id = shop_cart.id";
            Statement stTotal = conn.createStatement();
            ResultSet rs = stTotal.executeQuery(query);
            if(rs.next()){
              String total = rs.getString("SUM(item_line.cost)");
              return total;            
            }else{
                return null;
            }                       
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null, "cloud calculation error");
    }
    return null;
    }
}
