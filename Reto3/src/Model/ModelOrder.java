package Model;

import Classes.Order;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;

public class ModelOrder {
    ConData conData;
    Order order;

    public ModelOrder() {
        this.conData = new ConData();
    }
    
public int addOrder(Order order){
        try (Connection conn = DriverManager.getConnection(conData.getUrl(), conData.getUser(), conData.getPassword())){
        if(conn != null){
                System.out.println("Conection from ModelOrder.addOrder");
            }
        String query= "INSERT INTO pedido (order_date, status, cost, client_id) VALUES (?,?,?,?)";
        PreparedStatement stOrder= conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        java.util.Date orderDate = order.getOrderDate();
        java.sql.Date sqlDate = new java.sql.Date(orderDate.getTime());
        stOrder.setDate(1, sqlDate);
        stOrder.setString(2, order.getStatus());
        stOrder.setDouble(3, order.getCost());
        stOrder.setInt(4, order.getClient_id());
        //stOrder.setInt(5, order.getShopCart_id());
        int newsRows= stOrder.executeUpdate();
        if(newsRows >0){
            ResultSet generatedKeys = stOrder.getGeneratedKeys();
            if(generatedKeys.next()){
                int order_id = generatedKeys.getInt(1);
                System.out.println("new order set key: "+order_id);                
                if(newsRows >0){
                    return order_id;
                }
            }
        }
        return 0;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error in the connection");
            
        }return 0; 
    }
    
   public boolean delOrder(int orderID){
        try (Connection conn = DriverManager.getConnection(conData.getUrl(), conData.getUser(), conData.getPassword())){
          if(conn != null){
              System.out.println("Connection from ModelClient.DelOrder");
          } 
        String query = "DELETE FROM pedido WHERE id = ?";
        PreparedStatement stOrder = conn.prepareStatement(query);
        stOrder.setInt(1, orderID);
        if(stOrder.execute()){
            System.out.println("order deleted");
            return true;
            }
        }catch(Exception e){   
            JOptionPane.showMessageDialog(null, "Service Problems");                    
        }return false;      
    } 
    
public Order loadOrder(int clientID){
    try(Connection conn = DriverManager.getConnection(conData.getUrl(), conData.getUser(), conData.getPassword())){
            //conn = conect.getConnection();
            if(conn != null){
                System.out.println("Connection from ModelOrder.loadOrder");
            }
            String query = "SELECT * FROM pedido WHERE client_id = ?";
            PreparedStatement load = conn.prepareStatement(query);
            load.setInt(1, clientID);
            ResultSet rs = load.executeQuery();
            if(rs.next()){
                int id= rs.getInt("id");                
                Date date= rs.getDate("order_date");
                String status= rs.getString("status");
                double cost=rs.getDouble("cost");
                int client_id= rs.getInt("client_id");
                //int shopCart_id= rs.getInt("shopCart_id");
                order = new Order(id, date, status, cost, client_id);
                System.out.println("loaded shopCart key: "+id);
                return order;
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error in the conection");
            } 
    return null;
}


}
