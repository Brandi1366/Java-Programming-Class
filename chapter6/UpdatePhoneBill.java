package chapter6;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UpdatePhoneBill implements Serializable
         {
    public static void main(String[] args) {
        ArrayList<PhoneBill> accounts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        try{
            FileInputStream readData = new FileInputStream("StorePhoneBills.txt");
           try (ObjectInputStream readStream = new ObjectInputStream(readData)) {

               accounts = (ArrayList<PhoneBill>) readStream.readObject();

//               readStream.close();
           }
        }catch (Exception e) {
            e.printStackTrace();
        }

        //Ask what the user wants to do, then ask if they would like to continue

        int task;

        do {
            System.out.println("What would you like to do:");
            System.out.println("To update a current phone account press 1.");
            System.out.println("To print a current phone account press 2.");
            System.out.println("To enter a new phone account press 3.");
            System.out.println("To finish press 4.");
            task = scanner.nextInt();

            //Works option chosen
            switch (task){
                case 1:
                    //update current
                    System.out.println("Please enter the ID you would like to update:");
                    int updateID = scanner.nextInt();
                    boolean validID = false;

                    for (int i=0; i<accounts.size(); i++) {
                        if (updateID == accounts.get(i).getId()) {
                            validID = true;
                            System.out.println("Thank you. That plan shows:");
                            accounts.get(i).printBill();
                            System.out.println("");
                            System.out.println("What would you like to change:");
                            System.out.println("To update the ID press 1.");
                            System.out.println("To update the base plan press 2.");
                            System.out.println("To update the allowed minutes press 3.");
                            System.out.println("To update the minutes used press 4.");
                            int option = scanner.nextInt();
                            switch (option) {
                                case 1:
                                    System.out.println("What is the new ID: ");
                                    int newID = scanner.nextInt();
                                    accounts.get(i).setId(newID);
                                    break;

                                case 2:
                                    System.out.println("What is the new base plan price: ");
                                    double newBasePlan = scanner.nextDouble();
                                    accounts.get(i).setBasePlan(newBasePlan);
                                    break;

                                case 3:
                                    System.out.println("What is the new allowed minutes: ");
                                    int newAllowedMinutes = scanner.nextInt();
                                    accounts.get(i).setMinutesAllowed(newAllowedMinutes);
                                    break;

                                case 4:
                                    System.out.println("How many minutes were used: ");
                                    int newMinutesUsed = scanner.nextInt();
                                    accounts.get(i).setMinutesUsed(newMinutesUsed);
                                    break;
                            }
                            System.out.println("That plan now shows:");
                            accounts.get(i).printBill();
                            System.out.println("");
                            break;
                        }
                    }
                        if (validID == false) {
                            System.out.println("ID not found.Please try again.");
                            System.out.println("");
                        }
                    break;
                case 2:
                    //print account
                    System.out.println("What is the ID of the account you would like to print:");
                    int printID = scanner.nextInt();
                    boolean checkID = false;

                    for (int i=0; 1<accounts.size(); i++){
                        if (printID == accounts.get(i).getId()){
                            accounts.get(i).printBill();
                            checkID = true;
                            break;
                        }
                    }
                    if (checkID == false){
                            System.out.println("ID not found.Please try again.");
                    }
                    break;

                case 3:
                    //add account
                    System.out.println("What is the new ID:");
                    int newID = scanner.nextInt();
                    System.out.println("What is the base plan cost:");
                    double newBasePlan = scanner.nextDouble();
                    System.out.println("What is the allowed minutes:");
                    int newAllowedMinutes = scanner.nextInt();
                    System.out.println("How many minutes did they use:");
                    int newUsedMinutes = scanner.nextInt();

                    PhoneBill newAccount = new PhoneBill(newID, newBasePlan,newUsedMinutes, newAllowedMinutes);
                    accounts.add(newAccount);
                    System.out.println("New account added.");
                    System.out.println("");
                    break;

                case 4:
                    //Exit and write to the file
                    System.out.println("Have a good day. All changes have been updated.");
                    try{
                        FileOutputStream writeData = new FileOutputStream("StorePhoneBills.txt");
                        ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

                        writeStream.writeObject(accounts);
                        writeStream.flush();
                        writeStream.close();

                    }catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                default:
                    System.out.println("Invalid response, please try again");
            }

        }while (task != 4);

    }
}
