import java.util.*;

public class DataTest {
    public DataTest(){

    }
    String mtd(){
        return "ABC";
    }
    public static boolean endWith(LinkedList<Integer> list1, LinkedList<Integer> list2){
        if(list1.size() < list2.size()){
            return false;
        }
        if(list1.isEmpty()){
            return false;
        }
        //loops backward over List2
        for(int i = list2.size() - 1; i > -1; i--){
            //gets the element from the back of the list to compare
            if(!list1.get(list1.size() - list2.size() + i).equals(list2.get(i))){
                return false;
            }
        }
    return true;
    }
    public static Stack<Integer> changeStack(Stack<Integer> stackIn){
        Stack<Integer> S = new Stack<>();
        //O(n) space complexity
        //O(n) time comp too
        ArrayList<Integer> swapSpace = new ArrayList<>();
        while(!stackIn.isEmpty()){
            swapSpace.add(stackIn.pop());
        }
        Integer temp;
        int swapIDX;

        //gets correct order of elements
        for(int i = 0; i < swapSpace.size() / 2; i++){
            swapIDX = swapSpace.size() - (swapSpace.size()/2 - i); //exploits int div
            temp = swapSpace.get(i);
            swapSpace.set(i, swapSpace.get(swapIDX));
            swapSpace.set(swapIDX, temp);
        }
        //inserts rev since push adds to top
        for(int i = swapSpace.size() - 1; i > -1; i--){
            S.push(swapSpace.get(i));
        }
        return S;
    }


    public static void main(String[] args) {
        DataTest d = new DataTest();
        System.out.println(d.mtd());
    }
}
