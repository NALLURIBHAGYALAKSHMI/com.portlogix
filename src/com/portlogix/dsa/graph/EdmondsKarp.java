package com.portlogix.dsa.graph;

import java.util.LinkedList;
import java.util.Queue;

public class EdmondsKarp {

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

    // Edmonds-Karp Maximum Flow
    public static int maxFlow(
            int[][] graph,
            int source,
            int sink) {

        int n = graph.length;

        int[][] residual =
                new int[n][n];

        // Copy graph into residual graph
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                residual[i][j] = graph[i][j];
            }
        }

        int maxFlow = 0;

        int[] parent = new int[n];

        // Continue while an augmenting path exists
        while (bfs(
                residual,
                source,
                sink,
                parent)) {

            // Find bottleneck capacity
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

            // Update residual capacities
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
                maxFlow(graph, 0, 5);

        System.out.println(
                "Maximum Flow = " + result
        );
    }
}