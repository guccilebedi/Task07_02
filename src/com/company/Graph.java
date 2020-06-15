package com.company;

import java.util.*;

public class Graph {
    private int maxVertex = 10;
    private boolean[][] adjMatrix = new boolean[maxVertex][maxVertex];
    private Vertex[] vertexArr = new Vertex[maxVertex];
    private int vertexCount = 0;

    public Graph() {
    }

    public void addVertex(char name) {
        if (vertexCount == maxVertex) {
            maxVertex = (int) (maxVertex * 1.5 + 1);
            vertexArr = Arrays.copyOf(vertexArr, maxVertex);
            adjMatrix = Arrays.copyOf(adjMatrix, maxVertex);
            for (int i = 0; i < maxVertex; i++) {
                adjMatrix[i] = i < vertexCount ? Arrays.copyOf(adjMatrix[i], maxVertex) : new boolean[maxVertex];
            }
        }
        vertexArr[vertexCount++] = new Vertex(name);
    }

    public void addEdge(int v1, int v2) {
        adjMatrix[v1][v2] = true;
        adjMatrix[v2][v1] = true;
    }

    public void color() {
        int temp = 1;
        int maxTemp = 1;
        for (int i = 0; i < vertexCount; i++) {
            vertexArr[i].setColor(String.valueOf(temp));
        }
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                if (adjMatrix[i][j]) {
                    while (vertexArr[i].getColor().equals(vertexArr[j].getColor())) {
                        temp++;
                        if (temp > maxTemp) {
                            maxTemp = temp;
                        }
                        vertexArr[j].setColor(String.valueOf(temp));
                    }
                    temp = 1;
                }
            }
        }
        for (int i = maxTemp; i > 0; i--) {
            String color = String.valueOf((int) (Math.random() * 0x1000000));
            for (int j = 0; j < vertexCount; j++) {
                if (Integer.parseInt(vertexArr[j].getColor()) == maxTemp) {
                    vertexArr[j].setColor(color);
                }
            }
            maxTemp--;
        }
    }

    public String toDot() {
        StringBuilder sb = new StringBuilder();
        String nl = System.getProperty("line.separator");
        for (int i = 0; i < vertexCount; i++) {
            int count = 0;
            for (int j = 0; j < vertexCount; j++) {
                if (adjMatrix[i][j]) {
                    sb.append(String.format("  %c %s %c", vertexArr[i].getName(), ("--"), vertexArr[j].getName()) + ";").append(nl);
                    count++;
                }
            }
            if (count == 0) {
                sb.append(vertexArr[i].getName() + ";").append(nl);
            }
        }
        return sb.toString();
    }
}
