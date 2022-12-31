package com.driver;

import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {

       Scanner sc = new Scanner(System.in);


       SavingsAccount b1 = new SavingsAccount("Balaji",10000.00,5000,2.5);

       System.out.println(b1.getSimpleInterest(2));
       System.out.println(b1.getCompoundInterest(1,2));

    }
}