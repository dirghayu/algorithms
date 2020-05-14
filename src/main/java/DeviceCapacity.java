import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeviceCapacity {


    public static void main(String args[]) {

    }

    List<List<Integer>> optimalUtilization(
            int deviceCapacity,
            List<List<Integer>> foregroundAppList,
            List<List<Integer>> backgroundAppList)
    {
        class Pair {
            private List<Integer> foregroundApp;
            private List<Integer> backgroundApp;
            private int totalMemory;

            public Pair(List<Integer> foregroundApp, List<Integer> backgroundApp) {
                this.foregroundApp = foregroundApp;
                this.backgroundApp = backgroundApp;
                totalMemory  = foregroundApp.get(1) + backgroundApp.get(1);
            }

            public int getTotalMemory() {
                return totalMemory;
            }
        }


        List<Pair> pairs = foregroundAppList.stream().flatMap(
                f ->
                        backgroundAppList.stream()
                                .filter(b -> f.get(1) + b.get(1) <= deviceCapacity)
                                .map(b -> new Pair(f, b))
        ).collect(Collectors.toList());

        Optional<Pair> max = pairs.stream().max(
                Comparator.comparing(Pair::getTotalMemory));

        if(max.isPresent()) {
            int maxMemory = max.get().totalMemory;
            Stream<Pair> topList = pairs.stream().filter(p -> p.totalMemory == maxMemory);

            return topList.map(t-> Arrays.asList(t.foregroundApp.get(0), t.backgroundApp.get(0)))
                    .collect(Collectors.toList());
        }else {
            return Arrays.asList();
        }

    }


        // WRITE YOUR CODE HERE
    }
