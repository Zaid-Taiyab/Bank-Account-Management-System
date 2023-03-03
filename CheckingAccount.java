public class CheckingAccount extends BankAccount{
    private double overdraftFee=35;

    public boolean debit(int x){
        balance-=x;
        if (balance<0){
            balance-=overdraftFee;
        }
        return true;
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

    public void setFee(int fee){
        overdraftFee=fee;
    }
    public double getFee(){
        return overdraftFee;
    }
    public void applyInterest(){
        if (balance>0){
            balance = (int) (interestRate * balance + balance);
        }
    }

    @Override
    public void withdraw(double w) {
        balance-=w;
        if (balance<0){
            balance-=35;
        }
    }

    @Override
    public void deposit(double d) {
        balance+=d;
    }

    public String accountInfo(){
        String i=String.format("%.2f",BankAccount.getBalance());
        if (balance>=0){
            overdraftFee=0;
            return "Type of Account : Checking\n"+"Account ID      : "+accountID+"\nCurrent Balance : $"+i;
        }
        if(balance<0){
            overdraftFee=35;
            double f=((double)((overdraftFee)));
            String o="Overdraft Fee   : $"+String.format("%.2f",f);
            return "Type of Account : Checking\n"+"Account ID      : "+accountID+"\nCurrent Balance : $"+i+"\n"+o;
        }
        return "Type of Account : Checking\n"+"Account ID      : "+accountID+"\nCurrent Balance : $"+i+"\n";
    }
}
