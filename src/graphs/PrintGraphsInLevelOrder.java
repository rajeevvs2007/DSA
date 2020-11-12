package graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tkmaab4 on 5/12/20.
 * Print Graph in Level Order: Given a graph and a node N, print the Graph in order of distancefrom N.
 * Each level should be in a new line.
 */
public class PrintGraphsInLevelOrder {

    public static void main(String[] args) {
        Graph graph = createGraph();

        for (Node node : graph.nodes){
            if (node.state == State.UNVISITED ){
                printLevel(node);
            }
        }

    }

    /**
     * Use BFS to visit all the nodes
     * @param root
     */
    private static void printLevel(Node root) {
        root.state = State.VISITING;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        Node dummy = new Node(0);
        queue.add(dummy);

        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(current.data == 0 ){
                if( !queue.isEmpty()) {
                    queue.add(new Node(0));
                }
                System.out.println("\n");
                continue;
            }
            System.out.print("\t"+current.data);
            for (Node neighbor : current.nodes){
                if (neighbor.state == State.UNVISITED) {
                    neighbor.state = State.VISITING;
                    queue.add(neighbor);
                }

            }
            root.state = State.VISITED;

        }
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
