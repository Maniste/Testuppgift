import java.util.ArrayList;
import java.util.Scanner;

public class Bank
{
    static ArrayList<User> userList = new ArrayList<User>();

    public static void BankMenu()
    {
        Scanner input = new Scanner(System.in);
        boolean bankLoop = true;
        while(bankLoop)
        {
            try
            {
                System.out.println("Hello and welcome to Luhn Bank");
                System.out.println("Please make a selection");

                System.out.println("1: Create account");
                System.out.println("2: Log in");
                System.out.println("3: Exit");

                int selection = input.nextInt();

                switch(selection)
                {
                    case 1:
                        CreateAccount(input);
                        continue;
                    case 2:
                        LogIn();
                        continue;
                    case 3:
                        System.out.println("\n");
                        System.out.println("Quiting program, Thank you for using Luhn Bank");
                        bankLoop = false;
                        continue;

                }

            }
            catch (Exception e)
            {

            }
        }

        input.close();

    }

    static void CreateAccount(Scanner input) {
        boolean creationLoop = true;
        String fName = "", lName = "";
        int pin = 0, state = 1;
        long perNumber = 0;

        System.out.println("Create a account selected\n");

        while (creationLoop)
        {
            try
            {
                switch (state)
                {
                    case 1:

                        System.out.print("First name: ");
                        fName = input.nextLine();

                        if (fName.length() <= 0)
                            throw new Exception("Invalid input: name too short");

                        //Check that there are no special characters
                        for (int i = 0; i < fName.length(); i++)
                            if (Character.isDigit(fName.charAt(i)))
                                throw new Exception("Invalid input: no special characters");

                        state++;
                        continue;
                    case 2:
                        //Repeate the above
                        System.out.print("Last name: ");
                        lName = input.nextLine();

                        if (lName.length() <= 0)
                            throw new Exception("Invalid input: name too short");

                        for (int i = 0; i < lName.length(); i++)
                            if (Character.isDigit(lName.charAt(i)))
                                throw new Exception("Invalid input: no special characters");

                        state++;
                        continue;
                    case 3:
                        System.out.print("\nInput personal number: ");

                        perNumber = input.nextInt();

                        state++;
                        continue;
                    case 4:
                        System.out.print("\nCreate a PIN: ");
                        pin = input.nextInt();

                        if(pin > 4)
                            throw new Exception("PIN can not be longer than 4 digits");

                        state++;
                        continue;
                }

                //everything is verified
                //we can now create the account
                //And then add it to the user list
                User newUser = new User(fName, lName, pin, perNumber);
                userList.add(newUser);
                System.out.println("\nAccount succesfully created\n");
                creationLoop = false;

            } catch (NumberFormatException ne) {
                System.out.println("Invalid input: can only be numbers");
            } catch (Exception e) {
                System.out.println("ERROR: " + e);
            }
        }
    }

    static void LogIn()
    {


    }

}
