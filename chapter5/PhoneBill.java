package chapter5;
/*
Calculate an itemized cell phone bill
 */
import java.util.Scanner;

public class PhoneBill {
    static double overageCostPerMinute=.25;
    static double taxPercentage=.15;

    public static void main(String arg[]){

        //get input needed
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter base cost of the plan:");
        double basePlan = scanner.nextDouble();

        System.out.println("Enter overage minutes:");
        int minutesOver = scanner.nextInt();
        scanner.close();

        //calculate bill
        double overageCost = getOverage(minutesOver);
        double taxes = getTaxes(basePlan,overageCost);
        double totalDue = getTotalBill(basePlan, overageCost,taxes);

        //print out itemized bill
        System.out.println("Phone Bill Statement");
        System.out.println("Plan: $" + String.format("%.2f",basePlan));
        System.out.println("Overage: $" + String.format("%.2f",overageCost));
        System.out.println("Tax: $" + String.format("%.2f",taxes));
        System.out.println("Total: $" + String.format("%.2f",totalDue));

    }

    public static double getOverage(int minutes){
        double overageCost = minutes * overageCostPerMinute;
        return overageCost;
    }

    public static double getTaxes(double basePlan, double overage){
        double taxesDue = (basePlan + overage) * taxPercentage;
        return taxesDue;
    }

    public static double getTotalBill(double basePlan, double overageCost, double taxes){
        double totalDue = basePlan + overageCost + taxes;
        return totalDue;
    }
}
