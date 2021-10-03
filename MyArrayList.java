import java.util.Arrays;

public class MyArrayList<E> {

    public final int initCAP = 2;
    private E[] data;
    private int currSize = 0;
    private int capacity = initCAP;

    public MyArrayList(){
        data = (E[])new Object[capacity];
    }

    public MyArrayList(int capacity){
        this.capacity = capacity;
        data = (E[])new Object[capacity];
    }

    public int add(E obj){
        //reallocates if size has hit max
        if(this.currSize == this.capacity){
            this.reallocate();
        }
        this.data[currSize] = obj;
        return ++this.currSize;
    }

    private void reallocate(){
        //doubles the size of the array and moves ptr
        this.capacity *= 2;
        this.data = Arrays.copyOf(this.data, capacity);
    }


    @Override
    public String toString() {
        String str = "[ ";
        for(int i = 0; i < this.currSize; i++){
            str += this.data[i].toString() + " ";
        }
        return str + "]";
    }
}