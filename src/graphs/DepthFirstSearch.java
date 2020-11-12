package graphs;

import java.util.List;

/**
 * Created by tkmaab4 on 5/6/20.
 */
public class DepthFirstSearch {

    public static void main(String[] args) {
        Graph graph = new Graph();
        createGraph(graph);
        int target = 12;
        boolean targetFound = dfs(graph,target);
        System.out.println("Target found " + targetFound);

    }

    private static boolean dfs(Graph graph, int target) {
        List<Node> nodes= graph.nodes;
        for(Node node : nodes){
            if (node.state == State.UNVISITED && dfsVisit(node,target)){
                return true;
            }
        }

        return false;

    }

    private static boolean dfsVisit(Node node, int target) {
        System.out.println("visiting nodes");
            node.state=State.VISITING;
            if(node.data == target) {
                return true;
            }
            for (Node neighbourNode : node.nodes){
                System.out.println("Accessing nodes");
                if (neighbourNode.state == State.UNVISITED){

                    if (dfsVisit(neighbourNode,target)) {
                         return true;
                     }
                }
            }
            node.state=State.VISITED;
            return false;
    }

    private static void createGraph(Graph graph) {
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
        node1.nodes.add(node5);

        node2.nodes.add(node4);
        node2.nodes.add(node6);

        node4.nodes.add(node6);
        node5.nodes.add(node6);

        graph.nodes.add(node1);
        graph.nodes.add(node2);
        graph.nodes.add(node3);
        graph.nodes.add(node4);
        graph.nodes.add(node5);
        graph.nodes.add(node6);
    }
}
