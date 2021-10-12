package BinaryTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BinaryTreeIO<E> {
    public static void writeTreeToFile(BinaryTree B, String fileName) throws IOException {
        File toWrite = new File(fileName);
        toWrite.createNewFile();
        FileWriter writer = new FileWriter(toWrite, false);
        writer.write(B.toString());
        writer.close();
    }

    public static BinaryTree<String> readTreeFromFile(Scanner S) {

        if(S == null){
            //file not found
            return null;
        }

        String data = S.nextLine().trim();
        if(data.equals("null")){
            return null;
        }
        BinaryTree<String> leftTree = readTreeFromFile(S);
        BinaryTree<String> rightTree = readTreeFromFile(S);
        return new BinaryTree<String>(data, leftTree, rightTree);
    }

    public static void main(String[] args) {
        BinaryTree<Integer> BLeft = new BinaryTree<>(2);
        BLeft.root.left = new BinaryTreeNode<>(1);
        BLeft.root.right = new BinaryTreeNode<Integer>(3);

        BinaryTree<Integer> BRight = new BinaryTree<Integer>(6);
        BRight.root.left = new BinaryTreeNode<Integer>(5);
        BRight.root.right = new BinaryTreeNode<Integer>(7);

        BinaryTree<Integer> B = new BinaryTree<Integer>(4, BLeft, BRight);

        String PATH = "src/BinaryTree/";
        String fileName = "b.txt";
        try {
            writeTreeToFile(B, PATH + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner S = null;
        try {
            S = new Scanner(new File(PATH + fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BinaryTree<String> bStr = readTreeFromFile(S);
        System.out.println(bStr.getLeftSubtree());

    }
}
