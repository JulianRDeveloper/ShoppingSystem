package Controller;

import Model.ModelItemLine;
import Classes.ItemLine;
import javax.swing.JOptionPane;

public class ctlItemLine {
    private ModelItemLine modelLine;

    public ctlItemLine(){
        this.modelLine = new ModelItemLine();
    }
    
    public boolean addItemLine(ItemLine line){
        try{
            this.modelLine.addLineItem((ItemLine)line);
            return true;
        }catch(Exception e){
         JOptionPane.showMessageDialog(null, "Service Problems");
            return false;   
        }
    }
    
            public boolean delItemLine(String itemId){
               String id= itemId;
        try{
            this.modelLine.delLineItem(id);
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Service Problems");
            
        }
    return false;
    }
    
}
