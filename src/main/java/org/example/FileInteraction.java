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
                readingExpenseList.add(new Expense(parts[0], parts[1], parts[2]));
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
}
