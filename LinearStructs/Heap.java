package LinearStructs;
//MIN HEAP ONLY
import java.util.ArrayList;

//basis for Prior Queue
public class Heap<E extends Comparable>{
    private ArrayList<E>flatTree = new ArrayList<>();
    //private int size = 0;

    //assert A != null for all calls
    private void swap(ArrayList<E> A, int i, int j){
        E temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }

    //adds to the end of the tree to ensure completeness
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

    public boolean isEmpty(){
        return flatTree.size() == 0;
    }

    //remove explanation
    //Start by remove node 0 and replacing it with the node at the bottom on the tree [Ensure Completeness]
    //attempt to swap with nodes below
    //Assume: Left is to be swapped as its smaller
    //assume is wrong (right is smaller or no swap is needed)
    //perform swaps until array boundaries are hit
    public E remove() {
        if(flatTree.isEmpty()){
            return null;
        }
        if(flatTree.size() == 1){
            return flatTree.remove(flatTree.size() - 1);
        }

        E removed = flatTree.get(0);

        //last element removed

        flatTree.set(0, flatTree.remove(flatTree.size() - 1));
        int parent = 0;
        int left = 2 * parent + 1;
        int right = left + 1; //right is adj to Left
        int minCH = 0;
        while (true) {
            if (left >= flatTree.size()) break;

            minCH = left;
            if (right < flatTree.size() && flatTree.get(right).compareTo(flatTree.get(left)) < 0) {
                minCH = right;
            }
            if (flatTree.get(parent).compareTo(flatTree.get(minCH)) > 0) {
                swap(flatTree, parent, minCH);
                parent = minCH;
            } else {
                break;
            }

            left = 2 * parent + 1;
            right = left + 1; //right is adj to Left

        }
        return removed;
    }

    @Override
    public String toString() {
        return flatTree.toString();
    }

    public static void main(String[] args) {
        Heap<Integer> H = new Heap<>();
        H.add(16);
        System.out.println(H.remove());
    }
}
