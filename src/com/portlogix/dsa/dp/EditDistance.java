package com.portlogix.dsa.dp;

public class EditDistance {

    // Calculate Levenshtein Edit Distance
    public static int calculate(String first, String second) {

        if (first == null || second == null) {
            return -1;
        }

        int m = first.length();
        int n = second.length();

        int[][] dp = new int[m + 1][n + 1];

        // Convert empty second string
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }

        // Convert empty first string
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // Fill DP table
        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                if (first.charAt(i - 1)
                        == second.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1];

                } else {

                    int insert =
                            dp[i][j - 1];

                    int delete =
                            dp[i - 1][j];

                    int replace =
                            dp[i - 1][j - 1];

                    dp[i][j] =
                            1 + Math.min(
                                    insert,
                                    Math.min(delete, replace)
                            );
                }
            }
        }

        return dp[m][n];
    }

    // Test the algorithm
    public static void main(String[] args) {

        String first = "container";
        String second = "containers";

        int result =
                calculate(first, second);

        System.out.println(
                "Edit Distance = " + result
        );
    }
}