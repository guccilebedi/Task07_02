package com.company;

public class Main {

    public static void main(String[] args) {
	    Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 1);
        graph.addEdge(4, 1);
        graph.addEdge(1, 6);
        graph.color();
        System.out.println(graph.toDot());
    }
}
