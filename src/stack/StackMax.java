package stack;

import javafx.util.Pair;


/**
 * Created by tkmaab4 on 4/10/20.
 * 1. (Level: Medium) Implement a Stack with O(1) lookup of the maximum element in the stack. For example,
 * Stack: 3 -> 2 -> 1 -> 5
 * Max() => 5
 */
public class StackMax {

    public static void main(String[] args) {

        Stack<Pair> stack = new Stack<Pair>();
        createStack(stack);
        int max = findMax(stack);
        System.out.println("Max >" + max);


    }

    private static int findMax(Stack<Pair> stack) {

        Pair<Integer,Integer> pair = stack.peek();
        return pair.getValue();

    }


    private static Stack<Pair> createStack(Stack<Pair> stack) {
        Pair pair1 = new Pair(5,0);
        Pair pair2 = new Pair(2,0);
        Pair pair3 = new Pair(3,0);
        Pair pair4 = new Pair(6,0);
        Pair pair5 = new Pair(1,0);

        stack.push(new Node(pair1));
        stack.push(new Node(pair2));
        stack.push(new Node(pair3));
        stack.push(new Node(pair4));
        stack.push(new Node(pair5));

        return stack;
    }
}
