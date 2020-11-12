package heap;

import java.util.*;

/**
 * Created by tkmaab4 on 5/19/20.
 * Heaps (Level: Easy) Find the n smallest numbers in an array of integers.
 */
public class FindKSmallestElements {

    public static void main(String[] args) {
        int a[] = {7,5,3,4,2,8,1};
        int k = 4;
       findNSmallElements(a, k);


    }

    private static void findNSmallElements(int[] a, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Points> pQueue = new PriorityQueue<Points>(4, Comparator.comparingDouble((Points p) -> p.k ).reversed());


        for (int i=0; i < a.length; i ++ ) {
            if (i < k){
                priorityQueue.add(a[i]);
            }
            if (a[i] < priorityQueue.peek()){
                priorityQueue.poll();
                priorityQueue.add(a[i]);
            }
        }
        Iterator<Integer> heapIterator = priorityQueue.iterator();

        while (heapIterator.hasNext()) {
            System.out.println(heapIterator.next());
        }


        Points p1 = new Points(2,4,20);
        Points p2 = new Points(3,4,25);

        List<Points> pointsList = new ArrayList<Points>();
        pointsList.add(p1);
        pointsList.add(p2);

        Collections.sort(pointsList,new PointComparator());
        Iterator<Points> iterator = pointsList.iterator();
        while (iterator.hasNext()) {
            System.out.println(" Points " + iterator.next().k);

        }



    }

    static class Points{
        int x;
        int y;
        double k;

        public Points(int x,int y, double k) {
            this.x=x;
            this.y=y;
            this.k=k;
        }
    }

    static class PointComparator implements Comparator<Points> {

        @Override
        public int compare(Points o1, Points o2) {
            if (o1.k > o2.k) {
                return 1;
            } else if (o1.k < o2.k) {
                return -1;
            } else {
                return 0;
            }

        }
    }

}
