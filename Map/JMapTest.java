package Map;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class JMapTest {
    public static void main(String[] args) {
        Map<Integer, Integer> M = new HashMap<>();
        for(int i = 1; i < 11; i++){
            M.put(i, i * 10);
        }

        //iter v1 !!
//        Iterator<Map.Entry<Integer, Integer>> IterB = M.entrySet().iterator();
//        Map.Entry<Integer, Integer> temp;
//        while(IterB.hasNext()){
//            temp = IterB.next();
//            System.out.println("key: "+temp.getKey()+" --> Val: "+temp.getValue());
//        }
//
//        //iter v2 !! //BETTER
//        for(Map.Entry<Integer, Integer> entry: M.entrySet()){
//            System.out.println("key: "+entry.getKey()+" --> Val: "+entry.getValue());
//        }

        //over entries

        //functional prog
        BiConsumer<Integer, Integer> F = (a, b) -> {
            System.out.println("K: "+a+", V: "+b);
        };

        Function<Integer, Integer> COMP_ABS = (x) -> {
            return x * 2;
        };

        for(int i = 5; i < 13; i++){
            M.computeIfAbsent(i, COMP_ABS);
            if((i & 1) == 0){
                M.computeIfPresent(i, (x, y) -> {return x * 1000;});
            }
        }
        //print via function
        M.forEach((a, b) -> {
            System.out.println("K: "+a+", V: "+b);
        });
    }
}
