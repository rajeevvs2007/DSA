package graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tkmaab4 on 5/5/20.
 */
public class Node {
    List<Node> nodes;
    int data;
    State state;
    int longestLength;
    int level;

    public void setLevel(int level){
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }
    public Node() {
        nodes = new ArrayList<Node>();
        state = State.UNVISITED;

    }
    public Node(int data) {
        this.data=data;
        nodes = new ArrayList<Node>();
        state = State.UNVISITED;


    }

}
