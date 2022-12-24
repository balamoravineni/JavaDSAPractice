package recursion.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Sudoku {
  public static void main(String args[]) {
    
    char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                      {'6','.','.','1','9','5','.','.','.'},
                      {'.','9','8','.','.','.','.','6','.'},
                      {'8','.','.','.','6','.','.','.','3'},
                      {'4','.','.','8','.','3','.','.','1'},
                      {'7','.','.','.','2','.','.','.','6'},
                      {'.','6','.','.','.','.','2','8','.'},
                      {'.','.','.','4','1','9','.','.','5'},
                      {'.','.','.','.','8','.','.','7','9'}};
    System.out.println("Input: ");
    for(int row=0;row<9;row++) {
      for(int col=0;col<9;col++) {
          System.out.print(board[row][col] + " ");
      }
      System.out.println();
  }
    System.out.println("Output: ");
    solveSudoku(board);
  }

  public static void solveSudoku(char[][] board) {
    Map<Integer, Set<Character>> rowsMap = new HashMap<>();
    Map<Integer, Set<Character>> columnsMap = new HashMap<>();
    Map<Integer, Set<Character>> boxesMap = new HashMap<>();
    List<Integer> rowIndexes = new ArrayList<>();
    List<Integer> columnIndexes = new ArrayList<>();
    for(Integer i=0; i<9;i++) {
        rowsMap.put(i, new HashSet<>());
        columnsMap.put(i, new HashSet<>());
        boxesMap.put(i, new HashSet<>());
    }
    for(int row=0;row<9;row++) {
        for(int col=0;col<9;col++) {
            if(board[row][col]!='.') {
                rowsMap.get(row).add(board[row][col]);
                columnsMap.get(col).add(board[row][col]);
                int boxKey = (3*(row/3)) + (col/3);
                boxesMap.get(boxKey).add(board[row][col]);
            }
            else {
                rowIndexes.add(row);
                columnIndexes.add(col);
            }
        }
    }
    // System.out.println("Number of empty cells: "+ rowIndexes.size() + ", " + columnIndexes.size());
    // System.out.println("rowsMap: " + rowsMap);
    // System.out.println("columnsMap: "+ columnsMap);
    // System.out.println("boxesMap: "+ boxesMap);

    char[][] ans = new char[9][9];
    solveRecursively(board, 0, rowIndexes, columnIndexes, rowsMap, columnsMap, boxesMap, ans);
    for(int row=0;row<9;row++) {
        for(int col=0;col<9;col++) {
            System.out.print(ans[row][col] + " ");
        }
        System.out.println();
    }
}


public static void solveRecursively(char[][] board, int index, List<Integer> rowIndexes, List<Integer> columnIndexes,
                    Map<Integer, Set<Character>> rowsMap,
                    Map<Integer, Set<Character>> columnsMap,
                    Map<Integer, Set<Character>> boxesMap,
                    char[][] ans) {
    if(index>=rowIndexes.size()) {
        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                // System.out.print(board[i][j]);
                ans[i][j] = board[i][j];
            }
            // System.out.println();
        }
        return;
    }

    int row = rowIndexes.get(index);
    int col = columnIndexes.get(index);
    int boxKey = (3*(row/3)) + (col/3);
    for(char i='1';i<='9';i++) {
        if(!rowsMap.get(row).contains(i) &&
            !columnsMap.get(col).contains(i) &&
            !boxesMap.get(boxKey).contains(i)){
            // add into maps 
            rowsMap.get(row).add(i);
            columnsMap.get(col).add(i);
            boxesMap.get(boxKey).add(i);

            board[row][col] = i;
            solveRecursively(board, index+1, rowIndexes, columnIndexes, rowsMap, columnsMap, boxesMap, ans);

            // remove from maps
            board[row][col] = '.';
            rowsMap.get(row).remove(i);
            columnsMap.get(col).remove(i);
            boxesMap.get(boxKey).remove(i);
        }
    }
}

}