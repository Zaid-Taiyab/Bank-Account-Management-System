import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int x = 0;
        int n=0;
        int c;
        double w,d,p;
        String aID;
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose the type of account:");
        System.out.println("1. Checking Account");
        System.out.println("2. Savings Account");
        System.out.println("3. Credit Card Account");
        try {
            x = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error");
        }
        if (x == 1) {
            CheckingAccount a = new CheckingAccount();
            System.out.println("Enter Account ID");
            aID=sc.next();
            a.setAccountID(aID);
            System.out.println();
            System.out.println(a.accountInfo());
            System.out.println();
            System.out.println("Choose Action");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            try {
                n = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error");
            }
            if (n==1){
                System.out.print("Enter amount to withdraw: $");
                w=sc.nextDouble();
                a.withdraw(w);
            }
            else if (n==2){
                System.out.print("Enter amount to deposit: $");
                d=sc.nextDouble();
                a.deposit(d);
            }
            System.out.println("Press 1 to check balance");
            c=sc.nextInt();
            if(c==1){
                System.out.println(a.accountInfo());
            }
            System.out.println();
        }
        else if (x == 2) {
            SavingsAccount a = new SavingsAccount();
            System.out.println("Enter Account ID");
            aID=sc.next();
            a.setAccountID(aID);
            System.out.println();
            System.out.println(a.accountInfo());
            System.out.println();
            System.out.println("Choose Action");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            try {
                n = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error");
            }
            if (n==1){
                System.out.print("Enter amount to withdraw: $");
                w=sc.nextDouble();
                a.withdraw(w);
            }
            else if (n==2){
                System.out.print("Enter amount to deposit: $");
                d=sc.nextDouble();
                a.deposit(d);
            }
            System.out.println("Press 1 to check balance");
            c=sc.nextInt();
            if(c==1){
                System.out.println(a.accountInfo());
            }
            System.out.println();
        }
        else if (x == 3) {
            CreditcardAccount a = new CreditcardAccount();
            System.out.println("Enter Account ID");
            aID=sc.next();
            a.setAccountID(aID);
            System.out.println();
            System.out.println(a.accountInfo());
            System.out.println();
            System.out.println("Choose Action");
            System.out.println("1. Make Payment");
            n=sc.nextInt();
            if (n==1){
                System.out.print("Enter the amount: $");
                p=sc.nextDouble();
                a.Payment(p);
            }
            System.out.println("Press 1 to check balance");
            c=sc.nextInt();
            if (c==1){
                System.out.println(a.accountInfo());
            }
            System.out.println();
        }
    }
}

