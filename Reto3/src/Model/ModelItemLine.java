package Model;
import Classes.ItemLine;
import java.sql.Connection;
import java.sql.*;
import javax.swing.JOptionPane;

public class ModelItemLine {
    ConData conData;
    int idcart;

    public ModelItemLine(){
        this.conData = new ConData();        
    }
    
    public boolean addLineItem(ItemLine line){
        try (Connection conn = DriverManager.getConnection(conData.getUrl(), conData.getUser(), conData.getPassword())){
            if(conn != null){
                System.out.println("Connected from ModelItemLine.addLineItem");
            }
            String query = "INSERT INTO item_line (amount, cost, item_id, shopCart_id) VALUES (?,?,?,?)";
            PreparedStatement stLine = conn.prepareStatement(query);
            stLine.setInt(1, line.getAmount());
            stLine.setDouble(2, line.getCost());
            stLine.setString(3, line.getItem_id());
            stLine.setInt(4, line.getShopCart_id());
            int inserted = stLine.executeUpdate();
            if(inserted >0){
                return true;
            }
        }catch(SQLException e){
            System.out.println("Error");
        }return false;
    }
    
  public boolean delLineItem(String itemId){
            String id= itemId;
            try (Connection conn = DriverManager.getConnection(conData.getUrl(), conData.getUser(), conData.getPassword())){
            //conn = conect.getConnection();
            if(conn != null){
                System.out.println("Connection from ModelItemLinel.delLineItem ");                
            }            
            String query = "DELETE FROM item_line WHERE item_id ='"+id+"'";
            Statement stLine = conn.createStatement();
            boolean ok = stLine.execute(query);
            return ok;

        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Service Problems");
            
        }
    return false;        
  }
}



