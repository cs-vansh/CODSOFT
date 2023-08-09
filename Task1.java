import java.util.Scanner;
import java.util.Random;

class Task1
{
	public static void main(String args[])
	{
		Random_Number randomObj = new Random_Number();
		Scanner sc=new Scanner(System.in);	
		int difference=100;
		int count=1;
		System.out.println("");
		System.out.println("Guess The Number");
		System.out.print("Enter a valid Integer guess for the generated number between 1 and 100:"+ "\t");

		while(difference!=0)
		{	
			
			int guess=sc.nextInt();
			int r = randomObj.giveRandomNumber();
			difference=guess - r ;
			if (difference==0)
			{
				System.out.println("You have guessed the number correctly. The number was indeed "+r);
				break;
			}
			else if(difference<0)
			{
				System.out.println("You have guessed a Smaller Number.Try with a Larger Number");
			}		
			else if(difference>0)
			{
				System.out.println("You have guessed a Larger Number. Try with a Smaller Number");
			}
			count++;
				
		}
		System.out.println("It took you "+count+" " + (count==1? "try" : "tries") + " to guess the number correctly");
		sc.close();
	}
}

class Random_Number
{
	Random obj1 = new Random();
	int random_number= obj1.nextInt(99) + 1; // In order for the number to be between 1 and 100
	public int giveRandomNumber()
	{
	 	//System.out.println("A random number has been generated between 1 and 100");
		return random_number;
	}	
}
