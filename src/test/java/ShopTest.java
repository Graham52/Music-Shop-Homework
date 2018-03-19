import Accessories.GuitarStrings;
import Instruments.Brass.Trumpet;
import Instruments.InstrumentCategory;
import Instruments.InstrumentType;
import Instruments.String.Guitar;
import Instruments.String.Violin;
import Shop.Shop;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShopTest {

    private Shop shop;
    private Trumpet trumpet;
    private GuitarStrings guitarStrings;
    private Violin violin;
    private Guitar bassGuitar;


    @Before
    public void before(){

        shop = new Shop("Ray's Music Shop");
        trumpet = new Trumpet(
                "Silver Trumpet(3)",
                120.00,
                InstrumentCategory.Brass,
                "Silver",
                "Silver Plated",
                3
        );
        violin = new Violin(
                "Stentor Standard Student",
                32.00,
                InstrumentCategory.Strings,
                "Brown",
                "Solid Tonewoods",
                "4/4"
        );
        bassGuitar = new Guitar(
                "Bass Guitar",
                65.00,
                InstrumentCategory.Strings,
                "Black",
                "Maple",
                "Electric",
                InstrumentType.BassGuitar.getnoOfStrings()
        );

        guitarStrings = new GuitarStrings("Guitar Strings(0.40)", 2.50, 0.40);

    }

    @Test

    public void canGetName(){
        assertEquals("Ray's Music Shop", shop.getName());
    }


    @Test

    public void stockStartsEmpty(){
        assertEquals(0, shop.getNoOfStockItems());
    }

    @Test

    public void canAddTrumpetToStock(){
        int stockCountBefore =  shop.getNoOfStockItems();
        shop.addStockItem(trumpet);
        assertEquals(stockCountBefore+1, shop.getNoOfStockItems());

    }

    @Test

    public void canAdd2InstrumentAnd1AccessoryToStock(){
        int stockCountBefore =  shop.getNoOfStockItems();
        shop.addStockItem(trumpet);
        shop.addStockItem(guitarStrings);
        shop.addStockItem(violin);
        assertEquals(3, shop.getNoOfStockItems());

    }

    @Test

    public void canRemoveItemFromStock(){

        shop.addStockItem(trumpet);
        shop.addStockItem(guitarStrings);
        int stockCountBefore =  shop.getNoOfStockItems();
        shop.removeStockItem(guitarStrings);
        assertEquals(stockCountBefore-1, shop.getNoOfStockItems());

    }

    @Test

    public void shopTillisZeroAtStart(){
        assertEquals(0, shop.getTill(), 0.01);
    }

    @Test

    public void shopSellsItemRemovesItemFromStock(){
        shop.addStockItem(trumpet);
        shop.addStockItem(guitarStrings);
        int stockCountBefore =  shop.getNoOfStockItems();
        shop.sellItem(trumpet);
        assertEquals(stockCountBefore-1, shop.getNoOfStockItems());
    }


    @Test

    public void canUpdateTill(){

        shop.setTill(21.25);
        assertEquals(21.25, shop.getTill(), 0.01);
    }

    @Test

    public void shopSellsItemUpdatesTilByItemRetailPricel(){
        double markup = bassGuitar.calculateMarkup(0.20);
        bassGuitar.setRetailPrice(markup);
        shop.addStockItem(bassGuitar);
        shop.addStockItem(trumpet);
        int stockCountBefore =  shop.getNoOfStockItems();
        double tillBefore = shop.getTill();

        assertEquals("Bass Guitar sold at £78.00", shop.sellItem(bassGuitar));
        assertEquals(stockCountBefore-1, shop.getNoOfStockItems());
        assertEquals(tillBefore+bassGuitar.getRetailPrice(), shop.getTill(), 0.01);
    }

    @Test

    public void canCheckItemExistsReturnsTrue(){
        shop.addStockItem(trumpet);
        assertEquals(true, shop.itemExists(trumpet));
    }

    @Test

    public void canCheckItemExistsReturnFalseIfDoesntExist(){
        shop.addStockItem(bassGuitar);
        assertEquals(false, shop.itemExists(trumpet));
    }

    @Test

    public void shopcantSellItemIfNotInStock(){
        double markup = bassGuitar.calculateMarkup(0.20);
        bassGuitar.setRetailPrice(markup);

        int stockCountBefore =  shop.getNoOfStockItems();
        double tillBefore = shop.getTill();

        assertEquals("Bass Guitar isn't in stock", shop.sellItem(bassGuitar));
        assertEquals(stockCountBefore, shop.getNoOfStockItems());
        assertEquals(tillBefore, shop.getTill(), 0.01);
    }

    @Test

    public void canGetTotalPotentialProfitofStock(){
        double markup1 = bassGuitar.calculateMarkup(0.20);
        bassGuitar.setRetailPrice(markup1);
        shop.addStockItem(bassGuitar);
        double markup2 = trumpet.calculateMarkup(0.25);
        trumpet.setRetailPrice(markup2);
        shop.addStockItem(trumpet);
        double markup3 = guitarStrings.calculateMarkup(0.10);
        guitarStrings.setRetailPrice(markup3);
        shop.addStockItem(guitarStrings);


        assertEquals(43.25, shop.getTotalPotentialProfit(), 0.01);

    }

}