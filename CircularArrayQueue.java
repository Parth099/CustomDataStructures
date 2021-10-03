import java.util.NoSuchElementException;

public class CircularArrayQueue<E> implements CustomQueueReq<E> {

    int front;
    int rear;
    int size;
    int capacity;
    E[] theData;

    static final int INIT_CAP = 16;

    public CircularArrayQueue(){
        this(INIT_CAP);
    }
    public CircularArrayQueue(int initCapacity){
        capacity = initCapacity;
        front = 0;
        rear = capacity -1;
        size = 0;
        theData = (E[])new Object[capacity];
    }

    @Override
    public boolean offer(E item) {
        if(size == capacity){
            reallocate();
        }
        rear = (rear + 1) % capacity;
        this.theData[rear] = item;
        size++;
        return true;
    }

    private void reallocate() {
        capacity = 2 * capacity;
        E[] newData = (E[])new Object[capacity];
        int k = front;
        for(int i = 0; i < size; i++){
            newData[i] = this.theData[k % size];
            k++;
        }
        front = 0;
        rear = capacity - 1;
        this.theData = newData;
    }

    @Override
    public E remove() {
        E data = this.poll();
        if(data == null){
            throw new NoSuchElementException();
        }
        return data;
    }

    @Override
    public E poll() {
        if(this.size == 0){
            return null;
        }
        E data = this.theData[front];
        front = (front + 1) % capacity;
        size--;
        return data;
    }

    @Override
    public E peek() {
        return (size == 0) ? null : this.theData[front];
    }

    @Override
    public E element() {
        if(this.peek() == null){
            throw new NoSuchElementException();
        }
        return this.peek();
    }
}
