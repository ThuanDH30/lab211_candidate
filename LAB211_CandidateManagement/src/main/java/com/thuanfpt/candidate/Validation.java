/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thuanfpt.candidate;
import Model.Candidate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author Bravo
 */
public class Validation {
    private final static Scanner sc = new Scanner(System.in);
    private static final String PHONE_VALID = "(0[3|5|7|8|9])+([0-9]{8})";

    private static final String EMAIL_VALID
            = "[A-Za-z]\\w+@\\w+(\\.\\w+){1,3}$";

     public int inputInt(String mess, int min, int max) {
        System.out.print(mess);
        while(true) {
            String input = sc.nextLine();
            try {
                int number = Integer.parseInt(input);
                if (number < min || number > max) {
                    System.out.print("Please input between " + min + ", " + max + ": ");
                    continue;
                }
                return number;
            } catch (Exception e) {
                System.out.print("Please input an integer number: ");
            }
        }
    }
    public double inputDouble(String mess, double min, double max) {
        System.out.print(mess);
        while(true) {
            String input = sc.nextLine();
            try {
                double number = Double.parseDouble(input);
                if (number < min || number > max) {
                    System.out.print("Please input between " + min + ", " + max + ": ");
                    continue;
                }
                return number;
            } catch (Exception e) {
                System.out.print("Please input an double number: ");
            }
        }
    }
        public String inputString(String mess,String regex) {
        System.out.print(mess);
        while(true) {
            String input = sc.nextLine();
            if(!input.matches(regex)){
                System.out.println("Please input matched with regex:"+regex);
                continue;
            }
            if (input.equals("")) {
                System.out.print("Please input a non-empty string: ");
                continue;
            }
            return input;
        }
    }
    public String inputDate(String mess) {
        System.out.print(mess);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        while(true) {
            String input = sc.nextLine();
            try {
                Date date = dateFormat.parse(input);
                Date curDate = Calendar.getInstance().getTime();
                if (curDate.compareTo(date) < 0) {
                    System.out.print("Please input date that before current date: ");
                    continue;
                }
                dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                return dateFormat.format(date);
            } catch (Exception e) {
                System.out.print("Please input valid date (dd-MM-yyyy): ");
            }
        }
    }

    public boolean checkInputYN() {
        while (true) {
            String result = sc.nextLine();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }
    public String checkInputGraduationRank() {
        while (true) {
            String result = sc.nextLine();
            if (result.equalsIgnoreCase("Excellence")
                    || result.equalsIgnoreCase("Good")
                    || result.equalsIgnoreCase("Fair")
                    || result.equalsIgnoreCase("Poor")) {
                return result;
            } else {
                System.err.println("Please input string: Excellence, Good, Fair, Poor");
                System.out.print("Enter again: ");
            }
        }
    }
    public boolean checkIdExist(ArrayList<Candidate> candidates, String id) {
        for (Candidate candidate : candidates) {
            if (candidate.getId().equalsIgnoreCase(id)) {
                System.err.println("Id exist.");
                return false;
            }
        }
        return true;
    }
    
    public String inputEmail(String mess) {
        System.out.print(mess);
        String regex = EMAIL_VALID;
        while(true) {
            String input = sc.nextLine();
            if(!input.matches(regex)){
                System.out.println("Please enter a valid email:"+regex);
                continue;
            }
            if (input.equals("")) {
                System.out.print("Please input a non-empty string: ");
                continue;
            }
            return input;
        }
    }
    
    public String inputPhoneNumber(String mess) {
        System.out.print(mess);
        String regex = PHONE_VALID;
        while(true) {
            String input = sc.nextLine();
            if(!input.matches(regex)){
                System.out.println("Please enter a valid phone number:"+regex);
                continue;
            }
            if (input.equals("")) {
                System.out.print("Please input a non-empty string: ");
                continue;
            }
            return input;
        }
    }
    



}

