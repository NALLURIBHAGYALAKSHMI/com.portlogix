package com.portlogix.dsa.graph;

import java.util.*;

public class Dinic {

    private final int[][] capacity;
    private final int n;

    public Dinic(int[][] graph) {

        this.n = graph.length;
        this.capacity = new int[n][n];

        for (int i = 0; i < n; i++) {
            System.arraycopy(
                    graph[i],
                    0,
                    capacity[i],
                    0,
                    n
            );
        }
    }

    // BFS creates the level graph
    private boolean bfs(
            int source,
            int sink,
            int[] level) {

        Arrays.fill(level, -1);

        Queue<Integer> queue =
                new LinkedList<>();

        level[source] = 0;
        queue.add(source);

        while (!queue.isEmpty()) {

            int current = queue.poll();

            for (int next = 0; next < n; next++) {

                if (level[next] == -1
                        && capacity[current][next] > 0) {

                    level[next] =
                            level[current] + 1;

                    queue.add(next);
                }
            }
        }

        return level[sink] != -1;
    }

    // DFS sends flow through the level graph
    private int dfs(
            int current,
            int sink,
            int flow,
            int[] level,
            int[] nextEdge) {

        if (current == sink) {
            return flow;
        }

        for (int next = nextEdge[current];
             next < n;
             nextEdge[current]++, next++) {

            if (level[next] ==
                        level[current] + 1
                    && capacity[current][next] > 0) {

                int pushed = dfs(
                        next,
                        sink,
                        Math.min(
                                flow,
                                capacity[current][next]
                        ),
                        level,
                        nextEdge
                );

                if (pushed > 0) {

                    capacity[current][next]
                            -= pushed;

                    capacity[next][current]
                            += pushed;

                    return pushed;
                }
            }
        }

        return 0;
    }

    // Dinic Maximum Flow
    public int maxFlow(
            int source,
            int sink) {

        int maxFlow = 0;

        int[] level = new int[n];

        while (bfs(
                source,
                sink,
                level)) {

            int[] nextEdge =
                    new int[n];

            while (true) {

                int flow = dfs(
                        source,
                        sink,
                        Integer.MAX_VALUE,
                        level,
                        nextEdge
                );

                if (flow == 0) {
                    break;
                }

                maxFlow += flow;
            }
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

        Dinic dinic =
                new Dinic(graph);

        int result =
                dinic.maxFlow(0, 5);

        System.out.println(
                "Maximum Flow = " + result
        );
    }
}