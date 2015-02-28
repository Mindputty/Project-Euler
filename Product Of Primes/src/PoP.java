import java.util.*;

// Product of Primes (PoP) will return the smallest number that is evenly divisible by *ALL* the
// numbers from 1 to (whatever you specify in targetNumber).
public class PoP {

	public static void main(String[] args) {
		
		Integer targetNumber = 15; 		//set desired target here
		Integer answer = createProductOfAllPrimes(targetNumber);
		System.out.println("The smallest number that is evenly divisible by "
				+ "all numbers from 1 to "+targetNumber+" is: "+answer);

	}
	
	// method to multiply all the smallest factors together
	public static Integer createProductOfAllPrimes(Integer target){
		
		Integer product = 1;
		ArrayList<Integer> factors = prepareFactorsList(target);
		for(int i = 0; i<factors.size(); i++){
			product *= factors.get(i);
		}
		return product;
	}
	
	// prepareFactorsList creates a list of all the smallest prime factors 
	// (includes multiples) that, when multiplied together, yield a number 
	// that is evenly divisible by all the numbers between 1 and target
	
	public static ArrayList<Integer> prepareFactorsList(Integer target){
		
		/** Start with the largest possible factor (the target itself) and find all its primes
		*	and then add those to a (soon to be) growing list of factors of our target product 
		*	number.
		*
		*	For example, the number that is evenly divisible by all numbers between 1 and 20
		*	has 20 as a factor. Therefore, we start with the smallest possible target product
		*	number of 20 and work backwards from 20, checking each number 19,18,17... to see if 
		*	that new number is already covered by the existing factors in the list, or whether 
		*	more factors need to be added so that the number is a factor of the target product
		*	number. In other words, 20's factors are 2*2*5. The target product number is 20, so 
		*	the number 20 is covered. Next is 19. 20 is not evenly divisible by 19, so find out
		*	the smallest factor that needs to be added to the factors list to make the 
		*	target product number evenly divisible by 19. Since 19 is a prime itself, the only
		*	way that the target number will be evenly divisible by 19 is if we multiply what we
		*	had already by 19, making 380. Now, 380 is divisible by 2*2*5*19. Next to check is 18.
		*	380 is not divisible by 18, so add a factor to the growing list that will make
		*	380(that factor) divisible by 18. Since 18 is 2*3*3, and 380 is 2*2*5*19, we can see
		*	that if we simply add 3*3 to the list of factors, (380*3*3) is now evenly divisible 
		*	by 18 (since 380*3*3 is (2*2*5*19)3*3 = (2*3*3)(2*5*19) and 18 = 2*3*3). The algorithm
		*	for this process is (compare the new factor with the existing list of factors). If they
		*	share any factors, use only one copy of a match(remove it from factors list) and then 
		*	merge the two lists. This has the effect of adding only the factors from the 
		*	comparison list that are different than the existing factors in the list.**/
		
		ArrayList<Integer> factors = getPrimeFactors(target); //start with 20's primes

		for(int i=target-1;i>=1;i--){ //countdown from 19
			ArrayList<Integer> comparisons = getPrimeFactors(i); //get all of 19's primes
			for(int j = 0;j<comparisons.size();j++){ 
				if(factors.contains(comparisons.get(j))){ //compare 19's primes with our factors list's primes
					factors.remove(comparisons.get(j)); //if it matches, delete one copy(the factors one)
				}
			}
			factors.addAll(comparisons); // merge the lists
		}
		return factors;
	}
	
	//not a "true" Primes-returning function, since it also includes 1, which is *not* a Prime
	public static ArrayList<Integer> getPrimeFactors(Integer x){
		
		Integer product = x;
		
		ArrayList<Integer> factors = new ArrayList<Integer>();
		factors.add(Integer.valueOf(1));
		
		int i = 2;
		
		while(i<=x){
			if(product%i==0){
				product = product/i;
				factors.add(i);
			} else if (product==1){
				break;
			} else {
				i++;
			}
		}
		
		return factors;
	}

}
