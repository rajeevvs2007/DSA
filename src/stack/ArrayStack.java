package stack;

/**
 * Created by tkmaab4 on 4/9/20.
 * 2. (Level: Medium) Use an array to implement 2 Stacks.
 */
public class ArrayStack {

    Object[] elementArray;

    int s1;


    public ArrayStack( int arraySize){
        elementArray = new Object[arraySize];
        s1=0;
    }

    public void push(Object value) throws StackFullException{
        if (s1>elementArray.length-1) {
            throw new StackFullException("Invalid Entry");
        }
        elementArray[s1++] = value;

    }

    public Object pop() throws StackEmptyException {
        if (s1 > 0 ) {
            return elementArray[--s1];
        } else {
            throw  new StackEmptyException("Stack Empty");
        }

    }

}
