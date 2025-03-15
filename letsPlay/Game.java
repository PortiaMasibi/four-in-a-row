package letsPlay;

import java.util.Scanner;

public class Game {

    // 2 players of the game
    private Player[] players = new Player[2];
    private Board board;
    private stactic Scanner scanner = new Scanner(System.in);

    public Game () {
        this.players = players;
        this.board = board;
    }

    public void setUpGame() {
        //taking in the players
        System.out.println("Input name of the first player");
        String player1 = scanner.nextLine();
        System.out.println("Input name of second player");
        String player2 = scanner.nextLine();

        //initializing player objects for each player
        players[0] = new Player(player1,1);
        players[1] = new Player(player2,2);

        //checking if players have unique names
        if(!player1.equalsIgnoreCase(player2)) {
            //setup board
            board = new Board();
            board.boardSetUp();
        }
        
    }

    public void printWinner(Player player) {
        System.out.println("The winner is " + player);
    }

    public void playerTurn(Player currentPlayer) throws InvalidMoveException, InputMismatchException, ColumnFullException {

        //prompting player to make a move
        int columnMove = currentPlayer.makeMove();

        try {
            board.addToken(columnMove, currentPlayer.getName());
        }

        // for when column is out of bounds
        catch(InvalidMoveException e) {
            System.out.println(e.getMessage());
        }

        //for when player does not provide valid input for the column number
        catch(InputMismatchException e){
            System.out.println(e.getMessage());
        }

        // for when the selected column in full
        catch(ColumnFullException e) {
            System.out.println(e.getMessage());
        }

        //For any other exceptions
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    // method to start the game
    public void play() throws InvalidMoveException, InputMismatchException, ColumnFullException {
        //currently no winner
        boolean noWinner = true;
        //settting up the game by getting the board and players
        setUpGame();
        //initializing currentPlayerIndex to 0
        int currentPlayerIndex = 0;

        //Entering a while loop as long as there is no winner
        while(noWinner = true) {

            //if we have no winner and the board is full
            if(board.boardFull() == true) {
                System.out.println("Board is now full.Game Ends.");
                return;
            }

            //if board is not full
            else {
                // the current player is assigned to the players array at the currentPlayIndex
                Player currentPlayer = players[currentPlayerIndex];
                //print board
                board.printBoard();
                //prints which player is playing
                System.out.println("It is player " + currentPlayer.getPlayerNumber() + "'s turn. " + currentPlayer.getName());
                //player then plays
                playerturn(currentPlayer);
                //checks if the player is winning
                String playerWinning = Integer.toString(currentPlayer.getPlayerNumber());

                If (biard.checkIfPlayerIsTheWinner(playerWinning) == true){
                    printWinner(currentPlayer);
                    noWinner = false;
                }
                
                //if current player is not the winner
                else {
                    currentPlayerIndexx++;
                    currentPlayerIndex = currentPlayerIndex % players.length;
                }

            }
        }

    }


}

//Exceptions

class InvalidMoveException extends Exception{
    public InvalidMoveException(String message) {
        super(message);
    }
}

class InputMismatchException extends Exception{
    public InputMismatchException(String message) {
        super(message);
    }
}

class ColumnFullException extends Exception{
    public ColumnFullException(String message) {
        super(message);
    }
}