public abstract class Tree implements Comparable, Seasonable {
    protected int height;
    protected Season season;
    protected Color leavesColor;
    // TODO: Add auxiliary fields and functions.

    Tree(int height, Season season, Color leavesColor){
        this.height = height;
        this.season = season;
        this.leavesColor = leavesColor;
    }

    @Override
    public Season getCurrentSeason() {
        return season;
    }

    @Override
    public int compareTo(Object o) {
        Tree tree = (Tree) o;
        return this.height - tree.height;
    }

    @Override
    public void changeSeason() {
        switch (season) {
            case WINTER:
                season = Season.SPRING;
                break;
            case SPRING:
                season = Season.SUMMER;
                break;
            case SUMMER:
                season = Season.FALL;
                break;
            case FALL:
                season = Season.WINTER;
                break;
        }
    }

    @Override
    public String toString() {
        return "Tree. My height is " + height + " and my leaves color is " + leavesColor;
    }

}
