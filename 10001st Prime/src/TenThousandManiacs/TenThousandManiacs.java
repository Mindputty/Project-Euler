/*		By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, 
 * 		we can see that the 6th prime is 13.
 * 
 *		What is the 10 001st prime number?*/

package TenThousandManiacs;

import java.util.ArrayList;

public class TenThousandManiacs {

	public static void main(String[] args) {
		int input = 10001;
		ArrayList<Integer> primes = generatePrimes(input);
		System.out.println("The first "+input+" primes are: "+primes);
		System.out.println("Prime number "+input+" is: "+primes.get(primes.size()-1));
	}
	
	public static ArrayList<Integer> generatePrimes(int x){
		return simplePrimes(2, 0, x);
	}
	
	//The following recursive code only works for smallish arrays of primes, otherwise gets StackOverflowError
	
	
/*	public static ArrayList<Integer> calcPrimesRecursive(ArrayList<Integer> primes, int num, int index, int stop){

		if(primes.size()<stop){
			if(index == primes.size()){
				primes.add(num);
				primes = calcPrimesRecursive(primes, num+1, 0, stop);
			} else {
				if(num%primes.get(index)==0){
					primes = calcPrimesRecursive(primes, num+1, 0, stop);
				} else {
						primes = calcPrimesRecursive(primes, num, index+1, stop);
				}
			}

		}
		return primes;	
	}*/

	public static ArrayList<Integer> simplePrimes(int num, int index, int stop){
		ArrayList<Integer> primes = new ArrayList<Integer>();
		primes.add(2);
		while(primes.size()<stop){
			boolean isDivisibleByPrimes = false;
			for(int i: primes){
				if(num%i==0){
					isDivisibleByPrimes = true;
					break;
				}
			}
			if(!isDivisibleByPrimes){
				primes.add(num);
			}
			num++;
		}
		return primes;
	}



	
/*	public static int calcPrimes(int x){
		int[] primes = new int[1];
		primes[0] = 2;
		int index = 0;
		int number = 2;
		
		while(primes.length < x){
			if(number % primes[index] == 0){
				number++;
				index = 0;
			} else if(number % primes[index]!=0){
				
			}
		}
		return primes[primes.length - 1];
				
	}*/

}
