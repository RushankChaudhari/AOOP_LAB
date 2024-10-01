package Bank_Account_Management_System;

public class BankAccount {
 private double balance;


 public BankAccount(double initialBalance) {
     this.balance = initialBalance;
 }

 public synchronized void deposit(double amount) {
     if (amount > 0) {
         balance += amount;
         System.out.println(Thread.currentThread().getName() + " deposited: $" + amount + " | New Balance: $" + balance);
     } else {
         System.out.println(Thread.currentThread().getName() + " tried to deposit a negative amount");
     }
 }

 
 public synchronized void withdraw(double amount) {
     if (amount > 0 && amount <= balance) {
         balance -= amount;
         System.out.println(Thread.currentThread().getName() + " withdrew: $" + amount + " | New Balance: $" + balance);
     } else if (amount > balance) {
         System.out.println(Thread.currentThread().getName() + " tried to withdraw: $" + amount + " | Insufficient funds.");
     } else {
         System.out.println(Thread.currentThread().getName() + " tried to withdraw a negative amount");
     }
 }

 public double getBalance() {
     return balance;
 }
}

class BankAccountTest {
 public static void main(String[] args) {
     BankAccount account = new BankAccount(1000.00);

     
     Thread user1 = new Thread(new TransactionTask(account), "User1");
     Thread user2 = new Thread(new TransactionTask(account), "User2");
     Thread user3 = new Thread(new TransactionTask(account), "User3");

     user1.start();
     user2.start();
     user3.start();
 }
}

class TransactionTask implements Runnable {
 private BankAccount account;

 public TransactionTask(BankAccount account) {
     this.account = account;
 }

 @Override
 public void run() {
     account.deposit(200.00);   
     account.withdraw(150.00);   
     account.deposit(300.00);    
     account.withdraw(500.00);   
 }
}

