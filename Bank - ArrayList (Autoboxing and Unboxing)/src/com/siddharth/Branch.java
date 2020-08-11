package com.siddharth;

import java.util.ArrayList;

public class Branch {

    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String customerName, double initialAmount){
        if(findCustomer(customerName)==null){
            Customer customer = new Customer(customerName, initialAmount);
            this.customers.add(customer);
            return true;
        }
        System.out.println("Customer '" + customerName + "' already present.");
        return false;
    }

    public Customer findCustomer(String customerName){
        for(int i=0; i<customers.size(); i++){
            Customer customer = customers.get(i);
            if(customer.getName().equalsIgnoreCase(customerName)){
                return customer;
            }
        }return null;
    }

    public void newTransaction(String name, double amount){
        Customer customer = findCustomer(name);
        if (customer!=null){
            customer.addTransaction(amount);
            System.out.println("Transaction of amount " + amount + " is done successfully.");
        }else{
            System.out.println("No customer found with name, " + name);
        }
    }


    public void printTransactions(Customer customer){
        System.out.println("\tTransactions:");
        for(int i=0; i<customer.getTransactions().size(); i++){
            System.out.println("\t\t\t"+ customer.getTransactions().get(i));
        }
    }


}
