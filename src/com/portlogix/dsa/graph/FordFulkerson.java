package com.portlogix.dsa.graph;

public class FordFulkerson {

    // Find an augmenting path using DFS
    private static boolean dfs(
            int[][] residual,
            int source,
            int sink,
            boolean[] visited,
            int[] parent) {

        visited[source] = true;

        if (source == sink) {
            return true;
        }

        for (int v = 0; v < residual.length; v++) {

            if (!visited[v] && residual[source][v] > 0) {

                parent[v] = source;

                if (dfs(
                        residual,
                        v,
                        sink,
                        visited,
                        parent)) {

                    return true;
                }
            }
        }

        return false;
    }

    // Ford-Fulkerson Maximum Flow
    public static int maxFlow(
            int[][] graph,
            int source,
            int sink) {

        int n = graph.length;

        int[][] residual = new int[n][n];

        // Copy original graph
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                residual[i][j] = graph[i][j];
            }
        }

        int maxFlow = 0;

        int[] parent = new int[n];

        while (true) {

            boolean[] visited = new boolean[n];

            for (int i = 0; i < n; i++) {
                parent[i] = -1;
            }

            // Find augmenting path
            boolean found = dfs(
                    residual,
                    source,
                    sink,
                    visited,
                    parent
            );

            if (!found) {
                break;
            }

            // Find bottleneck capacity
            int pathFlow = Integer.MAX_VALUE;

            int current = sink;

            while (current != source) {

                int previous = parent[current];

                pathFlow = Math.min(
                        pathFlow,
                        residual[previous][current]
                );

                current = previous;
            }

            // Update residual capacities
            current = sink;

            while (current != source) {

                int previous = parent[current];

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

        int result = maxFlow(
                graph,
                0,
                5
        );

        System.out.println(
                "Maximum Flow = " + result
        );
    }
}