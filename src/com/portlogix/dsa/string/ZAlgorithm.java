package com.portlogix.dsa.string;

public class ZAlgorithm {

    // Build Z-array
    private static int[] buildZArray(String text) {

        int n = text.length();

        int[] z = new int[n];

        int left = 0;
        int right = 0;

        for (int i = 1; i < n; i++) {

            if (i <= right) {
                z[i] = Math.min(
                        right - i + 1,
                        z[i - left]
                );
            }

            while (i + z[i] < n &&
                   text.charAt(z[i])
                           == text.charAt(i + z[i])) {

                z[i]++;
            }

            if (i + z[i] - 1 > right) {

                left = i;
                right = i + z[i] - 1;
            }
        }

        return z;
    }

    // Z Algorithm pattern search
    public static int search(String text, String pattern) {

        if (text == null ||
            pattern == null ||
            pattern.isEmpty() ||
            pattern.length() > text.length()) {

            return -1;
        }

        String combined =
                pattern + "$" + text;

        int[] z = buildZArray(combined);

        int patternLength = pattern.length();

        for (int i = 0; i < z.length; i++) {

            if (z[i] == patternLength) {

                return i - patternLength - 1;
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