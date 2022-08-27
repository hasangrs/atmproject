package atmpackage;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Options extends Account {

    Scanner scan = new Scanner(System.in);

    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer , Integer> data = new HashMap<>();

    boolean flag = true;

    public void login(){

        System.out.println("hi! welcome to Hasan ATM...");

        do {
            data.put(12345,1234);
            data.put(23456,2345);
            data.put(34567,3456);
            data.put(45678,4567);

            try {
                System.out.println("enter account number");
                setAccountNumber(scan.nextInt());
                System.out.println("enter the pin number");
                setPinNumber(scan.nextInt());
            }catch (Exception e){
                System.out.println("hey! you have entered an invalid character");
                scan.nextLine();
                String exit = scan.next().toLowerCase();
                if (exit.equals("q")){
                    flag = false;
                }
                e.printStackTrace();
            }

            int count = 0;
            for (Map.Entry<Integer,Integer> w : data.entrySet()){

                if (w.getKey().equals(getAccountNumber()) && w.getValue().equals(getPinNumber())){
                    System.out.println("welcome to your account");
                    selectAccount();
                }else {
                    count++;
                }
            }

            if (count == data.size()){
                System.out.println("invalid user");
                System.out.println("press any integer to try again or press 'Q' to exit");
                String exit = scan.next();
                if (exit.equalsIgnoreCase("q")){
                    flag = false;
                }
            }





        }while (flag);



    }

    public void selectAccount(){

        do {
            System.out.println("select option:");
            System.out.println("1:checking account operations");
            System.out.println("2:saving account operations");
            System.out.println("3:exit");

            int option = scan.nextInt();

            if (option == 3){
                break;
            } else if (option == 1) {
                //call checking account operation
                checkingOperations();

            } else if (option == 2) {
                //call saving account operation
                savingOperations();


            }else {
                System.out.println("invalid option! please select a correct one");
            }


        }while (true);




    }

    public void checkingOperations(){

        do {
           operationsMessage();

            int option = scan.nextInt();

            if (option == 4){
                break;
            }

            switch (option){

                case 1:
                    System.out.println("your checking account balance is: " + moneyFormat.format(getCheckingBalance()));
                    break;
                case 2:
                    if (getCheckingBalance() > 0){
                        getCheckingWithdraw();
                    }else {
                        System.out.println("you do not have enough money, please deposit first");
                    }
                    break;
                case 3:

                    getCheckingDeposit();
                    break;

                default:
                    System.out.println("invalid option! please select 1, 2, 3 or 4");



            }










        }while (true);




    }

    public void savingOperations(){

        do {
           operationsMessage();

            int option = scan.nextInt();

            if (option == 4){
                break;
            }

            switch (option){

                case 1:
                    System.out.println("your saving account balance is : "+moneyFormat.format(getSavingBalance()));
                    break;
                case 2:
                    if (getSavingBalance() > 0){
                        getSavingWithdraw();
                    }else {
                        System.out.println("you do not have enough money, please deposit first");
                    }
                    break;
                case 3:
                    getSavingDeposit();
                    break;

                default:
                    System.out.println("invalid option! please select 1, 2, 3 or 4");







            }









        }while (true);








    }

    public void operationsMessage(){
        System.out.println("select option:");
        System.out.println("1: view balance");
        System.out.println("2: withdraw");
        System.out.println("3: deposit");
        System.out.println("4: exit");





    }



}
