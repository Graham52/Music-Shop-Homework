package Behaviours;

public interface ISell {

    String sell();

    double calculateMarkup(double increase);

    double getMarkupAmount();
}