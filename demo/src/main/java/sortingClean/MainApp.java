package sortingClean;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.util.Random;

// TODO: Add java classes (in separate files for annotations and aspects)
public class MainApp {
    static WeldContainer container = new Weld().initialize();

    public static void main(String[] args) {
        // TODO: Change this line to initialize an injected AlgorithmRunner
        AlgorithmRunner algorithmRunner = container.select(AlgorithmRunner.class).get();

        algorithmRunner.runAlgorithms();
    }
    // TODO: Add producers
    private static SortingAlgorithm<Integer> makeRandomSortingAlgorithm(){
        Random random = new Random(System.currentTimeMillis());
        SortingAlgorithm<Integer> sortAlg= null;
        switch (random.nextInt(4)){
            case 0: sortAlg = container.select(QuickSort.class).get();
                break;
            case 1: sortAlg = container.select(MergeSort.class).get();
                break;
            case 2: sortAlg =container.select(BubbleSort.class).get();
                break;
            case 3: sortAlg = container.select(InsertionSort.class).get();
        }
        return sortAlg;
    }

    @Produces
    public @Named("AQuickSort") SortingAlgorithm<Integer> quickSort()
    {    return container.select(QuickSort.class).get();}
    @Produces
    public @Named("ABubbleSort") SortingAlgorithm<Integer> bubbleSort()
    {    return container.select(BubbleSort.class).get();}
    @Produces
    public @Named("RandomSortingAlgorithm") SortingAlgorithm<Integer> randomSortingAlgorithm()
    {    return makeRandomSortingAlgorithm();}

    @Produces
    public @Sweet int getNumOfSpoonsSweet()
    {
        return 10000;
    }


}
