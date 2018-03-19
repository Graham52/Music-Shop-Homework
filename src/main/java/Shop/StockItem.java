package Shop;

import Behaviours.ISell;

public abstract class StockItem implements ISell {

    private String description;
    private double wholesalePrice;
    private double retailPrice;

    public StockItem(String description, double wholesalePrice){
        this.description = description;
        this.wholesalePrice = wholesalePrice;
//        Initialise retailPrice to wholesalePrice until markup takes place ?
        this.retailPrice = wholesalePrice;
    }

    public String getDescription() {
        return this.description;
    }

    public double getWholesalePrice() {
        return this.wholesalePrice;
    }

    public void setRetailPrice(double markup) {
        this.retailPrice = wholesalePrice + markup;
    }

    public double getRetailPrice() {
        return this.retailPrice;
    }

    public double calculateMarkup(double markupIncrease){
        return this.wholesalePrice * markupIncrease;
    }

    public double getMarkupAmount() {
        return this.retailPrice - this.wholesalePrice;
    }
}