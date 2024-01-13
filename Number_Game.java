package codsoft_project;

import java.util.Random;
import java.util.Scanner;

public class Number_Game {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			Random random = new Random();
			
	        int minRange = 1;
	        int maxRange = 100;
	        int maxAttempts = 10;
	        int score = 0;

	        boolean playAgain = true;
	        while (playAgain) {
	            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange;
	            System.out.println("Welcome to the Number Guessing Game!!!");
	            System.out.println("--------------------------------------");
	            System.out.println("I have selected a number between " + minRange + " and " + maxRange);
	            System.out.println("Try to guess it !!");

	            int attempts = 0;
	            while (attempts < maxAttempts) {
	                System.out.print("Enter your guess Number: ");
	                int userGuess = sc.nextInt();
	                attempts++;

	                if (userGuess < targetNumber) 
	                    System.out.println("Too low ! Try again.");
	                else if (userGuess > targetNumber) 
	                    System.out.println("Too high ! Try again.");
	                else {
	                    System.out.println("Congratulations Dear!! You guessed the number " + targetNumber + " in " + attempts + " attempts.");
	                    score += maxAttempts - attempts + 1;
	                    break;
	                }
	            }

	            if (attempts == maxAttempts) {
	                System.out.println("Sorry, you have Exceeded number of attempts !!!") ;
	                System.out.println("The correct number was:" + targetNumber);
	            }

	            System.out.print("Do you want to play again? (yes/no): ");
	            String playAgainRes = sc.next().toLowerCase();
	            playAgain = playAgainRes.equals("yes");
	        }

	        System.out.println("Thanks for playing No Game With us !!!");
	        System.out.println("Your total score is: " + score);
	    }		

	}