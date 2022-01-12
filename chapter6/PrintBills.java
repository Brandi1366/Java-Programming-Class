package chapter6;

public class PrintBills {
    public static void main(String arg[]){
        PhoneBill Phone = new PhoneBill();
        Phone.printBill();
        PhoneBill Phone2 = new PhoneBill(102);
        Phone2.printBill();
        PhoneBill Phone3 = new PhoneBill(103, 29.99, 1000, 900);
        Phone3.printBill();
    }
}
