public class backtracking {

    public static void changeArr(int arr[], int i, int val) {
        //base case
        if( i == arr.length){
            printArr(arr);
            return;
        }

        //recursion
        arr[i] = val;
        changeArr(arr, i+1, val+1); //fnc call step
        arr[i] = arr[i] - 2;    //backtrack step
    }

    public static void printArr(int arr[]) {
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void subSets(String str, String ans, int i){
        //base case
        if(i== str.length()){
            System.out.println(ans);
            return;
        }


        //recursion
        //yes choice
        subSets(str, ans+str.charAt(i), i+1);
        //no choice
        subSets(str, ans, i+1);
    }

    public static void permutation(String str, String ans){
        //base case
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }


        //recursion
        //yes choice
        for(int i=0; i<str.length(); i++){
            char curr = str.charAt(i);
            //"abcde" => "ab" + "de" = "abde"
            String Newstr = str.substring(0, i)+ str.substring(i+1);
            permutation(Newstr, ans+curr);
        }
    }

    public static boolean isSafe(char board[][], int row, int col){
        //vertical up
        for(int i=row-1; i>=0; i--){
            if(board[i][col] == 'Q')
                return false;
        }
        //left up diagonal
        for(int i=row-1, j=col-1; i>=0  && j>=0; i--, j--){
            if(board[i][j] == 'Q')
                return false;
        }
        //right up digonal
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i-- , j++){
            if(board[i][j] == 'Q')
                return false;
        }
        return true;
    }

    public static void Nqueens(char board[][], int row){
        
        //base 
        if(row == board.length){
            printBoard(board);
            count++;
            return;
        }

        //recursion column loop
        for(int j=0; j<board.length; j++){
            if(isSafe(board,row,j)){
                board[row][j] = 'Q';
                Nqueens(board, row+1); //function call
                board[row][j] = 'x';    //backtracking step
            }
        }
    }

    public static boolean nQueens(char board[][], int row){
        
        //base 
        if(row == board.length){
            printBoard(board);
            count++;
            return true;
        }

        //recursion column loop
        for(int j=0; j<board.length; j++){
            if(isSafe(board,row,j)){
                board[row][j] = 'Q';
                if (nQueens(board, row+1)){ //function call
                    return true;
                }; 
                board[row][j] = 'x';    //backtracking step
            }
        }
        return false;
    }

    public static void printBoard(char board[][]) {

        System.out.println("------Chess Board -----");
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void print2DArr(int board[][]) {

        System.out.println("------  -----");
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printsudoku(int s[][]) {

        System.out.println("  __   __   __   __   __   __   __   __   __");
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.print("| " + s[i][j] + " " + "|");
            }
            System.out.println();
        }
    }

    public static int gridWays(int i, int j, int n, int m) {

        //base case
        if(i == n-1 && j == m-1){
            return 1;
        }
        else if ( i == n || j==n){
            return 0;
        }

        int w1 = gridWays(i, j+1, n, m);
        int w2 = gridWays(i+1, j, n, m);

        return w1 + w2;
    }

    public static boolean isSuSafe(int sudoku[][], int row, int col, int digit){
        //column
        for(int i=0; i<9; i++){
            if(sudoku[i][col] == digit){
                return false;
            }
        }
        //row
        for(int j=0; j<9; j++){
            if(sudoku[row][j] == digit){
                return false;
            }
        }

        //grid
        int sr = (row/3)* 3;
        int sc = (col/3)* 3;
        for(int i=sr; i<sr+3; i++){
            for(int j=sc; j<sc+3; j++){
                if(sudoku[i][j]==digit){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean sudokuSolver(int sudoku[][], int row, int col) {
        //base case
        if(row == 9){
            return true;
        }

        //recursion
        int nextRow = row, nextCol = col+1;
        if(col+1 == 9){
            nextRow = row+1;
            nextCol = 0;
        }

        if(sudoku[row][col] != 0){
            return sudokuSolver(sudoku, nextRow, nextCol);
        }
        for(int digit = 1; digit<=9; digit++){
            if(isSuSafe(sudoku,row,col,digit)){
                sudoku[row][col] = digit;
                if(sudokuSolver(sudoku, nextRow, nextCol)){
                    return true; //solution exists
                };
                sudoku[row][col] = 0;
            }
        }
        return false;
    }

    static int count =0;

    public static void main(String[] args) {
        int arr[] = new int[5];
        changeArr(arr, 0, 1);
        printArr(arr);
        String str = "abc";
        subSets(str, "", 0);
        permutation(str, "");

        int n=4;
        char board[][] = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = 'x';
            }
        };
        // Nqueens(board, 0);
        // System.out.println("Total ways to NQueens :" + count);

        if(nQueens(board, 0)){
            System.out.println("Solution is possible");
            printBoard(board);
        }else{
            System.out.println("Solution is not possible");
        };

        int g = 3, w =3;
        System.out.println(gridWays(0,0,g,w));

        //sudoku
        int sudoku[][] = {
            {0,0,8,0,0,0,0,0,0},
            {4,9,0,1,5,7,0,0,2},
            {0,0,3,0,0,4,1,9,0},
            {1,8,5,0,6,0,0,2,0},
            {0,0,0,0,2,0,0,6,0},
            {9,6,0,4,0,5,3,0,0},
            {0,3,0,0,7,2,0,0,4},
            {0,4,9,0,3,0,0,5,7},
            {8,2,7,0,0,9,0,1,3},
        };

        if(sudokuSolver(sudoku,0,0)){
            System.out.println("Solution Exists");
            printsudoku(sudoku);
        }
        else{
            System.out.println("Solution does not exists");
        };
    }
}
