package com.sena.luhn_algortihm;

import java.util.Scanner;

public class LuhnAlg {

    static int collectDigits(int number){
        int sum = 0;
        while(number != 0){
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        System.out.print("Enter your 16-digit credit card number: ");
        String no = scn.next();


        if(no.length() != 16){
            System.out.println("Error: Credit card number must be 16 digits.");
            return;
        }

        int sum = 0;
        boolean doubleDigit = false;


        for(int i = no.length() - 1; i >= 0; i--){
            char c = no.charAt(i);


            if(!Character.isDigit(c)){
                System.out.println("Error: Only numeric digits allowed.");
                return;
            }

            int digit = c - '0';

            if(doubleDigit){
                digit *= 2;
                digit = collectDigits(digit);
            }

            sum += digit;
            doubleDigit = !doubleDigit;
        }

        if(sum % 10 == 0){
            System.out.println("Correct credit card number");
        } else {
            System.out.println("Wrong credit card number");
        }

        scn.close();
    }
}
