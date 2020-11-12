package recursion;

import javafx.util.Pair;
import java.util.*;

/**
 * Created by tkmaab4 on 6/16/20.
 */
public class MazePath {

    public static void main(String[] args) {
        int maze[][] = {
                {0,0,0,1,1},
                {0,1,0,0,0},
                {0,0,1,1,0},
                {0,0,0,1,0}
                };

        State[][] memo = new State[maze.length][maze[0].length];
        for (State[] state:memo){
            Arrays.fill(state,State.UN_VISITED);
        }
        Set<String> testSet = new HashSet<>();
        testSet.add(null);
        testSet.add(null);
        System.out.println("find path "+ findPath(maze, 0,0,memo));

    }

    private static boolean findPath(int[][] maze, int i, int j, State[][] memo) {
        //basecase
        if (oob(maze,i,j) || maze[i][j] == 1 || memo[i][j] != State.UN_VISITED){
            return false;
        }
        if (i == maze.length-1 && j == maze[0].length-1) {
            return true;
        }

        Pair<Integer,Integer>[] pairs = new Pair[4];
        pairs[0] = new Pair(i+1,j);
        pairs[1] = new Pair(i-1,j);
        pairs[2] = new Pair(i,j+1);
        pairs[3] = new Pair(i,j-1);

        memo[i][j] = State.VISTING;
        for (Pair<Integer,Integer> pair:pairs){
            if (findPath(maze,pair.getKey(),pair.getValue(),memo)) {
                return true;
            }

        }
        memo[i][j] = State.PATH_NOT_FOUND;
        return false;

    }

    private static boolean oob(int[][] maze, int i, int j) {
        if (i > maze.length-1 || i < 0 || j > maze[0].length-1 || j < 0){
            return true;
        }
        return false;
    }


    enum State {
        VISTING,UN_VISITED,PATH_NOT_FOUND;
    }
}
