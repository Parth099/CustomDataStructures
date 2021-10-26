package BinaryTree;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearchTree<E extends Comparable> extends BinaryTree<E> implements SearchTree<E>{

    //rewrite to enforce OOP

    protected boolean addReturn = false;
    protected E deleteReturn = null;

    public BinarySearchTree(){

    }
    public BinarySearchTree(E initItem){
        super(initItem);
    }


    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean add(E item) {
        root = add(root, item);
        return addReturn;
    }

    private BinaryTreeNode<E> add(BinaryTreeNode<E> subtree, E item){
        if(subtree == null){
            return new BinaryTreeNode<E>(item);
        }
        //avoids null.compareTo
        int compResult = subtree.data.compareTo(item);
        if(compResult == 0){
            addReturn = false;
            return subtree;
        }
        else if(compResult > 0){
            //tree item is larger than insertion point
            subtree.left = add(subtree.left, item);
            return subtree;
        }
        else{
            //tree item is not equal or larger or equal so split right.
            subtree.right = add(subtree.right, item);
            return subtree;
        }
    }

    @Override
    public boolean contains(E item) {
        return this.find(item) != null;
    }

    @Override
    public E find(E item) {
        return find(this.root, item);
    }

    private E find(BinaryTreeNode<E> localRoot, E item){
        //leaf/null node implies item will not exist
        if(localRoot == null){
            return null;
        }


        int compRes = localRoot.data.compareTo(item);

        if(compRes == 0){
            return localRoot.data;
        }

        //tree node is smaller than what is required
        else if(compRes > 0)
            return find(localRoot.left, item);
        else
            return find(localRoot.right, item);
    }

    @Override
    public E delete(E item) {
        root = delete(root, item);
        return deleteReturn;
    }

    public BinaryTreeNode<E> delete(BinaryTreeNode<E> localRoot, E item){
        if(localRoot == null){
            deleteReturn = null;
            return localRoot; //object not found
        }
        int compRes = item.compareTo(localRoot.data);
        if(compRes < 0){
            System.out.println("T: left");
            localRoot.left = delete(localRoot.left, item);
            return localRoot;
        }
        else if(compRes > 0){
            System.out.println("T: right");
            localRoot.right = delete(localRoot.right, item);
            return localRoot;
        }
        else{
            //node found;
            //if a node has 0 or 1 child the method is the same; //0 - leaf has nothing below
            //delete the node and set it to the node chain below.

            deleteReturn = localRoot.data;


            if(localRoot.left == null){
                return localRoot.right;
            }
            else if(localRoot.right == null){
                return localRoot.left;
            }
            else {
                //there node has 2 children
                //2 case algorithm:
                //EXP: get largest element on the left subtree on that node for node replacement || smallest element on right tree
                //      overwrite the data on the deletion node with replacement and then delete old replacement
                if(localRoot.left.right == null){
                    localRoot.data = localRoot.left.data;
                    localRoot.left = localRoot.left.left;
                    return localRoot;
                }
                localRoot.data = getMax(localRoot.left); //notice that since we know there exists 2 children we can go left
                return localRoot;
            }

        }
    }
    public E getMax(BinaryTreeNode<E> BST){
        if(BST == null){
            return null;
        }
        BinaryTreeNode<E> curr = BST;
        BinaryTreeNode<E> prev = curr;
        while(curr.right != null){
            prev = curr;
            curr = curr.right;
        }
        E data = curr.data;
        prev.right = null;
        return data;
    }

    @Override
    public boolean remove(E item) {
        return false;
    }

    public static void main(String[] args) {
        BinarySearchTree<Character> BST = new BinarySearchTree<Character>();
        ArrayList<Character> insertToTree = new ArrayList<Character>(Arrays.asList(new Character[]{'G', 'O', 'K', 'R', 'B', 'C', 'E'}));
        for(Character k: insertToTree){
            BST.add(k);
        }
        System.out.println(BST);
    }
}
