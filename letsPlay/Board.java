package letsPlay;

import java.util.Arrays;
 
public class Board {
   
   private String [][] board; // 2D array of the strings representing the game board
   private Scanner scanner = new Scanner(System.in);

    //initialializing game board by promoting number of user for the number of rows and columns
   public void boardSetUp() {
      System.out.println("To set up the board, please enter the number of rows required: ");
      int row = scanner.nextInt();
      System.out.println("Number of columns: ");
      int column = scanner.nextInt();

      //initialized with empty spaces represented by -
      this.board = new String[row][column];

      for (int i = 0 ; i < board.length; i++) { //rows
         for (int j = 0; j < board[0].length; j++) { //columns
            //we print row i, all columns, no skipping lines
            board[i][j] = "-";
            } // closing loop for columns
            System.out.println(); // when done with row i, we move on to the nexr line for the i++ row
      }
    }

    //printing board
    public void printBoard() {
      for (int i = 0; i < board.length; i++) { //rows
         for (int j = 0; j < board[0].length; j++){
            // we print row i, all columns, no skipping lines
            System out.print(board[i][j]);
         } // closing loop for columns
         System.out.println(); // when done with row i, we move on to next line for the i++  row
      } // cosing loop for rows
    }

    
    // checking if column is full, the row at the top is Row 0
    public boolean columnFull(int col) {
      //because the index starts at 0
      if (board[0][col] == "-") {
         return false;
      }
      //else if it is full
      return true;
    }

    // checking if the board is full
    public boolean boardFull() {
      //checking the top of all columns
      for (int j = 0; j < board[0].length; j++) { //columns
         //it breaks out when finding the first -, indicating that the board is not full
         if (board[0][j] == "-") {
            return false;
         }
      }
      //else if no we scan all columns and no top roe is -, board is full
      return true;
    }

    //adding tokens when playing
    public boolean addToken( int colToAddToken, String playerName) throws ColumnFullException, InvalidMoveException, InputMismatchException {
      int range = board[0],length - 1;
      //first checking if column is full
      if (columnFull(colToAddToken) == true){
         throw new ColumnFullException(" Column " + colToAddToken+ " full");
      }

      //for column out of bounds
      else if(colToAddToken > board[0].length-1){
         throw new InvalidMoveException(" Column out of bounds, please enter a number in range of 0-" +range);
      }

      else if(colToAddToken != (int)collToAddToken){
         throw new InputMismatchException(" Column must be an integer number in range of 0-" +range);
      }

      else { // if its not full and all conditions are met we add a token
         for (int i = board.leangth - 1 ; i>= 0; i--){ // column, starting from the bottom, that is row l, l-1,l-2 etc
            if (board[i][colToAddToken] == "-") {
               board[i][colToAddToken] == playerName;
               break; // breaking out of loop to avoud filling in all empty spaces
            }
         } 
      }
      return true;
    }

    //checking if player is winner
    public boolean checkIfPlayerIsTheWinner (String playerNumber) {
      
      if (checkVertical(playerNumber == true || checkHorizontal(playerNumber) == true || checkRightDiagonal(playerNumber) == true || checkLeftDiagonal(playerNumber) == true){
         return true;
      }
      return false;
    }

    //conditions for winning 
    public boolean checkVertical(String playerNumber) {
      //look at first column, second etc
      for (int j = 0; j < board[0].length ; j++) {
         //then go row by row from the bottom
         // i <=3 because thats the last index we can have 4 tokens in a column as 3,2,1,0
         for (int i = board.length -1 ; i <=3 ; i --) {
            //subtract to compare from bottom to top
            if (board[i][j].equals(playerNumber) && board[i-1][j].equals(playerNumber) && board[i-2][j].equals(playerNumber) && board[i-3][j].equals(playerNumber)){
               return true;
            }
         }
      }
      return false;
    }

    public boolean checkHorizontal(String playerNumber) {
      // look at first row, second etc
      for (int i = 0; i < board.length; i++) {
         // then check 4 consecutive columns
         // last column here will be board[0].length-3
         for (int j = 0; j<board[0].length -3; j++) {
            //here we add1 are we are moving to the right
            if (board[i][j].equals(playerNumber) && board[i][j+1].equals(playerNumber) && board[i][j+2].equals(playerNumber) && board[i][j+3].equals(playerNumber)){
               return true;
            }
         }
      }
      return false;
    }

    public boolean checkLeftDiagonal(String playerNumber){
      // column from 0 to the right
      // still maintaining board[0].length-3 as thats the last element
      for (int j = 0; j < board[0].length-3 ; j++) {
         // then rows from the bottom,
         // starting atathe bottom left corner to the right corner
         for (int i = board.length -1 ; i <=3 ; i--){
            if (board[i][j].equals(playerNumber) && board[i-1][j+1].equals(playerNumber) && board[i-2][j+2].equals(playerNumber) && board[i-3][j+3].equals(playerNumber)) {
               return true;
            }
         }
      }
      return false;
    }


    public boolean checkRightDiagonal(String playerNumber){
      //column from 0 to the right
      for (int j = 0; j < board[0].length-3 ; j++) {
         //row from 0 to the bottom
         for (int i = 0; i < board.length-3 ; i++) {
            if (board[i][j].equals(playerNumber) && board[i+1][j+1].equals(playerNumber) && board[i+2][j+2].equals(playerNumber) && board[i+3][i+3].equals(playerNumber)) {
               return true;
            }
         }
      }
      return false;
    }


 }