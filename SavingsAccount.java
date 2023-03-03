public class SavingsAccount extends BankAccount {
    public boolean debit(int a) {
        if (a < balance) {
            balance -= a;
            return true;
        }
        return false;
    }
    private String accountID;
    @Override
    public String getAccountID() {
        return accountID;
    }

    @Override
    public void setAccountID(String id) {
        accountID=id;
    }

    public void applyInterest() {
        if (balance > 0) {
            balance = (int) (interestRate * balance + balance);
        }
    }

    @Override
    public void withdraw(double w) {
        if (balance>=w) {
            balance -= w;
        }
        else {
            System.out.println("Error: Insufficient Funds");
        }
    }

    @Override
    public void deposit(double d) {
        balance+=d;
    }

    public String accountInfo() {
        String i=String.format("%.2f",BankAccount.getBalance());
        return "Type of Account : Savings\n"+"Account ID      : "+accountID+"\nCurrent Balance : $"+i;
    }
}
