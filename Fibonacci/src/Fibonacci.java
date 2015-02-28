
public class Fibonacci {

	public static void main(String[] args) {
		
		int answer = p2();
		System.out.println("The answer is "+answer);

	}
	
	public static int p2(){
		
		int sum = 0;
		int last = 1;
		int first = 0;
		int next = 1;
		
		while(last <= 4000000){
			
			last = first + next;
			
			if(last%2==0){
				sum += last;
			}
			
			first = next;
			next = last;
			
		}
		return sum;
	}

}
