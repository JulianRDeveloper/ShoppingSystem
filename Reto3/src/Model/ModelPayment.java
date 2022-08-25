package Model;

import Classes.Payment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;

public class ModelPayment {
    ConData conData;

    public ModelPayment() {
        conData = new ConData();
    }
    
public int addPayment(Payment pay){
    try(Connection conn = DriverManager.getConnection(conData.getUrl(), conData.getUser(), conData.getPassword())){
            //conn = conect.getConnection();
            if(conn != null){
                System.out.println("Connection from ModelPayment.addPayment");
            }
            String query= "INSERT INTO payment (pay_date, payment, order_id) VALUES (?,?,?)";
        PreparedStatement stPay= conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        java.util.Date payDate = pay.getPayDate();
        java.sql.Date sqlDate = new java.sql.Date(payDate.getTime());
        stPay.setDate(1, sqlDate);
        stPay.setDouble(2, pay.getPayment());
        stPay.setInt(3, pay.getOrder_id());
        int newsRows= stPay.executeUpdate();
        if(newsRows >0){
            ResultSet generatedKeys = stPay.getGeneratedKeys();
            if(generatedKeys.next()){
                int pay_id = generatedKeys.getInt(1);
                System.out.println("new payment set key: "+pay_id);                
                if(newsRows >0){
                    return pay_id;
                }
            }
        }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error in the connection");            
        }return 0; 
    }

   public boolean delPayment(int payID){
        try (Connection conn = DriverManager.getConnection(conData.getUrl(), conData.getUser(), conData.getPassword())){
          if(conn != null){
              System.out.println("Connection from ModelPayment.delPayment");
          } 
        String query = "DELETE FROM payment WHERE id = ?";
        PreparedStatement stPay = conn.prepareStatement(query);
        stPay.setInt(1, payID);
        if(stPay.execute()){
            System.out.println("payment deleted");
                return true;
        }
        }catch(Exception e){   
            JOptionPane.showMessageDialog(null, "Service Problems");                    
        }return false;      
    } 
  
   public boolean updateOrderStatus(int payID){
        try (Connection conn = DriverManager.getConnection(conData.getUrl(), conData.getUser(), conData.getPassword())){
        if(conn != null){
                System.out.println("Conection from ModelPayment.updateStatus");
            }
        String query= "UPDATE pedido SET status='PAYDED' WHERE id = ?";
        PreparedStatement up= conn.prepareStatement(query);
        up.setInt(1, payID);
        int newsRows= up.executeUpdate();
        if(newsRows >0){
            System.out.println("status PAYDED updated ");
            return true;
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error in the connection");            
        }return false; 
    }
   
   public Payment loadPayment(int orderID){
    try(Connection conn = DriverManager.getConnection(conData.getUrl(), conData.getUser(), conData.getPassword())){
            //conn = conect.getConnection();
            if(conn != null){
                System.out.println("Connection from ModelPayment.loadPayment");
            }
            String query = "SELECT * FROM payment WHERE order_id = ?";
            PreparedStatement load = conn.prepareStatement(query);
            load.setInt(1, orderID);
            ResultSet rs = load.executeQuery();
            if(rs.next()){
                int id= rs.getInt("id");                
                Date date= rs.getDate("pay_date");                
                double pay=rs.getDouble("payment");
                int order_id= rs.getInt("order_id");                
                Payment payment = new Payment(id, date, pay, order_id);
                System.out.println("loaded payment key: "+id);
                return payment;
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error in the conection");
            } 
    return null;
}
}
