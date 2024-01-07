package com.example.neetcode;

import java.util.*;

public class ValidSudoku {

    public static void main(String[] args) {
        //String[][] board = {{"8","3",".",".","7",".",".",".","."},{"6",".",".","1","9","5",".",".","."},{".","9","8",".",".",".",".","6","."},{"8",".",".",".","6",".",".",".","3"},{"4",".",".","8",".","3",".",".","1"},{"7",".",".",".","2",".",".",".","6"},{".","6",".",".",".",".","2","8","."},{".",".",".","4","1","9",".",".","5"},{".",".",".",".","8",".",".","7","9"}};
        String[][] board = {{"5","3",".",".","7",".",".",".","."},{"6",".",".","1","9","5",".",".","."},{".","9","8",".",".",".",".","6","."},{"8",".",".",".","6",".",".",".","3"},{"4",".",".","8",".","3",".",".","1"},{"7",".",".",".","2",".",".",".","6"},{".","6",".",".",".",".","2","8","."},{".",".",".","4","1","9",".",".","5"},{".",".",".",".","8",".",".","7","9"}};
        Map<Integer, Set<String>> rows = new HashMap<>(), cols = new HashMap<>();
        Map<String, Set<String>> square = new HashMap<>();

        String currItem = "";
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++){
                currItem = board[i][j];
                if(Objects.equals(currItem, ".")) {
                    continue;
                }

                if(rows.getOrDefault(i, new HashSet<>()).contains(currItem)
                        || cols.getOrDefault(j, new HashSet<>()).contains(currItem)
                        || square.getOrDefault(i / 3 + "#" + j / 3, new HashSet<>()).contains(currItem)
                ){
                    System.out.println(false);
                    return;
                }

                Set<String> rowSet = rows.getOrDefault(i, new HashSet<>());
                rowSet.add(currItem);
                rows.put(i, rowSet);


                Set<String> colSet = cols.getOrDefault(j, new HashSet<>());
                colSet.add(currItem);
                cols.put(j, colSet);

                Set<String> squareSet = square.getOrDefault(i/3 + "#" + j/3, new HashSet<>());
                squareSet.add(currItem);
                square.put(i/3 + "#" + j/3, squareSet);
            }
        }
        System.out.println(true);
    }

}
