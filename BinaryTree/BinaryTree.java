package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree<E> {
    protected BinaryTreeNode root;

    public BinaryTree(){
    }

    public BinaryTree(E initData){
        root = new BinaryTreeNode(initData);
    }

    public BinaryTree(BinaryTreeNode<E> root){
        this.root = root;
    }
    public BinaryTree(E root, BinaryTree<E> tLeft, BinaryTree<E> tRight){
        if(root == null){
            throw new RuntimeException();
        }
        this.root = new BinaryTreeNode(root);
        if(tLeft != null){
            this.root.left = tLeft.root;
        }
        if(tRight != null) {
            this.root.right = tRight.root;
        }
    }

    @Override
    public String toString() {
        StringBuilder SB = new StringBuilder();
        recurToSTR(root,1, SB);
        return SB.toString();
    }

    private void recurToSTR(BinaryTreeNode<E> root, int depth, StringBuilder SB){
        for(int i = 0; i < depth - 1; i++){
            SB.append(" ");
        }
        if (root == null){
            SB.append("null\n");
        }
        else{
            SB.append(root.toString());
            SB.append('\n');
            recurToSTR(root.left, depth+1, SB);
            recurToSTR(root.right, depth+1, SB);
        }
    }

    //subtree callers
    public BinaryTree<E> getLeftSubtree(){
        return new BinaryTree<E>(root.left);
    }

    public BinaryTree<E> getRightSubtree(){
        return new BinaryTree<E>(root.right);
    }

    public List<E> inOrderTraversal(){
        //O(n) time, O(n) Space
        //Pro: Does not flood call stack
        //Con: O(n) Space
        Stack<BinaryTreeNode> nodeStack = new Stack<BinaryTreeNode>();
        List<E> inOrderList = new ArrayList<>();
        BinaryTreeNode<E> curr = this.root;

        while(curr != null || !nodeStack.isEmpty()) {

            //goes as far left as possible
            while(curr != null){
                nodeStack.push(curr);
                curr = curr.left;
            }

            //backtracks and sets up new path to go back on
            curr = nodeStack.pop();
            inOrderList.add(curr.data);
            curr = curr.right;
        }
        return inOrderList;
        // Think of it as a iter version on the recursive algo:
        // It goes down to the lowest left node and does iot(subtree)
    }


    public static void main(String[] args) {
        BinaryTree<Integer> BLeft = new BinaryTree<Integer>(2);
        BLeft.root.left = new BinaryTreeNode<Integer>(1);
        BLeft.root.right = new BinaryTreeNode<Integer>(3);

        BinaryTree<Integer> BRight = new BinaryTree<Integer>(6);
        BRight.root.left = new BinaryTreeNode<Integer>(5);
        BRight.root.right = new BinaryTreeNode<Integer>(7);

        BinaryTree<Integer> B = new BinaryTree<Integer>(4, BLeft, BRight);
        System.out.println(B.getRightSubtree());
        System.out.println(B.inOrderTraversal());

    }
}
