package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("what's the start amount?");
		double startAmount = in.nextDouble();
		System.out.println("what's the win probability?");
		double winProbability = in.nextDouble();
		System.out.println("what's the win limit?");
		double winLimit = in.nextDouble();
		System.out.println("Total # of simulations?");
		double totalSimulations = 0;
		totalSimulations = in.nextInt();
		int days = 1;
		int ruin = 0;
		
		
		while(days <= totalSimulations)
		{
			
			double dayMoney = startAmount;
			int gamesPlayed = 0;
				
				while(dayMoney > 0 && dayMoney < winLimit)
				{ 
					if(Math.random() < winProbability)
					{
						dayMoney++;
						
					}
					else
					{
						dayMoney--;
					}
					gamesPlayed++;
				}
		
			if(dayMoney == 0)
		{
			System.out.println("Day " + days + ": " + "Ruin!! " + gamesPlayed);
			ruin++;
		}
		else if (dayMoney == winLimit)
		{
			System.out.println("Day " + days + ": " + "Success!!" + gamesPlayed);
		}
		
		days++;
	}
	
	
			
			double expectedRuin = 0;
			if(winProbability == 0.5)
				{
				 expectedRuin = 1 - (startAmount/winLimit);
				}
			else
			{
				double alpha = (1- winProbability)/winProbability;
				double a = Math.pow(alpha, winProbability);
				double b = Math.pow(alpha, winLimit);
				 expectedRuin = (a - b)/(1 - b);
				
			}
			double ruinRate = ruin / totalSimulations;
			System.out.println("Ruin Rate: " + ruinRate);
			System.out.println(expectedRuin);
	}

	
}


