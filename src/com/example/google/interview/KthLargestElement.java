package com.example.google.interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {

    private PriorityQueue<Integer> min;
    private int k;

    public KthLargestElement(Integer arr[], int k) {
        min = new PriorityQueue<>(k);

        //form the min heap with the last k elements of the sorted array
        for (int i = arr.length - k; i < arr.length; i++) {
            min.add(arr[i]);
        }
        this.k = k;
    }

    public int addToStream(int i) {

        //if the minheap is not full yet then return the current min valu
        if (min.size() < this.k)
            return min.peek();

        //if the new element is less than the current kth largest element then no effect
        if (min.peek() > i) {
            return min.peek();
        } else {  // else add the nes element into min-heap and return new kth largest elem
            min.poll();
            min.add(i);
            return min.peek();
        }
    }

    public static void main(String[] args) {
        // if the input array is not sorted then sort it first before passing to the constructor
        Integer[] input = {8, 20, 21, 32, 45, 76};
        KthLargestElement kl = new KthLargestElement(input, 3);

        System.out.println(kl.addToStream(2));
        System.out.println(kl.addToStream(56));
    }

}
