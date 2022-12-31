package com.driver;

import java.util.HashSet;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;


    HashSet<Integer> AccountNoSet = new HashSet<>();

    public BankAccount(String name, double balance, double minBalance) {
       this.name = name;
       this.balance = balance;
       this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
           String AccountNo = "";
           int firstNo = (int)Math.pow(10,digits-1);
           int lastNo = (int) Math.pow(10,digits)-1;

           int i = firstNo;

           while(i<=lastNo){

               int currentSum = 0;
               int temp = i;

               while(temp!=0){

                   currentSum+=temp%10;
                   temp=temp/10;
               }

               if(currentSum==sum){
                   if(!AccountNoSet.contains(i)){
                      AccountNoSet.add(i);
                      AccountNo = AccountNo + i;
                      return AccountNo;
                   }
                   else
                       i=i+9;
               }
               else
                   i++;
           }
           throw new Exception("Account Number can not be generated");
    }

    public void deposit(double amount) {
        //add amount to balance
      this.balance = balance + amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance

             if((balance-amount)<minBalance)
                 throw new Exception("Insufficient Balance");

             this.balance = balance - amount;

    }

}