package prec;

public class NthMagicNumber {
	// Function to find n'th magic numebr
	static int nthMagicNo(int n)
	{
	    int pow = 1, answer = 0;
	 
	    // Go through every bit of n
	    while (n>0)
	    {
	       pow = pow*5;
	 
	       // If last bit of n is set
	       if ((n % 2)==1)
	         answer += pow;
	 
	       // proceed to next bit
	        n = n/2;
	    }
	    return answer;
	}
	
	 
	// Driver program to test above function
	public static void  main(String... arrgs)
	{
	    for (int n = 1; n < 100; n++) {
	    	System.out.println("n'th magic number is " + nthMagicNo(n) /*+ " my"+maginno(n)*/);
		}
	 
	  //  return 0;
	}
}
