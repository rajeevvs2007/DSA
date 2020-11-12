package stack;

/**
 * Created by tkmaab4 on 4/8/20.
 */
public class FindElementInStack {

    public static void main(String[] args) {

        Stack<Integer> integerStack = createStack();
        findElement(integerStack,2);
    }

    private static void findElement(Stack stack, Integer target) {
        Stack<Integer> temp = new Stack<Integer>();

        while (!stack.isEmpty()) {
            if (stack.peek() == target) {
                System.out.println("Found element " + target + " in stock");
                break;
            }
            temp.push(stack.pop());

        }

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }

    private static Stack<Integer> createStack() {
        Stack<Integer> stack = new Stack<Integer>();

        Node<Integer> node1 = new Node<>(1);
        stack.push(node1);

        Node<Integer> node2 = new Node<>(2);
        stack.push(node2);

        Node<Integer> node3 = new Node<>(3);
        stack.push(node3);

        Node<Integer> node4 = new Node<>(4);
        stack.push(node4);

        return stack;
    }
}
