import java.util.Scanner;
public class Program2 {
	public static void main(String[] arg){
		Scanner scanner = new Scanner(System.in);
		
		//asking user to input their loan amount
		System.out.print("Enter the amount of loan: ");
		boolean loanAmount = scanner.hasNextDouble();
		while (loanAmount == false) {
			scanner.next();
			
			System.out.print("Please enter the amount of loan: ");
			loanAmount = scanner.hasNextDouble();
		}
		double A = scanner.nextDouble();
		
		//asking user to input interest rate
		System.out.print("Enter the interest rate (%): ");
		boolean interestRate = scanner.hasNextDouble();
		while (interestRate == false){
			scanner.next();
			
			System.out.print("Please enter the interest rate (%): ");
			interestRate = scanner.hasNextDouble();
		}
		double r = scanner.nextDouble();
		
		//asking user to input number of years
		System.out.print("Enter the number of years: ");
		boolean years = scanner.hasNextDouble();
		while (years == false) {
			scanner.next();
			
			System.out.print("Please enther the number of years: ");
			years = scanner.hasNextDouble();
		}
		double n = scanner.nextDouble();
		
		double i = r/5200; 
		//System.out.print(i);
		
		double weeklyPayment = (i/(1-(Math.pow((1+i),(-52*n)))))*A;
		
		System.out.println("Your weekly payment will be: $" + String.format("%.2f",weeklyPayment));
	}
}