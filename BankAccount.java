public abstract class BankAccount {

    protected static double interestRate=0.0;
    protected static double balance=700;

    public boolean credit(int x){
        balance+=x;
        return true;
    }
    public abstract boolean debit(int y);
    public static double getBalance(){
        return balance;
    }

    public abstract String getAccountID();

    public abstract void setAccountID(String id);

    public static double getInterestRate() {

        return interestRate;
    }

    public void setInterestRate(double interestRate) {

        this.interestRate = interestRate;
    }
    public abstract void applyInterest();
    public abstract void withdraw(double w);
    public abstract void deposit(double d);

    public String accountInfo() {
        return null;
    }
}