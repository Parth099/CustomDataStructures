public interface CustomQueueReq<T> {

    boolean offer(T item); //inserts to the rear of a queue
    T remove(); //removes from front; throws error if empty
    T poll(); //remove but with no error
    T peek(); //returns first element if it exists else null without removal
    T element(); //peek with a thrown error

}
