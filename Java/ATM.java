import java.util.*;

class Bank {

    int[] accountNumber = new int[100];
    int[] pinNumber = new int[100];
    int[] amount = new int[100];

    int accIdx = 0;
    int pinIdx = 0;
    int accNum, pinNum;

    public void addAccount() {
        Scanner sc = new Scanner(System.in);
        int input;

        do {
            System.out.println("Enter account number to add in ATM: ");
            int acc = sc.nextInt();
            accountNumber[accIdx] = acc;
            accIdx++;

            System.out.println("Enter pin number to add in ATM: ");
            int pin = sc.nextInt();
            pinNumber[pinIdx] = pin;
            pinIdx++;

            System.out.println("Account Successfully Added...");

            System.out.println("Enter 0: Add more account 1: No More account add");
            input = sc.nextInt();
            if (input != 0)
                break;
                
        } while (true);  

        System.out.println("All Accounts Entered");

        enterAccount();
    }

    public void enterAccount() {
        Scanner sc = new Scanner(System.in);
        int flag = 0, error=0;
        while (flag == 0) {
            System.out.println("Enter Account Number: ");
            accNum = sc.nextInt();
            System.out.println("Enter Pin Number: ");
            pinNum = sc.nextInt();

            for (int i = 0; i < accIdx; i++) {
                if (accNum == accountNumber[i]) {
                    if (pinNum == pinNumber[i]) {
                        System.out.println("Welcome " + accNum);
                        error=1;
                        flag = showDetails(i);
                    } 
                    else 
                        System.out.println("Wrong Pin Number");      
                } 
            }

            if(error==0)
                System.out.println("Wrong Account Number");
        }
    }

    public int showDetails(int i) {
        int input, check;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter 00: Exit 1: Check Amount 2: Credit Amount 3: Debit Amount");
            input = sc.nextInt();

            if (input == 00) {
                System.out.println("Exit Account...");
                break;
            } else if (input == 1) {
                checkAmount(i);
            } else if (input == 2) {
                creditAmount(i);
            } else if (input == 3) {
                debitAmount(i);
            } else {
                System.out.println("Wrong Input");
                System.out.println("Choose Given Input Only ");
                // break;
            }
        }
        System.out.println("Enter 0: Stay in ATM 1: Exit ATM");
        check = sc.nextInt();
        if(check==0)
            return 0;
        else
        return 1;
    }

    public void checkAmount(int i) {
        System.out.println("Total Amount: " + amount[i]);
    }

    public void creditAmount(int i) {
        int money;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount to add: ");
        money = sc.nextInt();
        amount[i] += money;
        System.out.println("Amount Credited");
    }

    public void debitAmount(int i) {
        int money;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount to debit: ");
        money = sc.nextInt();
        amount[i] -= money;
        System.out.println("Amount Debited");
    }
}

public class ATM {
    public static void main(String[] args) {
        Bank b = new Bank();
        b.addAccount();
    }
}
