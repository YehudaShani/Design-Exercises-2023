public abstract class Animal implements Seasonable,Comparable{
    protected int weight;
    private Season season;
    protected Color color;
    // TODO: Add auxiliary fields and functions.

    Animal(int weight, Season season, Color color){
        this.weight =weight;
        this.season =season;
        this.color =color;
    }

    @Override
    public Season getCurrentSeason() {
        return season;
    }

    @Override
    public int compareTo(Object o) {
        Animal animal = (Animal) o;
        return this.weight - animal.weight;
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
        return "Animal. My weight is " + weight + " and my color is " + color;
    }
}
