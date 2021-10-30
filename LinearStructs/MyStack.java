package LinearStructs;

import java.util.NoSuchElementException;

public class MyStack<E> implements CustomStackReq<E> {

    private Node<E> head = null;
    public MyStack(){

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

        public Node(E data, Node<E> nextNode){
            this.data = data;
            this.next = nextNode;
        }

        @Override
        public String toString() {
            return this.data.toString();
        }
    }

    @Override
    public void push(E item) {
        if(this.isEmpty()) {
            head = new Node<E>(item);
        }
        else{
            head = new Node<E>(item, head);
        }
    }

    @Override
    public E pop() {
        if(this.isEmpty()){
            throw new NoSuchElementException();
        }
        E itemDeleted = head.data;
        head = head.next;
        return itemDeleted;
    }

    @Override
    public String toString() {
        StringBuilder retS = new StringBuilder("[ ");
        Node<E> nodeRef = head;
        while(nodeRef != null){
            retS.append(nodeRef.toString() + " -> ");
            nodeRef = nodeRef.next;
        }
        retS.append(" ]");
        return retS.toString();
    }

    @Override
    public E peek() {
        if(this.isEmpty()){
            return null;
        }
        return head.data;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
}
