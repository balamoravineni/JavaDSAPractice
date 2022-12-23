package recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
  public static void main(String args[]) {
    
    int n = 4;
    System.out.println("Input: "+ n);
    // output chessboard positions in the form of ["Q...", ".Q..", "..Q.", "...Q"] -> just an example representation
    System.out.println("Output: ");
    char[] charArr = new char[n];
    for(int i=0; i<n;i++) {
      charArr[i] = '.';
    }
    List<StringBuilder> board = new ArrayList<>();
    for(int i=0; i<n;i++) {
      board.add(new StringBuilder(new String(charArr)));
    }
    // System.out.println(board);
    List<List<String>> ans = new ArrayList<>();
    // solveNQueens(board, 0, ans);

    
    // we can optimize isPlacingQueenSafe login by using hashing
    boolean[] leftDirection = new boolean[n]; // if row is occupied, then we cannot place Queen in that row
    boolean[] leftLowerDiagnolDirection = new boolean[2*n-1]; // if row + col is occupied, then we cannot place in that diagnol
    boolean[] leftUpperDiagnolDirection = new boolean[2*n-1]; // if (n-1 + row-col) is occupied, then we cannot place in that diagnol
    solveNQueensOptimized(board, 0, ans, leftDirection, leftLowerDiagnolDirection, leftUpperDiagnolDirection);
    System.out.println(ans);
  }

  public static void solveNQueensOptimized(List<StringBuilder> board, int col, List<List<String>> ans,
                      boolean[] leftDirection, boolean[] leftLowerDiagnolDirection, boolean[] leftUpperDiagnolDirection) {
    if(col==board.size()) {
      List<String> temp = new ArrayList<>();
      board.stream().forEach(str -> temp.add(new String(str)));
      ans.add(temp);
      // System.out.println(board);
      return;
    }
    for(int row=0;row<board.size();row++) {
      if(!leftDirection[row] && 
          !leftLowerDiagnolDirection[row+col] && 
          !leftUpperDiagnolDirection[board.size()-1+row-col]) {
        leftDirection[row] = true;
        leftLowerDiagnolDirection[row+col] = true;
        leftUpperDiagnolDirection[board.size()-1+row-col] = true;
        board.get(row).setCharAt(col, 'Q');
        solveNQueens(board, col+1, ans);
        leftDirection[row] = false;
        leftLowerDiagnolDirection[row+col] = false;
        leftUpperDiagnolDirection[board.size()-1+row-col] = false;
        board.get(row).setCharAt(col, '.');
      }
    }
  }

  public static void solveNQueens(List<StringBuilder> board, int col, List<List<String>> ans) {
    if(col==board.size()) {
      List<String> temp = new ArrayList<>();
      board.stream().forEach(str -> temp.add(new String(str)));
      ans.add(temp);
      // System.out.println(board);
      return;
    }
    for(int row=0;row<board.size();row++) {
      if(isPlacingQueenSafe(row, col, board)) {
        board.get(row).setCharAt(col, 'Q');
        solveNQueens(board, col+1, ans);
        board.get(row).setCharAt(col, '.');
      }
    }
  }

  public static boolean isPlacingQueenSafe(int row, int col, List<StringBuilder> board) {
    int rowCopy = row;
    int colCopy = col;
    // placing queen is safe only if there are no queens present in left upper direction, left direction, left lower direction
    row--; col--;
    while(row>=0 && col>=0) {
      if(board.get(row).charAt(col)=='Q') {
        return false;
      }
      row--; col--;
    }

    row = rowCopy;
    col = colCopy;
    col--;
    while(col>=0) {
      if(board.get(row).charAt(col)=='Q') {
        return false;
      }
      col--;
    }

    row = rowCopy;
    col = colCopy;
    col--;
    row++;
    while(col>=0 && row<board.size()) {
      if(board.get(row).charAt(col)=='Q') {
        return false;
      }
      col--;row++;
    }

    return true;
  }

}
