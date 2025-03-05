package letsPlay;

import java.util.Scanner;

// Player Class
public class Player {

    private String name;
    private int playerNumber;

    public Player (String name, int playerNumber){
        this.name = name;
        this.playerNumber = playerNumber;
    }

    private static Scanner scanner = new Scanner(System.in);

    //getters
    public String  getName(){
        return name;
    }

    public int getPlayerNumber(){
        return playerNumber;
    }

    public int makeMove(){
        System.out.println( "Which column do you want to place your token in");
        int columnNumber = scanner.nextInt();
        //scanner.close()
        return columnNumber;
    }

    @Override
    public String toString(){
        return "Player [" + playerNumber + " is " + name + " ]";
    }
}