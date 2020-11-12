package heap;

/**
 * Created by tkmaab4 on 5/19/20.
 */
public class MaxHeap {

    int[] a;
    int size;

    public MaxHeap(int capacity){
        a = new int[capacity];
        size = 0;
    }

    private int parent(int i){
        return (i-1)/2;
    }

    private int left(int i){
        return 2*i + 1;
    }

    private int right(int i){
        return 2*i + 2;
    }

    private boolean isValid(int i){
        return (i >= 0 && i < a.length);
    }

    public void insert(int i) {
        if (size >= a.length) {
            throw new IllegalArgumentException("Heap full");
        }
        int itemIndex = size;
        a[size] = i;
        size ++;

        propogateUp(itemIndex);

    }

    private void propogateUp(int itemIndex) {
        int parentIndex = parent(itemIndex);

        while (a[itemIndex] > a[parentIndex]) {
           swap(a,itemIndex,parentIndex);
           itemIndex = parentIndex;
           parentIndex = parent(parentIndex);

        }
    }

    private void swap(int[] a, int itemIndex, int parentIndex) {
        int temp = a[itemIndex];
        a[itemIndex] = a[parentIndex];
        a[parentIndex] = temp;

    }

    /**
     * will remove max index
     */
    public void remove() {
        int root = a[0];
        a[0] = a[size-1];
        size--;
        heapify(0);

    }

    private void heapify(int i) {
        int left = isValid(i) ? a[left(i)] : Integer.MIN_VALUE;
        int right = isValid(i) ? a[right(i)] : Integer.MIN_VALUE;

        int max = Math.max(Math.max(left,right),a[i]);

        int maxIndex = i;

        if (max == left) {
            maxIndex = left(i);
        } else if (max == right) {
            maxIndex = right(i);
        }

        if (maxIndex != i) {
            swap(a,i,maxIndex);
            heapify(maxIndex);
        }
    }

}
