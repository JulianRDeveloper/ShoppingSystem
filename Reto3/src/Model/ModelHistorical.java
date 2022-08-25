package Model;

import Classes.Historical;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ModelHistorical {
    ConData conData;
    Historical History;
    DefaultTableModel table;
    
    
        public ModelHistorical() {
        this.conData = new ConData();
        this.table = new DefaultTableModel();
    }
        
    public boolean addFinishedHistory(Historical historical){
        try (Connection conn = DriverManager.getConnection(conData.getUrl(), conData.getUser(), conData.getPassword())){
            if(conn != null){
                System.out.println("Connected from ModelHistorical.addHistory");
            }
            String query = "INSERT INTO historical (order_id, rec_orderDate, rec_orderStatus, rec_payment, rec_cartItems, rec_payDate, rec_sendDate, rec_sendCompany, client_id) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement stHis = conn.prepareStatement(query);
            
            java.util.Date orderDate = historical.getRec_orderDate();
            java.sql.Date sqlOrderDate = new java.sql.Date(orderDate.getTime());
            java.util.Date payDate = historical.getRec_payDate();
            java.sql.Date sqlPayDate = new java.sql.Date(payDate.getTime());
            java.util.Date sendDate = historical.getRec_sendDate();
            java.sql.Date sqlSendDate = new java.sql.Date(sendDate.getTime());
            
            stHis.setInt(1, historical.getOrder_id());
            stHis.setDate(2, sqlOrderDate);
            stHis.setString(3, historical.getRec_orderStatus());
            stHis.setDouble(4, historical.getRec_payment());
            stHis.setInt(5, historical.getRec_cartItems());
            stHis.setDate(6, sqlPayDate);
            stHis.setDate(7, sqlSendDate);
            stHis.setString(8, historical.getRec_sendCompany());
            stHis.setInt(9, historical.getClient_id());
            int inserted = stHis.executeUpdate();
            if(inserted >0){
                System.out.println("order historical saved");
                return true;
            }
        }catch(SQLException e){
            System.out.println("Error");
        }return false;
    }   

    public boolean addCanceledHistory(Historical historical){
        try (Connection conn = DriverManager.getConnection(conData.getUrl(), conData.getUser(), conData.getPassword())){
            if(conn != null){
                System.out.println("Connected from ModelHistorical.addHistory");
            }
            String query = "INSERT INTO historical (order_id, rec_orderDate, rec_orderStatus, rec_payment, rec_cartItems, rec_payDate, rec_sendDate, rec_sendCompany, client_id) VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement stHis = conn.prepareStatement(query);
            
            java.util.Date orderDate = historical.getRec_orderDate();
            java.sql.Date sqlOrderDate = new java.sql.Date(orderDate.getTime());
            
            stHis.setInt(1, historical.getOrder_id());
            stHis.setDate(2, sqlOrderDate);
            stHis.setString(3, historical.getRec_orderStatus());
            stHis.setDouble(4, historical.getRec_payment());
            stHis.setInt(5, historical.getRec_cartItems());
            stHis.setDate(6, null);
            stHis.setDate(7, null);
            stHis.setString(8, historical.getRec_sendCompany());
            stHis.setInt(9, historical.getClient_id());
            int inserted = stHis.executeUpdate();
            if(inserted >0){
                System.out.println("order historical saved");
                return true;
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error in the connection");
        }return false;
    }  
    
    public DefaultTableModel updateHistoryTable(JTable model, int clientID){        
        try(Connection conn = DriverManager.getConnection(conData.getUrl(), conData.getUser(), conData.getPassword())){
            if(conn != null){
                System.out.println("Connection from ModelHistorical.updateHistoryTable");
            }
        String query = "SELECT * FROM historical WHERE client_id = ?";
        PreparedStatement stHis = conn.prepareStatement(query);
        stHis.setInt(1, clientID);
        ResultSet rs = stHis.executeQuery();
        Object[] historys = new Object[8];
        table= (DefaultTableModel)model.getModel();
        while(rs.next()){
            historys[0]= rs.getInt("order_id");
            historys[1]= rs.getString("rec_orderStatus");
            historys[2]= rs.getDate("rec_orderDate");
            historys[3]= rs.getDate("rec_payDate");
            historys[4]= rs.getDate("rec_sendDate");            
            historys[5]= rs.getString("rec_sendCompany");            
            historys[6]= rs.getInt("rec_cartItems");            
            historys[7]= rs.getDouble("rec_payment");          
            table.addRow(historys);            
        }
        return table;
        //cartTable.setModel(cartStock);    
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error in the connection");
        }
    return null;
    }  
}
