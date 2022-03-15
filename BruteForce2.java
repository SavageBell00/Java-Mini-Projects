public class BruteForce2 {
	public static void main(String[] args) {
		// ABCDE * A = EEEEEE
		int ABCDE = 10000; // going to test 10,000 --> 99,999
		
		// For or While loop to increment and test 
		/*
		Each iteration:
			Get ABCDE as component parts:
			int firstDigit = ABCDE%10;
			int secondDigit = (ABCDE/10)%10;
			int thirdDigit = (ABCDE/100)%10;
			int fourthDigit = (ABCDE/1000)%10;
			int fithDigit = (ABCDE/10000)%10;
		Then test:
			1. Are all the numbers different from each other?
			2. Does ABCDE x A == EEEEEE
		
		If yes, print the result.
		 
		 */
		 
		 for (int i = ABCDE; i <= 99999; i++){
			int firstDigit = i%10; 
			int secondDigit = (i/10)%10;
			int thirdDigit = (i/100)%10;
			int fourthDigit = (i/1000)%10;
			int fifthDigit = (i/10000)%10;
			
			if (firstDigit == secondDigit || firstDigit == thirdDigit || firstDigit == fourthDigit || firstDigit == fifthDigit) {
				i++;
			}
			else if (secondDigit == thirdDigit || secondDigit == fourthDigit || secondDigit == fifthDigit) {
				i++;
			}
			else if (thirdDigit == fourthDigit || thirdDigit == fifthDigit){
				i++;
			}
			else if (fourthDigit == fifthDigit){
				i++;
			} else {
				//System.out.println(i); //wondering why the else breaks and doesnt go to line 43 or 44 if i print here?
				int answer = firstDigit * 111111;
				if (answer == fifthDigit*i){
					System.out.println("ABCDE equals: " + i);
				}
				
				
			}
		 }
	}
}