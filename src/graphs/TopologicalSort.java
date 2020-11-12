package graphs;

import java.util.Stack;

/**
 * Created by tkmaab4 on 5/14/20.
 *
 */
public class TopologicalSort {

    public static void main(String[] args) {

        Graph graph = createGraph();
        Stack<Node> nodeStack = new Stack<>();
        for (Node node : graph.nodes){
            if (node.state == State.UNVISITED ){
                dfsVisit(node,nodeStack);
            }
        }
        while (!nodeStack.isEmpty()) {
            System.out.print(nodeStack.pop().data + ">");
        }


    }

    private static void dfsVisit(Node node, Stack<Node> nodeStack) {

        node.state = State.VISITING;
        for (Node neighbor : node.nodes){
            if (neighbor.state == State.UNVISITED) {
                neighbor.state = State.VISITING;
                dfsVisit(neighbor, nodeStack);
            }
        }
        node.state = State.VISITED;
        nodeStack.push(node);

    }

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
