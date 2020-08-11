package com.siddharth;

import java.util.ArrayList;
import java.util.Scanner;

public class Bank {

    private final String name = "State Bank Of India";
    private ArrayList<Branch> branch;
    private Scanner sc = new Scanner(System.in);

    public Bank() {
        this.branch = new ArrayList<>();
    }

    public boolean addBranch(String branchName){
        Branch oldBranch = findBranch(branchName);
        if(oldBranch==null){
            Branch newBranch = new Branch(branchName);
            branch.add(newBranch);
            return true;
        }
        System.out.println("Branch '" + branchName + "' already exists.");
        return false;
    }

    public Branch findBranch(String branchName){
        for (int i=0;i<branch.size(); i++){
            Branch oldBranch = branch.get(i);
            if(oldBranch.getName().equalsIgnoreCase(branchName)){
                return oldBranch;
            }
        }return null;
    }

    public boolean newCustomer(String branchName,String customerName, double amount){
        Branch branch = findBranch(branchName);
        if(branch!= null){
            return branch.newCustomer(customerName,amount);
        }
        System.out.println("Branch '" + branchName + "' not found.");
        return false;
    }

    public void addTransaction(String branchName, String customerName, double amount){
        Branch branch = findBranch(branchName);
        if(branch!=null){
            branch.newTransaction(customerName,amount);
        }else{
            System.out.println("No branch found with name '" + branchName + "'.");
        }
    }

    public void listCustomers(String branchName){
        Branch branch = findBranch(branchName);
        if(branch!=null){
            if(branch.getCustomers().size()>0){
                for (int i = 0; i < branch.getCustomers().size(); i++) {
                    System.out.println(i+1 + ". " + branch.getCustomers().get(i).getName());
                    branch.printTransactions(branch.getCustomers().get(i));
                }
            }else{
                System.out.println("No customers found in branch '" + branchName + "'.");
            }
        }else{
            System.out.println("No branch found with '" + branchName + "' name.");
        }
    }
}
