package Model;


import Classes.Payment;
import Classes.Send;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
        
public class ModelSend {
    ConData conData;

    public ModelSend(){
        conData = new ConData();
    }
    
public int addSend(Send send){
    try(Connection conn = DriverManager.getConnection(conData.getUrl(), conData.getUser(), conData.getPassword())){
            //conn = conect.getConnection();
            if(conn != null){
                System.out.println("Connection from ModelSend.addSend");
            }
            String query= "INSERT INTO send (send_address, send_date, send_company, payment_id, order_id) VALUES (?,?,?,?,?)";
        PreparedStatement stSend= conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        java.util.Date sendDate = send.getSendDate();
        java.sql.Date sqlDate = new java.sql.Date(sendDate.getTime());
        System.out.println(sqlDate);
        stSend.setString(1, send.getSendAddress());
        stSend.setDate(2, sqlDate);
        stSend.setString(3, send.getSendCompany());
        stSend.setInt(4, send.getPayment_id());
        stSend.setInt(5, send.getOrder_id());
        int newsRows= stSend.executeUpdate();
        if(newsRows >0){
            ResultSet generatedKeys = stSend.getGeneratedKeys();
            if(generatedKeys.next()){
                int send_id = generatedKeys.getInt(1);
                System.out.println("new send set key: "+send_id);
                return send_id;
            }         
        }
        return 0;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error in the connection -create send");            
    }return 0; 
}
 
public boolean updateOrderStatus(int clientID){
        try (Connection conn = DriverManager.getConnection(conData.getUrl(), conData.getUser(), conData.getPassword())){
        if(conn != null){
                System.out.println("Conection from ModelSend.updateStatus");
            }
        String query= "UPDATE pedido SET status='SENT' WHERE client_id = ?";
        PreparedStatement up= conn.prepareStatement(query);
        up.setInt(1, clientID);
        int newsRows= up.executeUpdate();
        if(newsRows >0){
            System.out.println("status SENT updated ");
            return true;
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error in the connection -updateStatus ");
            
        }return false; 
    }

    public boolean delSend(int sendID){
        try (Connection conn = DriverManager.getConnection(conData.getUrl(), conData.getUser(), conData.getPassword())){
          if(conn != null){
              System.out.println("Connection from ModelSend.delSend");
          } 
        String query = "DELETE FROM send WHERE id = ?";
        PreparedStatement stOrder = conn.prepareStatement(query);
        stOrder.setInt(1, sendID);
        if(stOrder.execute()){
            System.out.println("send deleted");
            return true;
        }
        }catch(Exception e){   
            JOptionPane.showMessageDialog(null, "Service Problems");                    
        }return false;      
    }
           
   public Send loadSend(int payID){
    try(Connection conn = DriverManager.getConnection(conData.getUrl(), conData.getUser(), conData.getPassword())){
            //conn = conect.getConnection();
            if(conn != null){
                System.out.println("Connection from ModelSend.loadSend");
            }
            String query = "SELECT * FROM send WHERE payment_id = ?";
            PreparedStatement load = conn.prepareStatement(query);
            load.setInt(1, payID);
            ResultSet rs = load.executeQuery();
            if(rs.next()){
                int id= rs.getInt("id");
                String send_address =rs.getString("send_address");
                Date date= rs.getDate("send_date");               
                String send_company= rs.getString("send_company");
                int payment_id= rs.getInt("payment_id");
                int order_id= rs.getInt("order_id");
                Send send = new Send(id, send_address, date, send_company, payment_id, order_id);
                System.out.println("loaded sed key: "+id);
                return send;
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error in the conection");
            } 
    return null;
}   

}
