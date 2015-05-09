public class MaxProduct {

	
	// args[0] is the search string length and args[1] is a string of digits 
	public static void main(String[] args) {
		
		//TODO add error checking for when string length is larger than array length, etc
		//Also, change input methods (to avoid hard coding)
		
		String[] items;
		int len, head, tail;
		int largestHead = 1;
		int largestTail = 1;
		int[] digits;
		long largestProduct = 1;
		long tempProduct = 1;
		
		// make string of digits into String[]
		// hard-coded once here for checking
		//items = args[1].split("");
		String testString = "73167176531330624919225119674426574742355349194934"+
				"96983520312774506326239578318016984801869478851843"+
				"85861560789112949495459501737958331952853208805511"+
				"12540698747158523863050715693290963295227443043557"+
				"66896648950445244523161731856403098711121722383113"+
				"62229893423380308135336276614282806444486645238749"+
				"30358907296290491560440772390713810515859307960866"+
				"70172427121883998797908792274921901699720888093776"+
				"65727333001053367881220235421809751254540594752243"+
				"52584907711670556013604839586446706324415722155397"+
				"53697817977846174064955149290862569321978468622482"+
				"83972241375657056057490261407972968652414535100474"+
				"82166370484403199890008895243450658541227588666881"+
				"16427171479924442928230863465674813919123162824586"+
				"17866458359124566529476545682848912883142607690042"+
				"24219022671055626321111109370544217506941658960408"+
				"07198403850962455444362981230987879927244284909188"+
				"84580156166097919133875499200524063689912560717606"+
				"05886116467109405077541002256983155200055935729725"+
				"71636269561882670428252483600823257530420752963450";
		
		items = testString.split("");
		
		//commented out for temporary hard-coding
		//len = Integer.parseInt(args[0]);
		len = 13;
		digits = new int[items.length];
		
		//create int[] of digits from String[]
		for (int i = 0; i < items.length; i++) {
		        digits[i] = Integer.parseInt(items[i]);
		}
		
		head = 0;
		tail = head + len -1;
		
		//set up the tempProduct as the product of the first len digits from the digits array
		
		for(int i = 0; i<len; i++){
			tempProduct *= digits[i];
		}
		
		largestProduct = tempProduct;
		
		while(tail<digits.length){
			
			tempProduct = 1;
			for(int i = 0; i < len; i++){
				tempProduct *= digits[head+i];
			}
			
			if (tempProduct > largestProduct){
				largestProduct = tempProduct;
				largestHead = head;
				largestTail = tail;
				//System.out.println(largestProduct);
			}

			head++;
			tail++;
		}

		System.out.println("The greatest product is "+largestProduct);
		System.out.println("Head: "+largestHead);
		System.out.println("Tail: "+largestTail);
	}

}
