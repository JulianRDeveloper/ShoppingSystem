package Classes;

public class NaturalClient extends Client {
    private String identification;
    private String names;
    private String lastnames;
    //private int client_id;

    public NaturalClient(String identification, String names, String lastnames, int id, String address, String phone, String mail) {
        super(id, address, phone, mail);
        this.identification = identification;
        this.names = names;
        this.lastnames = lastnames;
    }

    @Override
    public String clientType(){
    return "natural";
}

    /**
     * @return the identification
     */
    public String getIdentification() {
        return identification;
    }

    /**
     * @param identification the identification to set
     */
    public void setIdentification(String identification) {
        this.identification = identification;
    }

    /**
     * @return the names
     */
    public String getNames() {
        return names;
    }

    /**
     * @param names the names to set
     */
    public void setNames(String names) {
        this.names = names;
    }

    /**
     * @return the lastnames
     */
    public String getLastnames() {
        return lastnames;
    }

    /**
     * @param lastnames the lastnames to set
     */
    public void setLastnames(String lastnames) {
        this.lastnames = lastnames;
    }

    

    }



