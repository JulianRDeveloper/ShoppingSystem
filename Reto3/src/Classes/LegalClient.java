package Classes;

public class LegalClient extends Client {
    private String company;
    private String NIT;
    //private int client_id;

    public LegalClient(String company, String NIT, int id, String address, String phone, String mail) {
        super(id, address, phone, mail);
        this.company = company;
        this.NIT = NIT;
    }

    @Override
        public String clientType(){
    return "legal";
}
    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @return the NIT
     */
    public String getNIT() {
        return NIT;
    }

    /**
     * @param NIT the NIT to set
     */
    public void setNIT(String NIT) {
        this.NIT = NIT;
    }

    
    
    
        
    }

 