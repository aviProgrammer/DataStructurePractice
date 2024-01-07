package com.example.neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeString {
    public static void main(String[] args) {
        EncodeDecodeString solution = new EncodeDecodeString();
        String encoded = solution.encode(Arrays.asList("neet","code","love","you"));
        System.out.println(encoded);

        List<String> decoded = solution.decode(encoded);
        System.out.println(decoded);
    }

    public String encode(List<String> strs) {
        StringBuilder output = new StringBuilder();
        for(String s : strs) {
            output.append(s.length() + "#" + s);
        }
        return output.toString();
    }

    public List<String> decode(String str) {
        List<String> output = new ArrayList<>();
        char[] chars = str.toCharArray();
        int length = 0, j = 0;
        for(int i = 0; i < chars.length;) {
            j = i;
            while(chars[j] != '#'){
                j++;
            }
            length = Integer.parseInt(str.substring(i, j));

            output.add(str.substring(j+1, j + length + 1));

            i = j + length + 1;
        }

        return output;
    }
}
