import java.util.*;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        List<Triple<Integer, Integer, Integer>> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] edgeInput = scanner.nextLine().split(" ");
            int u = Integer.parseInt(edgeInput[0]);
            int v = Integer.parseInt(edgeInput[1]);
            int w = Integer.parseInt(edgeInput[2]);
            edges.add(new Triple<>(u, v, w));
        }

        edges.sort(Comparator.comparingInt(Triple::getThird));

        int left = 0;
        int right = edges.get(edges.size() - 1).getThird();

        int startComponentsCount = countComponents(n, edges);

        while (left < right) {
            int mid = (left + right + 1) / 2;
            List<Triple<Integer, Integer, Integer>> filteredEdges = new ArrayList<>();
            for (Triple<Integer, Integer, Integer> edge : edges) {
                if (edge.getThird() > mid) {
                    filteredEdges.add(edge);
                }
            }
            int components = countComponents(n, filteredEdges);
            if (components > startComponentsCount) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        List<Triple<Integer, Integer, Integer>> filteredEdges = new ArrayList<>();
        for (Triple<Integer, Integer, Integer> edge : edges) {
            if (edge.getThird() > left) {
                filteredEdges.add(edge);
            }
        }
        int newCount = countComponents(n, filteredEdges);

        if (newCount > startComponentsCount) {
            left -= 1;
        }
        if (newCount < startComponentsCount) {
            left += 1;
        }

        System.out.println(left);
    }

    public static int countComponents(int n, List<Triple<Integer, Integer, Integer>> edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (Triple<Integer, Integer, Integer> edge : edges) {
            int u = edge.getFirst();
            int v = edge.getSecond();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        Set<Integer> visited = new HashSet<>();
        int components = 0;
        for (int node = 1; node <= n; node++) {
            if (!visited.contains(node)) {
                dfs(node, visited, graph);
                components++;
            }
        }
        return components;
    }

    public static void dfs(int node, Set<Integer> visited, Map<Integer, List<Integer>> graph) {
        visited.add(node);
        for (int neighbor : graph.get(node)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited, graph);
            }
        }
    }

    static class Triple<T, U, V> {
        private final T first;
        private final U second;
        private final V third;

        public Triple(T first, U second, V third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        public T getFirst() {
            return first;
        }

        public U getSecond() {
            return second;
        }

        public V getThird() {
            return third;
        }
    }
}
