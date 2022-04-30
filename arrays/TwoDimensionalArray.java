package arrays;

public class TwoDimensionalArray {

    public int[][] arr;
    int rows;
    int columns;

    public TwoDimensionalArray(int r, int c) {
        rows = r;
        columns = c;
        arr = new int[rows][columns];
        for (int i=0;i<rows;i++) {
            for (int j=0;j<columns; j++) {
                arr[i][j] = Integer.MIN_VALUE;
            }
        }
    }

    public TwoDimensionalArray(int r, int c, int init) {
        rows = r;
        columns = c;
        arr = new int[rows][columns];
        for (int i=0;i<rows;i++) {
            for (int j=0;j<columns; j++) {
                arr[i][j] = init;
            }
        }
    }

    public void set(int i, int j, int val) {
        try {
            if(arr[i][j]!=Integer.MIN_VALUE) {
                System.out.println("Given index is already occupied");
                return;
            }
            arr[i][j] = val;
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Given Index ("+ i + "," + j +") is out  of bounds");
        }
    }

    public int get(int i, int j) {
        return arr[i][j];
    }

    public void delete(int i, int j) {
        arr[i][j] = Integer.MIN_VALUE;
    }

    public void traverse() {
        System.out.println("Traversing 2D Array: ");
        for(int i=0; i<arr.length; i++) {
            for(int j=0;j< arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public OrderedPair search(int val) {
        for(int i=0; i<rows; i++) {
            for(int j=0;j< columns; j++) {
                if(arr[i][j]==val) {
                    return new OrderedPair(i, j);
                }
            }
        }
        return new OrderedPair(-1, -1);
    }

}