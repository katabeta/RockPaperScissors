import java.util.Random;
import java.util.Scanner;

public class Game {
	//private int rounds;
	private int player1Score = 0;
	private int player2Score = 0;
	private boolean againstHuman;
	Scanner in = new Scanner(System.in);
	
	
	public Game(int roundsToPlay, boolean againstHuman){
		this.againstHuman = againstHuman;
		
		//////////
		//System.out.println("Playing againstHuman" + againstHuman);
		/////////
		int counter = 0;
		//this.rounds = roundsToPlay;
		while(counter < roundsToPlay){
			playRound();
			counter++;
			
			if(counter == roundsToPlay - 1){
				if(player1Score < player2Score){
					System.out.println("PLAYER 2 WON THE GAME");			
				} else if (player1Score > player2Score){
					System.out.println("PLAYER 1 WON THE GAME");
				} else {
					System.out.println("GAME ENDED IN A DRAW!");
				}
				
				
				while(true){
					System.out.println("Would you like to play again? y/n");
					//TODO finish writing play again
					if(in.hasNext()){
						if(in.next().equals("y")){
							counter = 0;
							break;
						} else if(in.next().equals("n")){
							break;
						} else {
							System.out.println("Invalid Input!");
						}
					}
				}
			}
		}
	}
	
	private void displayOptions(){
		System.out.println("1: ROCK");
		System.out.println("2: PAPER");
		System.out.println("3: SCISSORS");
	}
	private int chooseCard(boolean isHuman){
		int toReturn = 1;
		boolean done = false;
		if(isHuman){
			do{
				if(in.hasNextInt()){
					toReturn = in.nextInt();
					done = true;
				} else {
					in.next();
					//toReturn = 0;
					//displayOptions();
					System.out.println("ERROR! Please enter a number from 1-3 to indicate your choice");
				}
			} while(!done);
		} else {
			
			/////////
			System.out.println("Getting computer choice");
			////////
			Random rnd = new Random();
			toReturn = rnd.nextInt(3) + 1;
		}
		return toReturn;
	}
	
	private void playRound(){
		displayOptions();
		System.out.println("PLAYER 1: please enter the number of your choice");
		System.out.println("");
		int player1Choice = chooseCard(true);
		System.out.println("");
		displayOptions();
		System.out.println("PLAYER 2: please enter the number of your choice");
		System.out.println("");
		int player2Choice = chooseCard(againstHuman);
		System.out.println("");
		
		switch(player1Choice){
		case 1:
			if(player2Choice == 1){
				System.out.println("DRAW this round!");
			} else if(player2Choice == 2){
				System.out.println("PLAYER 2 WON this round!");
				player2Score++;
			} else{
				System.out.println("PLAYER 1 WON this round!");
				player1Score++;
			}
			break;
		case 2:
			if(player2Choice == 2){
				System.out.println("DRAW this round!");
			} else if(player2Choice == 3){
				System.out.println("PLAYER 2 WON this round!");
				player2Score++;
			} else{
				System.out.println("PLAYER 1 WON this round!");
				player1Score++;
			}
			break;
		case 3:
			if(player2Choice == 3){
				System.out.println("DRAW this round!");
			} else if(player2Choice == 1){
				System.out.println("PLAYER 2 WON this round!");
				player2Score++;
			} else{
				System.out.println("PLAYER 1 WON this round!");
				player1Score++;
			}
			break;
		default:
			System.out.println("ERROR!");
			break;
		}
	}
}
