import java.util.Scanner;

class Task2
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int total=0;
		System.out.print("Enter the number of subjects:");
		int n=sc.nextInt();
		for(int i=1;i<=n;i++)
		{
			System.out.print("Enter the marks of Subject "+i+":");
			int marks=sc.nextInt();
			total+=marks;	
		}
		System.out.println("Your Total Marks are "+total+" out of "+(n*100));
	
		float average = total/n;
		
		System.out.println("Average of Your Marks is "+average);
		
		if(average>=90.0)
		{
			System.out.println("You were Outstanding!!, Your Grade is O+");
		
		}	
		else if(80.0<=average && average<90.0)
		{
			System.out.println("Your Grade is A+");
		
		}
		else if(70<=average && average<80.0)
		{
			System.out.println("Your Grade is A");
		
		}
		else if(60<=average && average<70.0)
		{
			System.out.println("Your Grade is B");
		
		}
		else if(50<=average && average<60.0)
		{
			System.out.println("Your Grade is C");
		
		}
		else if(40<=average && average<50.0)
		{
			System.out.println("Your Grade is D");
		
		}
		else 
		{
			System.out.println("You have Failed,Your Grade is F");
		
		}
		sc.close();
	}


}
