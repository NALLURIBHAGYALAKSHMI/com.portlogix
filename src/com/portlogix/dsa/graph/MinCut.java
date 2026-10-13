package com.portlogix.dsa.graph;

import java.util.*;

public class MinCut {

    // BFS to find an augmenting path
    private static boolean bfs(
            int[][] residual,
            int source,
            int sink,
            int[] parent) {

        boolean[] visited =
                new boolean[residual.length];

        Queue<Integer> queue =
                new LinkedList<>();

        queue.add(source);
        visited[source] = true;
        parent[source] = -1;

        while (!queue.isEmpty()) {

            int current = queue.poll();

            for (int next = 0;
                 next < residual.length;
                 next++) {

                if (!visited[next]
                        && residual[current][next] > 0) {

                    parent[next] = current;
                    visited[next] = true;

                    if (next == sink) {
                        return true;
                    }

                    queue.add(next);
                }
            }
        }

        return false;
    }

    // Calculate the minimum cut value
    public static int minimumCut(
            int[][] graph,
            int source,
            int sink) {

        if (graph == null ||
            graph.length == 0 ||
            source < 0 ||
            sink < 0 ||
            source >= graph.length ||
            sink >= graph.length) {

            return 0;
        }

        int n = graph.length;

        int[][] residual =
                new int[n][n];

        // Copy original graph
        for (int i = 0; i < n; i++) {

            System.arraycopy(
                    graph[i],
                    0,
                    residual[i],
                    0,
                    n
            );
        }

        int maxFlow = 0;

        int[] parent = new int[n];

        // Find maximum flow
        while (bfs(
                residual,
                source,
                sink,
                parent)) {

            int pathFlow =
                    Integer.MAX_VALUE;

            int current = sink;

            while (current != source) {

                int previous =
                        parent[current];

                pathFlow = Math.min(
                        pathFlow,
                        residual[previous][current]
                );

                current = previous;
            }

            current = sink;

            while (current != source) {

                int previous =
                        parent[current];

                residual[previous][current]
                        -= pathFlow;

                residual[current][previous]
                        += pathFlow;

                current = previous;
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    // Find vertices reachable from source
    private static void markReachable(
            int[][] residual,
            int source,
            boolean[] visited) {

        visited[source] = true;

        for (int next = 0;
             next < residual.length;
             next++) {

            if (!visited[next]
                    && residual[source][next] > 0) {

                markReachable(
                        residual,
                        next,
                        visited
                );
            }
        }
    }

    // Display the minimum cut edges
    public static void displayMinCut(
            int[][] graph,
            int source,
            int sink) {

        if (graph == null ||
            graph.length == 0) {

            System.out.println(
                    "Invalid graph."
            );

            return;
        }

        int n = graph.length;

        int[][] residual =
                new int[n][n];

        for (int i = 0; i < n; i++) {

            System.arraycopy(
                    graph[i],
                    0,
                    residual[i],
                    0,
                    n
            );
        }

        int[] parent = new int[n];

        // Max-flow phase
        while (bfs(
                residual,
                source,
                sink,
                parent)) {

            int pathFlow =
                    Integer.MAX_VALUE;

            int current = sink;

            while (current != source) {

                int previous =
                        parent[current];

                pathFlow = Math.min(
                        pathFlow,
                        residual[previous][current]
                );

                current = previous;
            }

            current = sink;

            while (current != source) {

                int previous =
                        parent[current];

                residual[previous][current]
                        -= pathFlow;

                residual[current][previous]
                        += pathFlow;

                current = previous;
            }
        }

        boolean[] reachable =
                new boolean[n];

        markReachable(
                residual,
                source,
                reachable
        );

        System.out.println(
                "\n========== MIN CUT EDGES =========="
        );

        int cutValue = 0;

        for (int u = 0; u < n; u++) {

            for (int v = 0; v < n; v++) {

                if (reachable[u]
                        && !reachable[v]
                        && graph[u][v] > 0) {

                    System.out.println(
                            "Edge: " + u +
                            " -> " + v +
                            " | Capacity: " +
                            graph[u][v]
                    );

                    cutValue += graph[u][v];
                }
            }
        }

        System.out.println(
                "Minimum Cut Value = " + cutValue
        );
    }

    // Test the algorithm
    public static void main(String[] args) {

        int[][] graph = {
                {0, 10, 10, 0, 0, 0},
                {0, 0, 2, 4, 8, 0},
                {0, 0, 0, 0, 9, 0},
                {0, 0, 0, 0, 0, 10},
                {0, 0, 0, 6, 0, 10},
                {0, 0, 0, 0, 0, 0}
        };

        int result =
                minimumCut(graph, 0, 5);

        System.out.println(
                "Minimum Cut = " + result
        );

        displayMinCut(
                graph,
                0,
                5
        );
    }
}