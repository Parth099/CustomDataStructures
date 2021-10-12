package BinaryTree;

public class BinaryTreeNode<E>{
    E data;
    BinaryTreeNode<E> left;
    BinaryTreeNode<E> right;

    public BinaryTreeNode(){

    }

    public BinaryTreeNode(E data){
        this.data = data;
    }

    public BinaryTreeNode(E data, BinaryTreeNode<E> left, BinaryTreeNode<E> right){
        this.data = data;
        this.left = left;
        this.right = right;
    }

    protected boolean isLeaf(){
        if(this.left == null && this.right == null){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if(data == null){
            return "null";
        }
        return data.toString();
    }
}
