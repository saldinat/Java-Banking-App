//TEAM:
//Tamara Saldina 101006791  
//Anastasiia Roldugina 101095885
package javafxapplication1;


public class Bank {
     static Account[] accountList = new Account[1000];
private static int numAccounts;
private static int maxAccount = 1000;

//Adding a new chequing account
public static  boolean addChequingAccount(long accNum, double bal, String owner) {
            Account a = new Account(accNum, bal, owner);
            if(numAccounts == maxAccount)
                return false;
            accountList[numAccounts] = a;
            numAccounts++;
            return true;
        }

//Adding a new account
private static  boolean addAccount(long accNum, double bal, String owner) {
            Account a = new Account(accNum, bal, owner);
            if(numAccounts == maxAccount)
                return false;
            accountList[numAccounts] = a;
            numAccounts++;
            return true;
        }

//A method printing all the accounts
 public String printAccounts() {
     String r = "";
    for(int i =0; i<numAccounts; i++) {
        r += accountList[i].toString() + "\n";
    }
    return r;
}
//A method that returns an index of the accNum in the accountList
 public int findAccount(long accNum){
    for(int i = 0; i<numAccounts; i++) {
        if (accountList[i].accountNum == accNum)
            return i;
    }
    System.out.println("Account not found");
    return -1;
}

public void depositAccount(long accNum, double amount) {
    if(findAccount(accNum)!=-1){
        int a = findAccount(accNum);
        accountList[a].deposit(amount);
}
}
public boolean withdrawAccount(long accNum, double amount) {
    if(findAccount(accNum)!=-1){
        int a = findAccount(accNum);
        accountList[a].withdraw(amount);
        return true;
}
    return false;
}

public boolean transfer(long accNumFrom,long accNumTo, double amount) {
    if(findAccount(accNumFrom)!=-1 && findAccount(accNumTo)!=-1){
        int from = findAccount(accNumFrom);
        int to = findAccount(accNumTo);
        accountList[to].transfer(accountList[from], amount);
        return true;
}
    return false;
}


}
