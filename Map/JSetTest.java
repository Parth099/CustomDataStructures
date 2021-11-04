package Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class JSetTest {
    public static void main(String[] args) {

        //uses hash function to check existence
        Set<Integer> intSet = new HashSet<Integer>();
        for(Integer i: new Integer[]{1, 4, 9, 16, 25, 36, 49, 64, 36}){
            intSet.add(i);
        }
        //like Math Set dupes cannot exist
        //System.out.println(intSet);

        //memberShip Test
        System.out.println("Contains 16? "+intSet.contains(16));

        //SubSet SetB of intSet
        Set<Integer> pow2 = new HashSet<>(Arrays.asList(new Integer[]{1, 4, 16, 64}));//SetB
        System.out.println("intSet SuperSet of SetB: "+intSet.containsAll(pow2));

        //union
        pow2 = new HashSet<>(Arrays.asList(new Integer[]{1, 4, 16, 64, 128, 256, 512, 1024}));
        Set<Integer> setOP = new HashSet<>(intSet);
        setOP.addAll(pow2);
        System.out.println("After Union: "+setOP);


        //intersection
        setOP = new HashSet<>(intSet);
        setOP.retainAll(pow2);
        System.out.println("After Intersection "+ setOP);

        //set diff
        setOP = new HashSet<>(intSet);
        setOP.removeAll(pow2);
        System.out.println("After Diff "+setOP);



    }
}
