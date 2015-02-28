package sum2diff;

public class sum2diff {

	public static void main(String[] args) {
		
/*		The sum of the squares of the first ten natural numbers is,

		1^2 + 2^2 + ... + 10^2 = 385
		The square of the sum of the first ten natural numbers is,

		(1 + 2 + ... + 10)^2 = 552 = 3025
		Hence the difference between the sum of the squares of the first ten natural numbers 
		and the square of the sum is 3025 - 385 = 2640.

		Find the difference between the sum of the squares of the first one hundred natural 
		numbers and the square of the sum.
*/		
		int inputNumber = 100;
		int sumSqrNum = sumSqr(inputNumber);
		int sqrSumNum = sqrSum(inputNumber);
		int diff = sumSqrNum - sqrSumNum;
		System.out.println("The sum of the squares of the numbers from 1 to "+inputNumber+" is: "+sumSqrNum);
		System.out.println("The square of the sum of the numbers from 1 to "+inputNumber+" is: "+sqrSumNum);
		System.out.println("The difference between these numbers is: "+diff);
	}
	
	public static int sqrSum(int x){
		int sum = 0;
		for(int i=1; i<=x; i++){
			sum = sum + (i*i);
		}
		return sum;
	}
	
	public static int sumSqr(int x){
		int sum = 0;
		int n = 0;
		while(n<=x){
			sum = sum + n;
			n++;
		}
		sum = sum*sum;
		return sum;
	}

}
