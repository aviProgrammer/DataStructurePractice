package com.example.google.interview;

import java.util.Arrays;

public class KClosest {

    private int findCrossOver(int[] arr, int start, int end, int x) {
        if(arr.length < 1) return 0;
        if(start < 0) return 0;
        if(end > arr.length) return 0;

        int mid = (start + end) / 2;

        if(arr[mid] == x) return mid;

        if(arr[mid] < x)
            return findCrossOver(arr, mid + 1, end, x);
        if (arr[mid] > x)
            return findCrossOver(arr, start, mid, x);
        return 0;
    }

    public int[] findKClosest(int[] arr, int x, int k) {
        int[] output = new int[k];
        int co = findCrossOver(arr, 0, arr.length, x);
        int closestKItemCount = 0;

        int l = co-1;
        int r = co+1;

        //Loop till it reaches either end of the array or if finds k closest elements
        while(l > 0 && r < arr.length && closestKItemCount < k) {
            if((arr[co] - arr[l]) <= (arr[r] - arr[co])) {
                output[closestKItemCount] = arr[l];
                closestKItemCount++;
                l--;
            } else {
                output[closestKItemCount] = arr[r];
                closestKItemCount++;
                r++;
            }
        }

        // if not all k closest items are found yet but it reached the end of the array
        while(l > 0 && closestKItemCount < k) {
            output[closestKItemCount] = arr[l];
            closestKItemCount++;
            l--;
        }

        // if not all k closest items are found yet but it reached the start of the array
        while(r < arr.length && closestKItemCount < k) {
            output[closestKItemCount] = arr[r];
            closestKItemCount++;
            r++;
        }
        return output;
    }

    public static void main(String[] args) {
        int[] inpurArr = {12, 15, 17, 21, 25, 31, 35, 41, 47, 56, 58};
        KClosest cl = new KClosest();
        System.out.println(Arrays.toString(cl.findKClosest(inpurArr, 35, 4)));
    }
}
