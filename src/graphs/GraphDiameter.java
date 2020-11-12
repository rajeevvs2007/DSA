package graphs;

import java.util.*;

/**
 * Created by tkmaab4 on 5/14/20.
 * Diameter of a Graph: Given a directed graph, find the length of the longest path in the graph.
 */
public class GraphDiameter {

    public static void main(String[] args) {

        Graph graph = createGraph();
        List<Integer> nodesDistance = new ArrayList<>();

        Stack<Node> nodeStack = null;
        for (Node node : graph.nodes) {

            if (node.state == State.UNVISITED) {
                nodeStack =  topoSort(node);
            }



            //DFS implementation
            /*if (node.state == State.UNVISITED) {
                Stack<Node> nodeStack = new Stack<Node>();
                node.setLevel(0);
                nodeStack.add(node);
                dfsVisit(node,nodeStack);
                int max = 0;
                System.out.println();
                while (!nodeStack.isEmpty()){
                    Node stackNode = nodeStack.pop();
                    max = Math.max(max,stackNode.level);
                    System.out.print(stackNode.data);
                    System.out.print(">");
                }
                System.out.println("Level" + max);
            }*/


        }
        int diameter = 0;
        while (!nodeStack.isEmpty()) {

            Node current = nodeStack.pop();
            diameter = Math.max(diameter,current.longestLength);
            // Max length at any node = Max Length to its parents + 1
            for (Node neighbor: current.nodes){
                if (current.longestLength+1 > neighbor.longestLength) {
                    neighbor.longestLength = current.longestLength+1;
                }
            }
        }
        System.out.println("Diameter>>"+ diameter);

    }

    private static Stack<Node> topoSort(Node node) {
        Stack<Node> nodeStack = new Stack<>();
        dfsVisit(node,nodeStack);
        return nodeStack;
    }

    private static void dfsVisit(Node node, Stack<Node> nodeStack) {
        node.state = State.VISITING;
        for(Node neighborNode : node.nodes) {
            if (neighborNode.state == State.UNVISITED){
                neighborNode.state = State.VISITING;
                dfsVisit(neighborNode,nodeStack);
            }
        }
        nodeStack.add(node);
        node.state = State.VISITED;
    }

    /*private static void dfsVisit(Node node,Stack<Node> nodeStack) {
        node.state = State.VISITING;
        for (Node neighbor :  node.nodes) {
            if (neighbor.state == State.UNVISITED) {
                int level = node.level+1;
                neighbor.setLevel(level);
                nodeStack.add(neighbor);
                neighbor.state=State.VISITING;
                dfsVisit(neighbor,nodeStack);

            }
        }

        node.state = State.VISITED;
    }*/


    private static Graph createGraph() {
        Graph graph = new Graph();

        Node node1 = new Node();
        node1.data = 1;

        Node node2 = new Node();
        node2.data = 2;

        Node node3 = new Node();
        node3.data = 3;

        Node node4 = new Node();
        node4.data = 4;

        Node node5 = new Node();
        node5.data = 5;

        Node node6 = new Node();
        node6.data = 6;

        Node node7 = new Node();
        node7.data = 7;

        Node node8 = new Node();
        node8.data = 8;

        Node node9 = new Node();
        node9.data = 9;

        Node node10 = new Node();
        node10.data = 10;

        Node node11 = new Node();
        node11.data = 11;

        Node node12 = new Node();
        node12.data = 12;

        Node node13 = new Node();
        node13.data = 13;

        node1.nodes.add(node2);
        node1.nodes.add(node3);

        node2.nodes.add(node4);

        node4.nodes.add(node3);
        node4.nodes.add(node5);

        node3.nodes.add(node7);
        node3.nodes.add(node8);
        node3.nodes.add(node8);

        node8.nodes.add(node9);

        node9.nodes.add(node10);

        node10.nodes.add(node11);
        node10.nodes.add(node12);

        node7.nodes.add(node6);
        node7.nodes.add(node13);

        node6.nodes.add(node5);


        graph.nodes.add(node1);
        graph.nodes.add(node2);
        graph.nodes.add(node3);
        graph.nodes.add(node4);
        graph.nodes.add(node5);
        graph.nodes.add(node6);
        graph.nodes.add(node7);
        graph.nodes.add(node8);
        graph.nodes.add(node9);
        graph.nodes.add(node10);
        graph.nodes.add(node11);
        graph.nodes.add(node12);
        graph.nodes.add(node13);

        return graph;
    }
}
