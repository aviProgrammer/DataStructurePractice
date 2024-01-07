package com.example.neetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        int maxLength = 0, currLength = 0;
        Set<Integer> numSet = new HashSet<Integer>(Arrays.stream(nums).boxed().collect(Collectors.toList()));

        for(int num : nums) {
            currLength = 1;
            if(numSet.contains(num-1))
                continue;

            while(numSet.contains(++num)){
                currLength++;
            }

            if(maxLength < currLength) {
                maxLength = currLength;
            }
        }

        System.out.println(maxLength);;
    }
}
