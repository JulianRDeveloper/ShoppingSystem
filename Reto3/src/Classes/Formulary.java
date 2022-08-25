
package Classes;


public class Formulary {
    private String address;
    private String phone;
    private String mail;
    
    private String company;
    private String NIT;
    
    private String identify;
    private String names;
    private String lastnames;
    
    private String user;
    private String password;
    private String pass;
    private int clientType;

    public Formulary(String address, String phone, String mail, String company, String NIT, String user, String password, String pass, int clientType) {
        this.address = address;
        this.phone = phone;
        this.mail = mail;
        this.company = company;
        this.NIT = NIT;
        this.user = user;
        this.password = password;
        this.pass = pass;
        this.clientType = clientType;
    }

    public Formulary(String address, String phone, String mail, String identify, String names, String lastnames, String user, String password, String pass, int clientType) {
        this.address = address;
        this.phone = phone;
        this.mail = mail;
        this.identify = identify;
        this.names = names;
        this.lastnames = lastnames;
        this.user = user;
        this.password = password;
        this.pass = pass;
        this.clientType = clientType;
    }

    ////////// VALIDACIONES DEL OBJETO /////////
    //_______________________________________________//
    //------------- INDIVIDUAL VALIDATIONS ----------//
    
    public boolean addressValidation(){
        return !address.equals("");
    }
    
    public boolean phoneValidation(){
        return !phone.equals("");
    }
    
    public boolean mailValidation(){
        return !mail.equals("");
    }
    
    public boolean companyValidation(){
        return !company.equals("");
    }
    
    public boolean NITValidation(){
        return !NIT.equals("");
    }
    
    public boolean identifyValidation(){
        return !identify.equals("");
    }
    
    public boolean namesValidation(){
        return !names.equals("");
    }
    
    public boolean lastnamesValidation(){
        return !lastnames.equals("");
    }
    
    public boolean userValidation(){
        return !user.equals("");
    }
    
    public boolean passwordValidation(){
        return !password.equals("");
    }
    
    public boolean passValidation(){
        return !pass.equals("");
    }
    //_____________________________________________//
    //------------- PERSONA VALIDATIONS -----------//
    public boolean personaSelfValidation(){
        if(!address.equals("") | !phone.equals("") | !mail.equals("")  | !identify.equals("") | !names.equals("") | !lastnames.equals("") | !user.equals("") && !password.equals("") && !pass.equals("")){
            return true;
        }else{
            return false;
        }
    }
    //______________________________________________//
    //------------- COMPANY VALIDATIONS ------------//    
    public boolean companySelfValidation(){
        if(!company.equals("") | !NIT.equals("") | !address.equals("") | !phone.equals("") | !mail.equals("") | !user.equals("") && !password.equals("") && !pass.equals("")){
            return true;
        }else{
            return false;
        }
    }
    
    //_____________________________________________//
    //------------- USER KEY VALIDATIONS -----------//
    
    public boolean userKeyValidation(){
        return password.equals(pass);
    }
   
    
    //_____________________________________________//
    //-------------  ENCAPSULATIONS  -----------//    
    
    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
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

    /**
     * @return the identify
     */
    public String getIdentify() {
        return identify;
    }

    /**
     * @param identify the identify to set
     */
    public void setIdentify(String identify) {
        this.identify = identify;
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

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the clientType
     */
    public int getClientType() {
        return clientType;
    }

    /**
     * @param clientType the clientType to set
     */
    public void setClientType(int clientType) {
        this.clientType = clientType;
    }
    
    
    
    
    
    
    
}
