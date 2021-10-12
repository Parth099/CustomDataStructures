package Lambda;

import java.util.function.BinaryOperator;
import java.util.function.Function;

public class LambdaTest {
    public static void main(String[] args) {
        //Cab is the FuncInterface
        FuncITF L = (int i) -> {
            System.out.println("Lambda i: "+ i);
            return i * i * i;
        };
        int cube = L.cube(55);
        System.out.println("Cube: "+cube);

        //BiConsumer
        BinaryOperator<Integer> mult = (Integer i, Integer j) -> {return i * j;};
        System.out.println(mult.apply(14, 14));

        //USING MATH FUNCTIONS
        //BARBARIC
        /*
        Function<Integer, Double> Fcos = (angle) -> {
            return Math.cos(Math.toRadians(angle));
        };
        showStep(0, 360, 30, Fcos);
         */


        //arg[-1] is a lambda
        showStep(0, 360, 30, angle -> Math.sin(Math.toRadians(angle)));

    }
    public static void showStep(int start, int end, int step, Function<Integer, Double> F){
        for(int i = start; i < end + 1; i += step){
            System.out.printf("F(%d): %f\n", i, F.apply(i));
        }
    }


    //NOTES
    //Like arrow functions in JS for Functional Prog
    //  anon function, that does not have a name
    //
    //Functional Interface
    //  Contains 1 ABS method
}
