package sortingClean;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Random;

// TODO: Add dependency injection and annotations to this file
public class AlgorithmRunner {
    @Inject
    @Named("ABubbleSort") SortingAlgorithm<Integer> quadraticAlgorithm ;
    @Inject
    @Named("AQuickSort") SortingAlgorithm<Integer> nlognAlgorithm ;
    @Inject
    @Named("RandomSortingAlgorithm") SortingAlgorithm<Integer> randomAlgorithm1 ;
    @Inject
    @Named("RandomSortingAlgorithm") SortingAlgorithm<Integer> randomAlgorithm2 ;

    @Inject
    @Sweet int numberOfElements ;
    public void runAlgorithms(){
        Random rand = new Random();
        Integer[] ints = rand.ints(1,Integer.MAX_VALUE)
                .distinct()
                .limit(numberOfElements)
                .boxed()
                .toArray(Integer[]::new);
        Integer[] intsClone = ints.clone();
        quadraticAlgorithm.sort(intsClone);
        intsClone = ints.clone();
        nlognAlgorithm.sort(intsClone);
        intsClone = ints.clone();
        randomAlgorithm1.sort(intsClone);
        intsClone = ints.clone();
        randomAlgorithm2.sort(intsClone);
    }


}
