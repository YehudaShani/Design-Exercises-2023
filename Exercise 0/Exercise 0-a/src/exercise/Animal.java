package exercise;

public interface Animal extends Seasonable, Comparable<Animal>{
    int weight = 0;
    Color color = null;
    Season season = null;
}
