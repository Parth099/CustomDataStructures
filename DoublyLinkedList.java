import java.util.Iterator;

public class DoublyLinkedList<T> implements Iterable<T> {

    Node<T> head;
    Node<T> tail;
    int size = 0;

    public int getSize(){
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        return new DoublyLinkedIter();
    }

    public class DoublyLinkedIter implements Iterator<T>{
        int index = 0;
        Node<T> curr = null;
        Node<T> prev = null;

        @Override
        public boolean hasNext() {
            if(head == null && curr == null){
                return false;
            }
            if(curr == null){
                return true;
            }
            return curr.next != null;
        }

        @Override
        public T next() {
            if(curr == null){
                curr = head;
                return curr.data;
            }
            prev = curr;
            curr = curr.next;
            return curr.data;
        }
    }

    private static class Node<T> {

        //attrs
        int size = 0;
        Node<T> next;
        Node<T> prev;
        T data;

        public Node(){
            this.next = null;
            this.prev = null;
            data = null;
        }

        public Node(T data){
            this.next = null;
            this.prev = null;
            this.data = data;
        }
        public Node(T data, Node<T> prev, Node<T> next){
            this.next = next;
            this.prev = prev;
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node("+this.data+")";
        }

        //• public int size()
        //• public boolean contains(Object obj)
        //• public E get(int index)
        //• public void set(int index, E item)
        //• public int indexOf(Object obj)
        //• public boolean add(E item)
        //• public void add(int index, E item)
        //• public E remove(int index)
        //• public boolean remove(Object obj)
    }
    private Node<T> getNode(int index){
        int cursor = 0;
        Node<T> currNode = head;
        while(cursor < index){
            currNode = currNode.next;
        }
        return currNode;

    }
    private void replaceHead(T item){
        if(head == null){
            this.head = new Node<T>(item);
            return;
        }
        head = new Node<T>(item, null, head);
        head.next.prev = head;
    }
    private T removeHead(){
        T data = head.data;
        if(head != null){
            head.next.prev = null;
            head.next = head;
        }
        return data;
    }
    public T remove(int index){
        if(index < 0 || index > this.getSize()){
            throw new IndexOutOfBoundsException(index);
        }
        if(index == 0){
            return removeHead();
        }
        int cursor = 0;
        T data;
        Node<T> current = head;
        while(cursor++ < index){
            current = current.next;
        }
        data = current.data;
        size--;
        current.prev.next = current.next;
        return data;
    }

    private void appendTail(T item) {
        if(tail == null){
            tail = new Node<>(item, head, null);
            head.next = tail;
        }
        else{
            //sets tail.next to new Node that has tail as prev, sets tail as this new node
            tail = tail.next = new Node<>(item, tail, null);
        }

    }

    public void add(T item){
        if(this.head == null){
            replaceHead(item);
        }
        else {
            appendTail(item);
        }
        size++;
    }



    @Override
    public String toString(){
        StringBuilder tStr = new StringBuilder("D-Linked-List [ ");
        Node<T> curr = head;
        while(curr != null){
            tStr.append(curr + " --> ");
            curr = curr.next;
        }
        tStr.append("null ]");
        return tStr.toString();
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> I = new DoublyLinkedList<>();
        I.add(1);
        I.add(2);
        I.add(3);
        System.out.println(I);

        Iterator<Integer> iT = I.iterator();
        while(iT.hasNext()){
            System.out.println(iT.next());
        }
        System.out.println("Breaker");
    }
}
