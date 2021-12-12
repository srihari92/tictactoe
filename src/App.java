

// A simple program to demonstrate
// Tic-Tac-Toe Game.
import java.util.*;

public class App {

	public static void main(String[] args)
	{
        int boardSize=3;
        int maxTurns=boardSize*boardSize,turn=1;
        TicTocToe.PLAYER winner=null;
        TicTocToe ticTokToe=new TicTocToe(3);
        System.out.println("Welcome to 3x3 Tic Tac Toe.");
        ticTokToe.printBoard();
        System.out.println("X will play first. Enter a slot number to place X in:");
        TicTocToe.PLAYER currentPlayer=TicTocToe.PLAYER.X;
        try (Scanner in = new Scanner(System.in)) {
            while(winner== null){
                try{
                    
                    int   numInput = in.nextInt();
                    if (!(numInput > 0 && numInput <= boardSize*boardSize)) {
                        System.out.println(
                            "Invalid input; re-enter slot number:");
                        continue;
                    }
                    if(!ticTokToe.move(numInput, currentPlayer)){
                        System.out.println(
                            "already selected, re-enter another slot number:");
                        continue;
                    }

                    turn++;
                    if(currentPlayer==TicTocToe.PLAYER.X){
                        currentPlayer=TicTocToe.PLAYER.O;
                    }else{
                        currentPlayer=TicTocToe.PLAYER.X;
                    }
                    
                    ticTokToe.printBoard();
                    ticTokToe.checkGameState();
                    if((winner=ticTokToe.getWinningPlayer())==null && turn <=maxTurns){
                        System.out.println("Enter a slot number to place "+currentPlayer.getDisplayName()+" in:");
                        continue;
                    }
                    else if(winner==null || maxTurns==turn){
                        System.out.println("Game is draw");
                        break;
                    }
                    else{
                        System.out.println("The winner is "+winner.getDisplayName());
                        break;
                    }

                }catch(Exception e){
                    System.out.println(
                        "Invalid input; re-enter slot number:");
                }
               
            }
        }
	}
}
