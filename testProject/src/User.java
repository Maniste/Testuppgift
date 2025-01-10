public class User
{
    private BankAccount salaryAccount;
    private BankAccount savingsAccount;

    private String firstName = "";
    private String lastName = "";

    private long personalNumber = 000000000;
    private int pinNumber = 0000;

    public User(String fn, String ln, int PIN, long persNumber)
    {
        firstName = fn;
        lastName = ln;
        pinNumber = PIN;
        personalNumber = persNumber;

        salaryAccount = new BankAccount(fn + " Salary", persNumber);
        savingsAccount = new BankAccount(fn + " Savings", persNumber);
    }
}
