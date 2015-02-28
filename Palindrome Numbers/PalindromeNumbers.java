
public class PalindromeNumbers {

	public static void main(String[] args) {
		int largestPalindromeSum = 10001;
		int sum = 0;
		for(int i = 100; i<=999; i++){
			for(int j = 100; j<=999; j++){
				sum = i*j;
				if(isPalindrome(sum)){
					if(sum > largestPalindromeSum){
						largestPalindromeSum = sum;
					}
				}
			}
		}
		
		System.out.println("The largest Palindromic Sum of two 3-digit integers is :"+largestPalindromeSum);
	}
	
	//currently only set up to deal with 5- and 6-digit numbers for x
	public static boolean isPalindrome(int x){
		
		String p = Integer.toString(x);
		
		if(p.length()==5){
			if( p.charAt(0)==p.charAt(4) && p.charAt(1)==p.charAt(3)){
				return true;
			} else {
				return false;
			}
		} else {
			if( p.charAt(0)==p.charAt(5) && p.charAt(1)==p.charAt(4) && p.charAt(2)==p.charAt(3)){
				return true;
			} else {
				return false;
			}
		}
	}
}
