import java.util.Scanner;
public class Program3 {
	public static void main(String[] arg) {
		Scanner scanner = new Scanner(System.in);
		
		//asking to enter number of tons
		System.out.print("Enter the number of tons: ");
		boolean tons = scanner.hasNextDouble();
		while (tons == false) {
			scanner.next();
			
			System.out.print("Please enter the number of tons: ");
			tons = scanner.hasNextDouble();
		}
		double tonsImperial = scanner.nextDouble();
		//System.out.println("The number of tons is " + String.format("%.0f",tonsImperial));
		
		//asking to enter number of stones
		System.out.print("Enter the number of stone: ");
		boolean stone = scanner.hasNextDouble();
		while(stone == false) {
			scanner.next();
			
			System.out.print("Please enter the number of stone: ");
			stone = scanner.hasNextDouble();
		}
		double stoneTotal = scanner.nextDouble();
		
		//asking to enter number of pounds
		System.out.print("Enter the number of pounds: ");
		boolean lbs = scanner.hasNextDouble();
		while (lbs == false) {
			scanner.next();
			
			System.out.print("Please enter the number of pounds: ");
			lbs = scanner.hasNextDouble();
		}
		double pounds = scanner.nextDouble();
		
		//asking to enter the number of ounces
		System.out.print("Enter the number of ounces: ");
		boolean ounces = scanner.hasNextDouble();
		while (ounces == false) {
			scanner.next();
			
			System.out.print("Please enter the number of ounces: ");
			ounces = scanner.hasNextDouble();
		}
		double ouncesImperial = scanner.nextDouble();
		
		//formula for total ounces 
		double totalOunces = (35840*tonsImperial)+(224*stoneTotal)+(16*pounds)+(ouncesImperial);
		System.out.println("The total ounces is " + String.format("%.0f",totalOunces));
		
		//formula for total kilosMetric
		double totalKilos = (totalOunces/35.274);
		//System.out.println("The total kilos in metric is " + totalKilos);
				
		//formula for metric tons, final kilos, and grams 
		double metricTons = (totalKilos/1000);
		double kilos = totalKilos%1000;
		double grams = (totalKilos - (int) totalKilos)*1000;
		
		System.out.println("The metric weight is " + String.format("%.0f",metricTons) + " metric tons, " + String.format("%.0f",kilos) + " kilos, and " + String.format("%.1f",grams) + " grams.");
	}
}