

public class Caribou extends Animal {

    Caribou(int weight, Season season) {
        super(weight, season, Color.BROWN);
        if (season == Season.WINTER) {
            color = Color.WHITE;
        }
    }

    @Override
    public String toString() {
        String response = "Caribou:";
        if (getCurrentSeason() == Season.SUMMER) {
            response += " I am migrating south.";
        }
        response += " My weight is: " + weight + " and my color is: " + color;
        return response;
    }

    @Override
    public void changeSeason() {
        super.changeSeason();
        switch (getCurrentSeason()) {
            case WINTER:
                color = Color.WHITE;
                break;
            case SPRING:
                color = Color.BROWN;
                break;
        }
    }
}
