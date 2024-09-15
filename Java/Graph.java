import java.util.*;

class Graph {
    private Map<String, List<String>> adjList;

    Graph(int v) {
        adjList = new HashMap<>();
        for (int i = 0; i < v; ++i)
            adjList.put("", new ArrayList<>());
    }

    void addEdge(String v, String w) {
        adjList.get(v).add(w);
        adjList.get(w).add(v);
    }

    // Breadth-First Search
    void BFS(String start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : adjList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    // Depth-First Search
    void DFS(String start) {
        Set<String> visited = new HashSet<>();
        DFSUtil(start, visited);
    }

    private void DFSUtil(String vertex, Set<String> visited) {
        visited.add(vertex);
        System.out.print(vertex + " ");

        for (String neighbor : adjList.get(vertex)) {
            if (!visited.contains(neighbor)) {
                DFSUtil(neighbor, visited);
            }
        }
    }
}

