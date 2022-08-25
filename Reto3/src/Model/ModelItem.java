package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ModelItem {
    ConData conData;
    DefaultTableModel table;

    public ModelItem() {
       conData = new ConData();
       table= new DefaultTableModel();
    }
    
    public DefaultTableModel loadStock(JTable model){
        try(Connection conn = DriverManager.getConnection(conData.getUrl(), conData.getUser(), conData.getPassword())){
//            conn = conect.getConnection();
            if(conn != null){
                System.out.println("Connection from ModelShpCart.stocker");
            }
        String query = "SELECT id, category, supplier, price FROM item ORDER BY category";
        Statement stItems = conn.createStatement();
        ResultSet rs = stItems.executeQuery(query);
        Object[] stockItems = new Object[4];
        table= (DefaultTableModel)model.getModel();
        while(rs.next()){
            stockItems[0]= rs.getString("id");
            stockItems[1]= rs.getString("category");
            stockItems[2]= rs.getString("supplier");
            stockItems[3]= rs.getDouble("price");
            //System.out.println(stockItems);
            table.addRow(stockItems);            
        }
        //model.setModel(table);
        return table;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "System Error");
    }return null;
    }
    
    
    
    
}
