
package Model;

import Classes.Client;
import Classes.LegalClient;
import Classes.NaturalClient;
import Controller.ctlClient;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;


public class ModelClient {
    ConData conData;
    LegalClient Legal;
    NaturalClient Natural;
    ctlClient ctlClient;

    public ModelClient() {
        this.conData = new ConData();
        
    }
    
    public boolean delClient(int clientID){
        try (Connection conn = DriverManager.getConnection(conData.getUrl(), conData.getUser(), conData.getPassword())){
          if(conn != null){
              System.out.println("Connection from ModelClient.DelClient");
          } 
        String query = "DELETE FROM client WHERE id = ?";
        PreparedStatement stClient = conn.prepareStatement(query);
        stClient.setInt(1, clientID);
        if(stClient.execute(query)){
            System.out.println("client deleted");
                return true;
        }
        }catch(Exception e){   
            JOptionPane.showMessageDialog(null, "Error in the Connection");
        }
        return false;
    }
    
    public LinkedList verifyLogin(String user, String password){
        try(Connection conn = DriverManager.getConnection(conData.getUrl(), conData.getUser(), conData.getPassword())){
            //conn = conect.getConnection();
            if(conn != null){
                System.out.println("Connection from ModelClient.verifyLogin");
            }
            String query = "SELECT * FROM userkey WHERE user = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, user);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
            String keyUser= rs.getString("user");
            String keyPassword= rs.getString("password");
            int userType= rs.getInt("userType");
            int clientID= rs.getInt("client_id");
            if(keyUser.equals(user) && keyPassword.equals(password)){
                LinkedList list = new LinkedList();
                list.add(clientID);
                list.add(userType);
                System.out.println("UserKey verificated");
                return list;
            }else{
                return null;
            }
            }
            }catch(SQLException e){
               JOptionPane.showMessageDialog(null, "Error in the Connection"); 
            }return null; 
    }
    
    public boolean addUserKey(String user, String password, int client_Type, int user_id){
        try (Connection conn = DriverManager.getConnection(conData.getUrl(), conData.getUser(), conData.getPassword())){
            if(conn != null){
                System.out.println("Conection from ModelClient.addUserKey");
            }
            String query= "INSERT INTO userkey(user, password, userType, client_id) VALUES (?,?,?,?)";
            PreparedStatement statementClient= conn.prepareStatement(query);
            statementClient.setString(1, user);
            statementClient.setString(2,password);
            statementClient.setInt(3, client_Type);      
            statementClient.setInt(4, user_id);
            int rows= statementClient.executeUpdate();
            if(rows>0){
                System.out.println("main UserKey registrated");
                return true;
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error in the connection");            
        }
        return false;
    }
    
        public boolean updateClient(Client client){
                try (Connection conn = DriverManager.getConnection(conData.getUrl(), conData.getUser(), conData.getPassword())){
            if(conn != null){
                System.out.println("Conection from ModelLegalClient.updateLegalClient");
            }
        String query= "UPDATE client SET address = ?, phone = ?, mail =? WHERE id = ?";
        PreparedStatement statementClient= conn.prepareStatement(query);
        statementClient.setString(1, client.getAddress());
        statementClient.setString(2, client.getPhone());
        statementClient.setString(3, client.getMail());        
        statementClient.setInt(4, client.getId());        
        int newsRows= statementClient.executeUpdate();
        if(newsRows >0){
            System.out.println("client updated");
            return true;            
        }
        }catch (SQLException e){
                    JOptionPane.showMessageDialog(null, "Error in the connection");
        }
    return false;
    }
        
    public boolean updateUserKey(int clientID, String newPassword){
        try(Connection conn = DriverManager.getConnection(conData.getUrl(), conData.getUser(), conData.getPassword())){
            if(conn != null){
                System.out.println("Connection from ModelClient.updateUserKey");
            }
                    String query2= "UPDATE userkey SET userkey.password = ? WHERE client_id = ?";
                    PreparedStatement st2 = conn.prepareStatement(query2);
                    st2.setString(1, newPassword);
                    st2.setInt(2, clientID);
                    int rows = st2.executeUpdate();
                    if(rows>0){
                        System.out.println("userKey : "+clientID+" was updated");
                        return true;
                    }else{
                        return false;
                    }  
        }catch(SQLException e){
               JOptionPane.showMessageDialog(null, "Error in the Connection"); 
        }
    return false; 
    }
    
        public boolean verifyKey(int clientID, String oldPassword){
        try(Connection conn = DriverManager.getConnection(conData.getUrl(), conData.getUser(), conData.getPassword())){
            //conn = conect.getConnection();
            if(conn != null){
                System.out.println("Connection from ModelClient.verifyKey");
            }
            String query = "SELECT password FROM userkey WHERE client_id = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, clientID);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
            String keyPassword= rs.getString("password");
                if(keyPassword.equals(oldPassword)){
                    System.out.println("assert key");
                    return true;
                    }                   
                }else{
                    System.out.println("keys don't match");
                    return false;
                }
        }catch(SQLException e){
               JOptionPane.showMessageDialog(null, "Error in the Connection"); 
        }
    return false; 
    }
}
