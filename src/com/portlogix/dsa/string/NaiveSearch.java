package com.portlogix.dsa.string;

public class NaiveSearch {

    // Naive String Search
    public static int search(String text, String pattern) {

        if (text == null ||
            pattern == null ||
            pattern.isEmpty() ||
            pattern.length() > text.length()) {

            return -1;
        }

        int n = text.length();
        int m = pattern.length();

        // Check pattern at every possible position
        for (int i = 0; i <= n - m; i++) {

            int j = 0;

            while (j < m &&
                   text.charAt(i + j) == pattern.charAt(j)) {

                j++;
            }

            // Complete pattern matched
            if (j == m) {
                return i;
            }
        }

        return -1;
    }

    // Test the algorithm
    public static void main(String[] args) {

        String text =
                "container ship is arriving";

        String pattern =
                "ship";

        int result = search(text, pattern);

        if (result != -1) {

            System.out.println(
                    "Pattern found at index: " + result
            );

        } else {

            System.out.println(
                    "Pattern not found."
            );
        }
    }
}