package Model;

public class ConData {
    private final String dirver= "com.mysql.jdbc.Driver";
    private final String user= "root";
    private final String password = "";
    private final String url= "jdbc:mysql://localhost:3306/store";

    /**
     * @return the dirver
     */
    public String getDirver() {
        return dirver;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }
    
    
}