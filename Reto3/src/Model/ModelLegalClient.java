package Model;

import Classes.Client;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Classes.LegalClient;
import javax.swing.JOptionPane;


public class ModelLegalClient {
  ConData conData;
  LegalClient Client;
  //LegalClient client;

    public ModelLegalClient() {
        this.conData = new ConData();
    }

    public int addLegalClient(LegalClient client){
                try (Connection conn = DriverManager.getConnection(conData.getUrl(), conData.getUser(), conData.getPassword())){
            if(conn != null){
                System.out.println("Conection from ModelLegalClient.addLegalClient");
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
                query = "INSERT INTO legal_client (company, NIT, client_id) VALUES (?,?,?)";
                PreparedStatement statement= conn.prepareStatement(query);
                statement.setString(1, client.getCompany());
                statement.setString(2, client.getNIT());               
                statement.setInt(3, client_id);
                int rows = statement.executeUpdate();
                if(rows >0){
                    System.out.println("new legalClient set key: "+client_id);
                    return client_id;
                }                
            }
        }
        }catch (SQLException e){
                    JOptionPane.showMessageDialog(null, "Error in the connection");
        }return 0;
    }
    
    public LegalClient loadClient(int userId){ 
            try(Connection conn = DriverManager.getConnection(conData.getUrl(), conData.getUser(), conData.getPassword())){
            //conn = conect.getConnection();
            if(conn != null){
                System.out.println("Connection from ModelLegalClient.loadClient");
            }
            String query = "SELECT * FROM client INNER JOIN legal_client ON legal_client.client_id = client.id WHERE client.id = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, userId);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                int id= rs.getInt("id");
                String address= rs.getString("address");
                String phone= rs.getString("phone");
                String mail= rs.getString("mail");;
                String company= rs.getString("company");
                String NIT= rs.getString("NIT");                
                int client_id= rs.getInt("client_id");
                Client= new LegalClient(company, NIT, id, address, phone, mail);
                System.out.println("LegalClient loaded key :"+client_id);
                return Client;
                }
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error in the connection");
                return null;
            }
        return null;
        }
}
