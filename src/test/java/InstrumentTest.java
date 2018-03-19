import Instruments.Brass.Trumpet;
import Instruments.InstrumentCategory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InstrumentTest {


    Trumpet trumpet;


    @Before

    public void before(){
        trumpet = new Trumpet(
                "Silver Trumpet(3)",
                120.00,
                InstrumentCategory.Brass,
                "Silver",
                "Silver Plated",
                3
        );


    }

    @Test

    public void canGetCategory(){
        assertEquals(InstrumentCategory.Brass, trumpet.getCategory());
    }

    @Test
    public void canGetValves(){
        assertEquals(3, trumpet.getValves());
    }

    @Test

    public void canPlayTrumpet(){
        assertEquals("Trumpet sound playing", trumpet.play());

    }

    @Test

    public void canCalculateTrumpetMarkup(){
        assertEquals(24, trumpet.calculateMarkup(0.20), 0.01);
    }

    @Test
    public void canSetTrumpetRetailPrice(){
        double markup = trumpet.calculateMarkup(0.20);
        trumpet.setRetailPrice(markup);
        assertEquals(144, trumpet.getRetailPrice(), 0.01);
    }
}
