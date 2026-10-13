package com.portlogix.dsa.dp;

import java.util.Arrays;

public class BitmaskDP {

    /*
     * Bitmask DP
     *
     * Finds the minimum cost of visiting all locations
     * and returning to the starting location.
     *
     * The input array represents the cost of visiting
     * each location.
     */
    public static int solve(int[] values) {

        if (values == null || values.length == 0) {
            return 0;
        }

        int n = values.length;

        /*
         * Limit the size because an int bitmask can
         * represent up to 30 useful states safely.
         */
        if (n > 20) {
            throw new IllegalArgumentException(
                    "Maximum 20 locations supported."
            );
        }

        int totalMasks = 1 << n;

        int[][] dp = new int[totalMasks][n];

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Start from location 0
        dp[1][0] = 0;

        // Visit every possible subset
        for (int mask = 1; mask < totalMasks; mask++) {

            for (int current = 0; current < n; current++) {

                if ((mask & (1 << current)) == 0) {
                    continue;
                }

                if (dp[mask][current] == Integer.MAX_VALUE) {
                    continue;
                }

                // Try visiting another location
                for (int next = 0; next < n; next++) {

                    if ((mask & (1 << next)) != 0) {
                        continue;
                    }

                    int newMask =
                            mask | (1 << next);

                    int newCost =
                            dp[mask][current]
                            + Math.abs(
                                values[current]
                                - values[next]
                            );

                    dp[newMask][next] =
                            Math.min(
                                dp[newMask][next],
                                newCost
                            );
                }
            }
        }

        // All locations visited
        int allVisited = totalMasks - 1;

        int answer = Integer.MAX_VALUE;

        for (int last = 0; last < n; last++) {

            answer = Math.min(
                    answer,
                    dp[allVisited][last]
            );
        }

        return answer;
    }

    // Test the algorithm
    public static void main(String[] args) {

        int[] values = {
                10, 20, 15, 30
        };

        int result = solve(values);

        System.out.println(
                "Minimum Bitmask DP Cost = " + result
        );
    }
}