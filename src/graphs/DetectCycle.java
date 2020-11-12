package graphs;

/**
 * Created by tkmaab4 on 5/26/20.
 */
public class DetectCycle {

    public static void main(String[] args) {

        Graph graph = createGraph();
        boolean cycleFound = false;
        for (Node node : graph.nodes) {
            if (node.state == State.UNVISITED ) {
                cycleFound = dfsVisit(node);
                break;
            }
        }

        System.out.println("cycleFound "+ cycleFound);
    }

    private static boolean dfsVisit(Node node) {
        node.state = State.VISITING;

        for (Node neighbor : node.nodes) {
            if (neighbor.state == State.UNVISITED &&  dfsVisit(neighbor)) {
               return true;
            } else if (neighbor.state == State.VISITING) {
                return true;
            }
        }

        node.state = State.VISITED;
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
        node1.nodes.add(node5);

        node2.nodes.add(node4);
        node2.nodes.add(node6);

        node4.nodes.add(node6);
        //cycle
        node4.nodes.add(node1);

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
