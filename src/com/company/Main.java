//this package will be different depending on your computer's default
package com.company;

//imports are listed here
//these are pre-defined in java
//we are making this import to allow us to get user input
import com.company.TicTacToe;

import java.util.Scanner;

//this is our Main class
public class Main {
    //this is our main method
    //code execution begins here
    public static void main(String[] args) {
        //we declare an object scanner of type Scanner
        //this allows us to take in user input
        //this is why we needed the import before
        //System.in defines where we get the input [keyboard]
        Scanner scanner= new Scanner(System.in);

        //a short welcome message is printed
        System.out.println("Welcome to TicTacToe");
        //we are creating an instance of the TicTacToe class called newGame
        TicTacToe newGame= new TicTacToe();

        //Prompting the user for input
        System.out.println("Enter Player 1 Name: ");
        //scanning the input (because we are expecting a String we use nextLine())
        //setting the newGame's player1 as whatever the input says
        //this line takes us to the setPlayer1 method in the TicTacToe class
        newGame.setPlayer1(scanner.nextLine());
        //repeating for player2
        System.out.println("Enter Player 2 Name: ");
        //this line takes us to the setPlayer2 method in the TicTacToe class
        newGame.setPlayer2(scanner.nextLine());
        //closing the scanner as we no longer need it
        scanner.close();
    }
}
