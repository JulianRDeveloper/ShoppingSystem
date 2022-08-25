package Classes;

import java.util.Date;

public class Send {
    private int id;
    private String sendAddress;
    private Date sendDate;
    private String sendCompany;
    private int payment_id;
    private int order_id;

    public Send(int id, String sendAddress, Date sendDate, String sendCompany, int payment_id, int order_id) {
        this.id = id;
        this.sendAddress = sendAddress;
        this.sendDate = sendDate;
        this.sendCompany = sendCompany;
        this.payment_id = payment_id;
        this.order_id = order_id;
    }

    public Send() {
    }
    
   
    /**
     * @return the sendAddress
     */
    public String getSendAddress() {
        return sendAddress;
    }

    /**
     * @param sendAddress the sendAddress to set
     */
    public void setSendAddress(String sendAddress) {
        this.sendAddress = sendAddress;
    }

    /**
     * @return the sendDate
     */
    public Date getSendDate() {
        return sendDate;
    }

    /**
     * @param sendDate the sendDate to set
     */
    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    /**
     * @return the sendCompany
     */
    public String getSendCompany() {
        return sendCompany;
    }

    /**
     * @param sendCompany the sendCompany to set
     */
    public void setSendCompany(String sendCompany) {
        this.sendCompany = sendCompany;
    }

    /**
     * @return the payment_id
     */
    public int getPayment_id() {
        return payment_id;
    }

    /**
     * @param payment_id the payment_id to set
     */
    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    /**
     * @return the order_id
     */
    public int getOrder_id() {
        return order_id;
    }

    /**
     * @param order_id the order_id to set
     */
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
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
    
    
}
