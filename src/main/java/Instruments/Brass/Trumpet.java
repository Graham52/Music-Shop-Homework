package Instruments.Brass;

import Instruments.Instrument;
import Instruments.InstrumentCategory;

public class Trumpet extends Instrument {

    int valves;

    public Trumpet(String description, double wholesalePrice, InstrumentCategory category, String colour, String material, int valves){
        super(description, wholesalePrice, category, colour, material);
        this.valves = valves;
    }


    public int getValves() {
        return this.valves;
    }

    public String play(){
        return "Trumpet sound playing";
    }

    public String sell(){
        String retailPriceString = String.format("%.2f", getRetailPrice());
        return "Trumpet selling at £" + retailPriceString;
    }
}