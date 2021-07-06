package com.example.google.interview;

import java.util.HashSet;
import java.util.Set;

public class SumOfTwoValues {

    private boolean sumOfTwoVals(int[] array, int x) {
        Set<Integer> complements = new HashSet<>();
        if(array != null && array.length < 1)
            return false;

        for (int c: array) {
            if(complements.contains(x-c))
                return true;

            complements.add(c);
        }
        return false;
    }


    public static void main(String[] args) {
        int[] inputArr = {6, 2, 5, 10, -3, 15};

        SumOfTwoValues sum = new SumOfTwoValues();
        System.out.println(sum.sumOfTwoVals(inputArr, -1));
    }
}
