package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileInteraction {

    ArrayList<Expense> writingExpenseList = new ArrayList<Expense>();
    ArrayList<Expense> readingExpenseList = new ArrayList<Expense>();;
    ArrayList<Budget> readingBudgetList = new ArrayList<Budget>();
    ArrayList<Budget> writingBudgetList = new ArrayList<Budget>();

    public void readingExpenses(String filename) {
        try {
            File soruce = new File(filename);
            Scanner myReader = new Scanner(soruce);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine().toString().trim();
                String[] parts = data.split(",");
                readingExpenseList.add(new Expense(parts[0], parts[1], parts[2], parts[3], parts[4]));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void writingExpense(String filename) {
        try (FileWriter myWriter = new FileWriter(filename, true)){
            for (int i = 0; i < writingExpenseList.size(); i++) {
                myWriter.write(writingExpenseList.get(i).amount.toString() + ",");
                myWriter.write(writingExpenseList.get(i).name.toString() + ",");
                myWriter.write(writingExpenseList.get(i).category.toString() + "," + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void writingBudget(String filename) {
        try (FileWriter myWriter = new FileWriter(filename, true)){
            for (int i = 0; i < writingBudgetList.size(); i++) {
                myWriter.write(writingBudgetList.get(i).budget + ",");
                myWriter.write(writingBudgetList.get(i).month + ",");
                myWriter.write(writingBudgetList.get(i).year + "," + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void readingBudget(String filename) {
        try {
            File soruce = new File(filename);
            Scanner myReader = new Scanner(soruce);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine().toString().trim();
                String[] parts = data.split(",");
                readingBudgetList.add(new Budget(parts[0], parts[1], parts[2]));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void checkSpendingAgainstBudget(int month) {
        try {
            File budgetFile = new File("budgets.txt");
            File expenseFile = new File("database.txt");
            Scanner budgetReader = new Scanner(budgetFile);
            Scanner expenseReader = new Scanner(expenseFile);
            int budget = 0;
            int expense = 0;
            while (budgetReader.hasNextLine()) {
                String data = budgetReader.nextLine();
                String[] parts = data.split(",");
                if(Integer.valueOf(parts[3]) == month){
                    budget += Integer.valueOf(parts[0]);
                }
            }
            while (expenseReader.hasNextLine()) {
                String data = expenseReader.nextLine();
                String[] parts = data.split(",");
                if(Integer.valueOf(parts[3]) == month){
                    expense += Integer.valueOf(parts[0]);
                }
            }
            System.out.println(budget);
            System.out.println(expense);
            budget = budget - expense;
            System.out.println(budget);
            expenseReader.close();
            budgetReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
