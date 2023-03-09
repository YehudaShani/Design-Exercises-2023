public class OliveTree extends Tree {


    OliveTree(int height, Season season) {
        super(height, season, Color.GREEN);
    }

    @Override
    public String toString() {
        String response = "Olive tree.";
        if (getCurrentSeason() == Season.FALL) {
            response += " I give fruit.";
        }
        response += " My height is: " + height + " and my color is: " + leavesColor;
        return response;
    }

    @Override
    public void changeSeason() {
        super.changeSeason();
        switch (season) {
            case WINTER:
            case FALL:
                height += 5;
                break;
            case SPRING:
            case SUMMER:
                height += 10;
                break;
        }
    }
}
