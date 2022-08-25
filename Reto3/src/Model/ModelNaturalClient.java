package Model;

import Classes.Client;
import Classes.NaturalClient;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ModelNaturalClient {
    ConData conData;
    NaturalClient client;

    public ModelNaturalClient() {
        this.conData = new ConData();
    }
    
    public int addNaturalClient(NaturalClient client){
        try (Connection conn = DriverManager.getConnection(conData.getUrl(), conData.getUser(), conData.getPassword())){
            if(conn != null){
                System.out.println("Conection from ModelNaturalClient.addNaturalClient");
            }
            String query= "INSERT INTO client(address, phone, mail) VALUES (?,?,?)";
            PreparedStatement statementClient= conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statementClient.setString(1, client.getAddress());
            statementClient.setString(2, client.getPhone());
            statementClient.setString(3, client.getMail());        
            int newsRows= statementClient.executeUpdate();
            if(newsRows >0){
                ResultSet generatedKeys = statementClient.getGeneratedKeys();            
                if(generatedKeys.next()){
                    int client_id = generatedKeys.getInt(1);               
                    query = "INSERT INTO natural_client (identification, names, lastnames, client_id) VALUES (?,?,?,?)";
                    PreparedStatement statement= conn.prepareStatement(query);
                    statement.setString(1, client.getIdentification());
                    statement.setString(2, client.getNames());
                    statement.setString(3, client.getLastnames());
                    statement.setInt(4, client_id);
                    newsRows = statement.executeUpdate();
                    if(newsRows >0){
                        System.out.println("new naturalClient generated key :"+client_id);
                        return client_id;
                }
            }
        }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error in the connection");
        }
        return 0;
    }
    
           public NaturalClient loadClient(int clientID){ 
            try(Connection conn = DriverManager.getConnection(conData.getUrl(), conData.getUser(), conData.getPassword())){
            //conn = conect.getConnection();
            if(conn != null){
                System.out.println("Connection from ModelNaturalClient.loadClient");
            }
            String query = "SELECT * FROM client INNER JOIN natural_client ON natural_client.client_id = client.id WHERE client.id = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, clientID);
            ResultSet rs= st.executeQuery();
            if(rs.next()){
                int id= rs.getInt("id");
                String address= rs.getString("address");
                String phone= rs.getString("phone");
                String mail= rs.getString("mail");
                String identification= rs.getString("identification");
                String names= rs.getString("names");
                String lastnames= rs.getString("lastnames");
                int client_id= rs.getInt("client_id");
                client= new NaturalClient(identification, names, lastnames, id, address, phone, mail);
                System.out.println("NaturalClient loaded key :"+client_id);
                return client;
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error in the connection");
            }return null;           
    } 
    
}
