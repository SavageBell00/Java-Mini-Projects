import java.util.Scanner;

public class Program1 {
	public static void main(String[] arg){
		Scanner scanner = new Scanner(System.in);
		
		//asking user to input customers name
		System.out.print("Please enter the customers name: ");
		String name = scanner.nextLine();
		
		
		//asking user to input kilometers while checking input validation
			System.out.print("Please enter the number of kilometers: ");
		boolean distanceInput = scanner.hasNextDouble();
		while (distanceInput == false) {
			scanner.next();
			
			System.out.print("Please give the number of kilometers: ");
			distanceInput = scanner.hasNextDouble();
		}
		double kmDistance = scanner.nextDouble();
		
		//asking user to input costs of records while checking input validation 
		System.out.print("Please enter the total costs of records purchased: ");
		boolean costInput = scanner.hasNextDouble();
		while (costInput == false) {
			scanner.next();
			
			System.out.print("Please enter the total costs of records purchased: ");
			costInput = scanner.hasNextDouble();
		}
		double costs = scanner.nextDouble();
		
		System.out.println("--------Purchase Summary for " + name + "--------");
		
		//the math for delivery cost: deliveryCost = kmDistance * 15
		double deliveryCost = kmDistance * 15;
		System.out.println("Delivery Cost: " + "$" + String.format("%.2f",deliveryCost));
		
		
		//the math for purchaseCost: purchaseCost = costs * 1.14(tax)
		double tax = 1.14;
		double purchaseCost = costs * tax;
		System.out.println("Purchase Cost: " + "$" + String.format("%.2f",purchaseCost));
		
		
		//the math for totalCost: totalCost = purchaseCost + deliveryCost
		double totalCost = purchaseCost + deliveryCost;
		System.out.println("Total Cost: " + "$" + String.format("%.2f",totalCost));
		
		
	}
	
}