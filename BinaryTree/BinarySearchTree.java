package BinaryTree;

public class BinarySearchTree<E extends Comparable> extends BinaryTree<E> implements SearchTree<E>{

    //rewrite to enforce OOP

    protected boolean addReturn = false;
    protected E deleteReturn = null;
    protected BinaryTree<E> bst;

    public BinarySearchTree(){

    }

    public BinarySearchTree(E item){
        bst = new BinaryTree<E>(item);
    }

    @Override
    public String toString() {
        if(bst == null) return "null";
        return bst.toString();
    }

    @Override
    public boolean add(E item) {
        if(bst == null){
            bst = new BinaryTree<E>(item);
            return true;
        }
        return add(bst.root, item);
    }

    private boolean add(BinaryTreeNode<E> subtree, E item){
        int compRes = subtree.data.compareTo(item);


        if(compRes == 0){
            return false; //no dupes in BST;
        }

        boolean compResultBool = compRes > 0;

        if(compResultBool && subtree.left != null) {
            return add(subtree.left, item);
        }
        else if(!compResultBool && subtree.right != null) {
            return add(subtree.right, item);
        }

        else if(compResultBool) {
            subtree.left = new BinaryTreeNode<E>(item);
            return true;
        }
        else if(!compResultBool) {
            subtree.right = new BinaryTreeNode<E>(item);
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(E item) {
        return false;
    }

    @Override
    public E find(E item) {
        return null;
    }

    @Override
    public E delete(E item) {
        return null;
    }

    @Override
    public boolean remove(E item) {
        return false;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> BST = new BinarySearchTree<Integer>();
        BST.add(4);

        BST.add(2);
        BST.add(3);
        BST.add(1);

        BST.add(6);
        BST.add(7);
        BST.add(5);

        BST = new BinarySearchTree<Integer>();
        for(int i = 8; i > 0; i--){
            BST.add(i);
        }
        System.out.println(BST);
    }
}
