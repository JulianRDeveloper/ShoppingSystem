
package Controller;

import Classes.Send;
import Model.ModelSend;
import javax.swing.JOptionPane;

public class ctlSend {
    ModelSend modelSend;
    Send send;

    public ctlSend() {
        modelSend = new ModelSend();
    }

public int addSend(Send send){
    try{
        return modelSend.addSend(send);
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "System Error");
    }return 0;
}   
  
       public boolean updateOrderStatus(int clientID){
        try{
            return modelSend.updateOrderStatus(clientID);
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, "System Error");
        }return false;
    } 

public boolean delSend(int sendID){
    try{
        return modelSend.delSend(sendID);
    }catch(Exception e){
        JOptionPane.showMessageDialog(null, "System Error");
    }return false;
}
 
    public Send loadSend(int payID){
        try{
            return modelSend.loadSend(payID);
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, "System Error");
        }return null;
    }
}
