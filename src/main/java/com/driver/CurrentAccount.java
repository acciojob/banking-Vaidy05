package com.driver;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception

        super(name,balance,5000);

        this.tradeLicenseId = tradeLicenseId;

        try{
            if(balance<5000)
                throw new Exception();
        }
        catch (Exception e){
            System.out.println("Insufficient Balance");
        }
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
         boolean consectiveChar = false;

         for(int i=0;i<tradeLicenseId.length()-1;i++){
             if(tradeLicenseId.charAt(i)==tradeLicenseId.charAt(i+1)){
                 consectiveChar=true;
                 break;
             }
         }

         if(consectiveChar){

             try {
                 HashMap<Character, Integer> freqChar = new HashMap<>();

                 int length = tradeLicenseId.length();

                 char c = ' ';
                 int maxfreq = 0;
                 int rem = tradeLicenseId.length() % 2;

                 for (int i = 0; i < tradeLicenseId.length(); i++) {

                     freqChar.put(tradeLicenseId.charAt(i), freqChar.getOrDefault(tradeLicenseId.charAt(i), 0) + 1);

                     if (freqChar.get(tradeLicenseId.charAt(i)) > maxfreq) {

                         maxfreq = freqChar.get(tradeLicenseId.charAt(i));
                         c = tradeLicenseId.charAt(i);
                     }
                 }
                 if (maxfreq > ((tradeLicenseId.length() / 2) + rem)) {

                     throw new Exception();
                 }
                 else{
                     Queue<Character> mp = new LinkedList<>();

                     for(int i=0;i<tradeLicenseId.length();i++){
                         if(c!=tradeLicenseId.charAt(i))
                             mp.add(tradeLicenseId.charAt(i));
                     }
                     tradeLicenseId="";
                     for(int i=0;i<length;i++){
                         if(i==0 || i%2==0){
                             tradeLicenseId=tradeLicenseId+c;
                         }
                         else{
                             if(!mp.isEmpty())
                                 tradeLicenseId = tradeLicenseId + mp.poll();
                         }

                     }
                 }
             }
             catch(Exception e){
                 System.out.println("Valid License can not be generated");
             }
         }
    }

}
