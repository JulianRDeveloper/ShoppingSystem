
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conect {
    
    Connection conn;
        public Conect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/store","root","");
            if(conn != null){
                //System.out.println("Conection1 Sucesfull");
            }
        }catch(ClassNotFoundException | SQLException e){//alt + 124--> |
            System.out.println("No Conected");    
    }
        }
        public Connection getConnection(){
            return conn;
        }
}
