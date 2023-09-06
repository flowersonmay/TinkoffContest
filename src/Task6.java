import java.util.*;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputData = scanner.nextLine().split(" ");
        int countCity = Integer.parseInt(inputData[0]);
        int countRoad = Integer.parseInt(inputData[1]);

        Map<Integer, CountOfPair<Set<Integer>, Integer>> map = new HashMap<>();
        for (int i = 1; i <= countCity; i++) {
            map.put(i, new CountOfPair<>(new HashSet<>(Collections.singletonList(i)), 1));
        }

        for (int i = 0; i < countRoad; i++) {
            int q = 0;
            int x = 0;
            int y = 0;
            String[] query = scanner.nextLine().split(" ");
            q = Integer.parseInt(query[0]);
            x = Integer.parseInt(query[1]);
            if (query.length == 3) {
                y = Integer.parseInt(query[2]);
            }
            switch (q) {
                case 1 -> {
                    if (!map.get(x).first.contains(y)) {
                        Set<Integer> newSet = new HashSet<>(map.get(x).first);
                        newSet.addAll(map.get(y).first);
                        for (int num : newSet) {
                            map.put(num, new CountOfPair<>(newSet, map.get(num).second + 1));
                        }
                    }
                }
                case 2 -> {
                    if (map.get(x).first.contains(y)) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                }
                default -> System.out.println(map.get(x).second);
            }
        }
    }

    static class CountOfPair<T, U> {
        T first;
        U second;

        public CountOfPair(T first, U second) {
            this.first = first;
            this.second = second;
        }
    }
}
