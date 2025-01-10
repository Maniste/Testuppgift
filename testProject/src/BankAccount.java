public class BankAccount
{
    String name;
    double balance = 0d;
    long accountNumber = 000;

    public BankAccount(String accountName, long persNumber)
    {
        name = accountName;
        balance = 1000d;
        accountNumber = persNumber + (System.currentTimeMillis());
    }

    public void TransferMoney(double moneyToTransfer)
    {
        balance += moneyToTransfer;
    }

    public double Withdraw(double moneyToWithdraw)
    {
        //make sure to check we have enough in the balance to withdraw
        if(balance < moneyToWithdraw)
        {
            //we cant withdraw the money
            //so notify user and cancle the process
            System.out.println("Not enough balance in account, transaction terminated");
            return 0d;
        }
        else
        {
            //we have enough money in our account
            //so finish the transaction
            balance -= moneyToWithdraw;
            return moneyToWithdraw;
        }
    }

}
