package Controller;

import Model.ModelLegalClient;
import Model.ModelNaturalClient;
import Model.ModelClient;
import Classes.*;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JOptionPane;

public class ctlClient {
    private ModelNaturalClient modelNaturalC;
    private ModelLegalClient modelLegalC;
    private ModelClient modelClient;

    public ctlClient() {
        this.modelNaturalC = new ModelNaturalClient();
        this.modelLegalC = new ModelLegalClient();
        this.modelClient = new ModelClient();
    }
    
    public int addClient(Client client){
        try{
           switch(client.clientType()){
               case "natural":
                   return this.modelNaturalC.addNaturalClient((NaturalClient)client);
                   
               case "legal":
                   return this.modelLegalC.addLegalClient((LegalClient)client);
                   
           }
           }catch(Exception e){
                 JOptionPane.showMessageDialog(null, "Controller Error");
           }return 0;
    }
    
    public boolean delClient(int clientID){
        if(this.modelClient.delClient(clientID)){
            return true;
        }
        return false;
    }
    
    public LinkedList verifyLogin(String user, String password){
        //System.out.println("connected from ctlClient.verifyLogin");
        LinkedList list = this.modelClient.verifyLogin(user, password);               
        try{
            if(!list.isEmpty()){
            return list;
        }
        }catch(Exception e){
             //JOptionPane.showMessageDialog(null, "Controller Error");
        }
        return null;
    }
    
    public boolean newUserKey(String user, String password, int client_Type, int user_id){
        try{
            return modelClient.addUserKey(user, password, client_Type, user_id);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Controller Error");            
        }return false;
    }

    public boolean updateClient(Client client){
        try{
            return this.modelClient.updateClient(client);
        }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Controller Error");
                }
        return false;
    }
    
    public boolean updateUserKey(int clientID, String oldPassword){               
        try{
            return  modelClient.updateUserKey(clientID, oldPassword);        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Controller Error");
        }
        return false;
    }

    public boolean verifyKey(int clientID, String newPassword){               
        try{
            return  modelClient.verifyKey(clientID, newPassword);        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Controller Error");
        }
        return false;
    }
    
    public NaturalClient loadNaturalClient(int clientID){
        return modelNaturalC.loadClient(clientID);
    }
    
    public LegalClient loadLegalClient(int clientID){
        return modelLegalC.loadClient(clientID);
    }
    
//    public int loadClientType(){
//        return modelClient.loadClientType();
//    }
}
