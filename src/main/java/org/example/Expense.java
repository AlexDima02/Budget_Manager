package org.example;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

public class Expense {
    String category;
    String name;
    String amount;
    String year;
    String month;

    public Expense(String amount, String name, String category, String month, String year) {
        this.amount = amount;
        this.name = name;
        this.category = category;
        this.year = year;
        this.month = month;
    }

    public Expense() {

    }

    public void removeExpense(String filename, String name){
        List<String> expenses = new ArrayList<>();
        String str;
        try {
            BufferedReader myWriter = new BufferedReader(new FileReader("database.txt"));
            String line;
            while ((line = myWriter.readLine()) != null) {
                expenses.add(line);
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for (int i = 0; i < expenses.size(); i++) {
            if (expenses.get(i).contains(name)) {
                expenses.remove(i);
            }
        }

        File file = new File("database.txt");
        file.delete();
        try (BufferedWriter bw
                     = new BufferedWriter(new FileWriter("database.txt", true))) {
            for (int i = 0; i < expenses.size(); i++) {
                String s;
                s = expenses.get(i);
                bw.write(s);
                bw.newLine();
                bw.flush();
            }
            System.out.println("Expense " + name + " has been removed.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void editExpense(String filename, String editAmount, String editName, String name) {

        List<String> expenses = new ArrayList<>();
        String str;
        try {
            BufferedReader myWriter = new BufferedReader(new FileReader("database.txt"));
            String line;
            while ((line = myWriter.readLine()) != null) {
                expenses.add(line);
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for (int i = 0; i < expenses.size(); i++) {
            if (expenses.get(i).contains(name)) {
                String[] expense = expenses.get(i).split(",");
                expense[1] = editName;
                expense[0] = editAmount;
                str = String.join(",", expense);
                expenses.set(i, str);
            }
        }

        File file = new File("database.txt");
        file.delete();
        try (BufferedWriter bw
                     = new BufferedWriter(new FileWriter("database.txt", true))) {
            for (int i = 0; i < expenses.size(); i++) {
                        String s;
                        s = expenses.get(i);
                        bw.write(s);
                        bw.newLine();
                        bw.flush();
                }
            } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
