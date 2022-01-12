package chapter6;
/*
Calculate an itemized cell phone bill
 */

public class PhoneBill {
    //fields
    private int id;
    private double basePlan;
    private int minutesUsed;
    private int minutesAllowed;
    private double taxes;
    private double totalDue;
    private double overageCost;

    /*
    constructors for nothing entered, id only entered, and all info entered
    */
    public PhoneBill(){
        id=101;
        basePlan=39.99;
        minutesUsed=1000;
        minutesAllowed=1000;
    }

    public PhoneBill(int id){
        this.id = id;
        basePlan=19.99;
        minutesUsed=500;
        minutesAllowed=1000;
    }

    public PhoneBill(int id, double basePlan, int minutesUsed, int minutesAllowed){
        this.id = id;
        this.basePlan = basePlan;
        this.minutesUsed = minutesUsed;
        this.minutesAllowed = minutesAllowed;
    }

    /*
    calculate excess minutes cost, taxes, and calculate itemized bill
     */

        public void calculateOverage(){
        double overage = minutesUsed - minutesAllowed;
        if (overage<0){
            overage = 0;
        }
        double overageCostPerMinute = .25;
        overageCost = overage * overageCostPerMinute;
    }

    public void getTaxes(){
        double taxPercentage = .15;
        taxes = (basePlan + overageCost) * taxPercentage;
    }

    public void GetTotalBill(){
        calculateOverage();
        getTaxes();
        totalDue = basePlan + overageCost + taxes;
    }

    /*
    print the itemized bill
     */

    public void printBill(){
        GetTotalBill();
        System.out.println("Phone Bill Statement");
        System.out.println("Bill id: " + id);
        System.out.println("Plan: $" + String.format("%.2f",basePlan));
        System.out.println("Overage: $" + String.format("%.2f",overageCost));
        System.out.println("Tax: $" + String.format("%.2f",taxes));
        System.out.println("Total: $" + String.format("%.2f",totalDue));
    }

}
