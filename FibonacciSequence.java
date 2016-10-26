import java.util.*;
//Daniel Lindberg
//2-25-2016

/*
	Garret this is a Finoacci Sequence class, you can easily wikipedia information about the Fibonacci Sequence
	I have included two ways to calculate the Fibonacci, so when you run this and pick a number you will see that
	bad fibonacci produces more comparions. In programming you want to find the most efficient way to code something
	since we would prefer the least amount of computations because it takes up time on the computer. This code gives
	two implmentations of how to calculate Fibonacci sequence. The more efficient one puts it into a list once its calculated
	for a number. So therefore when you try and calculate some number it keeps track of previously calculated values.
	In fibonacci since it is calculated by the two previous fibonacci values you will end up doing more calculations if
	you don't keep track of previously calculated values. Below I explain how bad fibonacci sequence is bad.

	How Bad Fibonacci works is that for some number it just calculates the previous two values of the fib sequence. This ends up
	being recursive. So therefore if I want to calculate fibonacci of the number 5. I have to get the fibonacci value at 4 and 3.
	However to calculate the fib of 4 you have to calculate the fib of 3 and 2.. etc. 
	So therefore bad fibonacci is bad because it is not efficiently keeping track of information.

	You can try this outby picking the number 45 (you can pick higher but heads up bad fibonacci will take 5 minutes for the 	
	number 50)
	The result for 45 is:
	Pick a number:
	45
	Your fib number is:1134903170
	It took 43 amount of times
	It took 1134903169 bad computation amount of times

	Another thing to note about this code is its recursive call. If you do not know recursion calls, it means that a function
	calls it self over and over. This is efficient because you don't have to code it for many differnet examples. it uses less
	coding lines.

	You may wonder why I am using long over int, the reason is because int only goes up to about positive and negative 2 billion.
	Long will go up much higher. 

*/

public class FibonacciSequence
{
	static List fibList = new ArrayList();
	static long computations =0;

	public static void main(String args[])
	{
		int fib;
		long result;
		char question = 'Y';
		Scanner in = new Scanner(System.in);
		while(question=='Y'||question=='y'){
			System.out.println("Pick a number:");
			fib = in.nextInt();
			fibList.add((long)1);
			fibList.add((long)1);
			result = fibonacci(fib);
			System.out.println("Your fib number is:"+result);
			System.out.println("It took "+computations+" amount of times");
			computations = 0;
			bad_fibonacci(fib);
			System.out.println("It took "+computations+" bad computation amount of times");
			computations = 0;
			result=0;
			fibList.clear();
			System.out.println("Continue (Y/N)");
			question = in.next().charAt(0);
		}	
	}
	
	static long fibonacci(int num)
	{
		long s;
		if(fibList.size() >= num)
		{
			return (long)fibList.get(num-1);
		}
		else
		{
			s=(fibonacci(num-1)+fibonacci(num-2));
			fibList.add(s);
			computations++;		
			return s;
		}	
	}
	static long bad_fibonacci(long num)
	{
		if (num==1 || num==2)
		{
			return 1;		
		}	
		else
		{
			computations++;
			return bad_fibonacci(num-1)+bad_fibonacci(num-2);			
		}
	}

}
