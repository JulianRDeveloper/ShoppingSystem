
package Controller;

import Classes.Historical;
import Model.ModelHistorical;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ctlHistorical {
  private Historical History;
  private ModelHistorical ModHistory; 

    public ctlHistorical() {
        ModHistory = new ModelHistorical();
    }
  
    public boolean addHistory(Historical historical){
        switch(historical.getRec_orderStatus()){
            case "FINISHED":
                return ModHistory.addFinishedHistory(historical);
            case "CANCELED":
                return ModHistory.addCanceledHistory(historical);
        }
        return false;
    }
    
    public DefaultTableModel updateHistorical(JTable model, int cartID){
            try{
            return this.ModHistory.updateHistoryTable(model, cartID);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "controller Problems");            
        }return null;
    }
    
}
