package graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by tkmaab4 on 5/11/20.
 */
public class BreadthFirstSearch {

    public static void main(String[] args) {
        Graph graph = createGraph();
        boolean matchFound = bfs(graph);
        System.out.println("Match found "+ matchFound);

    }

    private static boolean bfs(Graph graph) {
        int target = 6;
        for (Node node : graph.nodes){
            if(node.state == State.UNVISITED && bfsVisit(node,target)) {
                return true;
            }
        }
        return false;
    }

    private static boolean bfsVisit(Node node, int target) {
        node.state = State.VISITING;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            if(current.data == target){
                return true;
            }
        for(Node neighbor : node.nodes){
             if (node.state == State.UNVISITED) {
                 neighbor.state=State.VISITING;
                 queue.add(neighbor);
              }
        }
        node.state = State.VISITED;
        }
        return false;
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
