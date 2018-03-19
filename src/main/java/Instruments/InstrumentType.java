package Instruments;

public enum InstrumentType {
    Guitar(6),
    Violin(4),
    Banjo(5),
    BassGuitar(4),
    Trumpet(0);

    private final int noOfStrings;

    InstrumentType(int noOfStrings){
        this.noOfStrings = noOfStrings;

    }

    public int getnoOfStrings(){
        return this.noOfStrings;
    }
}