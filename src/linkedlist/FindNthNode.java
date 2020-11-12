package linkedlist;

/**
 * Created by tkmaab4 on 3/24/20.
 */
public class FindNthNode {

    public static void main(String[] args) {

        Node head = createLinkedList();

        int target = 2;
        System.out.println("Find the" + target +":node: "+ findNode(head,target));

    }

    private static String findNode(Node head,int target) {

        int count = 0;
        Node node = head;
        while (count < target) {
            node = node.next;
            if (node == null){
                return null;
            }
            count ++;
        }
        return String.valueOf(node.value);
    }

    private static Node createLinkedList() {

        Node head = new Node();
        head.value=0;

        Node node1 = new Node();
        node1.value=1;
        node1.next=null;
        head.next=node1;

        Node node2 = new Node();
        node2.value=2;
        node2.next=null;
        node1.next=node2;

        Node node3 = new Node();
        node3.value=3;
        node3.next=null;
        node2.next=node3;

        return head;

    }
}
