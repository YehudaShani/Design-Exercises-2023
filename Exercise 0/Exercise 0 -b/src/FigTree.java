public class FigTree extends Tree {


    FigTree(int height, Season season) {
        super(height, season, null);
        if (season == Season.SUMMER || season == Season.SPRING)
            leavesColor = Color.GREEN;
        else
            leavesColor = Color.YELLOW;
    }

    @Override
    public String toString() {
        String response = "Fig tree.";
        if (getCurrentSeason() == Season.SUMMER) {
            response += " I give fruit.";
        }
        response += " My height is: " + height;
        if (leavesColor != null) {
            response += " and my color is: " + leavesColor;
        } else {
            response += " and I have no leaves";
        }
        return response;
    }

    @Override
    public void changeSeason() {
        super.changeSeason();
        switch (season) {
            case WINTER:
                leavesColor = null;
                height += 20;
                break;
            case FALL:
                height += 20;
                leavesColor = Color.YELLOW;
                break;
            case SPRING:
            case SUMMER:
                height += 30;
                leavesColor = Color.GREEN;
                break;
        }
    }
}
