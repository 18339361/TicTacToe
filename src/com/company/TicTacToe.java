//the package is mentioned again
package com.company;
//this time we are also importing Random to generate a random number
import java.util.Random;
import java.util.Scanner;

//TicTacToe class begins
class TicTacToe {
    private String player1; //this variable is of type String and it will hold player1's name
    private String player2; //player2's name
    private String winner= ""; //winner's name (we have initialised this as empty)

    private Random rand = new Random(); //rand is an instance of Random
    private int turn= rand.nextInt((2-1)+1) +1; //the next integer generated for rand will be between 1 and 2
    //turn will store the random number to prevent either player always getting the first turn
    //the format of generating a random number between two number is as follows:
    // rand.nextInt((max - min) + min) + min;

    //getPlayer1 method returns whatever is stored in the player1 variable
    private String getPlayer1() {
        return player1;
    }

    //this method is used to assign a String value to the player1 variable
    void setPlayer1(String player1) {
        this.player1 = player1;
    }

    //getPlayer2 method returns whatever is stored in the player2 variable
    private String getPlayer2() {
        return player2;
    }

    //this method is used to assign a String value to the player2 variable
    void setPlayer2(String player2) {
        this.player2 = player2;
        //I called the playGame method here so control would not be returned back to the Main class
        playGame();
    }

    //this method is for playing the game
    private void playGame(){
        //scanner will be used for reading user input
        Scanner scanner = new Scanner(System.in);
        //this is the array that stores the values in the different locations on the board
        char[] board= {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        //this while loop will continue executing until the winner string is given a value
        while(winner.isEmpty()){
            //if turn is equal to 2 it is the X's turn
            if(turn==2){
                System.out.println(getPlayer1() + "'s turn");//telling the user whose turn it is
                printBoard(board);//printing the board for them to visualize it
                System.out.println("Choose unoccupied location between 1-9");//prompting the user to choose a location
                int position= scanner.nextInt()-1;//taking the value entered and subtracting 1 to get location in array as arrays start at 0
                //if a valid location is chosen, we place an X there
                if(position<=8 && position>=0){
                    if(board[position]==' '){
                        board[position]= 'X';
                    }
                    else{
                        System.out.println("Space already occupied\nTry Again");//error message if place is already taken
                        continue;//skip back to top of loop
                    }
                }
                else{
                    System.out.println("Invalid Number\nPlease choose a number between 1-9");//error message if invalid number is chosen
                    continue;//skip back to top of loop
                }
                //if the game is over we print the board and the final message
                if(isGameOver(board)){
                    printBoard(board);
                    printFinalMessage();
                }
                turn--;
            }

            //same code but for O not X
            else{
                System.out.println(getPlayer2() + "'s turn");
                printBoard(board);
                System.out.println("Choose unoccupied location between 1-9");
                int position= scanner.nextInt()-1;
                if(position<=8 && position>=0){
                    if(board[position]==' '){
                        board[position]= 'O';
                    }
                    else{
                        System.out.println("Space already occupied\nTry Again");
                        continue;
                    }
                }
                else{
                    System.out.println("Invalid Number\nPlease choose a number between 1-9");
                    continue;
                }
                if(isGameOver(board)){
                    printBoard(board);
                    printFinalMessage();
                }
                turn++;
            }
        }
        //closing the scanner as it is no longer needed
        scanner.close();
    }

    //method to print the board
    private void printBoard(char[] board){
        //prints the lines and values of the elements in the array
        System.out.print("_" + board[0] + "_|_" + board[1] + "_|_" + board[2] + "_\n");
        System.out.print("_" + board[3] + "_|_" + board[4] + "_|_" + board[5] + "_\n");
        System.out.print(" " + board[6] + " | " + board[7] + " | " + board[8] + " \n");
    }

    //method to check if the game is over
    //takes in the board array and checks if corresponding locations are occupied by the same letter
    private boolean isGameOver(char[] board){
        boolean result;//stores true or false result for the question is game over?
        //each if checks for each of the winning possibilities: rows, columns and diagonals
        if(board[0] == board[1] && board[1] == board[2] && board[0]== 'X'){ //checks if first row is XXX
            winner= getPlayer1();//assigns the winning player's name to winner (it is no longer empty so while will not execute anymore)
            result= true;//the game is over so result is true
        }
        else if(board[0] == board[1] && board[1] == board[2] && board[0]== 'O'){
            winner= getPlayer2();
            result= true;
        }
        else if(board[3] == board[4] && board[4] == board[5] && board[3]== 'X'){
            winner= getPlayer1();
            result= true;
        }
        else if(board[3] == board[4] && board[4] == board[5] && board[3]== 'O'){
            winner= getPlayer2();
            result= true;
        }
        else if(board[6] == board[7] && board[7] == board[8] && board[6]== 'X'){
            winner= getPlayer1();
            result= true;
        }
        else if(board[6] == board[7] && board[7] == board[8] && board[6]== 'O'){
            winner= getPlayer2();
            result= true;
        }
        else if(board[0] == board[4] && board[4] == board[8] && board[0]== 'X'){
            winner= getPlayer1();
            result= true;
        }
        else if(board[0] == board[4] && board[4] == board[8] && board[0]== 'O'){
            winner= getPlayer2();
            result= true;
        }
        else if(board[2] == board[4] && board[4] == board[6] && board[2]== 'X'){
            winner= getPlayer1();
            result= true;
        }
        else if(board[2] == board[4] && board[4] == board[6] && board[2]== 'O'){
            winner= getPlayer2();
            result= true;
        }
        else if(board[0] == board[3] && board[3] == board[6] && board[0]== 'X'){
            winner= getPlayer1();
            result= true;
        }
        else if(board[0] == board[3] && board[3] == board[6] && board[0]== 'O'){
            winner= getPlayer2();
            result= true;
        }
        else if(board[1] == board[4] && board[4] == board[7] && board[1]== 'X'){
            winner= getPlayer1();
            result= true;
        }
        else if(board[1] == board[4] && board[4] == board[7] && board[1]== 'O'){
            winner= getPlayer2();
            result= true;
        }
        else if(board[2] == board[5] && board[5] == board[8] && board[2]== 'X'){
            winner= getPlayer1();
            result= true;
        }
        else if(board[2] == board[5] && board[5] == board[8] && board[2]== 'O'){
            winner= getPlayer2();
            result= true;
        }
        //draw statement is here, if all boxes are occupied but no winning situations have been found, the game is a draw
        else if(board[0]!=' ' && board[1]!=' ' && board[2]!=' ' && board[3]!=' ' && board[4]!=' ' && board[5]!=' ' && board[6]!=' ' && board[7]!=' ' && board[8]!=' ' ){
            winner= "Draw";
            result= true;
        }
        //the game is not over
        else{
            result= false;
        }
        //result is returned
        return result;
    }

    //if the game is over, this final message method will print the final message
    private void printFinalMessage(){
        System.out.println("\n*****GAME OVER*****");//telling the user the game is over
        if(!winner.equals("Draw")){//if it is not a draw, we print the winner's name
            System.out.println("The winner is " + winner.toUpperCase() +" :)");
        }
        else{//if it is a draw we print a message stating that
            System.out.println("Game was a draw :) ");
        }
    }
}
