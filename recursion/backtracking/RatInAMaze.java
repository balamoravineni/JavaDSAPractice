package recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class RatInAMaze {
  public static void main(String args[]) {
    
    int n = 4;
    int[][] matrix = {{1, 0, 0, 0},
                      {1, 1, 0, 1},
                      {1, 1, 0, 0},
                      {0, 1, 1, 1}};
    System.out.println("Input: " + n);
    for(int i=0;i<n;i++) {
      for(int j=0;j<n;j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println("Output: ");
    List<String> ans = new ArrayList<>();
    boolean visited[][] = new boolean[n][n];
    if(matrix[0][0]==1) {
      visited[0][0] = true; // important to mark initial posistion also, as visited
      solveRatmaze(matrix, 0, 0, visited, new ArrayList<>(), ans);
      // solveRatmazeOptimized(matrix, 0, 0, visited, new ArrayList<>(), ans);
    }
    // System.out.println(visited);
    System.out.println(ans);
  }

  static String direction = "DLRU";
  // change in x or y in above directions
  static int[] iArr = { 1, 0, 0, -1 };
  static int[] jArr = { 0, -1, 1, 0 };

  //optimized code length
  public static void solveRatmazeOptimized(int[][] matrix, int i, int j, boolean[][] visited, List<Character> path, List<String> ans) {
    if(i==matrix.length-1 && j==matrix.length-1) {
      StringBuilder pathString = new StringBuilder();
      path.stream().forEach(el -> pathString.append(el));
      ans.add(new String(pathString));
      return;
    }
    // if not visited only, move up/down/right/left
    for(int ind=0;ind<4;ind++) {
      int nextI = i+iArr[ind];
      int nextJ = j+jArr[ind];
      if(nextI>=0 && nextI<matrix.length &&
          nextJ>=0 && nextJ<matrix.length && 
          !visited[nextI][nextJ] && matrix[nextI][nextJ]==1) {
            path.add(direction.charAt(ind));
            visited[nextI][nextJ] = true;
            solveRatmaze(matrix, nextI, nextJ, visited, path, ans);
            path.remove(path.size()-1);
            visited[nextI][nextJ] = false;
      }
    }
  }


  public static void solveRatmaze(int[][] matrix, int i, int j, boolean[][] visited, List<Character> path, List<String> ans) {
    if(i==matrix.length-1 && j==matrix.length-1) {
      StringBuilder pathString = new StringBuilder();
      path.stream().forEach(el -> pathString.append(el));
      ans.add(new String(pathString));
      return;
    }
    // if not visited only, move up/down/right/left
    // move down
    if(i+1<=matrix.length-1 && matrix[i+1][j]==1 && !visited[i+1][j]) {
      path.add('D');
      visited[i+1][j] = true;
      solveRatmaze(matrix, i+1, j, visited, path, ans);
      path.remove(path.size()-1);
      visited[i+1][j] = false;
    }
    // move left
    if(j-1>=0 && matrix[i][j-1]==1 && !visited[i][j-1]) {
      path.add('L');
      visited[i][j-1] = true;
      solveRatmaze(matrix, i, j-1, visited, path, ans);
      path.remove(path.size()-1);
      visited[i][j-1] = true;
    }
    // move right
    if(j+1<=matrix.length-1 && matrix[i][j+1]==1 && !visited[i][j+1]) {
      path.add('R');
      visited[i][j+1] = true;
      solveRatmaze(matrix, i, j+1, visited, path, ans);
      path.remove(path.size()-1);
      visited[i][j+1] = false;
    }
    // move up
    if(i-1>=0 && matrix[i-1][j]==1 && !visited[i-1][j]) {
      path.add('U');
      visited[i-1][j] = true;
      solveRatmaze(matrix, i-1, j, visited, path, ans);
      path.remove(path.size()-1);
      visited[i-1][j] = false;
    }
  }

}
