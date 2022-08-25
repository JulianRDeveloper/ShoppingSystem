
package Classes;

import java.time.LocalDate;
import java.util.Date;


public class Historical {
    private int order_id;
    private Date rec_orderDate;
    private String rec_orderStatus;
    private double rec_payment;
    private int rec_cartItems;
    private Date rec_payDate;
    private Date rec_sendDate;
    private String rec_sendCompany;
    private int client_id;

    public Historical(int order_id, Date rec_orderDate, String rec_orderStatus, double rec_payment, int rec_cartItems, Date rec_payDate, Date rec_sendDate, String rec_sendCompany, int client_id) {
        this.order_id = order_id;
        this.rec_orderDate = rec_orderDate;
        this.rec_orderStatus = rec_orderStatus;
        this.rec_payment = rec_payment;
        this.rec_cartItems = rec_cartItems;
        this.rec_payDate = rec_payDate;
        this.rec_sendDate = rec_sendDate;
        this.rec_sendCompany = rec_sendCompany;
        this.client_id = client_id;
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
     * @return the rec_orderDate
     */
    public Date getRec_orderDate() {
        return rec_orderDate;
    }

    /**
     * @param rec_orderDate the rec_orderDate to set
     */
    public void setRec_orderDate(Date rec_orderDate) {
        this.rec_orderDate = rec_orderDate;
    }

    /**
     * @return the rec_orderStatus
     */
    public String getRec_orderStatus() {
        return rec_orderStatus;
    }

    /**
     * @param rec_orderStatus the rec_orderStatus to set
     */
    public void setRec_orderStatus(String rec_orderStatus) {
        this.rec_orderStatus = rec_orderStatus;
    }

    /**
     * @return the rec_payment
     */
    public double getRec_payment() {
        return rec_payment;
    }

    /**
     * @param rec_payment the rec_payment to set
     */
    public void setRec_payment(double rec_payment) {
        this.rec_payment = rec_payment;
    }

    /**
     * @return the rec_cartItems
     */
    public int getRec_cartItems() {
        return rec_cartItems;
    }

    /**
     * @param rec_cartItems the rec_cartItems to set
     */
    public void setRec_cartItems(int rec_cartItems) {
        this.rec_cartItems = rec_cartItems;
    }

    /**
     * @return the rec_payDate
     */
    public Date getRec_payDate() {
        return rec_payDate;
    }

    /**
     * @param rec_payDate the rec_payDate to set
     */
    public void setRec_payDate(Date rec_payDate) {
        this.rec_payDate = rec_payDate;
    }

    /**
     * @return the rec_sendDate
     */
    public Date getRec_sendDate() {
        return rec_sendDate;
    }

    /**
     * @param rec_sendDate the rec_sendDate to set
     */
    public void setRec_sendDate(Date rec_sendDate) {
        this.rec_sendDate = rec_sendDate;
    }

    /**
     * @return the rec_sendCompany
     */
    public String getRec_sendCompany() {
        return rec_sendCompany;
    }

    /**
     * @param rec_sendCompany the rec_sendCompany to set
     */
    public void setRec_sendCompany(String rec_sendCompany) {
        this.rec_sendCompany = rec_sendCompany;
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
