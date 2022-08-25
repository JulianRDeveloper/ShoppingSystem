package Controller;

import Model.ModelItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ctlItem {
    ModelItem item;

    public ctlItem() {
        this.item= new ModelItem();
    }
      
    public DefaultTableModel loadStock(JTable model){
      try{          
          return this.item.loadStock(model);           
      }catch(Exception e){
          JOptionPane.showMessageDialog(null, "Service Problems");
          
      }return null;  
    }
}
