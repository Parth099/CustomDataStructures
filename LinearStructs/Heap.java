package LinearStructs;

import java.util.ArrayList;

public class Heap<E extends Comparable>{
    private ArrayList<E>flatTree = new ArrayList<>();
    //private int size = 0;

    private void swap(ArrayList<E> A, int i, int j){
        E temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }

    public boolean add(E item) {
        flatTree.add(item);                   //-2 below due to array sizing starting at 1
        int parent = (flatTree.size() - 2)/2; //min parent 0 --> min parent = 1 - 2 / 2 -- > 0 [no out of bounds]
        int child = flatTree.size() - 1;
        while(parent >= 0 && flatTree.get(parent).compareTo(flatTree.get(child)) > 0){
            swap(flatTree, parent, child);
            child = parent;
            parent = (parent - 1) / 2;
        }
        return true;
    }

    public E remove() {
        return null;
    }

    @Override
    public String toString() {
        return flatTree.toString();
    }

    public static void main(String[] args) {
        Heap<Integer> H = new Heap<>();
        H.add(18);
        H.add(5);
        H.add(7);
        H.add(1);
        System.out.println(H);
    }
}
