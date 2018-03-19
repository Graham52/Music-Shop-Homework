import Accessories.DrumSticks;
import Accessories.GuitarStrings;
import Accessories.SheetMusic;
import Instruments.InstrumentCategory;
import Instruments.InstrumentType;
import Instruments.String.Guitar;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StockItemTest {

    private DrumSticks drumSticks;
    private GuitarStrings guitarStrings;
    private SheetMusic violinSheetMusic;
    private Guitar bassGuitar;

    @Before

    public void before(){
        guitarStrings = new GuitarStrings("Guitar Strings(0.40)", 2.50, 0.40);
        drumSticks = new DrumSticks("Nylon Tip Drumsticks", 2.50, "Nylon");
        violinSheetMusic = new SheetMusic("Violin Sheet Music", 1.40, InstrumentType.Violin);

        bassGuitar = new Guitar(
                "Bass Guitar",
                65.00,
                InstrumentCategory.Strings,
                "Black",
                "Maple",
                "Electric",
                InstrumentType.BassGuitar.getnoOfStrings()
        );

    }

    @Test

    public void canGetGuitarStringsDescription(){
        assertEquals("Guitar Strings(0.40)", guitarStrings.getDescription());
    }

    @Test

    public void canGetGuitarStringsGauge(){
        assertEquals(0.40, guitarStrings.getStringGauge(), 0.01);
    }

    @Test
    public void canGetDrumSticksWholesalePrice(){
        assertEquals(2.50, drumSticks.getWholesalePrice(), 0.01);
    }

    @Test
    public void canGetDrumSticksTip(){
        assertEquals("Wood", drumSticks.getTip());
    }

    @Test
    public void canGetViolinSheetMusicsRetailPrice(){

        double markup = violinSheetMusic.calculateMarkup(0.30);
        violinSheetMusic.setRetailPrice(markup);
        assertEquals(1.82, violinSheetMusic.getRetailPrice(), 0.01);
    }

    @Test
    public void canGetViolinSheetMusicInstrumentType(){
        assertEquals(InstrumentType.Violin, violinSheetMusic.getInstrumentType());
    }

    @Test

    public void canSellBassGuitar(){
        double markup = bassGuitar.calculateMarkup(0.20);
        bassGuitar.setRetailPrice(markup);
        assertEquals("Bass Guitar selling at £78.00", bassGuitar.sell());
    }

    @Test

    public void getMarkupAmount(){
        double markup = bassGuitar.calculateMarkup(0.20);
        bassGuitar.setRetailPrice(markup);
        assertEquals(13, bassGuitar.getMarkupAmount(), 0.01);
    }
}