package Classes;

public class ItemLine {
    private int amount;
    private double cost;
    private String item_id;
    private int shopCart_id;

    public ItemLine(int amount, double cost, String item_id, int shopCart_id) {
        this.amount = amount;
        this.cost = cost;
        this.item_id = item_id;
        this.shopCart_id = shopCart_id;
    }



    /**
     * @return the amount
     */
    public int getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * @return the cost
     */
    public double getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(double cost) {
        this.cost = cost;
    }



    /**
     * @return the shopCart_id
     */
    public int getShopCart_id() {
        return shopCart_id;
    }

    /**
     * @param shopCart_id the shopCart_id to set
     */
    public void setShopCart_id(int shopCart_id) {
        this.shopCart_id = shopCart_id;
    }

    /**
     * @return the item_id
     */
    public String getItem_id() {
        return item_id;
    }

    /**
     * @param item_id the item_id to set
     */
    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }


    

    
    
}
