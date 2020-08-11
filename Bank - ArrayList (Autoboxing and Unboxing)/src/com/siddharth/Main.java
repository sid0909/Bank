package com.siddharth;

import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static Bank bank = new Bank();
    public static void main(String[] args) {
	    boolean control = false;
	    int choice;
	    while(!control){
            System.out.println("Press");
            System.out.println("\t1. Add a branch.");
            System.out.println("\t2. Add a customer to an existing branch.");
            System.out.println("\t3. Add transaction to an existing customer.");
            System.out.println("\t4. List all the Customers name with their transaction of a branch.");
            System.out.println("\t5. Quit the application.");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    addBranch();
                    break;
                case 2:
                    addCustomer();
                    break;
                case 3:
                    addTransaction();
                    break;
                case 4 :
                    listCustomers();
                    break;
                case 5:
                    control = true;
                    break;
                default:
                    System.out.println("Invalid Input!\n");
                    control = false;
            }
        }
    }

    public static void addBranch(){
        System.out.print("Enter branch name to add: ");
        String branchName = sc.nextLine();
        Branch newBranch = new Branch(branchName);
        if(bank.addBranch(branchName)){
            System.out.println(branchName + ", branch created successfully.");
        }else{
            System.out.println("Branch creation failed.");
        }
    }

    public static void addCustomer(){
        System.out.print("Enter branch name in which new customer is going to add: ");
        String branchName = sc.nextLine();
        System.out.print("\tEnter customer name: ");
        String customerName = sc.nextLine();
        System.out.print("\tEnter initial amount: ");
        double initialAmount = sc.nextDouble();
        if(bank.newCustomer(branchName,customerName,initialAmount)){
            System.out.println("Customer '" + customerName + "' added successfully in branch '"
                    + branchName + "'.");
        }else{
            System.out.println("Customer not added successfully.");
        }
    }

    public static void addTransaction(){
        System.out.print("\tEnter branch name of the customer to add transaction: ");
        String branchName = sc.nextLine();
        System.out.print("\tEnter customer name: ");
        String customerName = sc.nextLine();
        System.out.print("\tEnter transaction amount: ");
        double amount = sc.nextDouble();
        bank.addTransaction(branchName,customerName,amount);
    }

    public static void listCustomers(){
        System.out.print("\tEnter the branch name: ");
        String branchName = sc.nextLine();
        bank.listCustomers(branchName);
    }
}
