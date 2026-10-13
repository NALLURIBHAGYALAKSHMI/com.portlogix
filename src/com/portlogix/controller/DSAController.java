package com.portlogix.controller;

import com.portlogix.config.ConsoleInput;
import com.portlogix.service.DSAService;
import com.portlogix.config.ConsoleInput;
import java.util.Scanner;

public class DSAController {

    private final DSAService service;
    private final Scanner scanner;

    public DSAController() {
        service = new DSAService();
        scanner = ConsoleInput.SCANNER;
    }

    // Display DSA menu
    public void showMenu() {

        int choice;

        do {
            System.out.println("\n======================================");
            System.out.println("        PORTLOGIX DSA MODULE");
            System.out.println("======================================");
            System.out.println("1. KMP String Matching");
            System.out.println("2. Naive String Search");
            System.out.println("3. Rabin-Karp");
            System.out.println("4. Z Algorithm");
            System.out.println("5. Aho-Corasick");
            System.out.println("6. Edit Distance");
            System.out.println("7. Bitmask DP");
            System.out.println("8. Ford-Fulkerson");
            System.out.println("9. Edmonds-Karp");
            System.out.println("10. Dinic");
            System.out.println("11. Bipartite Matching");
            System.out.println("12. Minimum Cut");
            System.out.println("0. Back");
            System.out.println("======================================");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    runKMP();
                    break;

                case 2:
                    runNaiveSearch();
                    break;

                case 3:
                    runRabinKarp();
                    break;

                case 4:
                    runZAlgorithm();
                    break;

                case 5:
                    runAhoCorasick();
                    break;

                case 6:
                    runEditDistance();
                    break;

                case 7:
                    runBitmaskDP();
                    break;

                case 8:
                    runFordFulkerson();
                    break;

                case 9:
                    runEdmondsKarp();
                    break;

                case 10:
                    runDinic();
                    break;

                case 11:
                    runBipartiteMatching();
                    break;

                case 12:
                    runMinCut();
                    break;

                case 0:
                    System.out.println("Returning to main menu...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    // KMP
    private void runKMP() {

        System.out.println("\n========== KMP ==========");

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        System.out.print("Enter pattern: ");
        String pattern = scanner.nextLine();

        service.runKMP(text, pattern);
    }

    // Naive Search
    private void runNaiveSearch() {

        System.out.println("\n========== NAIVE SEARCH ==========");

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        System.out.print("Enter pattern: ");
        String pattern = scanner.nextLine();

        service.runNaiveSearch(text, pattern);
    }

    // Rabin-Karp
    private void runRabinKarp() {

        System.out.println("\n========== RABIN-KARP ==========");

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        System.out.print("Enter pattern: ");
        String pattern = scanner.nextLine();

        service.runRabinKarp(text, pattern);
    }

    // Z Algorithm
    private void runZAlgorithm() {

        System.out.println("\n========== Z ALGORITHM ==========");

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        System.out.print("Enter pattern: ");
        String pattern = scanner.nextLine();

        service.runZAlgorithm(text, pattern);
    }

    // Aho-Corasick
    private void runAhoCorasick() {

        System.out.println("\n========== AHO-CORASICK ==========");

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        System.out.print("How many patterns? ");
        int count = scanner.nextInt();
        scanner.nextLine();

        String[] patterns = new String[count];

        for (int i = 0; i < count; i++) {

            System.out.print("Enter pattern " + (i + 1) + ": ");
            patterns[i] = scanner.nextLine();
        }

        service.runAhoCorasick(text, patterns);
    }

    // Edit Distance
    private void runEditDistance() {

        System.out.println("\n========== EDIT DISTANCE ==========");

        System.out.print("Enter first string: ");
        String first = scanner.nextLine();

        System.out.print("Enter second string: ");
        String second = scanner.nextLine();

        service.runEditDistance(first, second);
    }

    // Bitmask DP
    private void runBitmaskDP() {

        System.out.println("\n========== BITMASK DP ==========");

        System.out.print("Enter number of values: ");
        int n = scanner.nextInt();

        int[] values = new int[n];

        for (int i = 0; i < n; i++) {

            System.out.print("Enter value " + (i + 1) + ": ");
            values[i] = scanner.nextInt();
        }

        service.runBitmaskDP(values);
    }

    // Sample graph
    private int[][] createSampleGraph() {

        return new int[][]{
                {0, 10, 10, 0, 0, 0},
                {0, 0, 2, 4, 8, 0},
                {0, 0, 0, 0, 9, 0},
                {0, 0, 0, 0, 0, 10},
                {0, 0, 0, 6, 0, 10},
                {0, 0, 0, 0, 0, 0}
        };
    }

    // Ford-Fulkerson
    private void runFordFulkerson() {

        int[][] graph = createSampleGraph();

        service.runFordFulkerson(graph, 0, 5);
    }

    // Edmonds-Karp
    private void runEdmondsKarp() {

        int[][] graph = createSampleGraph();

        service.runEdmondsKarp(graph, 0, 5);
    }

    // Dinic
    private void runDinic() {

        int[][] graph = createSampleGraph();

        service.runDinic(graph, 0, 5);
    }

    // Bipartite Matching
    private void runBipartiteMatching() {

        System.out.println("\n========== BIPARTITE MATCHING ==========");

        int[][] graph = {
                {1, 1, 0},
                {0, 1, 1},
                {1, 0, 1}
        };

        service.runBipartiteMatching(graph);
    }

    // Minimum Cut
    private void runMinCut() {

        int[][] graph = createSampleGraph();

        service.runMinCut(graph, 0, 5);
    }
}