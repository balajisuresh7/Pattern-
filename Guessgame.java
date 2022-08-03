//THE GUESSER GAME PROJECT. 
//THIS GAME IS PLAYED BY GUESSER,UMPIRE AND THE PLAYERS. 
//GUESSER : HE DECIDES THE NUMBER TO BE GUESSED AND INFORMS THE UMPIRE.
//PLAYER : HE GUESSES THE NUMBER DECIDED BY THE GUESSER AND PASSES IT TO UMPIRE.
//UMPIRE: HE GETS THE NUMBER FROM GUESSER AND PLAYERS, COMPARES IT AND DECIDES WHO WON THE GAME.
//GAME RULES: 
//1.THE GUESSED NUMBER SHOULD BE GREATER THAN ZERO AND LESS THAN 100.
//2.NUMBER OF ROUNDS IS FIXED AND IT IS DECIDED BEFORE THE START OF THE PLAY.
//3.PLAYER WHO HAS GUESSED THE NUMBER CORRECT HIGHEST NUMBER OF TIMES WILL BE DECLARED THE WINNER.
//4.IF MULTIPLE PLAYER HAS GUESSED HIGHEST NUMBER OF TIMES, THEN THOSE PLAYERS ARE WINNERS.

//FEATURES:
//1.VALIDATES THE GUESSED NUMBER. IF IT IS LESS THAN 0 OR GREATER THAN 100, ASKS THE GUESSER TO GUESS THE NUMBER AGAIN.
//2.VALIDATES THE NUMBER OF PLAYERS WHO CAN PARTICIPATE. IF THERE ARE MORE THAN 10 NUMBER OF PLAYERS, ASKS TO DROP EXTRA PLAYERS.
//3.VALIDATES THE NUMBER OF PLAYERS. SHOULD BE A NUMERIC VALUE BETWEEN 0 AND 10.
//4.VALIDATES THE NUMBER OF ROUNDS. THIS GAME CAN BE PLAYED WITH MAXIMUM OF 10 ROUNDS.
//5.GETS THE WINNER IN EACH ROUND.
//6.IF NO PLAYER WON THE ROUND, REPORTS THE SAME.
//7.ANNOUNCE THE PLAYER AS WINNER, IF HE HAS GUESSED THE CORRECT NUMBER MOST NUMBER OF TIMES.
//8.IF TWO OR MORE PLAYERS WON MOST ROUNDS, THEN THE TROPHY IS SHARED.
//9.IF NO PLAYER HAS GUESS CORRECT EVEN AFTER ALL THE ROUNDS, THEN THE TROPHY IS GIVEN TO NONE.

package utils;

import java.util.Scanner;

//Guesser class gets the number to be guessed in each round.
class Guesser
{
	int guessNum;
	public int guessnumber()
	{
		Scanner s1 = new Scanner(System.in);
		System.out.println("enter the number to be guessed");
		guessNum = s1.nextInt();
		while (guessNum > 100 || guessNum <= 0)
		{
			System.out.println("Please enter a number that is greater than zero and less than 100");
			guessNum = s1.nextInt();
		}
		return guessNum;
	}
}

//Player class gets the number guessed by each player in a round.
class Player
{
	int guessNum;
	public int guessnumber(int a)
	{
		Scanner s1 = new Scanner(System.in);
		System.out.println("Hey Player " + a + " please guess the number");
		guessNum = s1.nextInt();
		while (guessNum > 100 || guessNum <= 0)
		{
			System.out.println("Please guess a number that is greater than zero and less than 100");
			guessNum = s1.nextInt();
		}
		return guessNum;
	}
}

//Gets the number guessed from guesser. Gets the number guessed by players. Compares the number from guesser and player and announces the winner.
class Umpire
{
	int numToGuess;
	int numOfPlayers;
	Player [] playerArray = new Player[numOfPlayers];
	int [] guessedNum = new int[0];
	int [] winCount = new int[numOfPlayers];
	
	public void guessTheNum()
	{
		Guesser g = new Guesser();
		numToGuess = g.guessnumber();
	}
	
	
	public void getNumOfPlayers()
	{
		Scanner s1 = new Scanner(System.in);
		System.out.println("Please enter the number of players who are gonna play this game");
		numOfPlayers = s1.nextInt();
		if(numOfPlayers > 10)
		{
			int x = numOfPlayers -10 ;
			System.out.println("This game can only be played by 10. Please drop " + x + " no of players from your team and start the game again");
			System.exit(0);
		}
		playerArray = new Player[numOfPlayers];
		winCount = new int[numOfPlayers]; 
	}
	
	
	public void getPlayerGuessedNumbers()
	{
		guessedNum = new int[playerArray.length];
		for(int i =0;i<numOfPlayers;i++)
		{
			playerArray[i] = new Player();
			guessedNum [i] = playerArray[i].guessnumber(i);
		}
	}
	
	
	public void compare()
	{
		char winner = ' ';
		for(int i =0 ; i< guessedNum.length;i++)
		{
			if (numToGuess == guessedNum[i])
			{
				System.out.println("Player " + i + " won the round ");
				winCount[i] = winCount[i] + 1;
				winner = 'y';
			}
		}
		if (winner != 'y')
		{
			System.out.println("No players won this round");
		}
		
	}

	
	public void winnerAnnouncement()
	{
		int maxValue = 0;
		for(int i =0; i<winCount.length;i++)
		{
			if (winCount[i] >= maxValue)
			{
				maxValue = winCount[i];
			}
		}
		for(int i=0 ; i<winCount.length;i++)
		{
			if(winCount[i] == maxValue && maxValue != 0)
			{
				System.out.println("All rounds are over. The winner is " + "player " + i);
			}
		}
		if (maxValue == 0)
		{
			System.out.println("All rounds are over. No Players won the game");
		}
	}
		
}

public class Guessgame {

	public static void main(String[] args) {
		Umpire u = new Umpire();
		System.out.print("Enter the number of rounds you want to play the guesser game");
		Scanner s1 = new Scanner(System.in);
		int rounds = s1.nextInt();
		for(int i=0; i<rounds;i++)
		{
		System.out.println("Round No " + i + " begins,All the Best!!!!" );
		u.guessTheNum();
		if(i==0)
		u.getNumOfPlayers();
		u.getPlayerGuessedNumbers();
		u.compare();
		}
		u.winnerAnnouncement();
		
	}

}
