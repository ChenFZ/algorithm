/**
 * Copyright (C), 2015-2021
 * Description: 图
 * <author>          <time>          <version>          <desc>
 * chenfz           2021/12/26 22:39           1.0              描述
 */
package com.chenfz.dataStructure;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 创建一个图，这个列子中假设本图为无向图
 */
public class Graph {
    private final ArrayList<String> vertices; // 存放图的顶点
    private final int[][] edges; //存放边的信息
    private int numberOfEdges = 0; //边的总数
    private final boolean[] isVisited;

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        String[] vertices = {"A", "B", "C", "D", "E", "F"};
        //插入所有顶点
        for (String vertex : vertices) {
            graph.insertVertex(vertex);
        }

        //插入所有的边
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(2, 3, 1);
        graph.insertEdge(2, 4, 1);
        graph.insertEdge(3, 4, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 5, 1);
        graph.printGraph();
        //graph.DFS(0);
        System.out.println("-----------");
        graph.DFS2(0);
    }

    public Graph(int n) {
        //初始化一张图
        numberOfEdges = 0;
        vertices = new ArrayList(n);
        edges = new int[n][n];
        isVisited = new boolean[n];
        for (boolean vertex : isVisited) {
            //定点的初始状态都是未遍历
            vertex = false;
        }
    }

    public void insertVertex(String vertex) {
        //插入顶点
        vertices.add(vertex);
    }

    public void insertEdge(int v, int w, int weight) {
        edges[v][w] = 1;
        edges[w][v] = 1;
        numberOfEdges++;
    }

    //打印图的邻接矩阵看一哈
    public void printGraph() {
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges.length; j++) {
                System.out.print(edges[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*
     ** 将这个函数直接放在Graph Class 中
     **/
    public void DFS(int i) {
        System.out.println(vertices.get(i) + " ->");
        isVisited[i] = true;  //第一步
        int w = findVertex(i);
        //第二步，若有邻接点,则对于所有的路径
        while (w != -1) {
            //第三步,如果该节点没有被遍历过
            if (!isVisited[w]) {
                DFS(w); //第四步，则对该节点进行DFS， 注意这句话是要往下一层搜索。
            }
            w = findNextVertex(i, w);  //注意这句话是要搜索同一层
        }
    }

    /*
            procedure DFS-iterative(G, v) is
        let S be a stack
        S.push(v)
        while S is not empty do
        v = S.pop()
        if v is not labeled as discovered then
        label v as discovered
        for all edges from v to w in G.adjacentEdges(v) do
        S.push(w)
     */
    public void DFS2(int i) {
        Stack<String> stack = new Stack<>();
        stack.push(vertices.get(i));
        int count = 0;
        while (!stack.isEmpty()) {
            String s = stack.pop();
            int index = vertices.indexOf(s);
            if (!isVisited[index]) {
                System.out.println(s + " -> " + count++);
                isVisited[index] = true;
                for (int j = vertices.size() - 1; j >= 0; j--) {
                    if (edges[index][j] > 0) {
                        stack.push(vertices.get(j));
                    }
                }
            }
        }

    }


    private int findNextVertex(int i, int w) {
        for (int j = w + 1; j < vertices.size(); j++) {
            if (edges[i][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    private int findVertex(int i) {
        for (int j = 0; j < vertices.size(); j++) {
            if (edges[i][j] > 0) {
                return j;
            }
        }
        return -1;
    }
}
