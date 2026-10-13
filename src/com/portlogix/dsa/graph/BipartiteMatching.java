package com.portlogix.dsa.graph;

import java.util.Arrays;

public class BipartiteMatching {

    /*
     * graph[u][v] = 1 means
     * left vertex u can be matched
     * with right vertex v.
     */

    private static boolean findMatch(
            int u,
            int[][] graph,
            boolean[] visited,
            int[] matchRight) {

        for (int v = 0; v < graph[u].length; v++) {

            if (graph[u][v] == 1 && !visited[v]) {

                visited[v] = true;

                // If right vertex is free OR
                // its current match can be moved
                if (matchRight[v] == -1 ||
                    findMatch(
                            matchRight[v],
                            graph,
                            visited,
                            matchRight)) {

                    matchRight[v] = u;

                    return true;
                }
            }
        }

        return false;
    }

    // Calculate maximum bipartite matching
    public static int maximumMatching(int[][] graph) {

        if (graph == null ||
            graph.length == 0 ||
            graph[0].length == 0) {

            return 0;
        }

        int leftSize = graph.length;
        int rightSize = graph[0].length;

        int[] matchRight =
                new int[rightSize];

        Arrays.fill(matchRight, -1);

        int matching = 0;

        for (int u = 0; u < leftSize; u++) {

            boolean[] visited =
                    new boolean[rightSize];

            if (findMatch(
                    u,
                    graph,
                    visited,
                    matchRight)) {

                matching++;
            }
        }

        return matching;
    }

    // Test the algorithm
    public static void main(String[] args) {

        int[][] graph = {
                {1, 1, 0},
                {0, 1, 1},
                {1, 0, 1}
        };

        int result =
                maximumMatching(graph);

        System.out.println(
                "Maximum Matching = " + result
        );
    }
}