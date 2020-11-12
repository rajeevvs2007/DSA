package graphs;

import java.util.*;
import java.util.List;

/**
 * Created by tkmaab4 on 5/6/20.
 *
 * Clone a Graph: Given an directed graph, make a copy.
 */
public class CloneGraph {

    public static void main(String[] args) {

        Graph graph = new Graph();
        createGraph(graph);
        Graph cloneGraph = cloneGraph(graph);

    }

    private static Graph cloneGraph(Graph graph) {
            List<Node> nodes = graph.nodes;
            Map<Node,List> nodeListMap = new HashMap<>();
            for (Node node : nodes) {
              if (node.state == State.UNVISITED ) {
                  dfsVisit(node,nodeListMap);
              }
            }
            Graph clonedGraph = new Graph();
            for (Node node : nodeListMap.keySet()){
                clonedGraph.nodes.add(node);
            }
            return clonedGraph;
    }

    private static void dfsVisit(Node node,Map<Node,List> nodeListMap) {
        node.state = State.VISITING;
        for (Node childNode : node.nodes){
           if (nodeListMap.get(node) == null){
               List<Node> nodeList = new ArrayList<Node>();
               nodeList.add(childNode);
               nodeListMap.put(node,nodeList);
           }else {
               List<Node> nodeList = nodeListMap.get(node);
               nodeList.add(childNode);
               nodeListMap.put(node,nodeList);
           }
           if (node.state == State.UNVISITED){
               dfsVisit(childNode,nodeListMap);
           }
        }
        if (node.nodes == null|| node.nodes.size() == 0) {
            if (nodeListMap.get(node) == null){
                List<Node> nodeList = new ArrayList<Node>();
                nodeListMap.put(node,null);
            }
        }
        node.state = State.VISITED;
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
