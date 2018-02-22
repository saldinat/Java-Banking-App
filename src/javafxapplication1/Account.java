//TEAM:
//Tamara Saldina 101006791  
//Anastasiia Roldugina 101095885
package javafxapplication1;

public class Account {
    protected long accountNum;
    protected double balance;
    protected String owner;
    
    //The constructor 
    public Account(long accNum, double bal, String own) {
        accountNum = accNum;
        balance = bal;
        owner = own;
    }
    
    //Returns the account number
    public double getAccountNumber() {
        return accountNum;
    }
    
    //Returns the balance
    public double getBalance() {
        return balance;
    }
    
    //Returns the owner name
    public String getOwner() {
        return owner;
    }
    
    //Performs the withdrawal from the account
    public boolean withdraw(double withdrawAmount) {
        
        if ((balance - withdrawAmount) < 0){ //Checking if there is enough money to withdraw
            System.out.println("No deposit done");
            return false;
        }
        balance -= withdrawAmount;
        return true;
    }
    
    //Perfoms the deposit 
    public void deposit(double depositAmount) {
        balance += depositAmount;
    }
    
    
    //Perfoms the transfer. The account 'a' identifies the account 
    //you are transfering the money FROM, 'this' identifies the account you are 
    //transfering TO
    public boolean transfer(Account a, double amount) {
        if(a.withdraw(amount)) {
            this.deposit(amount);
            return true;
        }
        System.out.println("No deposit done");
        return false;
    }
    @Override
    //Overriding a built in toString() method
    public String toString() {
        return "The account number: " + this.accountNum + 
                "\nThe account balance: " + this.balance +
                "\nOwner's name: " + this.owner + "\n";
    }
   
}
