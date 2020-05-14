import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ClosestDistance {



    public static void main(String args[]) {

    }

    List<List<Integer>> ClosestXdestinations(int numDestinations,
                                             List<List<Integer>> allLocations,
                                             int numDeliveries)
    {

        Function<List<Integer>, Integer> findDistance =
                (coord) -> coord.get(0) * coord.get(0) +
                            coord.get(1) * coord.get(1);

        List<List<Integer>> topDeliveries = allLocations.stream()
                .sorted(
                        Comparator.comparing(findDistance))
                .limit(numDeliveries)
                .collect(Collectors.toList());

                return topDeliveries;
        // WRITE YOUR CODE HERE

    }
}
