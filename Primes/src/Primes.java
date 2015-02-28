import java.util.*;

public class Primes {

	public static void main(String[] args) {
		
		long upperLimit = 600851475143L;
		// ArrayList<Long> answer;
		System.out.println("Starting evaluation of number: "+upperLimit);
		//answer = findPrimes(upperLimit);
		//System.out.println("The largest prime less than "+upperLimit+" is "+answer.get(answer.size()-1));
		System.out.println("The Largest Prime Factor of "+upperLimit+" is "+LPF(upperLimit));

	}
	
	public static ArrayList<Long> findPrimes(long upperLimit){ //Largest Prime Less Than
		
		ArrayList<Long> primes = new ArrayList<Long>();
		
		int dots = 0;
		
		primes.add(2L);
		
		for(long i = 2; i < upperLimit; i++){
			
			boolean isPrime = true;
			Iterator<Long> p = primes.iterator();
			
			while(p.hasNext()){
				if(i%p.next()==0){
					//i is not a prime, therefore break and try the next i
					isPrime = false;
					break;
				}
			}
			
			if(isPrime==true){
				primes.add(i);
			}

			if(i%1000 == 0){
				System.out.print(".");
				if(dots>30){
					dots = 0;
					System.out.println();
				}
				dots += 1;
			}
		}
		
		return primes;
		
	}

	// Find the Largest Prime Factor of a number, upperLimit
	public static Long LPF(Long upperLimit){
		Long div = 2L;
		while(upperLimit > 1){
			if(upperLimit%div == 0){
				upperLimit = upperLimit/div;
			} else {
				div += 1;
			}
			
		}
		return div;
	}

}
