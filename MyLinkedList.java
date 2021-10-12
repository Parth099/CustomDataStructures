import java.util.Iterator;

public class MyLinkedList<E> implements Iterable<E>{

    private int size = 1;
    private Node<E> head;

    @Override
    public Iterator<E> iterator() {
        return new MyLinkedIterator();
    }
    class MyLinkedIterator implements Iterator<E>{

        Node<E> currentNode = null;
        //boolean doneFlag;
        @Override
        public boolean hasNext() {
            if(currentNode == null && head != null){
                return true;
            }
            return currentNode.next != null;
        }

        @Override
        public E next() {
            if(currentNode == null && head != null){
                currentNode = head;
                return currentNode.data;
            }
            else if(currentNode != null){
                currentNode = currentNode.next;
                return currentNode.data;
            }

            return null;
        }
    }

    private static class Node<E>{
        public E data;
        public Node<E> next;

        public Node(){
            this.data = null;
            this.next = null;
        }

        public Node(E data){
            this.data = data;
            this.next = null;
        }

        public Node(Node<E> nextNode, E data){
            this.data = data;
            this.next = nextNode;
        }

        @Override
        public String toString() {
            return "Node( "+( (this.data == null) ? "null" : this.data.toString())+" )";
        }
    }
    public MyLinkedList(){
        this.head = new Node<E>();
    }

    private Node<E> getNode(int index){
        Node<E> nodePtr = this.head;
        while (index-- > 0){
            nodePtr = nodePtr.next;
        }
        return nodePtr;
    }

    //only getter
    public int getSize() {
        return size;
    }


    public void add(E item){
        if(head.data == null){
            head.data = item;
            return;
        }
        Node<E> currentNode = head;

        //stops at the last filled node
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = new Node<E>(item);
        this.size++;
    }
    private void addAfterNode(Node<E> currentNode, E item){
        Node<E> newNode = new Node<>(item);
        newNode.next = currentNode.next;
        currentNode.next = newNode;
    }
    private void replaceHeadNode(E item){
        Node<E> newNode = new Node<>(this.head, item);
        this.head = newNode;
    }
    public void add(int index, E item){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        //we know index exists!
        size++;
        if(index == size){
            this.add(item);
            return;
        }
        if(index == 0){
            replaceHeadNode(item);
            return;
        }
        Node<E> currentNode = this.getNode(index - 1);
        this.addAfterNode(currentNode, item);
    }
    private boolean removeHead(){
        if(this.head.next == null) {
            this.head.data = null;
            return true;
        }
        size--;
        this.head = this.head.next;
        return true;
    }
    public boolean remove(E obj){
        if(this.head != null && this.head.data.equals((obj))){
            return removeHead();
        }

        Node<E> prev = this.head;
        Node<E> currNode = this.head.next;
        while(currNode != null){
            if(currNode.data.equals(obj)){
                if(currNode.next != null){
                    prev.next = currNode.next;
                }
                else{
                    prev.next = null;
                }
                size--;
                return true;
            }
            prev = currNode;
            currNode = currNode.next;
        }
        //no deletes made --> no objects matched or list is null
        return false;
    }

    public void remove(int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            removeHead();
            return;
        }
        Node<E> nodePrev = getNode(index - 1);
        nodePrev.next = nodePrev.next.next;
        size--;
    }

    public void set(int index, E value){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        Node<E> nodeToSet = getNode(index);
        nodeToSet.data = value;
    }

    @Override
    public String toString() {
        StringBuilder tStr= new StringBuilder("Linked List[ " +this.head.toString());
        Node<E> currentNode = this.head;
        while(currentNode.next != null){
            currentNode = currentNode.next;
            tStr.append(" --> " + currentNode.toString());
        }

        return tStr.toString() + " ]";
    }
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException(index);
        }
        return getNode(index).data;
    }

    public Node<E> getMidNode(){
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }

        Node<E> fast = head;
        Node<E> slow = head;

        //checks fast.next so that .next.next is valid
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public Node<E> reverseFromNode(Node<E> revNode){
        Node<E> prev = null;
        Node<E> curr = revNode;
        Node<E> next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public boolean isPalindrome(){
        Node<E> curr = head;
        Node<E> mid = this.reverseFromNode(this.getMidNode());

        while(curr != null){
            if(curr.data != mid.data){
                return false;
            }
            curr = curr.next;
            mid = mid.next;
        }
        return true;
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> L = new MyLinkedList<>();
        L.add(5); L.add(6); L.add(7); L.add(99); L.add(7); L.add(6); L.add(5);
        System.out.println(L);
        System.out.println(L.isPalindrome());
    }

}
