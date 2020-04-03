package fact;

import java.util.HashMap;

/*
this class has been made just for educational purposes
i write it down a simple example for DP(dynamic programming)
top-down approach which called memoization
another approach bottom-top example 8queens which called tabulation
visit at link below:
https://github.com/miladhashemzadeh/8queensUsingBackTrack
how to find when solve problems with which approach:
1.overlapping sub-problems: recompute same type of problem over and over, we can prevent. like this class
2.optimal substructure: That is, the solution to the entire problem relies on solutions to sub problems.
 */
public class Factorial {
    HashMap<Integer, Integer> mMemoizationList = new HashMap<>();

    //simple implementation
    private int fact(int number) {
        if (number == 1)
            return 1;
        return number * fact(number - 1);
    }


    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        long startNormal = System.currentTimeMillis();
        System.out.println("normal started 5 time: ");
        compute(factorial);
        compute(factorial);
        System.out.println("normal ended at: " + (System.currentTimeMillis() - startNormal));
        long startOptimized = System.currentTimeMillis();
        computeOptimize(factorial);
        computeOptimize(factorial);
        System.out.println("optimized ended 5 time: " + (System.currentTimeMillis() - startOptimized));

    }

    private static void compute(Factorial factorial) {
        System.out.println(factorial.fact(5));
        System.out.println(factorial.fact(4));
        System.out.println(factorial.fact(3));
        System.out.println(factorial.fact(2));
        System.out.println(factorial.fact(1));
    }

    private static void computeOptimize(Factorial factorial) {
        System.out.println(factorial.dpFact(5));
        System.out.println(factorial.dpFact(4));
        System.out.println(factorial.dpFact(3));
        System.out.println(factorial.dpFact(2));
        System.out.println(factorial.dpFact(1));
    }

    private int dpFact(int number) {
        if (number == 1)
            return 1;
        int i = 0;
        if (mMemoizationList.get(number) == null){
            i = number * fact(number - 1);
            mMemoizationList.put(number,i);
        }else{
            i=mMemoizationList.get(number);
        }

        return i;
    }


}
