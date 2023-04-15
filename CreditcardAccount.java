import javax.swing.*;

public class CreditcardAccount extends BankAccount {
    private double limit = 700;
//    private double balance=-500;
    @Override
    public boolean debit(int y) {
        if (y<=limit){
            balance-=y;
            return true;
        }
        return false;
    }

    private String accountID;

    public String getAccountID() {
        return accountID;
    }

    @Override
    public void setAccountID(String id) {
        accountID=id;
    }
    public void Payment(double p){
        if (p<=balance+limit && p>=0){
            balance-=p;
        }
        else {
            JOptionPane.showMessageDialog(null, "Error: Transaction failed. Amount exceeds credit limit.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String accountInfo() {
        String i=String.format("%.2f",balance);
        String o=String.format("%.2f",limit);
        return "Type of Account : Credit card\n"+"Account ID      : "+accountID+"\nCurrent Balance : $"+i+"\n"+"Credit Limit    : $"+o;
    }

    @Override
    public void applyInterest() {
        if (balance<0){
            balance = (int) (interestRate * balance + balance);
        }
    }

    @Override
    public void withdraw(double w) {
        if (balance>=w){
            balance-=w;
        }
    }

    @Override
    public void deposit(double d) {
        balance+=d;
    }

    public void setLimit(double l){
        limit=l;
    }
    public double getLimit(){
        return limit;
    }
}
