import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TwoCitySchedule {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        List<Person> cityA = new ArrayList<>();
        List<Person> cityB = new ArrayList<>();

        int cost[];
        for (int i = 0; i  < costs.length; i++) {
            cost = costs[i];
            if (cost[0] < cost[1]) {
                Person p = new Person(i, 'a', cost[1] - cost[0]);
                cityA.add(p);
            } else {
                Person p = new Person(i, 'b', cost[0]-cost[1]);
                cityB.add(p);
            }
        }

        schedule(n, (List<Person>) cityB, (List<Person>) cityA);

        schedule(n, (List<Person>) cityA, (List<Person>) cityB);

        int total = 0;
        Person p;
        for (int i = 0; i < n/2; i++) {
            p = cityA.get(i);
            total += costs[p.id][0];
            p = cityB.get(i);
            total += costs[p.id][1];
        }
        return total;
    }

    private void schedule(int n, List<Person> cityA, List<Person> cityB) {
        if (cityB.size() > n/2) {
            cityB.sort(Comparator.comparingInt(p -> p.opCost));
            while (cityB.size() > n/2) {
                Person p = cityB.get(0);
                cityA.add(p);
                cityB.remove(0);
            }
        }
    }

    class Person {
        int id;
        char dest;
        int opCost;
        Person(int id, char dest, int opCost) {
            this.id = id;
            this.dest = dest;
            this.opCost = opCost;
        }
    }
}
