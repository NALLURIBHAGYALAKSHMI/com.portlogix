package com.portlogix.service;

import com.portlogix.dsa.dp.BitmaskDP;
import com.portlogix.dsa.dp.EditDistance;
import com.portlogix.dsa.graph.BipartiteMatching;
import com.portlogix.dsa.graph.Dinic;
import com.portlogix.dsa.graph.EdmondsKarp;
import com.portlogix.dsa.graph.FordFulkerson;
import com.portlogix.dsa.graph.MinCut;
import com.portlogix.dsa.string.AhoCorasick;
import com.portlogix.dsa.string.KMP;
import com.portlogix.dsa.string.NaiveSearch;
import com.portlogix.dsa.string.RabinKarp;
import com.portlogix.dsa.string.ZAlgorithm;

public class DSAService {

    // KMP String Matching
    public void runKMP(String text, String pattern) {

        System.out.println("\n========== KMP ==========");

        int result = KMP.search(text, pattern);

        if (result != -1) {
            System.out.println(
                    "Pattern found at index: " + result
            );
        } else {
            System.out.println("Pattern not found.");
        }
    }

    // Naive String Search
    public void runNaiveSearch(String text, String pattern) {

        System.out.println("\n========== NAIVE SEARCH ==========");

        int result = NaiveSearch.search(text, pattern);

        if (result != -1) {
            System.out.println(
                    "Pattern found at index: " + result
            );
        } else {
            System.out.println("Pattern not found.");
        }
    }

    // Rabin-Karp
    public void runRabinKarp(String text, String pattern) {

        System.out.println("\n========== RABIN-KARP ==========");

        int result = RabinKarp.search(text, pattern);

        if (result != -1) {
            System.out.println(
                    "Pattern found at index: " + result
            );
        } else {
            System.out.println("Pattern not found.");
        }
    }

    // Z Algorithm
    public void runZAlgorithm(String text, String pattern) {

        System.out.println("\n========== Z ALGORITHM ==========");

        int result = ZAlgorithm.search(text, pattern);

        if (result != -1) {
            System.out.println(
                    "Pattern found at index: " + result
            );
        } else {
            System.out.println("Pattern not found.");
        }
    }

    // Aho-Corasick
    public void runAhoCorasick(String text, String[] patterns) {

        System.out.println("\n========== AHO-CORASICK ==========");

        AhoCorasick.search(text, patterns);
    }

    // Edit Distance
    public void runEditDistance(String first, String second) {

        System.out.println("\n========== EDIT DISTANCE ==========");

        int distance =
                EditDistance.calculate(first, second);

        System.out.println(
                "Edit Distance = " + distance
        );
    }

    // Bitmask Dynamic Programming
    public void runBitmaskDP(int[] values) {

        System.out.println("\n========== BITMASK DP ==========");

        int result = BitmaskDP.solve(values);

        System.out.println(
                "Bitmask DP Result = " + result
        );
    }

    // Ford-Fulkerson
    public void runFordFulkerson(int[][] graph,
                                 int source,
                                 int sink) {

        System.out.println("\n========== FORD-FULKERSON ==========");

        int result =
                FordFulkerson.maxFlow(graph, source, sink);

        System.out.println(
                "Maximum Flow = " + result
        );
    }

    // Edmonds-Karp
    public void runEdmondsKarp(int[][] graph,
                               int source,
                               int sink) {

        System.out.println("\n========== EDMONDS-KARP ==========");

        int result =
                EdmondsKarp.maxFlow(graph, source, sink);

        System.out.println(
                "Maximum Flow = " + result
        );
    }

    // Dinic
    public void runDinic(int[][] graph,
                         int source,
                         int sink) {

        System.out.println("\n========== DINIC ==========");

        Dinic dinic = new Dinic(graph);

        int result =
                dinic.maxFlow(source, sink);

        System.out.println(
                "Maximum Flow = " + result
        );
    }

    // Bipartite Matching
    public void runBipartiteMatching(int[][] graph) {

        System.out.println("\n========== BIPARTITE MATCHING ==========");

        int result =
                BipartiteMatching.maximumMatching(graph);

        System.out.println(
                "Maximum Matching = " + result
        );
    }

    // Minimum Cut
    public void runMinCut(int[][] graph,
                          int source,
                          int sink) {

        System.out.println("\n========== MIN CUT ==========");

        int result =
                MinCut.minimumCut(graph, source, sink);

        System.out.println(
                "Minimum Cut = " + result
        );
    }
}