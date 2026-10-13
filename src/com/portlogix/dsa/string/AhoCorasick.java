package com.portlogix.dsa.string;

import java.util.*;

public class AhoCorasick {

    // Trie node
    private static class Node {

        Map<Character, Node> children = new HashMap<>();

        Node failure;

        List<String> output = new ArrayList<>();
    }

    private Node root;

    public AhoCorasick() {
        root = new Node();
    }

    // Build Trie
    private void buildTrie(String[] patterns) {

        for (String pattern : patterns) {

            Node current = root;

            for (char ch : pattern.toCharArray()) {

                current.children.putIfAbsent(ch, new Node());

                current = current.children.get(ch);
            }

            current.output.add(pattern);
        }
    }

    // Build failure links
    private void buildFailureLinks() {

        Queue<Node> queue = new LinkedList<>();

        root.failure = root;

        for (Node child : root.children.values()) {

            child.failure = root;

            queue.add(child);
        }

        while (!queue.isEmpty()) {

            Node current = queue.poll();

            for (Map.Entry<Character, Node> entry :
                    current.children.entrySet()) {

                char ch = entry.getKey();

                Node child = entry.getValue();

                Node failure = current.failure;

                while (failure != root &&
                       !failure.children.containsKey(ch)) {

                    failure = failure.failure;
                }

                if (failure.children.containsKey(ch) &&
                    failure.children.get(ch) != child) {

                    child.failure =
                            failure.children.get(ch);

                } else {

                    child.failure = root;
                }

                child.output.addAll(
                        child.failure.output
                );

                queue.add(child);
            }
        }
    }

    // Search multiple patterns
    public void searchPatterns(String text,
                               String[] patterns) {

        if (text == null ||
            patterns == null ||
            patterns.length == 0) {

            System.out.println("Invalid input.");
            return;
        }

        buildTrie(patterns);

        buildFailureLinks();

        Node current = root;

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            while (current != root &&
                   !current.children.containsKey(ch)) {

                current = current.failure;
            }

            if (current.children.containsKey(ch)) {

                current = current.children.get(ch);

            } else {

                current = root;
            }

            if (!current.output.isEmpty()) {

                for (String pattern : current.output) {

                    int position =
                            i - pattern.length() + 1;

                    System.out.println(
                            "Pattern \"" + pattern +
                            "\" found at index " +
                            position
                    );
                }
            }
        }
    }

    // Static method used by DSAService
    public static void search(String text,
                              String[] patterns) {

        AhoCorasick ahoCorasick =
                new AhoCorasick();

        ahoCorasick.searchPatterns(
                text,
                patterns
        );
    }

    // Test the algorithm
    public static void main(String[] args) {

        String text =
                "port ships carry containers";

        String[] patterns = {
                "ship",
                "container",
                "port"
        };

        search(text, patterns);
    }
}