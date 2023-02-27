import static java.lang.Math.round;

public class Bear extends Animal {

    Bear(int weight, Season season) {
        super(weight, season, Color.BROWN);
    }

    @Override
    public String toString() {
        String response = "Bear.";
        if (getCurrentSeason() == Season.WINTER) {
            response += " I am sleeping.";
        }
        response += " My weight is: " + weight + " and my color is: " + color;
        return response;
    }

    @Override
    public void changeSeason() {
        super.changeSeason();
        switch (getCurrentSeason()) {
            case WINTER:
                weight = (int) round(weight * 0.8);
                break;
            case SPRING:
                weight *= (int) round(weight * 0.75);
                break;
            case SUMMER:
                weight *= round(weight * (float) 4 / 3);
                break;
            case FALL:
                weight *= (int)round (weight * 1.25);
                break;
        }

    }
}
