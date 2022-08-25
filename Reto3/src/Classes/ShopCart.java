package Classes;

import Controller.ctlShopCart;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class ShopCart {
    
    private int id;
    private String cartDate;
    private int client_id;


    public ShopCart(int id, String cartDate, int client_id) {
        this.id = id;
        this.cartDate = cartDate;
        this.client_id = client_id;
    }
    
    public ShopCart(LocalDateTime cartDate, int client_id) {
        LocalDateTime carDate = LocalDateTime.now();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = dateFormat.format(carDate);
        this.cartDate = formattedDate;
        this.client_id = client_id;
    }

    public String timeLess(){
        //String dateCart = cartDate;
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter date_format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String todayStr = date_format.format(today);
        SimpleDateFormat form = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        try{
            Date dateCart = form.parse(cartDate);
            Date dateToday = form.parse(todayStr);
            long differ = dateToday.getTime() - dateCart.getTime();
            long hour= differ/3600000;
            long restHour= differ%3600000;
            long mins= restHour/60000;
            //System.out.println(hour + mins);           
            long tlh= 23-hour;
            long tlm= 60-mins;
            if(tlm == 60){
                tlm= 0;
                tlh++;
                }
            //long restMins= differ%60000;
            String timeLess= tlh + ":" + tlm;
            System.out.println(timeLess);
            return timeLess;
            
        }catch(ParseException e){
        }
return null; 
    } 
    
    public boolean checkTimeLimi(){
        //String dateCart = cartDate;
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter date_format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String todayStr = date_format.format(today);
        SimpleDateFormat form = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        try{
            Date dateCart = form.parse(cartDate);
            Date dateToday = form.parse(todayStr);
            long differ = dateToday.getTime() - dateCart.getTime();
            if(differ > 86400000){
                return true;
            }else{
                return false;
            }
        }catch(ParseException e){
            JOptionPane.showMessageDialog(null, "Expire Limit Error");
        }
return false; 
    }  
    
    
    
public String getAmounts(){
    ctlShopCart ctlCart = new ctlShopCart();
    return ctlCart.getAmounts();
}

public String getTotalPrice(){
    ctlShopCart ctlCart = new ctlShopCart();
    return ctlCart.getTotalPrice();
}    
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the cartDate
     */
    public String getCartDate() {
        return cartDate;
    }

    /**
     * @param cartDate the cartDate to set
     */
    public void setCartDate(String cartDate) {
        this.cartDate = cartDate;
    }

    /**
     * @return the client_id
     */
    public int getClient_id() {
        return client_id;
    }

    /**
     * @param client_id the client_id to set
     */
    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    
}
