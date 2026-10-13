package com.portlogix.dsa.string;

public class RabinKarp {

    private static final int BASE = 256;
    private static final int PRIME = 101;

    // Rabin-Karp string search
    public static int search(String text, String pattern) {

        if (text == null ||
            pattern == null ||
            pattern.isEmpty() ||
            pattern.length() > text.length()) {

            return -1;
        }

        int n = text.length();
        int m = pattern.length();

        int patternHash = 0;
        int textHash = 0;

        int highestPower = 1;

        // Calculate BASE^(m-1) % PRIME
        for (int i = 0; i < m - 1; i++) {
            highestPower =
                    (highestPower * BASE) % PRIME;
        }

        // Calculate initial hash values
        for (int i = 0; i < m; i++) {

            patternHash =
                    (BASE * patternHash
                            + pattern.charAt(i)) % PRIME;

            textHash =
                    (BASE * textHash
                            + text.charAt(i)) % PRIME;
        }

        // Slide the pattern over the text
        for (int i = 0; i <= n - m; i++) {

            // Hash values match
            if (patternHash == textHash) {

                boolean match = true;

                // Verify characters
                for (int j = 0; j < m; j++) {

                    if (text.charAt(i + j)
                            != pattern.charAt(j)) {

                        match = false;
                        break;
                    }
                }

                if (match) {
                    return i;
                }
            }

            // Calculate hash for next window
            if (i < n - m) {

                textHash =
                        (BASE * (textHash
                                - text.charAt(i)
                                * highestPower)
                                + text.charAt(i + m))
                                % PRIME;

                // Make hash positive
                if (textHash < 0) {
                    textHash += PRIME;
                }
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