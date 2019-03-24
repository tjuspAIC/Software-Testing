package cn.tjucic.st;

import java.util.ArrayList;

//Introduction to Software Testing
//Authors: Paul Ammann & Jeff Offutt
//Chapter 7; page ??
//Can be run from command line
//See PrintPrimes.num for a numbered version.
//No JUnit tests at this time

/** *****************************************************
* Finds and prints n prime integers
* Jeff Offutt, Spring 2003
********************************************************* */
public class PrintPrimes
{

private static boolean isDivisible (int i, int j)
{
   if (j%i == 0)
      return true;
   else
      return false;
}
protected static String printPrimes (int n)
{
   ArrayList<Integer> path=new ArrayList<>();
   
   int curPrime;           // Value currently considered for primeness
   int numPrimes;          // Number of primes found so far.
   boolean isPrime;        // Is curPrime prime?
   int [] primes = new int [100]; // The list of prime numbers.
   String AllPrimes="";
   // Initialize 2 into the list of primes.
   primes [0] = 2;
   numPrimes = 1;
   curPrime  = 2;
   path.add(1);
   path.add(2);
   while (numPrimes < n)
   {
	   path.add(3);

	   curPrime++;  // next number to consider ...
      isPrime = true;
      path.add(4);
      for (int i = 0; i <= numPrimes-1; i++)
      {   // for each previous prime.
    	  path.add(5);
         if (isDivisible (primes[0], curPrime))
         {  // Found a divisor, curPrime is not prime.
        	 path.add(6);
            isPrime = false;
            break; // out of loop through primes.
         }
         path.add(7);
         path.add(4);
      }
      path.add(8);
      if (isPrime)
      {   // save it!
    	  path.add(9);
         primes[numPrimes] = curPrime;
         numPrimes++;
      }
      path.add(10);
      path.add(2);

   }  // End while
   path.add(11);
   // Print all the primes out.
   path.add(12);
   for (int i = 0; i <= numPrimes-1; i++)
   {  path.add(13);
//      System.out.println ("Prime: " + primes[i]);
    AllPrimes=AllPrimes+"Prime: " + primes[i]+" ";
      path.add(14);
      path.add(15);
      path.add(12);
   }
   path.add(16);
   String result="";
   for(int i=0;i<path.size();i++) {
	   result=result+path.get(i)+"->";
   }
   //return result;
   return AllPrimes;
}  // end printPrimes

//public static void main (String []argv)
//{  // Driver method for printPrimes
//   // Read an integer from standard input, call printPrimes()
//   int integer = 0;
//   if (argv.length != 1)
//   {
//      System.out.println ("Usage: java PrintPrimes v1 ");
//      return;
//   }
//
//   try
//   {
//      integer = Integer.parseInt (argv[0]);
//   }
//   catch (NumberFormatException e)
//   {
//      System.out.println ("Entry must be a integer, using 1.");
//      integer = 1;
//   }
//
//   System.out.println(printPrimes (1));
//}
}