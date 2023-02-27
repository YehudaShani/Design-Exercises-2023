import java.util.ArrayList;
import java.util.Arrays;


public class SeasonUtil {
    public static final Season[] SEASONS = Season.values();

    public static void sortSeasonable(Comparable[] seasonables) {
        Arrays.sort(seasonables);
    }

    static String reportAll(Seasonable[] seasonables) {
        StringBuilder sb = new StringBuilder();
        for (Seasonable seasonable : seasonables) {
            sb.append(seasonable.toString()).append("\n");
        }
        return sb.toString();
    }
}
