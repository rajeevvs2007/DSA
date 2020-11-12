package graphs;


import javafx.util.Pair;

import java.util.*;

/**
 * Created by tkmaab4 on 5/26/20.
 * A Bipartite Graph is a graph where nodes can be separated into 2 groups such that no 2 nodes in the group have an edge.
 */
public class BipartiateGraph {

    public static void main(String[] args) {
       Graph graph = createGraph();
        List<Node> evenNodes = new ArrayList<>();
        List<Node> oddNodes = new ArrayList<>();
       for (Node node : graph.nodes) {
           if (node.state == State.UNVISITED) {
               bfs(node,evenNodes,oddNodes);
           }
       }

        for (Node node : evenNodes) {
            System.out.println(node.data);
        }

        System.out.println("================");
        for (Node node : oddNodes) {
            System.out.println(node.data);
        }


    }

    private static Pair<List,List> bfs(Node node, List<Node> evenNodes, List<Node> oddNodes) {
        Queue<Node> queue = new LinkedList<Node>();
        node.setLevel(0);
        queue.add(node);

        while (!queue.isEmpty()){
            Node current = queue.poll();
            current.state = State.VISITING;
            if (current.getLevel() %2 == 0) {
                evenNodes.add(current);
            } else {
                oddNodes.add(current);
            }

            for (Node neighbor : current.nodes) {
                if (neighbor.state == State.UNVISITED) {
                    neighbor.state = State.VISITING;
                    neighbor.setLevel(current.getLevel() + 1);
                    queue.add(neighbor);
                } else if (neighbor.level == current.level) {
                    return null;
                }
            }
            current.state = State.VISITED;


        }

        return new Pair<>(evenNodes,oddNodes);
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

        node1.nodes.add(node2);
        node1.nodes.add(node3);

        node2.nodes.add(node4);

        node3.nodes.add(node5);

        node4.nodes.add(node6);

        node5.nodes.add(node6);

        graph.nodes.add(node1);
        graph.nodes.add(node2);
        graph.nodes.add(node3);
        graph.nodes.add(node4);
        graph.nodes.add(node5);
        graph.nodes.add(node6);

        return graph;
    }
}
